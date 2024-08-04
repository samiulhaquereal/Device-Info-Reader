import 'package:flutter/services.dart';

class DeviceInfo {
  static const MethodChannel _channel = MethodChannel('com.example/device_info');

  Future<Map<String, dynamic>> getDeviceInfo() async {
    try {
      final Map<dynamic, dynamic>? deviceInfo = await _channel.invokeMethod('getDeviceInfo');
      return deviceInfo?.cast<String, dynamic>() ?? {};
    } on PlatformException catch (e) {
      print('Failed to get device info: ${e.message}');
      return {};
    }
  }
}
