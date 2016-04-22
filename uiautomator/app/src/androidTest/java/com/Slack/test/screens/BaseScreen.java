package com.Slack.test.screens;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

public abstract class BaseScreen {

    private static final String TAG = "BaseScreen";

    UiDevice mDevice;

    public BaseScreen() {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }
}