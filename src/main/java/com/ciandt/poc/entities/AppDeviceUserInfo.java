package com.ciandt.poc.entities;

import java.util.Date;

import com.wlu.orm.hbase.annotation.DatabaseField;
import com.wlu.orm.hbase.annotation.DatabaseTable;

@DatabaseTable(canBeFamily=true)
public class AppDeviceUserInfo {

    @DatabaseField(isIndexed=true)
    private String userId;

    @DatabaseField()
    private boolean isDeveloper;


    @DatabaseField()
    private boolean hasUserId;
    
    @DatabaseField()
    private Date lastUserTime;
    
    @DatabaseField()
    private String ip;
   
    @DatabaseField()
    private Date lastActive;

    @DatabaseField()
    private Date lastUpdated;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isDeveloper() {
		return isDeveloper;
	}

	public void setIsDeveloper(boolean isDeveloper) {
		this.isDeveloper = isDeveloper;
	}

	public boolean isHasUserId() {
		return hasUserId;
	}

	public void setHasUserd(boolean hasUserId) {
		this.hasUserId = hasUserId;
	}

	public Date getLastUserTime() {
		return lastUserTime;
	}

	public void setLastUserTime(Date lastUserTime) {
		this.lastUserTime = lastUserTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLastActive() {
		return lastActive;
	}

	public void setLastActive(Date lastActive) {
		this.lastActive = lastActive;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "AppDeviceUserInfo [userId=" + userId + ", isDeveloper=" + isDeveloper + ", hasUserId=" + hasUserId
				+ ", lastUserTime=" + lastUserTime + ", ip=" + ip + ", lastActive=" + lastActive + ", lastUpdated="
				+ lastUpdated + "]";
	}
}
