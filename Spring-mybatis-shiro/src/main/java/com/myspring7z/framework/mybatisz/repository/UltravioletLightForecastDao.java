package com.myspring7z.framework.mybatisz.repository;

import java.util.List;

import com.myspring7z.framework.mybatisz.entity.UltravioletLightForecast;

@MyBatisRepository
public interface UltravioletLightForecastDao {
	
	public UltravioletLightForecast get(long id);
	
	public List<UltravioletLightForecast> getUVLForecastsByDateTime(UltravioletLightForecast ultravioletLightForecast);
}
