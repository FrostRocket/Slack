package com.Slack.test.utils;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import com.Slack.test.model.Package;

public class AndroidUtils {

    private static final String TAG = "AndroidUtils";

    /**
     * Uses package manager to find the package name of the device launcher. Usually this package
     * is "com.android.launcher" but can be different at times. This is a generic solution which
     * works on all platforms.
     */
    public static String getLauncherPackageName() {
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);

        return resolveInfo.activityInfo.packageName;
    }

    public static void clearData() {
        Log.i(TAG, "Clearing app data");
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("pm clear " + Package.SLACK);
    }

    public static void clearLogcat() {
        Log.i(TAG, "Clearing logcat history");
        InstrumentationRegistry.getInstrumentation().getUiAutomation().executeShellCommand("logcat -c");
    }
}
