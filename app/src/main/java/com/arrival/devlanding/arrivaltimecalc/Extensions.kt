package com.arrival.devlanding.arrivaltimecalc

import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat


fun Context.isPermissionGranted(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}
