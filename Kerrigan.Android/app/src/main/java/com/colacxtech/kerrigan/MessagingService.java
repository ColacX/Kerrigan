package com.colacxtech.kerrigan;

import android.util.Log;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

//handles all incoming message from the firebase service
public class MessagingService extends FirebaseMessagingService {

    private static final String TAG = "MessagingService";
    NotificationHelper notificationService = new NotificationHelper();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        try {
            Log.d(TAG, "onMessageReceived");

            //check if message contains a data payload.
            if (remoteMessage.getData().size() > 0) {
                Map dataMap = remoteMessage.getData();
                //Log.d(TAG, remoteMessage.getData().toString());
                notificationService.showNotification(this, (String)dataMap.get("title"), (String)dataMap.get("body"), (String)dataMap.get("json"));
            }

            //checking for notification is unnecessary because the android system will display it instead.
//            // Check if message contains a notification payload.
//            if (remoteMessage.getNotification() != null) {
//                notificationService.showNotification(this, remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
//            }
        }
        catch (Throwable t)
        {
            FirebaseCrash.report(t);
        }
    }
}
