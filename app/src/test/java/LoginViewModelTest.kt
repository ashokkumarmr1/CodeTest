import android.app.Application
import com.patternexample.ui.login.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import login.LoginApiService
import okhttp3.Response
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule
import retrofit2.Response.success
import kotlin.Result.Companion.success

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {

    lateinit var loginViewModel : LoginViewModel
    lateinit var loginUseCase: LoginUseCase

    @Rule
    @JvmField
    var initRule: MockitoRule = MockitoJUnit.rule()
    private val application =   Mockito.mock(Application::class.java)

    private val postList: LoginRepository = Mockito.mock(LoginRepository::class.java)


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        loginUseCase = LoginUseCase(postList)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun get_postStateFlow()
    {
        runBlocking {
            Mockito.`when`(loginUseCase.getPostss())
                .thenReturn(listOf<Post>(Post(1, "new"))))
            loginViewModel.getPost()
            val result = loginViewModel.getPost()
            assertEquals(listOf<Post>(Post(1,"new")), result)
        }
    }
}