package com.Slack.test.screens;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;

import com.Slack.test.model.Package;
import com.Slack.test.model.Timeout;

public class SearchScreen extends BaseScreen {

    private static final String TAG = "SearchScreen";

    public boolean hasMessage(String message) {
        BySelector messageTextView = By.text(message);
        mDevice.wait(Until.hasObject(messageTextView), Timeout.OBJECT_EXISTS);

        return mDevice.hasObject(messageTextView);
    }
    public void setSearchText(String searchText) {
        BySelector searchEditText = By.res(Package.SLACK, "actionbar_search");
        mDevice.wait(Until.hasObject(searchEditText), Timeout.OBJECT_EXISTS);
        mDevice.findObject(searchEditText).clear();
        mDevice.findObject(searchEditText).setText(searchText);
    }

    public void pressSearch() {
        mDevice.pressEnter();
    }
}