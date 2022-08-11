## getColorが非推奨 

public int getColor (int id)がは API 23 から Deprecated（非推奨）になっているので、使用しているとAndroid Studioから怒られます。OSバージョンごとに処理を分けるのもあるそうですが、そのif文を書くことでコード量が無駄に増えてしまうのを避けるためにも、以下のような対応を行いました。

変更前
```
resources.getColor(R.color.someColor)
```

変更後
```
    ContextCompat.getColor(
        requireContext(),
        R.color.someColor
    )
```

## 参考にしたサイト

- [getResources().getColor() is deprecated](https://www.androidbugfix.com/2022/06/getresourcesgetcolor-is-deprecated.html)
- [getResources().getColor() is deprecated [duplicate]](https://stackoverflow.com/questions/31842983/getresources-getcolor-is-deprecated)
- [【Android Studio】getColorメソッドのDeprecated解消法（Java & Kotlin対応）](https://codeforfun.jp/android-studio-how-to-solve-deprecated-getcolor-method/)