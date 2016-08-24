package com.ciandt.poc.entities;

import com.google.appengine.api.datastore.GeoPt;
import com.wlu.orm.hbase.annotation.DatabaseField;
import com.wlu.orm.hbase.annotation.DatabaseTable;

@DatabaseTable(canBeFamily=true)
public class AppDeviceLocaleInfo {

    @DatabaseField()
    private String country;

    @DatabaseField()
    private String region;

    @DatabaseField()
    private String timezone;

    @DatabaseField()
    private Integer timezoneOffsetSeconds;

    @DatabaseField()
    private String locale;

    @DatabaseField()
    private GeoPt location;

    @DatabaseField()
    private String city;
    
    public AppDeviceLocaleInfo(){
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

	public Integer getTimezoneOffsetSeconds() {
		return timezoneOffsetSeconds;
	}

	public void setTimezoneOffsetSeconds(Integer timezoneOffsetSeconds) {
		this.timezoneOffsetSeconds = timezoneOffsetSeconds;
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

	@Override
	public String toString() {
		return "AppDeviceLocaleInfo [country=" + country + ", region=" + region + ", timezone=" + timezone
				+ ", timezoneOffsetSeconds=" + timezoneOffsetSeconds + ", locale=" + locale + ", location=" + location
				+ ", city=" + city + "]";
	}
}
