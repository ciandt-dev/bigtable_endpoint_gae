package com.ciandt.poc.entities;

import java.util.Date;

import com.wlu.orm.hbase.annotation.DatabaseField;
import com.wlu.orm.hbase.annotation.DatabaseTable;

@DatabaseTable(canBeFamily=true)
public class AppDeviceSessionData {
    
	@DatabaseField
    private Double totalTimeFromSessions;
    
    @DatabaseField
    private Date lastSessionStartTime;
	
    @DatabaseField
	public String currentSession;
	
    @DatabaseField
	public String firstSession;
	
    @DatabaseField
	public Date sessionStartTime;
	
    @DatabaseField
	public Date sessionTimeKey;
	
    @DatabaseField
	public int sessionPosition;
	
    @DatabaseField
	public boolean sessionIsBackground;
	
    @DatabaseField
	public boolean sessionCountedForDau;
	
    @DatabaseField
	public boolean sessionCountedForMau;
	
    @DatabaseField
	public boolean sessionClosed;
	
    @DatabaseField
	public Date sessionPauseTime;
	
    @DatabaseField
	public double sessionPauseLengthSeconds;

	public AppDeviceSessionData() {
	}

	public String getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(String currentSession) {
		this.currentSession = currentSession;
	}

	public String getFirstSession() {
		return firstSession;
	}

	public void setFirstSession(String firstSession) {
		this.firstSession = firstSession;
	}

	public Date getSessionStartTime() {
		return sessionStartTime;
	}

	public void setSessionStarTime(Date sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	public Date getSessionTimeKey() {
		return sessionTimeKey;
	}

	public void setSessionTimeKey(Date sessionTimeKey) {
		this.sessionTimeKey = sessionTimeKey;
	}

	public int getSessionPosition() {
		return sessionPosition;
	}

	public void setSessionPosition(int sessionPosition) {
		this.sessionPosition = sessionPosition;
	}

	public boolean isSessionIsBackground() {
		return sessionIsBackground;
	}

	public void setSessionIsBackground(boolean sessionIsBackground) {
		this.sessionIsBackground = sessionIsBackground;
	}

	public boolean isSessionCountedForDau() {
		return sessionCountedForDau;
	}

	public void setSessionCountedForDau(boolean sessionCountedForDau) {
		this.sessionCountedForDau = sessionCountedForDau;
	}

	public boolean isSessionCountedForMau() {
		return sessionCountedForMau;
	}

	public void setSessionCountedForMau(boolean sessionCountedForMau) {
		this.sessionCountedForMau = sessionCountedForMau;
	}

	public boolean isSessionClosed() {
		return sessionClosed;
	}

	public void setSessionClosed(boolean sessionClosed) {
		this.sessionClosed = sessionClosed;
	}

	public Date getSessionPauseTime() {
		return sessionPauseTime;
	}

	public void setSessionPauseTime(Date sessionPauseTime) {
		this.sessionPauseTime = sessionPauseTime;
	}

	public double getSessionPauseLengthSeconds() {
		return sessionPauseLengthSeconds;
	}

	public void setSessionPauseLengthSeconds(double sessionPauseLengthSeconds) {
		this.sessionPauseLengthSeconds = sessionPauseLengthSeconds;
	}

	public Double getTotalTimeFromSessions() {
		return totalTimeFromSessions;
	}

	public void setTotalTimeFromSessions(Double totalTimeFromSessions) {
		this.totalTimeFromSessions = totalTimeFromSessions;
	}

	public Date getLastSessionStartTime() {
		return lastSessionStartTime;
	}

	public void setLastSessionStartTime(Date lastSessionStartTime) {
		this.lastSessionStartTime = lastSessionStartTime;
	}
	
}