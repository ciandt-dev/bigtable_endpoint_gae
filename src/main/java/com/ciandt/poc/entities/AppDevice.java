package com.ciandt.poc.entities;

import java.util.Date;

import com.wlu.orm.hbase.annotation.DatabaseField;
import com.wlu.orm.hbase.annotation.DatabaseTable;

/**
 * Created by lucasarruda on 8/11/16.
 */
@DatabaseTable(tableName = "AppDevice")
public class AppDevice {
    // Make sure the object has an empty construction function with
    // no parameters and getter&setter functions for each member variable.
    @DatabaseField(id = true)
    private String app;
    
    @DatabaseField()
    private Date created;

    @DatabaseField(familyName = "app_version")
    private String app_version;

    @DatabaseField(familyName = "anomaly")
    private long anomaly;

    @DatabaseField(familyName = "version")
    private int version;

    @DatabaseField(familyName = "token")
    private String token;

    @DatabaseField(familyName = "user_info")
    private AppDeviceUserInfo userInfo;
    
    @DatabaseField(familyName = "session_data")
    private AppDeviceSessionData data;
    
    @DatabaseField(familyName = "locale_info")
    private AppDeviceLocaleInfo localeInfo;

	public AppDevice() {
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public long getAnomaly() {
        return anomaly;
    }

    public void setAnomaly(long anomaly) {
        this.anomaly = anomaly;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCurrent_session() {
        return data.current_session;
    }

    public void setCurrent_session(String current_session) {
        this.data.current_session = current_session;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirst_session() {
        return data.first_session;
    }

    public void setFirst_session(String first_session) {
        this.data.first_session = first_session;
    }

    public Date getSession_start_time() {
        return data.session_start_time;
    }

    public void setSession_start_time(Date session_start_time) {
        this.data.session_start_time = session_start_time;
    }

    public Date getSession_time_key() {
        return data.session_time_key;
    }

    public void setSession_time_key(Date session_time_key) {
        this.data.session_time_key = session_time_key;
    }

    public int getSession_position() {
        return data.session_position;
    }

    public void setSession_position(int session_position) {
        this.data.session_position = session_position;
    }

    public boolean isSession_is_background() {
        return data.session_is_background;
    }

    public void setSession_is_background(boolean session_is_background) {
        this.data.session_is_background = session_is_background;
    }

    public boolean isSession_counted_for_dau() {
        return data.session_counted_for_dau;
    }

    public void setSession_counted_for_dau(boolean session_counted_for_dau) {
        this.data.session_counted_for_dau = session_counted_for_dau;
    }

    public boolean isSession_counted_for_mau() {
        return data.session_counted_for_mau;
    }

    public void setSession_counted_for_mau(boolean session_counted_for_mau) {
        this.data.session_counted_for_mau = session_counted_for_mau;
    }

    public boolean isSession_closed() {
        return data.session_closed;
    }

    public void setSession_closed(boolean session_closed) {
        this.data.session_closed = session_closed;
    }

    public Date getSession_pause_time() {
        return data.session_pause_time;
    }

    public void setSession_pause_time(Date session_pause_time) {
        this.data.session_pause_time = session_pause_time;
    }

    public double getSession_pause_length_seconds() {
        return data.session_pause_length_seconds;
    }

    public void setSession_pause_length_seconds(double session_pause_length_seconds) {
        this.data.session_pause_length_seconds = session_pause_length_seconds;
    }

}
