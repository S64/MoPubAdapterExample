package jp.s64.android.example.mopub.lib

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.mopub.common.LifecycleListener
import com.mopub.common.MoPubReward
import com.mopub.mobileads.AdData
import com.mopub.mobileads.BaseAd

class MyRewardedVideoAdapter : BaseAd() {

    companion object {

        private const val TAG = "MyRewardedVideoAdapter"
        private const val MY_AD_NETWORK_ID = "my-ad-network-id"

    }

    private lateinit var cachedApp: Application

    private var lastActivity: Activity? = null

    private fun msg(context: Context?, msg: String) {
        msg(TAG, context ?: lastActivity ?: cachedApp, msg)
    }

    private val lifecycle = object : LifecycleListener {

        override fun onCreate(activity: Activity) {
            lastActivity = activity
            msg(activity, "LifecycleListener#onCreate")
        }

        override fun onStart(activity: Activity) {
            lastActivity = activity
            msg(activity, "LifecycleListener#onStart")
        }

        override fun onPause(activity: Activity) {
            lastActivity = activity
            msg(activity, "LifecycleListener#onPause")
        }

        override fun onResume(activity: Activity) {
            lastActivity = activity
            msg(activity, "LifecycleListener#onResume")
        }

        override fun onRestart(activity: Activity) {
            lastActivity = activity
            msg(activity, "LifecycleListener#onRestart")
        }

        override fun onStop(activity: Activity) {
            msg(activity, "LifecycleListener#onStop")
        }

        override fun onDestroy(activity: Activity) {
            msg(activity, "LifecycleListener#onDestroy")
        }

        override fun onBackPressed(activity: Activity) {
            msg(activity, "LifecycleListener#onBackPressed")
        }

    }

    override fun onInvalidate() {
        msg(null, "onInvalidate")
    }

    override fun getLifecycleListener() = lifecycle

    override fun getAdNetworkId(): String {
        return MY_AD_NETWORK_ID
    }

    override fun checkAndInitializeSdk(launcherActivity: Activity, adData: AdData): Boolean {
        cachedApp = launcherActivity.application
        msg(launcherActivity, "checkAndInitializeSdk")
        return true
    }

    override fun load(context: Context, adData: AdData) {
        msg(context, "load")
        mLoadListener.onAdLoaded()
    }

    override fun show() {
        msg(null, "show")
        mInteractionListener.onAdShown()
        mInteractionListener.onAdImpression()

        MoPubReward.success(MoPubReward.NO_REWARD_LABEL, MoPubReward.DEFAULT_REWARD_AMOUNT).let {
            mInteractionListener.onAdComplete(it)
        }

        mInteractionListener.onAdDismissed()
    }

}
