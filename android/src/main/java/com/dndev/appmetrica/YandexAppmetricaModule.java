package com.dndev.appmetrica;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.push.YandexMetricaPush;

import org.json.JSONObject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class YandexAppmetricaModule extends ReactContextBaseJavaModule {
    @Nonnull
    @Override
    public String getName() {
        return "YandexAppmetrica";
    }

    public YandexAppmetricaModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @ReactMethod
    public void activateWithApiKey(String apiKey) {
        YandexMetricaConfig.Builder configBuilder = YandexMetricaConfig.newConfigBuilder(apiKey);

        this._activate(configBuilder, false);
    }

    @ReactMethod
    public void activateWithApiKey(String apiKey, Boolean push) {
        YandexMetricaConfig.Builder configBuilder = YandexMetricaConfig.newConfigBuilder(apiKey);

        this._activate(configBuilder, push);
    }

    @ReactMethod
    public void activateWithConfig(ReadableMap config) {
        YandexMetricaConfig.Builder configBuilder = YandexMetricaConfig.newConfigBuilder(config.getString("apiKey"));
        if (config.hasKey("sessionTimeout")) {
            configBuilder.withSessionTimeout(config.getInt("sessionTimeout"));
        }
        if (config.hasKey("firstActivationAsUpdate")) {
            configBuilder.handleFirstActivationAsUpdate(config.getBoolean("firstActivationAsUpdate"));
        }

        this._activate(configBuilder, false);
    }

    @ReactMethod
    public void activateWithConfig(ReadableMap config, Boolean push) {
        YandexMetricaConfig.Builder configBuilder = YandexMetricaConfig.newConfigBuilder(config.getString("apiKey"));
        if (config.hasKey("sessionTimeout")) {
            configBuilder.withSessionTimeout(config.getInt("sessionTimeout"));
        }
        if (config.hasKey("firstActivationAsUpdate")) {
            configBuilder.handleFirstActivationAsUpdate(config.getBoolean("firstActivationAsUpdate"));
        }

        this._activate(configBuilder, push);
    }

    @ReactMethod
    public void reportEvent(String message) {
        Log.d("reportEvent", "");
        YandexMetrica.reportEvent(message);
    }

    @ReactMethod
    public void reportEventWithParams(String message, ReadableMap config) {
        Log.d("reportEventWithParams", "");
        YandexMetrica.reportEvent(message, this.getJson(config));
    }

    @ReactMethod
    public void reportError(String message) {
        try {
            Integer.valueOf("00xffWr0ng");
        } catch (Throwable e) {
            YandexMetrica.reportError(message, e);
        }
    }

    @ReactMethod
    public void setUserProfileID(String id) {
        YandexMetrica.setUserProfileID(id);
    }

    private void _activate(YandexMetricaConfig.Builder config, Boolean push) {
        YandexMetrica.activate(getReactApplicationContext().getApplicationContext(), config.build());
        if (push) {
            YandexMetricaPush.init(getReactApplicationContext().getApplicationContext());
        }
        Activity activity = getCurrentActivity();

        if (activity != null) {
            Application application = activity.getApplication();
            YandexMetrica.enableActivityAutoTracking(application);
        }
    }

    private String getJson(ReadableMap readableMap) {
        ReadableMapKeySetIterator iterator = readableMap.keySetIterator();
        JSONObject json = new JSONObject();

        try {
            while (iterator.hasNextKey()) {
                String key = iterator.nextKey();

                switch (readableMap.getType(key)) {
                    case Null:
                        json.put(key, null);
                        break;
                    case Boolean:
                        json.put(key, readableMap.getBoolean(key));
                        break;
                    case Number:
                        json.put(key, readableMap.getDouble(key));
                        break;
                    case String:
                        json.put(key, readableMap.getString(key));
                        break;
                    case Array:
                        json.put(key, readableMap.getArray(key));
                        break;
                    case Map:
                        json.put(key, this.getJson(readableMap.getMap(key)));
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            Log.d("YandexAppmetrica", e.toString());
        }

        return json.toString();
    }
}
