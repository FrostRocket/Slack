package com.Slack.test.watchers;

import android.util.Log;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class SlackSuiteWatcher extends TestWatcher {

    private static final String TAG = "SlackSuiteWatcher";

    @Override
    protected void starting(Description desc) {
        String suite = desc.getClassName();
        Log.i(TAG, "Suite started: " + suite.substring(suite.lastIndexOf(".") + 1));
    }

    @Override
    protected void finished(Description desc) {
        String suite = desc.getClassName();
        Log.i(TAG, "Suite finished: " + suite.substring(suite.lastIndexOf(".") + 1));
    }

    @Override
    protected void succeeded(Description desc) {
        String suite = desc.getClassName();
        Log.i(TAG, "Suite passed: " + suite.substring(suite.lastIndexOf(".") + 1));
    }

    @Override
    protected void failed(Throwable e, Description desc) {
        String suite = desc.getClassName();
        Log.i(TAG, "Suite failed: " + suite.substring(suite.lastIndexOf(".") + 1));
        e.printStackTrace();
    }
}
