package com.example.a83661.screenrecorder.util

import android.os.Environment
import com.example.a83661.screenrecorder.base.Constants
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class StringUT {
    companion object {
        /**
         * 创建存储路径
         */
        fun getFilePath(): String {
            val directory = Constants.directory
            if (Environment.MEDIA_MOUNTED != Environment.getExternalStorageState()) {
                return null!!
            }
            val folder = File(directory)
            var success = true
            if (!folder.exists()) {
                success = folder.mkdir()
            }
            val filePath: String
            if (success) {
                val videoName = ("capture" + getCurSysDate() + ".mp4")
                filePath = directory + File.separator + videoName
            } else {
                return null!!
            }
            return filePath
        }

        fun getDirectory(): String {
            return Environment.getExternalStorageDirectory().toString() + File.separator + "ScreenRecordings"

        }

        /**
         * 获取时间戳
         */
        fun getCurSysDate(): Any? {
            return SimpleDateFormat("yyyyMMddHHmmss").format(Date())
        }
    }
}