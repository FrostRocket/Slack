package com.Slack.test.watchers;

import android.util.Log;

import com.Slack.test.utils.AndroidUtils;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.Calendar;

public class SlackTestWatcher extends TestWatcher {

    private static final String TAG = "SlackTestWatcher";

    @Override
    protected void starting(Description desc) {
        Log.i(TAG, "Test started: " + desc.getMethodName());
    }

    @Override
    protected void finished(Description desc) {
        Log.i(TAG, "Test finished: " + desc.getMethodName());
    }

    @Override
    protected void succeeded(Description desc) {
        Log.i(TAG, "Test passed: " + desc.getMethodName());
    }

    @Override
    protected void failed(Throwable e, Description desc) {
        Log.i(TAG, "Test failed: " + desc.getMethodName());
        e.printStackTrace();

        // Do things here, like reporting results to test database, etc.
    }
}
