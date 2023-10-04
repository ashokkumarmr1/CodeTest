import login.LoginApiService
import login.LoginRepositoryInterface

class LoginRepository (private val loginApiService : LoginApiService) : LoginRepositoryInterface {
    override suspend fun getPost(): List<Post> {
        TODO("Not yet implemented")
        loginApiService.getPost()
    }

    override suspend fun getData(): Post {
        TODO("Not yet implemented")
    }
}