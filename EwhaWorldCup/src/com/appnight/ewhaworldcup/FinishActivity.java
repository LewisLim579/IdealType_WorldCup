package com.appnight.ewhaworldcup;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.plattysoft.leonids.ParticleSystem;

public class FinishActivity extends Activity {

	ImageView imgProfile;
	TextView tv_name;
	TextView tv_phone;

	final static int imageNumber[] = { R.id.emiter_top_one,
			R.id.emiter_top_two, R.id.emiter_top_three, R.id.emiter_top_four,
			R.id.emiter_top_five, R.id.emiter_top_six, R.id.emiter_top_seven,
			R.id.emiter_top_eight, R.id.emiter_top_nine, R.id.emiter_top_ten,
			R.id.emiter_top_eleven, R.id.emiter_top_twelve };

	final static int pollenNumber[] = { R.drawable.pollen1, R.drawable.pollen2,
			R.drawable.pollen3, R.drawable.pollen4, R.drawable.pollen5,
			R.drawable.pollen6, R.drawable.pollen7, R.drawable.pollen8,
			R.drawable.pollen9, R.drawable.pollen10, R.drawable.pollen11,
			R.drawable.pollen12 };

	private boolean animInitialized = false;

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		if (hasFocus && !animInitialized) {
			for (int i = 0; i < 12; i++) {
				new ParticleSystem(this, 10, pollenNumber[i], 10000)
						.setSpeedModuleAndAngleRange(0f, 0.1f, 180, 180)
						.setRotationSpeed(144).setAcceleration(0.000025f, 90)
						.emit(findViewById(imageNumber[i]), 1);
			}
			this.animInitialized = true;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finish);
		imgProfile = (ImageView) findViewById(R.id.imageView_profile);
		tv_name = (TextView) findViewById(R.id.textView_name);
		tv_phone = (TextView) findViewById(R.id.textView_phonenumber);
		String name=getIntent().getStringExtra("name");
		String phone=getIntent().getStringExtra("phone");
		int profile=getIntent().getIntExtra("img", 0);
		imgProfile.setImageResource(profile);
		tv_name.setText(name);
		tv_phone.setText(phone);
		tv_phone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+tv_phone.getText().toString()));
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.finish, menu);
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
