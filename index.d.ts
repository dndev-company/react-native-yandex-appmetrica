declare module 'react-native-yandex-appmetrica' {
    type YandexAppmetricaConfig = {
        apiKey: string;
        sessionTimeout?: number;
        firstActivationAsUpdate?: boolean;
    };

    const activateWithApiKey: (apiKey: string, push?: boolean) => void;
    const activateWithConfig: (config: YandexAppmetricaConfig, push?: boolean) => void;
    const reportEvent: (message: string, params?: object) => void;
    const reportError: (message: string, reason: object) => void;
    const setUserProfileID: (id: number) => void;

    export default {
        activateWithApiKey,
        activateWithConfig,
        reportEvent,
        reportError,
        setUserProfileID,
    };
}