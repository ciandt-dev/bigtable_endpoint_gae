package com.ciandt.poc.entities;

import java.util.Date;

import com.google.appengine.api.datastore.GeoPt;
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
    
    @DatabaseField(familyName = "")
    private Double total_time_from_sessions;
    
    @DatabaseField(familyName = "")
    private Date created;
    
    @DatabaseField(familyName = "")
    private Date last_session_start_time;

    @DatabaseField(familyName = "")
    private String app_version;

    @DatabaseField(familyName = "")
    private String user_id;

    @DatabaseField(familyName = "")
    private boolean is_developer;

    @DatabaseField(familyName = "")
    private long anomaly;

    @DatabaseField(familyName = "")
    private String country;

    @DatabaseField(familyName = "")
    private String region;

    @DatabaseField(familyName = "")
    private String timezone;

    @DatabaseField(familyName = "")
    private Integer timezone_offset_seconds;

    @DatabaseField(familyName = "")
    private String locale;

    @DatabaseField(familyName = "")
    private GeoPt location;

    @DatabaseField(familyName = "")
    private String city;

    @DatabaseField(familyName = "")
    private boolean has_user_id;

    @DatabaseField(familyName = "")
    private int version;

    @DatabaseField(familyName = "")
    private Date last_user_time;

    @DatabaseField(familyName = "")
    private String current_session;

    @DatabaseField(familyName = "")
    private String token;

    @DatabaseField(familyName = "")
    private String ip;

    @DatabaseField(familyName = "")
    private Date last_active;

    @DatabaseField(familyName = "")
    private Date last_updated;

    @DatabaseField(familyName = "")
    private String first_session;

    @DatabaseField(familyName = "")
    private Date session_start_time;

    @DatabaseField(familyName = "")
    private Date session_time_key;

    @DatabaseField(familyName = "")
    private int session_position;

    @DatabaseField(familyName = "")
    private boolean session_is_background;

    @DatabaseField(familyName = "")
    private boolean session_counted_for_dau;

    @DatabaseField(familyName = "")
    private boolean session_counted_for_mau;

    @DatabaseField(familyName = "")
    private boolean session_closed;

    @DatabaseField(familyName = "")
    private Date session_pause_time;

    @DatabaseField(familyName = "")
    private double session_pause_length_seconds;


    public AppDevice() {
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public Double getTotal_time_from_sessions() {
        return total_time_from_sessions;
    }

    public void setTotal_time_from_sessions(Double total_time_from_sessions) {
        this.total_time_from_sessions = total_time_from_sessions;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLast_session_start_time() {
        return last_session_start_time;
    }

    public void setLast_session_start_time(Date last_session_start_time) {
        this.last_session_start_time = last_session_start_time;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public boolean is_developer() {
        return is_developer;
    }

    public void setIs_developer(boolean is_developer) {
        this.is_developer = is_developer;
    }

    public long getAnomaly() {
        return anomaly;
    }

    public void setAnomaly(long anomaly) {
        this.anomaly = anomaly;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getTimezone_offset_seconds() {
        return timezone_offset_seconds;
    }

    public void setTimezone_offset_seconds(Integer timezone_offset_seconds) {
        this.timezone_offset_seconds = timezone_offset_seconds;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public GeoPt getLocation() {
        return location;
    }

    public void setLocation(GeoPt location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isHas_user_id() {
        return has_user_id;
    }

    public void setHas_user_id(boolean has_user_id) {
        this.has_user_id = has_user_id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getLast_user_time() {
        return last_user_time;
    }

    public void setLast_user_time(Date last_user_time) {
        this.last_user_time = last_user_time;
    }

    public String getCurrent_session() {
        return current_session;
    }

    public void setCurrent_session(String current_session) {
        this.current_session = current_session;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

}
