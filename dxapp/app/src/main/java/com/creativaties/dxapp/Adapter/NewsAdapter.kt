package com.creativaties.dxapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.creativaties.dxapp.R
import com.creativaties.dxapp.ui.WebActivity
import com.creativaties.dxapp.data.model.News
import com.creativaties.dxapp.databinding.NewsitemBinding

class NewsAdapter(var newsitem : List<News.Article>) :
    RecyclerView.Adapter<NewsAdapter.Myholder>() {

    inner class Myholder(var newsitemBinding: NewsitemBinding)
        : RecyclerView.ViewHolder(newsitemBinding.root){

        var text: TextView

        init {
            text = itemView.findViewById(R.id.web)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myholder {
        val binding = DataBindingUtil.inflate<NewsitemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.newsitem,parent,false
        )
        return Myholder(binding)

    }

    override fun onBindViewHolder(holder: Myholder, position: Int) {
        holder.newsitemBinding.data = newsitem[position]


        holder.text.setOnClickListener {
            val intent = Intent(holder.itemView.context, WebActivity::class.java)
            intent.putExtra("key",newsitem.get(position).url)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return  newsitem.size
    }
}