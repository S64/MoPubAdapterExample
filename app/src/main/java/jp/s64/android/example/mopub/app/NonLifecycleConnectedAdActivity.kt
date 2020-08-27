package jp.s64.android.example.mopub.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.my_activity.*

class NonLifecycleConnectedAdActivity : AppCompatActivity(R.layout.my_activity) {

    companion object {

        private const val TAG = "NonLifecycleConnectedAdActivity"

    }

    private val delegate by lazy {
        AdDelegate(this, TAG, load, show, instanceId, newActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        delegate.onCreate()
    }

    override fun onResume() {
        super.onResume()

        delegate.onResume()
    }

}