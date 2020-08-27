package jp.s64.android.example.mopub.app

import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mopub.common.MoPubReward
import com.mopub.mobileads.MoPubErrorCode
import com.mopub.mobileads.MoPubRewardedVideoListener
import com.mopub.mobileads.MoPubRewardedVideos
import jp.s64.android.example.mopub.lib.MyMediationSettings
import jp.s64.android.example.mopub.lib.getInstanceId
import jp.s64.android.example.mopub.lib.msg

class AdDelegate(
    private val self: AppCompatActivity,
    private val tag: String,
    private val load: Button,
    private val show: Button,
    private val instanceId: TextView,
    private val newActivity: Button
) {

    private val listener = object : MoPubRewardedVideoListener {

        override fun onRewardedVideoLoadSuccess(adUnitId: String) {
            msg(tag, self, "onRewardedVideoLoadSuccess")
            refreshUi()
        }

        override fun onRewardedVideoLoadFailure(adUnitId: String, errorCode: MoPubErrorCode) {
            msg(tag, self, "onRewardedVideoLoadFailure")
            refreshUi()
        }

        override fun onRewardedVideoStarted(adUnitId: String) {
            msg(tag, self, "onRewardedVideoStarted")
            refreshUi()
        }

        override fun onRewardedVideoPlaybackError(adUnitId: String, errorCode: MoPubErrorCode) {
            msg(tag, self, "onRewardedVideoPlaybackError")
            refreshUi()
        }

        override fun onRewardedVideoClicked(adUnitId: String) {
            msg(tag, self, "onRewardedVideoClicked")
            refreshUi()
        }

        override fun onRewardedVideoClosed(adUnitId: String) {
            msg(tag, self, "onRewardedVideoClosed")
            refreshUi()
        }

        override fun onRewardedVideoCompleted(adUnitIds: MutableSet<String>, reward: MoPubReward) {
            msg(tag, self, "onRewardedVideoCompleted")
            refreshUi()
        }

    }

    fun onCreate() {
        (self.application as MyApp).initMoPub(self)

        load.setOnClickListener {
            MoPubRewardedVideos.loadRewardedVideo(MyApp.adUnitId, MyMediationSettings())
            refreshUi()
        }

        show.setOnClickListener {
            MoPubRewardedVideos.showRewardedVideo(MyApp.adUnitId)
            refreshUi()
        }

        newActivity.setOnClickListener {
            self.startActivity(Intent(self, self.javaClass))
            refreshUi()
        }
    }

    private fun refreshUi() {
        load.isEnabled = !MoPubRewardedVideos.hasRewardedVideo(MyApp.adUnitId)
        show.isEnabled = MoPubRewardedVideos.hasRewardedVideo(MyApp.adUnitId)
        instanceId.text = getInstanceId(self)
    }

    fun onResume() {
        MoPubRewardedVideos.setRewardedVideoListener(listener)
        refreshUi()
    }

}
