package com.travels.searchtravels

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.travels.searchtravels.activity.MainActivity
import com.travels.searchtravels.utils.Constants
import org.junit.After
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ImageTest {

    val context = ApplicationProvider.getApplicationContext<Context>()

    lateinit var scenario: ActivityScenario<MainActivity>

    @Test
    fun testSnowImage(){
        val intent = Intent(context, MainActivity::class.java)
        scenario = ActivityScenario.launch(intent)
        scenario.onActivity { activity ->
//            val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.snow)
            val uri = Uri.parse("android.resource://com.travels.searchtravels/${R.drawable.snow}")
            activity.uploadImage(uri)
            Thread.sleep(5000)
            Assert.assertEquals("Картинка со снегом", Constants.PICKED_CITY_EN, SNOW_ANSWER)
        }
    }

    @Test
    fun testCityImage(){
        val intent = Intent(context, MainActivity::class.java)
        scenario = ActivityScenario.launch(intent)
        scenario.onActivity { activity ->
            val uri = Uri.parse("android.resource://com.travels.searchtravels/${R.drawable.city}")
            activity.uploadImage(uri)
            Thread.sleep(5000)
            Assert.assertEquals("Картинка с городом", Constants.PICKED_CITY_EN, OTHER_ANSWER)
        }
    }

    @Test
    fun testOcean(){
        val intent = Intent(context, MainActivity::class.java)
        scenario = ActivityScenario.launch(intent)
        scenario.onActivity { activity ->
            val uri = Uri.parse("android.resource://com.travels.searchtravels/${R.drawable.ocean}")
            activity.uploadImage(uri)
            Thread.sleep(5000)
            Assert.assertEquals("Картинка с океаном", Constants.PICKED_CITY_EN, OCEAN_ANSWER)
        }
    }

    @Test
    fun testBeachImage(){
        val intent = Intent(context, MainActivity::class.java)
        scenario = ActivityScenario.launch(intent)
        scenario.onActivity { activity ->
            val uri = Uri.parse("android.resource://com.travels.searchtravels/${R.drawable.beach}")
            activity.uploadImage(uri)
            Thread.sleep(5000)
            Assert.assertEquals("Картинка с пляжем", Constants.PICKED_CITY_EN, BEACH_ANSWER)
        }
    }

    @Test
    fun testSeaImage(){
        val intent = Intent(context, MainActivity::class.java)
        scenario = ActivityScenario.launch(intent)
        scenario.onActivity { activity ->
            val uri = Uri.parse("android.resource://com.travels.searchtravels/${R.drawable.sea}")
            activity.uploadImage(uri)
            Thread.sleep(5000)
            Assert.assertEquals("Картинка с морем", Constants.PICKED_CITY_EN, SEA_ANSWER)
        }
    }

    @Test
    fun testMountainImage(){
        val intent = Intent(context, MainActivity::class.java)
        scenario = ActivityScenario.launch(intent)
        scenario.onActivity { activity ->
            val uri = Uri.parse("android.resource://com.travels.searchtravels/${R.drawable.mountain}")
            activity.uploadImage(uri)
            Thread.sleep(5000)
            Assert.assertEquals("Картинка с горами", Constants.PICKED_CITY_EN, MOUNTAIN_ANSWER)
        }
    }


    @After
    fun cleanUp() {
        scenario.close()
    }

    companion object {
        const val SNOW_ANSWER = "Helsinki"
        const val SEA_ANSWER = "Rimini"
        const val OCEAN_ANSWER = "Rimini"
        const val BEACH_ANSWER = "Rimini"
        const val MOUNTAIN_ANSWER = "Sochi"
        const val OTHER_ANSWER = ""
    }
}
