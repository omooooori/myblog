# スコープ関数letの使い方

``` Kotlin
(A) 変数.let { 処理 }
(B) 変数?.let { 処理 }
```

``` Kotlin
fun main(args: Array<String>) {

    var list : MutableList<String>? = null

    // listはnullのため、処理は実行されない
    list?.let {
        println("let 1")
        for(item in it) println(item.uppercase())
    }

    // listを初期化
    list = mutableListOf<String>()

    // listに要素を追加
    list.add("rice ball")
    list.add("carry")
    list.add("pasta")

    // listはnullではないので、処理は実行される
    list?.let {
        println("let 2")
        for(item in it) println(item.uppercase())
    }
}
```


(A) 変数.let { 処理 }

``` Kotlin
    var list : MutableList<String>? = null

    // listはnullのため、処理は実行されない
    list?.let {
        println("let 1")
        for(item in it) println(item.uppercase())
    }
```

↓

``` Kotlin
    var list : MutableList<String>? = null

    // listはnullのため、処理は実行されない
    list.let {
        println("let 1")
        for(item in it) println(item.uppercase())
    }
```
こうするとコンパイルエラーが発生します。

Not nullable value required to call an 'iterator()' method on for-loop range

