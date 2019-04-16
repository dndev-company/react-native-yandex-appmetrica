package com.dndev.appmetrica;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.yandex.metrica.push.firebase.MetricaMessagingService;

public class YandexAppmetricaFirebaseMessaging extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        new MetricaMessagingService().processPush(this, remoteMessage);

        super.onMessageReceived(remoteMessage);
    }
}
