package com.kys.daggerhiltnytimes

import androidx.test.core.app.launchActivity
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.kys.daggerhiltnytimes.di.ProductionModule
import com.kys.daggerhiltnytimes.framework.presentation.DetailFragment
import com.kys.daggerhiltnytimes.framework.presentation.MainActivity
import com.kys.daggerhiltnytimes.framework.presentation.MainFragment
import com.kys.daggerhiltnytimes.framework.presentation.MainFragmentFactory
import com.kys.daggerhiltnytimes.util.launchFragmentInHiltContainer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@UninstallModules(ProductionModule::class)
@HiltAndroidTest
class MainTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var someString: String

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    //@BindValue
    //var myString: String = "gggf" // Doesn't work?? I'm prob doing it wrong.

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun hiltTest(){
        assertThat(someString, containsString("TEST string"))
    }

    @Test
    fun mainFragmentTest(){
        val scenario = launchFragmentInHiltContainer<MainFragment>(
            factory = fragmentFactory
        )
    }

    @Test
    fun mainActivityTest(){
        val scenario = launchActivity<MainActivity>()
    }

    @Module
    @InstallIn(ApplicationComponent::class)
    object ProductionModule {
        @Singleton
        @Provides
        fun provideString(): String{
            return "This is a TEST string I'm providing for injection"
        }
    }
}
























