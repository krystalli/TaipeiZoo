package com.krystal.taipeizoo.extension

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.krystal.taipeizoo.R

fun Context.launchUrl(url: String) {
    val builder = CustomTabsIntent.Builder()
    // Use colorPrimaryDark because we want the text color to be white
    builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
        .setShowTitle(true)
        .addDefaultShareMenuItem()
    val customTabsIntent = builder.build()
    customTabsIntent.launchUrl(this, Uri.parse(url))
}