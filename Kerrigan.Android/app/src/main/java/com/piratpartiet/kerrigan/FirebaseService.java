package com.piratpartiet.kerrigan;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.iid.FirebaseInstanceId;

//handles registration to googles firebase service
public class FirebaseService extends FirebaseInstanceIdService {

    private static final String TAG = "FirebaseService";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onTokenRefresh: " + refreshedToken);
    }
}
