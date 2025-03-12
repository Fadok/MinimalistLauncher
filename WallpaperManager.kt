package com.minimalistlauncher.services

import android.app.WallpaperManager
import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.InputStream

object WallpaperSetter {
    fun setWallpaper(context: Context, uri: Uri) {
        val wallpaperManager = WallpaperManager.getInstance(context)
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        val bitmap = BitmapFactory.decodeStream(inputStream)
        wallpaperManager.setBitmap(bitmap)
    }
}
