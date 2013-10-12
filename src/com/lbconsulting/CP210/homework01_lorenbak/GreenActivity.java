package com.lbconsulting.CP210.homework01_lorenbak;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class GreenActivity extends Activity {
	// TAG String for logging GreenActivity
	private final static String TAG = MainActivity.TAG;
	private final static boolean L = MainActivity.L; // enable Logging

	// /////////////////////////////////////////////////////////////////////////////
	// GreenActivity skeleton
	// /////////////////////////////////////////////////////////////////////////////
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// The Activity is being created.
		setContentView(R.layout.activity_main);
		if (L)
			Log.i(TAG, "GreenActivity onCreate Starting.");
		this.doCreate(savedInstanceState);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		// The Activity will be started.
		if (L)
			Log.i(TAG, "GreenActivity onRestart");
	}

	@Override
	protected void onStart() {
		super.onStart();
		// The Activity is starting and about to become visible.
		if (L)
			Log.i(TAG, "GreenActivity onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		// The Activity is visible and "resumed" and running.
		if (L)
			Log.i(TAG, "GreenActivity onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();

		// Another activity is taking focus.
		// This Activity is about to be "paused".
		// Store values to be persisted between instances here.
		if (L)
			Log.i(TAG, "GreenActivity onPause"
					+ (isFinishing() ? " Finishing" : ""));

	}

	@Override
	protected void onStop() {
		super.onStop();
		// The Activity is no longer visible and is now "stopped".
		if (L)
			Log.i(TAG, "GreenActivity onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// The Activity is about to be destroyed.
		if (L)
			Log.i(TAG, "GreenActivity onDestroy"
					+ (isFinishing() ? " Finishing" : ""));
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// Called when state should be saved
		if (L)
			Log.i(TAG, "GreenActivity onSaveInstanceState");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedState) {
		super.onRestoreInstanceState(savedState);

		// If we had state to restore, we note that in the log message
		if (L)
			Log.i(TAG, "GreenActivity onRestoreInstanceState."
					+ (null != savedState ? " Restored state." : ""));
	}

	@Override
	protected void onPostCreate(Bundle savedState) {
		super.onPostCreate(savedState);
		// If we had state to restore, we note that in the log message
		if (L)
			Log.i(TAG, "GreenActivity onPostCreate"
					+ (null == savedState ? " Restored state" : ""));
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		// Resuming the Activity is complete.
		if (L)
			Log.i(TAG, "GreenActivity onPostResume");
	}

	@Override
	protected void onUserLeaveHint() {
		super.onUserLeaveHint();
		// Notification that the user navigated away from this Activity.
		if (L)
			Log.i(TAG, "GreenActivity onUserLeaveHint");
	}

	@Override
	public void onConfigurationChanged(Configuration newConfiguration) {
		super.onConfigurationChanged(newConfiguration);

		// This won't happen unless we declare changes we handle in the manifest
		if (L)
			Log.i(TAG, "GreenActivity onConfigurationChanged");
	}

	@Override
	public void onLowMemory() {
		// No guarantee this is called before or after other callbacks
		if (L)
			Log.i(TAG, "GreenActivity onLowMemory");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		if (L)
			Log.i(TAG, "GreenActivity onCreateOptionsMenu");
		return true;
	}

	// /////////////////////////////////////////////////////////////////////////////
	// GreenActivity specific code
	// /////////////////////////////////////////////////////////////////////////////

	private void doCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_green);

	}
}
