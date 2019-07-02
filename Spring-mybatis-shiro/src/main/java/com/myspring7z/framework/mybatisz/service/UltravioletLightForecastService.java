package com.myspring7z.framework.mybatisz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myspring7z.framework.mybatisz.entity.UltravioletLightForecast;
import com.myspring7z.framework.mybatisz.repository.UltravioletLightForecastDao;

@Component
@Transactional
public class UltravioletLightForecastService {
	
	@Autowired
	private UltravioletLightForecastDao ultravioletLightForecastDao;
	
	public UltravioletLightForecast get(long id) {
		return ultravioletLightForecastDao.get(id);
	}
	
	public List<UltravioletLightForecast> getUVLForecastsByDateTime(UltravioletLightForecast ultravioletLightForecast){
		return ultravioletLightForecastDao.getUVLForecastsByDateTime(ultravioletLightForecast);
	}

	public UltravioletLightForecastDao getUltravioletLightForecastDao() {
		return ultravioletLightForecastDao;
	}

	public void setUltravioletLightForecastDao(UltravioletLightForecastDao ultravioletLightForecastDao) {
		this.ultravioletLightForecastDao = ultravioletLightForecastDao;
	}
	
	
}
