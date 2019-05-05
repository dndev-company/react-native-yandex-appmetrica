# react-native-yandex-appmetrica

Bridge for Yandex Mobile Metrica SDK and Yandex Mobile Push SDK on both Android and iOS.

## Installation

### Javascript

    npm install @dndev/react-native-yandex-appmetrica

or

    yarn add @dndev/react-native-yandex-appmetrica

## Usage

    import YandexAppmetrica from '@dndev/react-native-yandex-appmetrica';

    // First you need activate with your api-key
    YandexAppmetrica.activateWithApiKey('YOUR-API-KEY);

or

    import YandexAppmetrica from '@dndev/react-native-yandex-appmetrica';

    // First you need activate with your config
    YandexAppmetrica.activateWithConfig(config);

## Methods

| Method             | Parameters                                              | Description                                            |
|--------------------|---------------------------------------------------------|--------------------------------------------------------|
| activateWithApiKey | apiKey: string, [push: boolean = false]                 | Activate SDK with apiKey (activate push notifications) |
| activateWithConfig | config: YandexAppmetricaConfig, [push: boolean = false] | Activate SDK with config (activate push notification)  |
| reportEvent        | message: string, [params: any]                          | Send event                                             |
| reportError        | message: string                                         | Send error                                             |
| setUserProfileID   | id: string                                              | Set user id                                            |

## Interface YandexAppmetricaConfig

| Params                  | Required | Type    |
|-------------------------|----------|---------|
| apiKey                  | +        | string  |
| sessionTimeout          | -        | number  |
| firstActivationAsUpdate | -        | boolean |