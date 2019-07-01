package ru.skillbranch.devintencive.models

import android.provider.ContactsContract

class UserView(
    val id: String,
    val fullName: String,
    val nickname: String,
    var avatar:String? = null,
    var status: String? ="offline",
    var initials: String?
) {

    fun printMe() {
        println()
    }
}