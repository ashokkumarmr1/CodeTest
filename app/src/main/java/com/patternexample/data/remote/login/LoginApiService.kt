package login

import Post
import retrofit2.http.GET

interface LoginApiService
{
    @GET("posts")
    suspend fun getPost():List<Post>
}