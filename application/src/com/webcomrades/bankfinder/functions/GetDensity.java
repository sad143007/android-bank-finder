package com.webcomrades.bankfinder.functions;

import android.content.Context;
import android.util.DisplayMetrics;

public enum GetDensity {

	F;

	public enum Density {
		MDPI, HDPI, XHDPI;
	}

	public Density apply(Context context) {
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		
		if (dm.density == DisplayMetrics.DENSITY_MEDIUM)
			return Density.MDPI;
		else if (dm.density == DisplayMetrics.DENSITY_HIGH)
			return Density.HDPI;
		else if (dm.density == DisplayMetrics.DENSITY_XHIGH)
			return Density.XHDPI;

		return Density.HDPI;
	}
}