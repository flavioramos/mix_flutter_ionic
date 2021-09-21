package com.example.flutter_project

import android.content.Intent
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import io.ionic.photogallery.MainActivityCamera
import io.ionic.starter.MainActivity


class MainActivity : FlutterActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GeneratedPluginRegistrant.registerWith(flutterEngine!!)

        MethodChannel(flutterEngine!!.dartExecutor.binaryMessenger, "com.example.ecs_flutter_test/test")
                .setMethodCallHandler { call, result ->
                    when (call.method) {
                        "openIonic1" -> {
                            val intent = Intent(context, MainActivity::class.java)
                            intent.putExtra("name","config_ionic")
                            startActivity(intent)
                        }
                        "openIonic2" -> {
                            val intent = Intent(context, MainActivityCamera::class.java)
                            intent.putExtra("name","config_ionic_camera")
                            startActivity(intent)
                        }
                    }
                }
    }
}
