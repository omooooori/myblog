

```
public class MyApplicationBase extends Application {

    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());
        }
        super.onCreate();
    }
```

StrictMode.setThreadPolicy() でスレッドに関連するポリシーを、StrictMode.setVm Policy() で VM(仮想マシン)に関連するポリシーを設定します。どちらのポリシーも dete ct で始まるメソッドで検知する違反のタイプを設定し、penalty で始まるメソッドで違反を 検知した場合のアクションを設定します。

ここではメモリリークに関連する4種類の設定を行っています。
- detectActivityLeaks()

Activity のサブクラスのメモリリークを検知します

- detectLeakedClosableObjects()

InputStream など、Closable クラスのサブクラスの close() 忘れを検知します

- detectLeakedRegistrationObjects()

BroadcastReceiver または ServiceConnection のリークを検知します

- detectLeakedSqlLiteObjects()

SQLiteCursor など SQLite 関連オブジェクトの close() 忘れを検知します

