package com.lbconsulting.CP210.homework01_lorenbak;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.Toast;

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
			Log.i(TAG, "MainActivity onCreateOptionsMenu");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String msg = null;

		switch (item.getItemId()) {

		case R.id.orientation:
			this.ShowDeviceOrientation();
			return true;

		case R.id.action_settings:
			// TODO code menu masterListSettings
			msg = "This activity has no settings.";
			Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG)
					.show();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	} // /////////////////////////////////////////////////////////////////////////////

	// GreenActivity specific code
	// /////////////////////////////////////////////////////////////////////////////

	private void doCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_green);

	}

	private void ShowDeviceOrientation() {

		Display display = ((WindowManager) this
				.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		int rotation = display.getRotation();

		/*
		 * If a device has a naturally tall screen, and the user has turned it
		 * on its side to go into a landscape orientation, the value returned
		 * here may be either Surface.ROTATION_90 or Surface.ROTATION_270
		 * depending on the direction it was turned. The angle is the rotation
		 * of the drawn graphics on the screen, which is the opposite direction
		 * of the physical rotation of the device. For example, if the device is
		 * rotated 90 degrees counter-clockwise, to compensate rendering will be
		 * rotated by 90 degrees clockwise and thus the returned value here will
		 * be Surface.ROTATION_90.
		 */

		String msg = "";
		switch (rotation) {
		case Surface.ROTATION_0:
			msg = "Natural portrait orientation.\nNot turned.";
			break;

		case Surface.ROTATION_90:
			msg = "Landscape orientation.\nTurned 90 degrees counter-clockwise.";
			break;

		case Surface.ROTATION_180:
			msg = "Portrait orientation.\nTurned 180 degrees.";
			break;

		case Surface.ROTATION_270:
			msg = "Landscape orientation.\nTurned 90 degrees clockwise.";
			break;

		default:
			msg = "Device orientation not found!";
			break;
		}

		this.ShowOrientationDialog(msg);
	}

	private void ShowOrientationDialog(String message) {
		// Show a dialog so the user can input the new List's Title.
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);

		dialog.setTitle("Device Orientation");
		dialog.setMessage(message);

		dialog.setPositiveButton(getString(R.string.OK),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int whichButton) {
						// Do nothing
					}
				});
		dialog.show();
	}
}
