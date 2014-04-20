package com.main;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.db.DataHandler;

public class AddData extends ActionBarActivity {
	
	Button save;
	EditText object, numbers, storageid;
	DataHandler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_data_layout);
		
		save = (Button) findViewById(R.id.savebutton);
		object = (EditText)findViewById(R.id.objecttext);
		numbers = (EditText) findViewById(R.id.numbervalue);
		storageid = (EditText)findViewById(R.id.boxname);
		
		//Adds the input data from Add Data into the database and saves
		save.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
			
				String getObjectName = object.getText().toString();
				String getNumber = numbers.getText().toString();
				String getStorage = storageid.getText().toString();
				
				handler = new DataHandler(getBaseContext());
				handler.open();
				
				long id = handler.insertData(getObjectName, getNumber, getStorage);
				Toast.makeText(getBaseContext(), "Data inserted", Toast.LENGTH_LONG).show();
				handler.close();
				
			}//end onClick v
		});//end


	}//end onCreate
	
}//end class