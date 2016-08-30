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
    
    @DatabaseField(familyName = "created")
    private Date created;
    
    @DatabaseField(familyName = "app_version", isIndexed=true)
    private String appVersion;

    @DatabaseField(familyName = "anomaly", isIndexed=true)
    private int anomaly;

    @DatabaseField(familyName = "version", isIndexed=true)
    private int version;

    @DatabaseField(familyName = "token", isIndexed=true)
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

    public int getAnomaly() {
        return anomaly;
    }

    public void setAnomaly(int anomaly) {
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

	@Override
	public String toString() {
		return "AppDevice [app=" + app + ", created=" + created + ", appVersion=" + appVersion + ", anomaly=" + anomaly
				+ ", version=" + version + ", token=" + token + ", userInfo=" + userInfo + ", data=" + data
				+ ", localeInfo=" + localeInfo + "]";
	}
	
	
}
