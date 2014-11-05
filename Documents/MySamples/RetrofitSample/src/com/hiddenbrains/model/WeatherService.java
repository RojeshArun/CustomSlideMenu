package com.hiddenbrains.model;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface WeatherService {

	@GET("/data/2.5/weather")
	void getWeatherInfo(@Query("q") String query,@Query("mode")String mode,Callback<WeatherHolder> callback);
	
	@GET("/data/2.5/weather")
	void getWeatherXMLInfo(@Query("q") String query,@Query("mode")String mode,Callback<WeatherXMLHolder> callback);
}
