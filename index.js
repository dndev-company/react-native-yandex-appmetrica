import { NativeModules, Platform } from 'react-native';

const { YandexAppmetrica } = NativeModules;

export default {
    activateWithApiKey(apiKey, push = false) {
        if (Platform.OS === 'ios') {
            YandexAppmetrica.activateWithApiKey(apiKey);
        } else {
            YandexAppmetrica.activateWithApiKey(apiKey, push);
        }
    },

    activateWithConfig(config, push = false) {
        if (Platform.OS === 'ios') {
            YandexAppmetrica.activateWithConfig(config);
        } else {
            YandexAppmetrica.activateWithConfig(config, push);
        } 
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