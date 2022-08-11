## PermissionDispatcherとは

- Runtime Permissionをシンプルに扱うためのライブラリ
- Kotlin/Javaの両方をサポートしている


```
@RuntimePermissions // 【必須】ActivityやFragmentにアノテーションをつけることで、Runtime Permissionを使うことを登録する。
class MainActivity : AppCompatActivity(), View.OnClickListener {

    @NeedsPermission(Manifest.permission.CAMERA) // 【必須】関数ごとにパーミッションが必要かどうか設定できる。
    fun showCamera() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.sample_content_fragment, CameraPreviewFragment.newInstance())
                .addToBackStack("camera")
                .commitAllowingStateLoss()
    }

    @OnShowRationale(Manifest.permission.CAMERA)
    fun showRationaleForCamera(request: PermissionRequest) {
        showRationaleDialog(R.string.permission_camera_rationale, request)
    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    fun onCameraDenied() {
        Toast.makeText(this, R.string.permission_camera_denied, Toast.LENGTH_SHORT).show()
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    fun onCameraNeverAskAgain() {
        Toast.makeText(this, R.string.permission_camera_never_askagain, Toast.LENGTH_SHORT).show()
    }
}
```
上記のようなコードを書くことで、ビルド後にコードが自動生成され、Permission Dispatcherを利用できるようになる。

## 今回つまった所

案件対応するにあたって、JavaコードをKotlinコードにしようと思ったんです。

Android Studioのメニュー、Code ＞Generate Java File to Kotlin FIleからKotlin変換をする。

Nullセーフ関連のビルドエラーを解消。

```
~FragmentPermissionsDispatcher.someMethod()

~FragmentPermissionsDispatcherは自動生成されたクラス。
someMethodは適当な名前です。この関数も自動生成されています。


// エラー
Unresolved reference: ~PermissionsDispathcer
```

といったエラーが発生。なんだこれは？返還前のJava側のコードと見比べたが、Java側では同じコードで実行できている。
自動生成されるコードもあるのに、なぜ参照できないのだろう？


## 解決した方法


```
~FragmentPermissionsDispatcher.someMethod()

↓

someMethod()
```

自動生成されたコードを見てみましょう。以下のようになっています。
```
public fun ~Fragment.someMethod(): Unit { ・・・ }
```

よく見ると、someMethod()は~Fragmentクラスの拡張関数として自動生成されているじゃないですか。拡張関数を呼ぶ場合は単に関数名だけで参照可能なんですよね。なるほど。

Javaの場合は、拡張関数ではなく、~FragmentPermissionsDispatcherというクラスが自動生成されるため、クラス名.メソッド名で呼ぶことができるんですね。



## 参考にしたサイト

- [PermissionsDispatcherによる権限管理](https://qiita.com/beyondseeker/items/1f964d011ee0a10d9376)
- [PermissionsDispatcherでRuntime Permissionをちょっとだけ楽にする](https://qiita.com/offwhite/items/d2371e477b307268f97e)
