package com.appnight.ewhaworldcup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class RoundActivity extends Activity {

	LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_round);
		layout = (LinearLayout) findViewById(R.id.roundback);
		int gender = getIntent().getIntExtra("gender", 0);
		int round = getIntent().getIntExtra("round", 0);

		if (gender == 1 && round == 8) {
			layout.setBackgroundResource(R.drawable.back_m_08);
		} else if (gender == 1 && round == 4) {
			layout.setBackgroundResource(R.drawable.back_m_04);
		} else if (gender == 1 && round == 2) {
			layout.setBackgroundResource(R.drawable.back_m_f);
		} else if (gender == 2 && round == 8) {
			layout.setBackgroundResource(R.drawable.back_w_08);
		} else if (gender == 2 && round == 4) {
			layout.setBackgroundResource(R.drawable.back_w_04);
		} else if (gender == 2 && round == 2) {
			layout.setBackgroundResource(R.drawable.back_w_f);
		} else if (gender == 1 && round == 16) {
			layout.setBackgroundResource(R.drawable.back_m_16);

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Intent roundIntent = new Intent(RoundActivity.this,
							GameActivity.class);
					roundIntent.putExtra("gender", 1);
					startActivity(roundIntent);
					finish();
					// overridePendingTransition(anim.fade_in, anim.fade_in);
					overridePendingTransition(0, 0);
				}
			}, 1500);
		} else if (gender == 2 && round == 16) {
			layout.setBackgroundResource(R.drawable.back_w_16);

			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub

					Intent roundIntent = new Intent(RoundActivity.this,
							GameActivity.class);
					roundIntent.putExtra("gender", 2);
					startActivity(roundIntent);
					finish();
					// overridePendingTransition(anim.fade_in, anim.fade_in);
					overridePendingTransition(0, 0);
				}
			}, 1500);
		}

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				finish();
				// overridePendingTransition(anim.fade_in, anim.fade_in);
				overridePendingTransition(0, 0);
			}
		}, 2500);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.round, menu);
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
