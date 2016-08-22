package com.ciandt.poc.entities;

import java.util.Date;
import java.util.Map;

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
    
    @DatabaseField(familyName = "created")
    private Date created;
    
    @DatabaseField(isQualifierValueMap=true, familyName="listValue")
    private Map<String, String> mapValues;

    @DatabaseField(familyName = "app_version")
    private String appVersion;

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

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	public AppDeviceLocaleInfo getLocaleInfo() {
		return localeInfo;
	}

	public void setLocaleInfo(AppDeviceLocaleInfo localeInfo) {
		this.localeInfo = localeInfo;
	}

	public AppDeviceSessionData getData() {
		return data;
	}

	public void setData(AppDeviceSessionData data) {
		this.data = data;
	}

	public AppDeviceUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(AppDeviceUserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Map<String, String> getMapValues() {
		return mapValues;
	}

	public void setMapValues(Map<String, String> mapValues) {
		this.mapValues = mapValues;
	}

}
