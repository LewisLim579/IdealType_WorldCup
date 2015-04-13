package com.appnight.ewhaworldcup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.appnight.ewhaworldcup.player.GameManager;
import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.ScaleModifier;

public class GameActivity extends Activity {
	ImageButton userImg1;
	ImageButton userImg2;
	final static int imageNumber[] = { R.id.emiter_star_one,
			R.id.emiter_star_two, R.id.emiter_star_three,
			R.id.emiter_star_four, R.id.emiter_star_five, R.id.emiter_star_six,
			R.id.emiter_star_seven, R.id.emiter_star_eight,
			R.id.emiter_star_nine };

	final static int starNumber[] = { R.drawable.star1, R.drawable.star2,
			R.drawable.star3, R.drawable.star4, R.drawable.star5,
			R.drawable.star6, R.drawable.star7, R.drawable.star8,
			R.drawable.star9 };
	int gameCount; // 0~6
	int nowPlayer;
	int nowPlayer2;

	int gender;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		userImg1 = (ImageButton) findViewById(R.id.imageButton_userimg1);
		userImg2 = (ImageButton) findViewById(R.id.imageButton_userimg2);
		gender = getIntent().getIntExtra("gender", 0);
		if (gender == 1) {
			GameManager.getInstance().initMangame();
			// GameManager.getInstance().inittmp();
			GameManager.getInstance().randomList();

		} else if (gender == 2) {
			GameManager.getInstance().initWomangame();
			GameManager.getInstance().randomList();
		}
		gameCount = 0;
		nowPlayer = gameCount;
		nowPlayer2 = gameCount + 1;
		userImg1.setImageResource(GameManager.getInstance().players.get(
				nowPlayer).getImg());

		userImg2.setImageResource(GameManager.getInstance().players.get(
				nowPlayer2).getImg());
		userImg1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				for (int i = 0; i < 9; i++) {
					new ParticleSystem(GameActivity.this, 2, starNumber[i],
							1000)
							.setSpeedByComponentsRange(-0.2f, 0.2f, -0.2f,
									0.04f).setAcceleration(0.000009f, 90)
							.setInitialRotationRange(0, 360)
							.setRotationSpeed(120).setFadeOut(150)
							.addModifier(new ScaleModifier(0f, 1.5f, 0, 500))
							.oneShot(v, 20);
				}

				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {

						// TODO Auto-generated method stub
						if (gameCount == 7) {

							Intent roundIntent = new Intent(GameActivity.this,
									RoundActivity.class);
							roundIntent.putExtra("gender", gender);
							roundIntent.putExtra("round", 8);
							startActivity(roundIntent);
							overridePendingTransition(0, 0);

							new Handler().postDelayed(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub

									GameManager.getInstance().players
											.remove(nowPlayer2);
									// GameManager.getInstance().randomList();
									nowPlayer = 0;
									nowPlayer2 = 1;
									userImg1.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer).getImg());
									userImg2.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer2).getImg());

								}
							}, 1500);

						} else if (gameCount == 11) {

							Intent roundIntent = new Intent(GameActivity.this,
									RoundActivity.class);
							roundIntent.putExtra("gender", gender);
							roundIntent.putExtra("round", 4);
							startActivity(roundIntent);
							overridePendingTransition(0, 0);

							new Handler().postDelayed(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub

									// GameManager.getInstance().randomList();

									GameManager.getInstance().players
											.remove(nowPlayer2);
									// GameManager.getInstance().randomList();
									nowPlayer = 0;
									nowPlayer2 = 1;
									userImg1.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer).getImg());
									userImg2.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer2).getImg());
								}
							}, 1500);

						} else if (gameCount == 13) {
							Intent roundIntent = new Intent(GameActivity.this,
									RoundActivity.class);
							roundIntent.putExtra("gender", gender);
							roundIntent.putExtra("round", 2);
							startActivity(roundIntent);
							overridePendingTransition(0, 0);

							new Handler().postDelayed(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub

									// GameManager.getInstance().randomList();

									GameManager.getInstance().players
											.remove(nowPlayer2);
									// GameManager.getInstance().randomList();
									nowPlayer = 0;
									nowPlayer2 = 1;
									userImg1.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer).getImg());
									userImg2.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer2).getImg());

								}
							}, 1500);

						} else if (gameCount == 14) {

							GameManager.getInstance().players
									.remove(nowPlayer2);

							// userImg2.setVisibility(View.GONE);
							Intent roundIntent = new Intent(GameActivity.this,
									FinishActivity.class);
							roundIntent.putExtra("name", GameManager
									.getInstance().players.get(0).getName());
							roundIntent.putExtra("phone", GameManager
									.getInstance().players.get(0)
									.getPhoneNumber());
							roundIntent.putExtra("img", GameManager
									.getInstance().players.get(0).getImg());
							startActivity(roundIntent);
							finish();
							overridePendingTransition(0, 0);
						} else {

							GameManager.getInstance().players
									.remove(nowPlayer2);
							nowPlayer++;
							nowPlayer2++;

							Log.e("testing", GameManager.getInstance().players
									.get(nowPlayer).getName() + " ");

							Log.e("testing", GameManager.getInstance().players
									.get(nowPlayer2).getName() + " ");
							userImg1.setImageResource(GameManager.getInstance().players
									.get(nowPlayer).getImg());
							userImg2.setImageResource(GameManager.getInstance().players
									.get(nowPlayer2).getImg());

						}

						gameCount++;

					}
				}, 1000);

			}

		});

		userImg2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				for (int i = 0; i < 9; i++) {
					new ParticleSystem(GameActivity.this, 2, starNumber[i],
							1000)
							.setSpeedByComponentsRange(-0.2f, 0.2f, -0.2f,
									0.04f).setAcceleration(0.000009f, 90)
							.setInitialRotationRange(0, 360)
							.setRotationSpeed(120).setFadeOut(150)
							.addModifier(new ScaleModifier(0f, 1.5f, 0, 500))
							.oneShot(v, 20);
				}

				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {

						// TODO Auto-generated method stub
						if (gameCount == 7) {
							Intent roundIntent = new Intent(GameActivity.this,
									RoundActivity.class);
							roundIntent.putExtra("gender", gender);
							roundIntent.putExtra("round", 8);
							startActivity(roundIntent);
							overridePendingTransition(0, 0);

							new Handler().postDelayed(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub

									GameManager.getInstance().players
											.remove(nowPlayer);

									// GameManager.getInstance().randomList();
									nowPlayer = 0;
									nowPlayer2 = 1;
									userImg1.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer).getImg());
									userImg2.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer2).getImg());
									// GameManager.getInstance().randomList();

								}
							}, 1500);

						} else if (gameCount == 11) {
							Intent roundIntent = new Intent(GameActivity.this,
									RoundActivity.class);
							roundIntent.putExtra("gender", gender);
							roundIntent.putExtra("round", 4);
							startActivity(roundIntent);
							overridePendingTransition(0, 0);

							new Handler().postDelayed(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub

									GameManager.getInstance().players
											.remove(nowPlayer);

									// GameManager.getInstance().randomList();
									nowPlayer = 0;
									nowPlayer2 = 1;
									userImg1.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer).getImg());
									userImg2.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer2).getImg());
									// GameManager.getInstance().randomList();

								}
							}, 1500);

						} else if (gameCount == 13) {
							Intent roundIntent = new Intent(GameActivity.this,
									RoundActivity.class);
							roundIntent.putExtra("gender", gender);
							roundIntent.putExtra("round", 2);
							startActivity(roundIntent);
							overridePendingTransition(0, 0);

							new Handler().postDelayed(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub

									GameManager.getInstance().players
											.remove(nowPlayer);

									// GameManager.getInstance().randomList();
									nowPlayer = 0;
									nowPlayer2 = 1;
									userImg1.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer).getImg());
									userImg2.setImageResource(GameManager
											.getInstance().players.get(
											nowPlayer2).getImg());
									// GameManager.getInstance().randomList();

								}
							}, 1500);
						} else if (gameCount == 14) {

							GameManager.getInstance().players.remove(nowPlayer);
							// userImg1.setVisibility(View.GONE);
							Intent roundIntent = new Intent(GameActivity.this,
									FinishActivity.class);
							roundIntent.putExtra("name", GameManager
									.getInstance().players.get(0).getName());
							roundIntent.putExtra("phone", GameManager
									.getInstance().players.get(0)
									.getPhoneNumber());
							roundIntent.putExtra("img", GameManager
									.getInstance().players.get(0).getImg());
							startActivity(roundIntent);
							finish();
							overridePendingTransition(0, 0);
						}

						else {
							GameManager.getInstance().players.remove(nowPlayer);
							nowPlayer++;
							nowPlayer2++;
							userImg1.setImageResource(GameManager.getInstance().players
									.get(nowPlayer).getImg());
							userImg2.setImageResource(GameManager.getInstance().players
									.get(nowPlayer2).getImg());

						}
						gameCount++;

					}
				}, 1000);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.male, menu);
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
