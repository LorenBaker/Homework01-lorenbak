package com.lbconsulting.CP210.homework01_lorenbak;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	// TAG String for logging MainActivity
	public final static String TAG = "CP210:HW01";
	public final static boolean L = true; // enable Logging

	// MainActivity module controls and variables
	private Button btnStartGreenActivity;

	// /////////////////////////////////////////////////////////////////////////////
	// MainActivity skeleton
	// /////////////////////////////////////////////////////////////////////////////
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// The Activity is being created.
		setContentView(R.layout.activity_main);
		if (L)
			Log.i(TAG, "MainActivity onCreate Starting.");
		this.doCreate(savedInstanceState);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		// The Activity will be started.
		if (L)
			Log.i(TAG, "MainActivity onRestart");
	}

	@Override
	protected void onStart() {
		super.onStart();
		// The Activity is starting and about to become visible.
		if (L)
			Log.i(TAG, "MainActivity onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		// The Activity is visible and "resumed" and running.
		if (L)
			Log.i(TAG, "MainActivity onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();

		// Another activity is taking focus.
		// This Activity is about to be "paused".
		// Store values to be persisted between instances here.
		if (L)
			Log.i(TAG, "MainActivity onPause"
					+ (isFinishing() ? " Finishing" : ""));
	}

	@Override
	protected void onStop() {
		super.onStop();
		// The Activity is no longer visible and is now "stopped".
		if (L)
			Log.i(TAG, "MainActivity onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// The Activity is about to be destroyed.
		if (L)
			Log.i(TAG, "MainActivity onDestroy"
					+ (isFinishing() ? " Finishing" : ""));
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// Called when state should be saved
		if (L)
			Log.i(TAG, "MainActivity onSaveInstanceState");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedState) {
		super.onRestoreInstanceState(savedState);

		// If we had state to restore, we note that in the log message
		if (L)
			Log.i(TAG, "MainActivity onRestoreInstanceState."
					+ (null != savedState ? " Restored state." : ""));
	}

	@Override
	protected void onPostCreate(Bundle savedState) {
		super.onPostCreate(savedState);
		// If we had state to restore, we note that in the log message
		if (L)
			Log.i(TAG, "MainActivity onPostCreate"
					+ (null == savedState ? " Restored state" : ""));
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		// Resuming the Activity is complete.
		if (L)
			Log.i(TAG, "MainActivity onPostResume");
	}

	@Override
	protected void onUserLeaveHint() {
		super.onUserLeaveHint();
		// Notification that the user navigated away from this Activity.
		if (L)
			Log.i(TAG, "MainActivity onUserLeaveHint");
	}

	@Override
	public void onConfigurationChanged(Configuration newConfiguration) {
		super.onConfigurationChanged(newConfiguration);

		// This won't happen unless we declare changes we handle in the manifest
		if (L)
			Log.i(TAG, "MainActivity onConfigurationChanged");
	}

	@Override
	public void onLowMemory() {
		// No guarantee this is called before or after other callbacks
		if (L)
			Log.i(TAG, "MainActivity onLowMemory");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		if (L)
			Log.i(TAG, "MainActivity onCreateOptionsMenu");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String msg = null;

		switch (item.getItemId()) {

		case R.id.action_orientation:
			DeviceOrientation deviceOrientation = new DeviceOrientation(this);
			deviceOrientation.ShowOrientationDialog();
			return true;

		case R.id.action_settings:
			// TODO code menu masterListSettings
			msg = this.getString(R.string.NoActivitySettings);
			Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG)
					.show();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	// /////////////////////////////////////////////////////////////////////////////
	// MainActivity specific code
	// /////////////////////////////////////////////////////////////////////////////

	private void doCreate(Bundle savedInstanceState) {
		// Initialize MainActivity controls
		btnStartGreenActivity = (Button) findViewById(R.id.btnStartGreenActivity);
		btnStartGreenActivity.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent greenActivityIntent = new Intent(MainActivity.this, GreenActivity.class);
				/*
				 * greenActivityIntent.putExtra("key", value); //Optional
				 * parameters
				 */
				MainActivity.this.startActivity(greenActivityIntent);
			}
		});
	}
}
