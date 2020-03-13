package com.krystal.taipeizoo.extension

import android.view.View

fun View.showOrHide(isValid: Boolean?) {
    if (isValid == true) {
        show()
    } else {
        hide()
    }
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}