package login

import Post

interface LoginRepositoryInterface
{
    suspend fun getPost():List<Post>
    suspend fun getData(): Post
}