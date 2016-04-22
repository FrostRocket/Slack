package com.Slack.test.screens;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;

import com.Slack.test.model.Package;
import com.Slack.test.model.Timeout;

public class HomeScreen extends BaseScreen {

    private static final String TAG = "HomeScreen";

    public boolean isVisible() {
        BySelector avatar = By.res(Package.SLACK, "avatar_button");
        mDevice.wait(Until.hasObject(avatar), Timeout.OBJECT_EXISTS);

        return mDevice.hasObject(avatar);
    }

    public void openMenu() {
        BySelector teamSelectionButton = By.res(Package.SLACK, "team_selection_icon");

        if(!mDevice.wait(Until.hasObject(teamSelectionButton), Timeout.OBJECT_EXISTS)) {
            BySelector avatar = By.res(Package.SLACK, "avatar_button");
            mDevice.wait(Until.hasObject(avatar), Timeout.OBJECT_EXISTS);
            mDevice.findObject(avatar).click();
        }
    }

    public void closeMenu() {
        BySelector drawer = By.res(Package.SLACK, "drawer_layout");

        if(mDevice.wait(Until.hasObject(drawer), Timeout.OBJECT_EXISTS)) {
            mDevice.pressBack();
        }
    }

    public void openSlackbotConversation() {
        openMenu();

        BySelector slackbotMenuItem = By.text("slackbot");
        mDevice.wait(Until.hasObject(slackbotMenuItem), Timeout.OBJECT_EXISTS);
        mDevice.findObject(slackbotMenuItem).click();
    }

    public void pressOverlay() {
        BySelector overlayButton = By.res(Package.SLACK, "overlay_button");
        mDevice.wait(Until.hasObject(overlayButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(overlayButton).click();
    }

    public void sendTextMessage(String message) {
        setTextMessage(message);
        pressSendButton();
    }

    public void setTextMessage(String message) {
        BySelector messageEditText = By.res(Package.SLACK, "message_input_field");
        mDevice.wait(Until.hasObject(messageEditText), Timeout.OBJECT_EXISTS);
        mDevice.findObject(messageEditText).clear();
        mDevice.findObject(messageEditText).setText(message);
    }

    public void pressSendButton() {
        BySelector sendButton = By.res(Package.SLACK, "message_send_btn");
        mDevice.wait(Until.hasObject(sendButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(sendButton).click();
    }

    public void pressSearchButton() {
        BySelector searchButton = By.res(Package.SLACK, "search_button");
        mDevice.wait(Until.hasObject(searchButton), Timeout.OBJECT_EXISTS);
        mDevice.findObject(searchButton).click();
    }

    public void longPressTextMessage(String message) {
        BySelector messageTextView = By.text(message);
        mDevice.wait(Until.hasObject(messageTextView), Timeout.OBJECT_EXISTS);
        mDevice.findObject(messageTextView).longClick();
    }

    public void pressMessageMenuItem(String menuItemText) {
        BySelector messageMenuItem = By.text(menuItemText);
        mDevice.wait(Until.hasObject(messageMenuItem), Timeout.OBJECT_EXISTS);
        mDevice.findObject(messageMenuItem).click();
    }
}