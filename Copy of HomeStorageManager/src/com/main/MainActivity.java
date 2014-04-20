package com.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//YourPersonalStorageController
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Sets the layout
		setContentView(R.layout.activity_main_layout);
		
		//Go into Add Data button
		Button addDataButton = (Button)findViewById(R.id.addnewdata);
		addDataButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AddData.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}//end onClick
		});// end addDataButton
		
		Button listDataButton = (Button)findViewById(R.id.listdata);
		listDataButton.setOnClickListener(new OnClickListener() {
			@SuppressWarnings("static-access")
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ListDataMain.class);
				intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});//end listDataButton
		
	}//end onCreate
	
	
}//end MainActivity
