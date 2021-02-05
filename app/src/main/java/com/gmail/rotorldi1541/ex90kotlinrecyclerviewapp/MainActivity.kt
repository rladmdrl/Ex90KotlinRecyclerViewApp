package com.gmail.rotorldi1541.ex90kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //대량의 데이터 property[속성:멤버변수]
    var items= arrayListOf<Item>()// ArrayList<>와동일


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //대량의데이터추가[테스트목적]
        items.add(Item("sam","Hello. kotlin",R.drawable.asdf))
        items.add(Item("sdw","한국이다",R.drawable.img))
        items.add(Item("sasd","이스라엘",R.drawable.asfd))
        items.add(Item("sasdf","한녕",R.drawable.fldjf))
        items.add(Item("sam","Hello. kotlin",R.drawable.asdf))
        items.add(Item("sdw","한국이다",R.drawable.img))
        items.add(Item("sasd","이스라엘",R.drawable.asfd))
        items.add(Item("sasdf","한녕",R.drawable.fldjf))

        //리사이클러뷰에 이미 아답터 프로퍼티가있음 고로 아답터객체를 대입해주면됨
        recycler.adapter=MyAdapter(this,items)

        //리사일클러뷰에 레이아웃매니저 붙이기
        recycler.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)



    }

    override fun onRestart() {
        super.onRestart()

        //리사이클러뷰를 개신하려면 아답터에게 데이터변경공지
        //혹시 아답터가 널이면 에러가나서 그냥 문법적으로 실수할여지가
        //없도록... 특이한 연산자 적용!!
        recycler.adapter!!.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //MenuInflater 을 get 하는 작업 필요없음 객체가있어서
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

}