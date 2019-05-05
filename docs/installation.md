# Installation on Andoird

**android/settings.gradle** Add this code

    ...

    include ':@dndev/react-native-yandex-appmetrica'
    project(':@dndev/react-native-yandex-appmetrica').projectDir = new File(rootProject.projectDir, '../node_modules/@dndev/react-native-yandex-appmetrica/android')

**android/app/build.gradle** Add this code

    ...

    dependencies {
        ...

        implementation project(':@dndev/react-native-yandex-appmetrica')
    }

**android/app/src/main/java/.../MainApplication.java** Add this code

    ...
    import com.dndev.appmetrica.YandexAppmetricaPackage;

    public class MainApplication extends Application implements ReactApplication {
        ...

        @Override List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                ...
                new YandexAppmetricaPackage()
            )
        }
    }
