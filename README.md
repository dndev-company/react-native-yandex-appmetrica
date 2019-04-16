# react-native-yandex appmetrica

## Why

Bridge react-native-appmetrica has old versions of all dependencies and don't support Appmetrica Push SDK

## Activate

    import YandexAppmetrica from 'react-native-yandex-appmetrica';

    // Activate with api key
    YandexAppmetrica.activate('YOUR-API-KEY');

    // Activate with config
    YandexAppmetrica.activate(config);

    // Activate pushes
    YandexAppmetrica.activate(config, true);