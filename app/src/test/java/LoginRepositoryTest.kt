import kotlinx.coroutines.runBlocking
import login.LoginApiService
import okhttp3.Response
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response.success
import kotlin.Result.Companion.success

class LoginRepositoryTest {

    lateinit var repository: LoginRepository
    lateinit var apiService : LoginApiService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = Mockito.mock(LoginRepository::class.java)
    }

    @Test
    fun getPost() {
        repository  =   Mockito.mock(LoginRepository::class.java)
        runBlocking {
            Mockito.`when`(apiService.getPost()).thenReturn((listOf<Post>()))
            val response = repository.getPost()
            assertEquals(listOf<Post>(), response)
        }

    }

    @Test
    fun getData() {
    }
}