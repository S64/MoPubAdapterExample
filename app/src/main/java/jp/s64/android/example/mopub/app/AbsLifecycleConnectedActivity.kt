package jp.s64.android.example.mopub.app

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.mopub.common.MoPub

abstract class AbsLifecycleConnectedActivity(@LayoutRes layoutRes: Int) : AppCompatActivity(layoutRes) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MoPub.onCreate(this)
    }

    override fun onPause() {
        super.onPause()
        MoPub.onPause(this)
    }

    override fun onStop() {
        super.onStop()
        MoPub.onStop(this)
    }

    override fun onResume() {
        super.onResume()
        MoPub.onResume(this)
    }

    override fun onStart() {
        super.onStart()
        MoPub.onStart(this)
    }

    override fun onRestart() {
        super.onRestart()
        MoPub.onRestart(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        MoPub.onDestroy(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        MoPub.onBackPressed(this)
    }

}