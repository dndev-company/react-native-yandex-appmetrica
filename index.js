import { NativeModules } from 'react-native';

const { YandexAppmetrica } = NativeModules;

export default {
    activateWithApiKey(apiKey, push = false) {
        YandexAppmetrica.activateWithApiKey(apiKey, push);
    },

    activateWithConfig(config, push = false) {
        YandexAppmetrica.activateWithConfig(config, push);
    },

    reportEvent(message, params) {
        if (params) {
            YandexAppmetrica.reportEventWithParams(message, params);
        } else {
            YandexAppmetrica.reportEvent(message);
        }
    },

    reportError(message, reason) {
        YandexAppmetrica.reportError(message, reason);
    },

    setUserProfileID(id) {
        YandexAppmetrica.setUserProfileID(id)
    },
};