package com.nari.learnmvp

import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.RuntimeException
import org.junit.rules.ExpectedException




class LoginApiTest {

    lateinit var loginModel : LoginInterface
    @Rule
    @JvmField
    val thrown = ExpectedException.none()

    @Before
    fun initial(){
        loginModel = LoginApi()
    }

    @Test
    fun idWrongTest(){
        val id = "gg"
        val pw = "123456"

        val result = loginModel.login(id,pw)

        Assert.assertEquals(result,false)
    }

    @Test
    fun pwWrongTest(){
        val id = "gginin"
        val pw = "123"

        val result = loginModel.login(id,pw)

        Assert.assertEquals(result,false)
    }

    @Test
    fun loginSuccessTest(){
        val id = "gginin"
        val pw = "123456"

        val result = loginModel.login(id,pw)

        Assert.assertEquals(result,true)
    }

    @Test
    fun loginFailTest(){
        val id = "YY"
        val pw = "123"

        val result = loginModel.login(id,pw)

        Assert.assertEquals(result,false)
    }

    @Test
    fun exceptionTest(){
        val id = "fuck"
        val pw = "123"

        thrown.expect(RuntimeException::class.java)
        loginModel.login(id,pw)
    }
}