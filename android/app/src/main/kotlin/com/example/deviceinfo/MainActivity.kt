package com.example.deviceinfo

import android.os.Build
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.example/device_info"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL)
            .setMethodCallHandler { call, result ->
                if (call.method == "getDeviceInfo") {
                    val deviceInfo = mapOf(
                        "brand" to Build.BRAND,
                        "model" to Build.MODEL,
                        "device" to Build.DEVICE,
                        "manufacturer" to Build.MANUFACTURER,
                        "product" to Build.PRODUCT,
                        "versionRelease" to Build.VERSION.RELEASE,
                        "versionSdkInt" to Build.VERSION.SDK_INT,
                        "hardware" to Build.HARDWARE,
                        "fingerprint" to Build.FINGERPRINT,
                        "id" to Build.ID,
                        "bootloader" to Build.BOOTLOADER,
                        "radioVersion" to Build.getRadioVersion(),
                        "cpuAbi" to Build.CPU_ABI,
                        "cpuAbi2" to Build.CPU_ABI2,
                        "serial" to Build.SERIAL
                    )
                    result.success(deviceInfo)
                } else {
                    result.notImplemented()
                }
            }
    }
}
