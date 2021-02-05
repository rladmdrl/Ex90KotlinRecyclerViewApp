package com.gmail.rotorldi1541.ex90kotlinrecyclerviewapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recylcer_item.view.*

class MyAdapter constructor(val context: Context, val items:ArrayList<Item>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var inflater=LayoutInflater.from(context)
        var itemView=inflater.inflate(R.layout.recylcer_item,parent,false)
        return VH(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // 첫번째 파라미터 : holder 를 VH 로 형변환
        var vh:VH=holder as VH //코틀린에서 클래스들의 형변환 연산자 as

        val item=items.get(position)
        vh.itemView.tvTitle.text=item.title
        vh.itemView.tvmsddf.text=item.msg
        Glide.with(context).load(item.img).into(vh.itemView.iv)


    }

    //아이템 한개의 뷰를 저장하는 뷰홀더클레스-inner class
    inner class VH constructor(itemView:View):RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(object  : View.OnClickListener{
                override fun onClick(v: View?) {
                    val item=items.get(layoutPosition)
                    val intent=Intent(context,ItemActivity::class.java)

                    intent.putExtra("title",item.title)
                    intent.putExtra("msg",item.msg)
                    intent.putExtra("img",item.img)
                    context.startActivity(intent)
                }
            })
        }
    }

}