import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import login.LoginApiService
import login.LoginRepositoryInterface
import javax.inject.Inject

class LoginUseCase (private val loginRepositoryInterface: LoginRepositoryInterface)
{
    suspend fun getPostss(): Flow<List<Post>> = flow {
        emit(loginRepositoryInterface.getPost())
    }.flowOn(Dispatchers.IO)

}