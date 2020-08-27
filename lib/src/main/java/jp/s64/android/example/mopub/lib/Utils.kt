package jp.s64.android.example.mopub.lib

import android.content.Context
import android.util.Log
import android.widget.Toast

typealias InstanceId = String

fun getInstanceId(context: Context): InstanceId = "${System.identityHashCode(context)}"

fun msg(tag: String, context: Context, msg: String) {
    Log.d(tag, msg)
    Toast.makeText(context, "${getInstanceId(context)}: ${msg}", Toast.LENGTH_SHORT).show()
}
