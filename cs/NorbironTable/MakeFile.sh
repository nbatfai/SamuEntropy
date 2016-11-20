mvn clean install && adb install -r target/NeuronTable.apk &&
adb shell am start -a android.intent.action.MAIN -n batfai.samuentropy.brainboard7/batfai.samuentropy.brainboard7.SplashActivity &&
adb logcat