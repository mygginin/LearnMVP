package com.nari.learnmvp

import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.verify
import org.mockito.Mockito.mock
import java.lang.RuntimeException

class PresenterTest {

    lateinit var viewInterface: ViewInterface
    lateinit var loginInterface: LoginInterface

    @Before
    fun before(){
        viewInterface = mock(ViewInterface::class.java)
        loginInterface = mock(LoginInterface::class.java)
    }

    @Test
    fun testLoginSuccess(){
        val id = "gginin"
        val pw = "123456"

        given(loginInterface.login(id,pw)).willReturn(true)
        val presenter = Presenter(viewInterface,loginInterface)
        presenter.onClick(id,pw)

        verify(viewInterface).showLoginSuccess()
    }

    @Test
    fun testLoginFail(){
        val id = "gginin"
        val pw = "123456"

        given(loginInterface.login(id,pw)).willReturn(false)
        val presenter = Presenter(viewInterface,loginInterface)
        presenter.onClick(id,pw)

        verify(viewInterface).showLoginFail()
    }

    @Test
    fun testThrowException(){
        val id = "gginin"
        val pw = "123456"

        given(loginInterface.login(id,pw)).willThrow(RuntimeException())

        val presenter = Presenter(viewInterface,loginInterface)
        presenter.onClick(id,pw)

        verify(viewInterface).showLoginFail()
    }
}