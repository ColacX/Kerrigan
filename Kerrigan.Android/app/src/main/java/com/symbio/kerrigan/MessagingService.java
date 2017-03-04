package com.symbio.kerrigan;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

//handles all incoming message from the firebase service
public class MessagingService extends FirebaseMessagingService {

    private static final String TAG = "MessagingService";
    NotificationHelper notificationService = new NotificationHelper();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "onMessageReceived");
        String from = remoteMessage.getFrom();
        String messageType = remoteMessage.getMessageType();

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            String messageText = remoteMessage.getData().toString();
            notificationService.showNotification(this, messageText);
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            String messageText = remoteMessage.getNotification().getBody().toString();
            notificationService.showNotification(this, messageText);
        }
    }
}
