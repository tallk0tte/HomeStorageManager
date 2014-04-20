package com.main;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;

public class ListDataMain extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_data_main_layout);
		
		Button listAllData  = (Button)findViewById(R.id.listalldata);
		listAllData.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ListDataMain.this, ListAllData.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}//end onClick
		});//end ListAllDataButton
		
		//Button search = (Button)findViewById(R.id.searchButton);
		

	
	}//end onCreate
}//end class

