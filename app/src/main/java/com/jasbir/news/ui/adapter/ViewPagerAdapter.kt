package com.jasbir.news.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.viewpager.widget.PagerAdapter
import com.jasbir.news.R
import com.jasbir.news.data.remote.response.News
import com.squareup.picasso.Picasso

class ViewPagerAdapter(var context: Context, var item: List<News.Article>) :
    PagerAdapter() {
    var inflater: LayoutInflater
    override fun getCount(): Int {
        return item.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as CardView
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = inflater.inflate(R.layout.newsitem, container, false)
        val card = itemView.findViewById<CardView>(R.id.card)
        val image = itemView.findViewById<ImageView>(R.id.image)
        val auther = itemView.findViewById<TextView>(R.id.auther)
        val heading = itemView.findViewById<TextView>(R.id.heading)
        val description = itemView.findViewById<TextView>(R.id.description)
        val content = itemView.findViewById<TextView>(R.id.content)
        Picasso.get().load(item.get(position).urlToImage).into(image)

        auther.setText(item.get(position).author)
        heading.setText(item.get(position).title)
        description.setText(item.get(position).description)
        content.setText(item.get(position).content)

        card.setOnClickListener {

        }

        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as CardView)
    }

    init {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}
