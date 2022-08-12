package com.example.code_practice

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