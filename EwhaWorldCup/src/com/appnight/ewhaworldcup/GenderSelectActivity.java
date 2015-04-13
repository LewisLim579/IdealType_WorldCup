package com.appnight.ewhaworldcup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.appnight.ewhaworldcup.R;

public class GenderSelectActivity extends Activity {
	private ImageButton imgBtn1, imgBtn2,imgBtn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gender);

		imgBtn1 = (ImageButton) findViewById(R.id.ImageButton_male);
		imgBtn2 = (ImageButton) findViewById(R.id.imageButton_female);
		imgBtn3 =(ImageButton)findViewById(R.id.imageButton_aboutus);
		
		imgBtn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(GenderSelectActivity.this,AboutUsActivity.class);
				startActivity(intent);
				
			}
		});
		imgBtn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						RoundActivity.class);
				intent.putExtra("gender", 2);
				intent.putExtra("round", 16);
				startActivity(intent);
				finish();
			}
		});

		imgBtn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						RoundActivity.class);
				intent.putExtra("gender", 1);
				intent.putExtra("round", 16);
				startActivity(intent);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gender, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
