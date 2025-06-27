package com.omarlkhalil.domain.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.util.Locale
import java.util.regex.Pattern



fun String.isValidName(): Boolean {
    return this.isNotEmpty() && this.length >= 3
}

fun String.isValidGender(): Boolean {
    return this.isNotEmpty() && this in listOf("Male", "Female")
}

fun Int.isValidAge(): Boolean {
    return this.isNotEmpty() && this in 18..100
}


fun String.isValidEmailAddress(): Boolean {
    val ePattern =
        "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
    val p = Pattern.compile(ePattern)
    val m = p.matcher(this)
    return m.matches()
}


fun Int.isNotEmpty(): Boolean {
    return this > 0
}