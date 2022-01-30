package com.creativaties.dxapp.data.model


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.creativaties.dxapp.R
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.newsitem.view.*

data class News(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
){
    data class Article(
        @SerializedName("author")
        val author: String,
        @SerializedName("content")
        val content: Any,
        @SerializedName("description")
        val description: String,
        @SerializedName("publishedAt")
        val publishedAt: String,
        @SerializedName("source")
        val source1: Source,
        @SerializedName("title")
        val title: String,
        @SerializedName("url")
        val url: String,
        @SerializedName("urlToImage")
        val urlToImage: String
    ){
        companion object{
            @BindingAdapter("imageUrl")
            @JvmStatic
            fun loadImage(imageView : ImageView, product_file: String?){
                if(product_file != null){

                    Picasso.get().load("$product_file").into(imageView)
                }
                else{
//                            Picasso.get().load(R.mipmap.ic_launcher).into(imageView)

                }
            }


        }
    }


}