package com.hiddenbrains.model;

import com.google.gson.annotations.SerializedName;

public class WeatherXMLHolder {
	
	
	  @SerializedName("city")
      public City city;
     
	  @SerializedName("temperature")
      public Temperature temperature;
	
	
	  public class City
	  {
		  public String country;
		  
		  @SerializedName("sun")
		  public Sun sun;
		  
		  @SerializedName("coord")
		  public Coord coord;
		  
	  }
	  
	  public class Sun
	  {
		  @SerializedName("@rise")
		  public String rise="";
		  
		  @SerializedName("@set")
		  public String set="";
	  }
	  
	  public class Coord
	  {
		  @SerializedName("@lat")
		  public String lat="";
		  
		  @SerializedName("@lon")
		  public String lon="";
	  }
	  
	  public class Temperature
	  {
		  @SerializedName("@value")
		  public String value="";
		  
		  @SerializedName("@min")
		  public String min="";
		  
		  @SerializedName("@max")
		  public String max="";
		  
		  @SerializedName("@unit")
		  public String unit="";
	  }
}

