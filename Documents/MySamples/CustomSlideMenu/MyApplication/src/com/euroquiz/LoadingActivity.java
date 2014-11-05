package com.euroquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LoadingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding_layout);
		
		
		gotoHomeScreen(); 
	}

	private void gotoHomeScreen() {
		
		Intent mIntent = new Intent(this, MainActivity.class);
		startActivity(mIntent);
		finish();
		
	}
}
