


## 発生したエラー

@BindView fields must not be private or static.

あるActivityファイルをKotlin化する時にエラーが発生しました。Kotlin化する時には、Android Studioの機能を利用しました。


## 解決方法

```
@BindView(R.id.some_view)
private var mSomeView: View? = null
```

```
@BindView(R.id.some_view)
lateinit var mSomeView: View
```

