package com.jmb.thesport.ui.viewmodels

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.jmb.thesport.data.model.response.Team
import com.jmb.thesport.data.model.response.Teams
import com.jmb.thesport.util.Resource
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import okio.IOException
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {


    @Mock
    lateinit var application: Application

    @Mock
    lateinit var observer: Observer<Resource<Teams>>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp(){
       Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
        dispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `onCreate load teams`() = runBlockingTest  {
        val fakeList =
            listOf(Team("1", "1", "1", "1", "1", "1", "1", "1",
                "1", "1", "1", "1", "1",
                "", "", "", "", "",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","","",
                "","",""))
        whenever(application.applicationContext).thenReturn(application)
        application.onCreate()
        val vm = HomeViewModel(application)
        vm.fetchLigaList.observeForever(observer)
        verify(observer).onChanged(Resource.Success(Teams(fakeList)))
      // verify(observer).onChanged(Resource.Success(Teams(fakeList)))
    }




}