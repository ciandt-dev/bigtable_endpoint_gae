package com.ciandt.poc.orm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.client.BufferedMutator;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.ciandt.poc.entities.AppDevice; 

/**
 * An example of using the {@link BufferedMutator} interface. 
 */ 
public class BufferedMutatorORM extends Configured implements Tool { 

	private static final Log LOG = LogFactory.getLog(BufferedMutatorORM.class); 

	private static final int POOL_SIZE = 10; 
	private static final int TASK_COUNT = 100; 

	private AtomicInteger atomicValue = new AtomicInteger();

	@Override 
	public int run(String[] args) throws InterruptedException, ExecutionException, TimeoutException { 
		// 
		// step 1: create a single Connection and a BufferedMutator, shared by all worker threads. 
		// 
		try(final BigtableORMMutatorHelper<AppDevice> orm =
				new BigtableORMMutatorHelper<AppDevice>(AppDevice.class)) {

			/** worker pool that operates on BufferedTable instances */ 
			final ExecutorService workerPool = Executors.newFixedThreadPool(POOL_SIZE); 
			List<Future<String>> futures = new ArrayList<>(TASK_COUNT); 

			for (int i = 0; i < TASK_COUNT; i++) { 
				futures.add(workerPool.submit(() -> {
					AppDevice appDevice = new AppDevice();
					int value = atomicValue.getAndIncrement();
					String rowKey = "myMutatorId-" + value;
					appDevice.setApp(rowKey);
					appDevice.setAppVersion(String.valueOf(value));
					orm.mutate(appDevice);
					return "Success: [singleRow:" + rowKey + " | value:" + rowKey;
					}
				)); 
			} 

			for (Future<String> f : futures) { 
				String result = f.get(15, TimeUnit.SECONDS);
				LOG.info(">>>>>>>>>>>>> "+result);
			} 
			workerPool.shutdown(); 
		} catch (Exception e){
			LOG.info("exception while creating/destroying Connection or BufferedMutator", e); 
		}
		return 0; 
	} 

	public static void main(String[] args) throws Exception { 
		ToolRunner.run(new BufferedMutatorORM(), args); 
	} 
}