package com.example.saishekar.rbnavigation;

import android.app.Application;
import android.content.Context;

import com.example.saishekar.rbnavigation.helper.LocaleHelper;

public class MainApplication extends Application {
	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
	}

}
