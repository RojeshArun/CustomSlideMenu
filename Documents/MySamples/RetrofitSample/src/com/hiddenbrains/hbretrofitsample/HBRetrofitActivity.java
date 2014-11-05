package com.hiddenbrains.hbretrofitsample;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hiddenbrains.model.GsonXMLConverter;
import com.hiddenbrains.model.WeatherHolder;
import com.hiddenbrains.model.WeatherService;
import com.hiddenbrains.model.WeatherXMLHolder;
import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;

public class HBRetrofitActivity extends Activity {

//	https://github.com/stanfy/gson-xml
	private final String API = "http://api.openweathermap.org";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hbretrofit);
		
		
//		callJSONWS();
		callXMLWS();
	}
	
	private void callXMLWS()
	{
//		https://api.soundcloud.com/
		
		GsonXMLConverter gsonXMLConverter = new GsonXMLConverter();
		
		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API).setConverter(gsonXMLConverter).build();
		WeatherService weatherService = restAdapter.create(WeatherService.class);
		weatherService.getWeatherXMLInfo("vizag","xml",new Callback<WeatherXMLHolder>() {
			
			@Override
			public void failure(RetrofitError arg0) {
				Log.e("fail", "failure");
			}

			@Override
			public void success(WeatherXMLHolder arg0, Response arg1) {
				Log.e("success", "success");				
			}
		});
	}
	
	private void callJSONWS()
	{
		Gson gson = new GsonBuilder().create();
		
		GsonConverter gsonConverter = new GsonConverter(gson);
		
		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API).setConverter(gsonConverter).build();
		WeatherService weatherService = restAdapter.create(WeatherService.class);
		weatherService.getWeatherInfo("asdasdasdasd","json",new Callback<WeatherHolder>() {
			
			@Override
			public void failure(RetrofitError arg0) {
				Log.e("fail", "failure");
			}

			@Override
			public void success(WeatherHolder arg0, Response arg1) {
				Log.e("success", "success");				
			}
		});
	}
}
