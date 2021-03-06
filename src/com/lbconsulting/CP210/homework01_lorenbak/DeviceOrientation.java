package com.lbconsulting.CP210.homework01_lorenbak;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

public class DeviceOrientation {
	/*
	 * If a device has a naturally tall screen, and the user has turned it on
	 * its side to go into a landscape orientation, the value returned here may
	 * be either Surface.ROTATION_90 or Surface.ROTATION_270 depending on the
	 * direction it was turned. The angle is the rotation of the drawn graphics
	 * on the screen, which is the opposite direction of the physical rotation
	 * of the device. For example, if the device is rotated 90 degrees
	 * counter-clockwise, to compensate rendering will be rotated by 90 degrees
	 * clockwise and thus the returned value here will be Surface.ROTATION_90.
	 */
	private int rotation;
	private String orientationMessage = "";
	private int orientation;
	private Context context;

	/**
	 * Class constructor that determines the device's orientation and rotation
	 * 
	 * @param context
	 */
	public DeviceOrientation(Context context) {
		this.context = context;

		this.orientation = this.context.getResources().getConfiguration().orientation;
		Display display = ((WindowManager) this.context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		this.rotation = display.getRotation();

		switch (rotation) {
		case Surface.ROTATION_0:
			switch (this.orientation) {
			case Configuration.ORIENTATION_PORTRAIT:
				this.orientationMessage = this.context.getString(R.string.NaturalPortrait);
				break;

			case Configuration.ORIENTATION_LANDSCAPE:
				this.orientationMessage = this.context.getString(R.string.NaturalLandscape);
				break;

			default:
				this.orientationMessage = this.context.getString(R.string.OrientationNotFound);
			}
			break;

		case Surface.ROTATION_90:
			switch (this.orientation) {
			case Configuration.ORIENTATION_PORTRAIT:
				this.orientationMessage = this.context.getString(R.string.Portrait90Degrees);
				break;

			case Configuration.ORIENTATION_LANDSCAPE:
				this.orientationMessage = this.context.getString(R.string.Landscape90Degrees);
				break;

			default:
				this.orientationMessage = this.context.getString(R.string.OrientationNotFound);
			}
			break;

		case Surface.ROTATION_180:
			switch (this.orientation) {
			case Configuration.ORIENTATION_PORTRAIT:
				this.orientationMessage = this.context.getString(R.string.Portrait180Degrees);
				break;

			case Configuration.ORIENTATION_LANDSCAPE:
				this.orientationMessage = this.context.getString(R.string.Landscape180Degrees);
				break;

			default:
				this.orientationMessage = this.context.getString(R.string.OrientationNotFound);
			}
			break;

		case Surface.ROTATION_270:
			switch (this.orientation) {
			case Configuration.ORIENTATION_PORTRAIT:
				this.orientationMessage = this.context.getString(R.string.Portrait270Degrees);
				break;

			case Configuration.ORIENTATION_LANDSCAPE:
				this.orientationMessage = this.context.getString(R.string.Landscape270Degrees);
				break;

			default:
				this.orientationMessage = this.context.getString(R.string.OrientationNotFound);
			}
			break;

		default:
			this.orientationMessage = this.context.getString(R.string.OrientationNotFound);
			break;
		}
	}

	public int getRotation() {
		return this.rotation;
	}

	public String getOrientationMessage() {
		return this.orientationMessage;
	}

	/**
	 * Shows a dialog showing the device's orientation to the user
	 */
	public void ShowOrientationDialog() {
		// Show a dialog showing the device's orientation.
		AlertDialog.Builder dialog = new AlertDialog.Builder(this.context);

		dialog.setTitle(this.context.getString(R.string.action_orientation));
		dialog.setMessage(this.orientationMessage);

		dialog.setPositiveButton(this.context.getString(R.string.OK),
				new DialogInterface.OnClickListener() {

					@SuppressWarnings("hiding")
					@Override
					public void onClick(DialogInterface dialog, int whichButton) {
						// Do nothing
					}
				});
		dialog.show();
	}
}
