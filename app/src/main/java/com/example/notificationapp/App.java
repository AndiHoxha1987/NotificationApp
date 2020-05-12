package com.example.notificationapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.os.Build;
public class App extends Application {

    public static final String GROUP_CHANEL_1_ID = "Personal";
    public static final String GROUP_CHANEL_2_ID = "Business";
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";
    public static final String CHANNEL_3_ID = "channel3";
    public static final String CHANNEL_4_ID = "channel4";
    public static final String CHANNEL_5_ID = "channel5";
    public static final String CHANNEL_6_ID = "channel6";
    public static final String CHANNEL_7_ID = "channel7";
    public static final String CHANNEL_8_ID = "channel8";
    public static final String CHANNEL_9_ID = "channel9";
    public static final String CHANNEL_10_ID = "channel10";
    public static final String CHANNEL_11_ID = "channel11";
    public static final String CHANNEL_12_ID = "channel12";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }
    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannelGroup notificationChannelGroup1 = new NotificationChannelGroup(
                    GROUP_CHANEL_1_ID,
                    "Personal"
            );

            NotificationChannelGroup notificationChannelGroup2 = new NotificationChannelGroup(
                    GROUP_CHANEL_2_ID,
                    "Business"
            );

            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");
            channel1.setGroup(GROUP_CHANEL_1_ID);

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("This is Channel 2");
            channel2.setGroup(GROUP_CHANEL_1_ID);

            NotificationChannel channel3 = new NotificationChannel(
                    CHANNEL_3_ID,
                    "Channel 3",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel3.setDescription("This is Channel 3");
            channel3.setGroup(GROUP_CHANEL_1_ID);

            NotificationChannel channel4 = new NotificationChannel(
                    CHANNEL_4_ID,
                    "Channel 4",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel4.setDescription("This is Channel 4");

            NotificationChannel channel5 = new NotificationChannel(
                    CHANNEL_5_ID,
                    "Channel 5",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel5.setDescription("This is Channel 5");

            NotificationChannel channel6 = new NotificationChannel(
                    CHANNEL_6_ID,
                    "Channel 6",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel6.setDescription("This is Channel 6");
            channel6.setGroup(GROUP_CHANEL_2_ID);

            NotificationChannel channel7 = new NotificationChannel(
                    CHANNEL_7_ID,
                    "Channel 7",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel7.setDescription("This is Channel 7");
            channel7.setGroup(GROUP_CHANEL_2_ID);

            NotificationChannel channel8 = new NotificationChannel(
                    CHANNEL_8_ID,
                    "Channel 8",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel8.setDescription("This is Channel 8");
            channel8.setGroup(GROUP_CHANEL_2_ID);

            NotificationChannel channel9 = new NotificationChannel(
                    CHANNEL_9_ID,
                    "Channel 9",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel9.setDescription("This is Channel 9");

            NotificationChannel channel10 = new NotificationChannel(
                    CHANNEL_10_ID,
                    "Channel 10",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel10.setDescription("This is Channel 10");
            channel10.setGroup(GROUP_CHANEL_2_ID);

            NotificationChannel channel11 = new NotificationChannel(
                    CHANNEL_11_ID,
                    "Channel 11",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel11.setDescription("This is Channel 11");
            channel11.setGroup(GROUP_CHANEL_2_ID);

            NotificationChannel channel12 = new NotificationChannel(
                    CHANNEL_12_ID,
                    "Channel 12",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel12.setDescription("This is Channel 12");

            NotificationManager manager = getSystemService(NotificationManager.class);
            assert manager != null;
            manager.createNotificationChannelGroup(notificationChannelGroup1);
            manager.createNotificationChannelGroup(notificationChannelGroup2);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
            manager.createNotificationChannel(channel3);
            manager.createNotificationChannel(channel4);
            manager.createNotificationChannel(channel5);
            manager.createNotificationChannel(channel6);
            manager.createNotificationChannel(channel7);
            manager.createNotificationChannel(channel8);
            manager.createNotificationChannel(channel9);
            manager.createNotificationChannel(channel10);
            manager.createNotificationChannel(channel11);
            manager.createNotificationChannel(channel12);
        }
    }
}