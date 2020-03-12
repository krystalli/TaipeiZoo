package com.krystal.taipeizoo.extension

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes

fun TextView.showTextIfNotBlank(text: String?) {
    if (text.isNullOrBlank()) {
        visibility = View.GONE
    } else {
        visibility = View.VISIBLE
        this.text = text
    }
}