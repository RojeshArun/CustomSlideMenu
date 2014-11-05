package com.hiddenbrains.model;

import com.google.gson.annotations.SerializedName;

public class WeatherHolder {

	@SerializedName("name")
	public String name="";

	@SerializedName("main")
	public WeatherData main;
	
	public class WeatherData
	{
		@SerializedName("temp")
		public String temp="";
		
		@SerializedName("temp_min")
		public String temp_min="";
		
		@SerializedName("temp_max")
		public String temp_max="";
		
		@SerializedName("pressure")
		public String pressure="";
		
		@SerializedName("sea_level")
		public String sea_level="";
		
		@SerializedName("grnd_level")
		public String grnd_level="";
		
		@SerializedName("humidity")
		public String humidity="";
	}
	
}
