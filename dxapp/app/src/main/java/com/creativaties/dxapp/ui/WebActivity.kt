package com.creativaties.dxapp.ui

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.creativaties.dxapp.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        progres.visibility = View.VISIBLE
        webView = findViewById(R.id.webview)
        webView.settings.setJavaScriptEnabled(true)

        val s = intent.getStringExtra("key")
        webView.loadUrl("$s")


        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progres.visibility = View.GONE
            }
        }


    }
}