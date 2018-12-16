package com.nari.learnmvp
import java.lang.RuntimeException

class LoginApi: LoginInterface {
    override fun login(id: String, password: String): Boolean {
        if(id == "fuck")
            throw RuntimeException("don't fuck")

        return (id == "gginin" && password == "123456")
    }
}