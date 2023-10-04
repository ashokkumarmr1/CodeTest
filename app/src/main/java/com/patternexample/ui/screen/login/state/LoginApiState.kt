import com.patternexample.ui.theme.WorkResult

sealed class LoginApiState{
    object Loading : LoginApiState()
    class Failure(val msg:Throwable) : LoginApiState()
    class Success(val data:List<Post>) : LoginApiState()
    object Empty : LoginApiState()
}

