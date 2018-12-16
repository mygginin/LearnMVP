package com.nari.learnmvp

import java.lang.Exception

class Presenter(var viewModel: ViewInterface, var loginModel: LoginInterface) {

    fun onClick(id:String,pw:String){
        try {
            val result = loginModel.login(id, pw)
            showLoginResult(result)
        }catch (e:Exception){
            showLoginResult(false)
        }
    }

    fun showLoginResult(result:Boolean){
        if(result)
            viewModel.showLoginSuccess()
        else
            viewModel.showLoginFail()
    }
}