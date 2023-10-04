package com.patternexample.ui.login

import LoginApiState
import LoginUseCase
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val postStateFlow:MutableStateFlow<LoginApiState> = MutableStateFlow(LoginApiState.Empty)
    val _postStateFlow:StateFlow<LoginApiState> = postStateFlow

    fun getPost() = viewModelScope.launch {
        postStateFlow.value = LoginApiState.Loading
        loginUseCase.getPostss()
            .catch { e ->
                postStateFlow.value = LoginApiState.Failure(e)
            }.collect { data ->
                postStateFlow.value = LoginApiState.Success(data)
            }
    }

    fun LogIn(username: String, password: String)
    {
       if(username.isEmpty() and password.isEmpty())
       {

       }
        else if (username.isEmpty() and password.isNotEmpty())
       {

       }
        else if(username.isNotEmpty() and password.isEmpty())
       {

       }
        else if(username.equals("admin@gmail.com") and password.equals("admin@123"))
       {
         getPost()
       }
    }

    fun isValidCredentials(email: String, password: String): Boolean {
        val emailPattern = Regex("[a-zA-Z0–9._-]+@[a-z]+\\.+[a-z]+")
        val passwordPattern = Regex("^(?=.*[0–9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
        return emailPattern.matches(email) && passwordPattern.matches(password)
    }
}