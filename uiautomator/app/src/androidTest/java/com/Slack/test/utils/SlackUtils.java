package com.Slack.test.utils;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import com.Slack.test.model.Package;
import com.Slack.test.model.Timeout;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SlackUtils {

    private static final String TAG = "SlackUtils";

    static final UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    public static void launchApp() {
        mDevice.pressHome();

        final String launcherPackage = AndroidUtils.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), Timeout.OBJECT_EXISTS);

        Context context = InstrumentationRegistry.getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(Package.SLACK);
        context.startActivity(intent);

        mDevice.wait(Until.hasObject(By.pkg(Package.SLACK).depth(0)), Timeout.OBJECT_EXISTS);
    }
}