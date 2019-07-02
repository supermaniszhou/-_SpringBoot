package com.myspring7z.framework.mybatisz.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.myspring7z.framework.mybatisz.entity.IdEntity;

@Entity
@Table(name = "base_ultra_violet_light_forecast")
public class UltravioletLightForecast extends IdEntity{

private static final long serialVersionUID = 1L;
	
	private Date createDate;	//录入时间
	private String dateTime;	//时次
	private String status;		//上传状态 成功1,失败0
	private String stationCode;	//站号
	private int forecastLevel; 	//紫外线预报级别
	private int radiationAvg; 	//紫外线平均辐射量
	private int radiationMax;	//紫外线最大辐射量
	private String fileName;	//文件名
	
	//时间 上午forenoon 下午afternoon
	private String time;
	
	public UltravioletLightForecast(){
		
	}

	@Column(name="createDate")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="dateTime")
	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="stationCode")
	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	@Column(name="forecastLevel")
	public int getForecastLevel() {
		return forecastLevel;
	}

	public void setForecastLevel(int forecastLevel) {
		this.forecastLevel = forecastLevel;
	}

	@Column(name="radiationAvg")
	public int getRadiationAvg() {
		return radiationAvg;
	}

	public void setRadiationAvg(int radiationAvg) {
		this.radiationAvg = radiationAvg;
	}

	@Column(name="radiationMax")
	public int getRadiationMax() {
		return radiationMax;
	}

	public void setRadiationMax(int radiationMax) {
		this.radiationMax = radiationMax;
	}

	@Column(name="fileName")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
