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
        YandexAppmetrica.reportEvent(message, params)
    },

    reportError(message, reason) {
        YandexAppmetrica.reportError(message, reason);
    },

    setUserProfileID(id) {
        YandexAppmetrica.setUserProfileID(id)
    },
};