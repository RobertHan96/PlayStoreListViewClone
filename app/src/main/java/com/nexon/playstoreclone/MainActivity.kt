package com.nexon.playstoreclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nexon.playstoreclone.adapters.AppAdapter
import com.nexon.playstoreclone.datas.App
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val appList : ArrayList<App>()
    var mAppAdapter : AppAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appList.add(App("아스팔트7","GameLoft", 4))
        appList.add(App("팔라독","NCSoft", 1))
        appList.add(App("리니지M","Netmarble", 4))
        appList.add(App("V4","NexonKorea", 5))

        mAppAdapter = AppAdapter(this, R.layout.app_list_item, appList)
        appListView.adapter = mAppAdapter
    }
}
