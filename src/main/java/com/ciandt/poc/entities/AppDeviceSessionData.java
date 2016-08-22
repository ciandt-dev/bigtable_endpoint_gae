package com.ciandt.poc.entities;

import java.util.Date;

import com.wlu.orm.hbase.annotation.DatabaseField;
import com.wlu.orm.hbase.annotation.DatabaseTable;

@DatabaseTable(canBeFamily=true)
public class AppDeviceSessionData {
    
	@DatabaseField()
    private Double total_time_from_sessions;
    
    @DatabaseField()
    private Date last_session_start_time;
	
    @DatabaseField()
	public String current_session;
	
    @DatabaseField()
	public String first_session;
	
    @DatabaseField()
	public Date session_start_time;
	
    @DatabaseField()
	public Date session_time_key;
	
    @DatabaseField()
	public int session_position;
	
    @DatabaseField()
	public boolean session_is_background;
	
    @DatabaseField()
	public boolean session_counted_for_dau;
	
    @DatabaseField()
	public boolean session_counted_for_mau;
	
    @DatabaseField()
	public boolean session_closed;
	
    @DatabaseField()
	public Date session_pause_time;
	
    @DatabaseField()
	public double session_pause_length_seconds;

	public AppDeviceSessionData() {
	}

	public String getCurrent_session() {
		return current_session;
	}

	public void setCurrent_session(String current_session) {
		this.current_session = current_session;
	}

	public String getFirst_session() {
		return first_session;
	}

	public void setFirst_session(String first_session) {
		this.first_session = first_session;
	}

	public Date getSession_start_time() {
		return session_start_time;
	}

	public void setSession_start_time(Date session_start_time) {
		this.session_start_time = session_start_time;
	}

	public Date getSession_time_key() {
		return session_time_key;
	}

	public void setSession_time_key(Date session_time_key) {
		this.session_time_key = session_time_key;
	}

	public int getSession_position() {
		return session_position;
	}

	public void setSession_position(int session_position) {
		this.session_position = session_position;
	}

	public boolean isSession_is_background() {
		return session_is_background;
	}

	public void setSession_is_background(boolean session_is_background) {
		this.session_is_background = session_is_background;
	}

	public boolean isSession_counted_for_dau() {
		return session_counted_for_dau;
	}

	public void setSession_counted_for_dau(boolean session_counted_for_dau) {
		this.session_counted_for_dau = session_counted_for_dau;
	}

	public boolean isSession_counted_for_mau() {
		return session_counted_for_mau;
	}

	public void setSession_counted_for_mau(boolean session_counted_for_mau) {
		this.session_counted_for_mau = session_counted_for_mau;
	}

	public boolean isSession_closed() {
		return session_closed;
	}

	public void setSession_closed(boolean session_closed) {
		this.session_closed = session_closed;
	}

	public Date getSession_pause_time() {
		return session_pause_time;
	}

	public void setSession_pause_time(Date session_pause_time) {
		this.session_pause_time = session_pause_time;
	}

	public double getSession_pause_length_seconds() {
		return session_pause_length_seconds;
	}

	public void setSession_pause_length_seconds(double session_pause_length_seconds) {
		this.session_pause_length_seconds = session_pause_length_seconds;
	}

	public Double getTotal_time_from_sessions() {
		return total_time_from_sessions;
	}

	public void setTotal_time_from_sessions(Double total_time_from_sessions) {
		this.total_time_from_sessions = total_time_from_sessions;
	}

	public Date getLast_session_start_time() {
		return last_session_start_time;
	}

	public void setLast_session_start_time(Date last_session_start_time) {
		this.last_session_start_time = last_session_start_time;
	}
	
}