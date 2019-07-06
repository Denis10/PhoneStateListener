package com.vodolazskiy.testphonestatus

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

private const val MY_PERMISSIONS = 10

class MainActivity : AppCompatActivity() {

    private val handler: Handler = Handler()

    private val requestPermissions = {
        val permissions = arrayOf(Manifest.permission.READ_CALL_LOG,
                Manifest.permission.READ_PHONE_STATE)
        ActivityCompat.requestPermissions(this, permissions, MY_PERMISSIONS)
        Toast.makeText(this, "Grant", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG)
                != PackageManager.PERMISSION_GRANTED
                ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            when {
                ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.READ_CALL_LOG) -> {
                    Toast.makeText(this, "Grant READ_PHONE_STATE", Toast.LENGTH_SHORT).show()
                    handler.postDelayed(requestPermissions, 1_000)
                }
                ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.READ_PHONE_STATE) -> {
                    Toast.makeText(this, "Grant READ_CALL_LOG", Toast.LENGTH_SHORT).show()
                    handler.postDelayed(requestPermissions, 1_000)
                }
                else -> requestPermissions.invoke()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacksAndMessages(null)
    }
}
