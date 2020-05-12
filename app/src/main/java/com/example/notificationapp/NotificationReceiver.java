package com.example.notificationapp;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String KEY ="key_text_reply";
            Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
            if (remoteInput != null) {
                CharSequence replyText = remoteInput.getCharSequence(KEY);
                Message answer = new Message(replyText, null);
                MainActivity.MESSAGES.add(answer);
                MainActivity.sendChannel1Notification(context);
            }

    }
}