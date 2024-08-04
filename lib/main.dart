import 'dart:developer';

import 'package:deviceinfo/deviceInfo.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: DemoScreen(),
    );
  }
}

class DemoScreen extends StatelessWidget {
  const DemoScreen({super.key});

  void getAndPrintDeviceInfo() async {
    final deviceInfo = DeviceInfo();
    final info = await deviceInfo.getDeviceInfo();
    print('Device Info: $info');
  }


  @override
  Widget build(BuildContext context) {
    getAndPrintDeviceInfo();
    return Scaffold(body: Column(

    ),);
  }
}
