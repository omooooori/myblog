package com.example.code_practice

fun main(args: Array<String>) {

    val host = "test"
    host
        .let {
            with(preferences.edit()) {
                putString(CART_HOST_CHANGER_LAST_USED_KEY, it)
                apply()
            }

            field = it
        }
}