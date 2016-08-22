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
    private Integer timezone_offset_seconds;

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
    
}
