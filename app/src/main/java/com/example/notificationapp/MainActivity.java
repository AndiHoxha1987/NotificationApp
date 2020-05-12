package com.example.notificationapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.notificationapp.App.CHANNEL_10_ID;
import static com.example.notificationapp.App.CHANNEL_11_ID;
import static com.example.notificationapp.App.CHANNEL_12_ID;
import static com.example.notificationapp.App.CHANNEL_1_ID;
import static com.example.notificationapp.App.CHANNEL_2_ID;
import static com.example.notificationapp.App.CHANNEL_3_ID;
import static com.example.notificationapp.App.CHANNEL_4_ID;
import static com.example.notificationapp.App.CHANNEL_5_ID;
import static com.example.notificationapp.App.CHANNEL_6_ID;
import static com.example.notificationapp.App.CHANNEL_7_ID;
import static com.example.notificationapp.App.CHANNEL_8_ID;
import static com.example.notificationapp.App.CHANNEL_9_ID;
import static com.example.notificationapp.App.GROUP_CHANEL_1_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;
    private MediaSessionCompat mediaSession;
    static List<Message> MESSAGES = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);

        mediaSession = new MediaSessionCompat(this, "tag");

        MESSAGES.add(new Message("Good morning!", "Jack"));
        MESSAGES.add(new Message("Hi", null));
        MESSAGES.add(new Message("How are u guys?", "Jenny"));
    }

    public void sendOnChannel1(View v) {
        if (!notificationManager.areNotificationsEnabled()) {
            openNotificationSettings();
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O &&
                isChannelBlocked(CHANNEL_1_ID)) {
            openChannelSettings(CHANNEL_1_ID);
            return;
        }
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1, notification);
    }

    public void sendOnChannel2(View v) {
        if (!notificationManager.areNotificationsEnabled()) {
            openNotificationSettings();
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O &&
                isChannelBlocked(CHANNEL_2_ID)) {
            openChannelSettings(CHANNEL_2_ID);
            return;
        }
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
        notificationManager.notify(2, notification);
    }

    public void sendOnChannel3(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);
        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage", message);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this,
                0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_3_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.GREEN)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Toast", actionIntent)
                .build();
        notificationManager.notify(3, notification);
    }

    public void sendOnChannel4(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);
        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage", message);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this,
                0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_foreground);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_4_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(largeIcon)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(getString(R.string.long_dummy_text))
                        .setBigContentTitle("Big Content Title")
                        .setSummaryText("Summary Text"))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Toast", actionIntent)
                .build();
        notificationManager.notify(4, notification);
    }

    public void sendOnChannel5(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_5_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("This is line 1")
                        .addLine("This is line 2")
                        .addLine("This is line 3")
                        .addLine("This is line 4")
                        .addLine("This is line 5")
                        .addLine("This is line 6")
                        .addLine("This is line 7")
                        .setBigContentTitle("Big Content Title")
                        .setSummaryText("Summary Text"))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        notificationManager.notify(5, notification);
    }

    public void sendOnChannel6(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);
        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.kali);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_6_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(picture)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(picture)
                        .bigLargeIcon(null))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();
        notificationManager.notify(6, notification);
    }

    public void sendOnChannel7(View v) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Bitmap artwork = BitmapFactory.decodeResource(getResources(), R.drawable.kali);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_7_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(artwork)
                .addAction(R.drawable.ic_dislike, "Dislike", null)
                .addAction(R.drawable.ic_previous, "Previous", null)
                .addAction(R.drawable.ic_pause, "Pause", null)
                .addAction(R.drawable.ic_next, "Next", null)
                .addAction(R.drawable.ic_like, "Like", null)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(1, 2, 3)
                        .setMediaSession(mediaSession.getSessionToken()))
                .setSubText("Sub Text")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
        notificationManager.notify(7, notification);
    }

    public void sendOnChannel8(View v) {
        sendChannel1Notification(this);
    }

    public static void sendChannel1Notification(Context context) {
        Intent activityIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, activityIntent, 0);
        androidx.core.app.RemoteInput remoteInput = new RemoteInput.Builder("key_text_reply")
                .setLabel("Your answer...")
                .build();
        Intent replyIntent;
        PendingIntent replyPendingIntent = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            replyIntent = new Intent(context, NotificationReceiver.class);
            replyPendingIntent = PendingIntent.getBroadcast(context,
                    0, replyIntent, 0);
        } else {
            Toast.makeText(context, "Notify", Toast.LENGTH_SHORT).show();
            //start chat activity instead (PendingIntent.getActivity)
            //cancel notification with notificationManagerCompat.cancel(id)
        }
        NotificationCompat.Action replyAction = new NotificationCompat.Action.Builder(
                R.drawable.ic_reply,
                "Reply",
                replyPendingIntent
        ).addRemoteInput(remoteInput).build();
        NotificationCompat.MessagingStyle messagingStyle =
                new NotificationCompat.MessagingStyle("Me");
        messagingStyle.setConversationTitle("Group Chat");
        for (Message chatMessage : MESSAGES) {
            NotificationCompat.MessagingStyle.Message notificationMessage =
                    new NotificationCompat.MessagingStyle.Message(
                            chatMessage.getText(),
                            chatMessage.getTimestamp(),
                            chatMessage.getSender()
                    );

            messagingStyle.addMessage(notificationMessage);
        }
        Notification notification = new NotificationCompat.Builder(context, CHANNEL_8_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setStyle(messagingStyle)
                .addAction(replyAction)
                .setColor(Color.BLUE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(8, notification);
    }

    public void sendOnChannel9(View v) {

        final int progressMax = 100;
        final NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_9_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Download")
                .setContentText("Download in progress")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setProgress(progressMax, 0, true);
        notificationManager.notify(9, notification.build());
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                for (int progress = 0; progress <= progressMax; progress += 20) {
                    /*notification.setProgress(progressMax, progress, false);
                    notificationManager.notify(2, notification.build());*/
                    SystemClock.sleep(1000);
                }
                notification.setContentText("Download finished")
                        .setProgress(0, 0, false)
                        .setOngoing(false);
                notificationManager.notify(9, notification.build());
            }
        }).start();
    }

    public void sendOnChannel10(View v) {
        final int progressMax = 100;
        final NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_10_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Download")
                .setContentText("Download in progress")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setProgress(progressMax, 0, false);
        notificationManager.notify(10, notification.build());
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                for (int progress = 0; progress <= progressMax; progress += 20) {
                    notification.setProgress(progressMax, progress, false);
                    notificationManager.notify(10, notification.build());
                    SystemClock.sleep(1000);
                }
                notification.setContentText("Download finished")
                        .setProgress(progressMax, 0, false)
                        .setOngoing(false);
                notificationManager.notify(10, notification.build());
            }
        }).start();
    }

    public void sendOnChannel11(View v) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_11_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Download")
                .setContentText("Download in progress")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        notificationManager.notify(11, notification);

        sleep(2000);
        for (int i = 0; i <= 5; i++) {
            notificationManager.notify(11, notification);
            sleep(1000);
        }
    }

    public void sendOnChannel12(View v) {
        //for sdk low than 24
        String title1 = "Title 1";
        String message1 = "Message 1";
        String title2 = "Title 2";
        String message2 = "Message 2";
        Notification notification1 = new NotificationCompat.Builder(this, CHANNEL_12_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title1)
                .setContentText(message1)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setGroup("example_group")
                .build();
        Notification notification2 = new NotificationCompat.Builder(this, CHANNEL_12_ID)
                .setSmallIcon(R.drawable.ic_like)
                .setContentTitle(title2)
                .setContentText(message2)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setGroup("example_group")
                .build();
        Notification summaryNotification = new NotificationCompat.Builder(this, CHANNEL_12_ID)
                .setSmallIcon(R.drawable.ic_reply)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine(title2 + " " + message2)
                        .addLine(title1 + " " + message1)
                        .setBigContentTitle("2 new messages")
                        .setSummaryText("user@example.com"))
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setGroup("example_group")
                .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_CHILDREN)
                .setGroupSummary(true)
                .build();

        sleep(2000);
        notificationManager.notify(12, notification1);
        sleep(2000);
        notificationManager.notify(13, notification2);
        sleep(2000);
        notificationManager.notify(14, summaryNotification);
    }

    private void sleep(final int i) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(i);
            }
        }).start();
    }

    private void openNotificationSettings() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Intent intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
            startActivity(intent);
        } else {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        }
    }

    @RequiresApi(26)
    private boolean isChannelBlocked(String channelId) {
        NotificationManager manager = getSystemService(NotificationManager.class);
        assert manager != null;
        NotificationChannel channel = manager.getNotificationChannel(channelId);
        return channel != null &&
                channel.getImportance() == NotificationManager.IMPORTANCE_NONE;
    }

    @RequiresApi(26)
    private void openChannelSettings(String channelId) {
        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
        intent.putExtra(Settings.EXTRA_CHANNEL_ID, channelId);
        startActivity(intent);
    }

    public void deleteNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = getSystemService(NotificationManager.class);
            assert manager != null;
            manager.deleteNotificationChannel(CHANNEL_3_ID);
            manager.deleteNotificationChannelGroup(GROUP_CHANEL_1_ID);
        }
    }
}
