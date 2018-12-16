package com.nari.learnmvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ViewInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initial()
    }

    private fun initial(){
        val presenter = Presenter(this, LoginApi())
        loginButton.setOnClickListener {
            presenter.onClick(idEditText.text.toString(),pwEditText.text.toString())
        }
    }

    override fun showLoginSuccess() {
        Toast.makeText(this,"login success",Toast.LENGTH_SHORT).show()
    }

    override fun showLoginFail() {
        Toast.makeText(this,"login fail",Toast.LENGTH_SHORT).show()
    }
}
