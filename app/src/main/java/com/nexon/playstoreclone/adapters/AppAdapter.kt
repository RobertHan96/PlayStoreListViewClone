package com.nexon.playstoreclone.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.nexon.playstoreclone.R
import com.nexon.playstoreclone.datas.App

class AppAdapter (context: Context, resID : Int, list: ArrayList<App>) : ArrayAdapter<App>(context, resID, list) {
    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let{ 
            // null이 아닐때
        }.let {
            // null일때
            tempRow = inf.inflate(R.layout.app_list_item, null)           
        }

//    위에서 이미 null 체크가 끝났으므로 내가 가져올 리스트 아이템은 !!를 사용해 강제 언랩핑해서 사용 준비
        val row = tempRow!!



        return  row
    }


}

