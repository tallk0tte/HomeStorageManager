package com.main;


import com.db.DataHandler;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View.OnClickListener;

public class ListAllData extends ActionBarActivity {
		
	DataHandler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_all_data);
		
		Button loadAll = (Button)findViewById(R.id.loadbutton);
		loadAll.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String getName, getValues, getID;
				getName = "";
				getValues = "";
				getID = "";
				
				handler = new DataHandler(getBaseContext());
				handler.open();
				Cursor C = handler.returnData();
					if(C.moveToFirst()){
						do{
							getName = C.getString(0);
							getValues = C.getString(1);
							getID = C.getString(2);
						}while(C.moveToNext());
					}//end if
					
					handler.close();
					Toast.makeText(getBaseContext(), 
							"NAME:  " + getName + " - AND VALUES:  " + getValues + " -  AND ID:  " + getID, Toast.LENGTH_LONG).show();
			}//end onClick
		});//end setOnClickListener
	}//end onCreate


}//end class
