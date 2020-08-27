package jp.s64.android.example.mopub.lib

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.mopub.common.BaseAdapterConfiguration
import com.mopub.common.MediationSettings
import com.mopub.common.OnNetworkInitializationFinishedListener
import com.mopub.mobileads.MoPubErrorCode

class MyMediationSettings : MediationSettings

class MyAdapterConfiguration : BaseAdapterConfiguration() {

    companion object {

        private const val TAG = "MyAdapterConfiguration"

    }

    override fun getAdapterVersion() = BuildConfig.VERSION_NAME

    override fun getBiddingToken(context: Context) = null

    override fun getMoPubNetworkName() = "MyMoPubNetwork"

    override fun getNetworkSdkVersion() = BuildConfig.VERSION_NAME

    override fun initializeNetwork(
        context: Context,
        configuration: MutableMap<String, String>?,
        listener: OnNetworkInitializationFinishedListener
    ) {
        msg(TAG, context, "initializeNetwork")
        listener.onNetworkInitializationFinished(
            javaClass,
            MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS
        )
    }

}
