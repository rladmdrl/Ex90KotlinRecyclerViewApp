package com.gmail.rotorldi1541.ex90kotlinrecyclerviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        //id 가 btn 인 Button 에 클릭 리스너 설정
        btn.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val intent=Intent(this@IntroActivity,MainActivity::class.java)
                startActivity(intent)
            }

        })
    }

    fun clickEit(view: View) {
        finish()
    }
}