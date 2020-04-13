package com.nexon.playstoreclone.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nexon.playstoreclone.R
import com.nexon.playstoreclone.datas.App
import kotlinx.android.synthetic.main.app_list_item.view.*

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
//     findViewById를 할때는 찾을 객체의 속성을 <> 안에 정확히 입력해야 객체를 가져올 수 있음

        val nameText = row.findViewById<TextView>(R.id.titleText)
        val companyNameText = row.findViewById<TextView>(R.id.companyText)
        val starOneImg = row.findViewById<ImageView>(R.id.starOneImg)
        val starTwoImg = row.findViewById<ImageView>(R.id.starTwoImg)
        val starThreeImg = row.findViewById<ImageView>(R.id.starThreeImg)
        val starFourImg = row.findViewById<ImageView>(R.id.starFourImg)
        val starFiveImg = row.findViewById<ImageView>(R.id.starFiveImg)

        val data = mList.get(position)

        val starImgList = ArrayList<ImageView>()
        starImgList.add(starOneImg)
        starImgList.add(starTwoImg)
        starImgList.add(starThreeImg)
        starImgList.add(starFourImg)
        starImgList.add(starFiveImg)

        for (index in 0..4) {
            val starImg = starImgList.get(index)
            if (index < data.score) {
                starImg.setImageResource(R.drawable.fill_star)
            } else {
                starImg.setImageResource(R.drawable.empty_star)
            }
        }

        nameText.text = "${position+1}. ${data.title}"
        companyNameText.text = data.company

        return  row
    }


}

