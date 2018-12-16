package com.nari.learnmvp

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert
import org.robolectric.Robolectric
import org.robolectric.shadows.ShadowToast

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @Test
    fun buttonClickTest(){
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        activity.loginButton.performClick()
        Assert.assertEquals(ShadowToast.getTextOfLatestToast(),"login fail")
        //assertThat(activity.message.getText()).isEqualTo("Robolectric Rocks!")
    }

    @Test
    fun successLoginTest(){
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        activity.idEditText.setText("gginin")
        activity.pwEditText.setText("123456")
        activity.loginButton.performClick()
        Assert.assertEquals(ShadowToast.getTextOfLatestToast(),"login success")
        //assertThat(activity.message.getText()).isEqualTo("Robolectric Rocks!")
    }

}
