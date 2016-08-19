package com.ciandt.poc.entities;

import java.util.Date;

import com.wlu.orm.hbase.annotation.DatabaseField;

public class AppDeviceUserInfo {

    @DatabaseField()
    private String user_id;

    @DatabaseField()
    private boolean is_developer;


    @DatabaseField()
    private boolean has_user_id;
    
    
    @DatabaseField()
    private Date last_user_time;
    
    @DatabaseField()
    private String ip;
   
    @DatabaseField()
    private Date last_active;

    @DatabaseField()
    private Date last_updated;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public boolean isIs_developer() {
		return is_developer;
	}

	public void setIs_developer(boolean is_developer) {
		this.is_developer = is_developer;
	}

	public boolean isHas_user_id() {
		return has_user_id;
	}

	public void setHas_user_id(boolean has_user_id) {
		this.has_user_id = has_user_id;
	}

	public Date getLast_user_time() {
		return last_user_time;
	}

	public void setLast_user_time(Date last_user_time) {
		this.last_user_time = last_user_time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLast_active() {
		return last_active;
	}

	public void setLast_active(Date last_active) {
		this.last_active = last_active;
	}

	public Date getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}
    
    
}
