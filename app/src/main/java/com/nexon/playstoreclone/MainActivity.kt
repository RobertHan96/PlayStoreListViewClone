package com.nexon.playstoreclone

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.nexon.playstoreclone.adapters.AppAdapter
import com.nexon.playstoreclone.datas.App
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val appList = ArrayList<App>()
    var mAppAdapter : AppAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()


    }

    fun setupEvents() {
        appListView.setOnItemLongClickListener { parent, view, position, id ->
            val alert = AlertDialog.Builder(this)
            alert.setTitle("삭제 확인")
            alert.setMessage("정말 이앱을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", {dialog, which ->
                Log.d("앱목록 삭제 전", appList.size.toString())
                appList.removeAt(position)
                Log.d("앱목록 삭제 후", appList.size.toString())
//          원본 데이터에 변경이 생긴 경우 어댑터에 데이터 갱신을 요청하는 코드
                mAppAdapter?.notifyDataSetChanged()
            })
            alert.setNegativeButton("취소", null)
            alert.show()
            return@setOnItemLongClickListener true

        }
    }

    fun setValues() {
        addApps()
        mAppAdapter = AppAdapter(this, R.layout.app_list_item, appList)
        appListView.adapter = mAppAdapter
    }

    fun addApps() {
        appList.add(App("아스팔트8 : 에어본","GameLoft", 5))
        appList.add(App("MineCraft ","Mojang ", 4))
        appList.add(App("아스팔트 7 : 히트","GameLoft", 4))
        appList.add(App("팔라독 (Paladog)","FazeCat ", 2))
        appList.add(App("Plants vs. Zombies","EA Games", 3))
        appList.add(App("스왐피 (Swampy)","Disney", 5))
        appList.add(App("리니지2M","NCSOFT", 3))
        appList.add(App("리니지M","NCSOFT", 4))
        appList.add(App("AFK아레나","Lilith Games", 1))
        appList.add(App("아스팔트8 : 에어본","GameLoft", 5))
    }
}
