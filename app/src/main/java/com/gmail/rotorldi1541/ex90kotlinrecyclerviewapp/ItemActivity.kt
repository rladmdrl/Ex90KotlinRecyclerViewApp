package com.gmail.rotorldi1541.ex90kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        //넘어온 Intent 객체를 얻어오기
        val title=intent.getStringExtra("title")
        val msg =intent.getStringExtra("msg")
        val img=intent.getIntExtra("img",R.drawable.fldjf)

        //제목줄에 title 표시
        supportActionBar!!.title=title

        //xml 의 id 를 멤버변수인양
        tv.text=msg
        Glide.with(this).load(img).into(iv)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    // 업 버튼 클릭 하였을때 뒤로가기 물리버튼을 누른 것과 같은 효과를 가지도록

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

}