package jp.s64.android.example.mopub.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mopub.common.MoPub
import jp.s64.android.example.mopub.lib.getInstanceId
import kotlinx.android.synthetic.main.launcher_activity.*

class LauncherActivity : AppCompatActivity(R.layout.launcher_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleConnected.setOnClickListener {
            startActivity(Intent(this@LauncherActivity, LifecycleConnectedAdActivity::class.java))
        }

        nonLifecycle.setOnClickListener {
            startActivity(Intent(this@LauncherActivity, NonLifecycleConnectedAdActivity::class.java))
        }

        multiInitialize.setOnClickListener {
            startActivity(Intent(this@LauncherActivity, MultiInitializeAdActivity::class.java))
        }

        instanceId.text = getInstanceId(this)
    }

    override fun onResume() {
        super.onResume()

        if (!MoPub.isSdkInitialized()) {
            (application as MyApp).initMoPub(this)
        }
    }

}
