package com.dndev.appmetrica;

import android.content.BroadcastReceiver;

import com.yandex.metrica.push.YandexMetricaPush;

abstract public class YandexAppmetricaSilentPushReceiver extends BroadcastReceiver {
    public static final String EXTRA_PAYLOAD = YandexMetricaPush.EXTRA_PAYLOAD;
    public static final String EXTRA_ACTION_INFO = YandexMetricaPush.EXTRA_ACTION_INFO;
    public static final String OPEN_DEFAULT_ACTIVITY_ACTION = YandexMetricaPush.OPEN_DEFAULT_ACTIVITY_ACTION;
}
