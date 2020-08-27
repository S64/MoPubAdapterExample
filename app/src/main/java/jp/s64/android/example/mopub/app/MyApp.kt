package jp.s64.android.example.mopub.app

import android.app.Activity
import android.app.Application
import com.mopub.common.MoPub
import com.mopub.common.SdkConfiguration
import com.mopub.common.SdkInitializationListener
import com.mopub.common.logging.MoPubLog
import jp.s64.android.example.mopub.lib.MyAdapterConfiguration
import jp.s64.android.example.mopub.lib.msg

class MyApp : Application() {

    companion object {

        private const val TAG = "MyApp"

        const val adUnitId = BuildConfig.AD_UNIT_ID

    }

    fun initMoPub(source: Activity) {
        val conf = SdkConfiguration.Builder(adUnitId)
            .withMediatedNetworkConfiguration(
                MyAdapterConfiguration.javaClass.name,
                mapOf()
            )
            .withLogLevel(MoPubLog.LogLevel.DEBUG)
            .build()

        MoPub.initializeSdk(source, conf, listener)
    }

    private val listener = SdkInitializationListener {
        msg(TAG, this@MyApp, "onInitializationFinished")
    }

}
