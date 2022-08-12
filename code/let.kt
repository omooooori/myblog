var list : MutableList<String>? = null

// listはnullのため、処理は実行されない
list?.let {
  for(item in it) println(item.toUpperCase())
}

// listに要素を追加
list = mutableListOf<String>()
list.add("dog")
list.add("cat")
list.add("rabbit")

// listはnullではないので、処理は実行される
list?.let {
  for(item in it) println(item.toUpperCase())
}

fun main(args: Array<String>) {
  println("test")
}