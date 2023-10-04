package login

import Constants
import LoginRepository
import LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule
{
    @Provides
    fun providesUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(providesUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): LoginApiService {
        return retrofit.create(LoginApiService::class.java)
    }

    @Provides
    @Singleton
    suspend fun provideLoginUserImpl(loginApiService: LoginApiService) : LoginRepository {
        return LoginRepository(loginApiService)
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(loginRepositoryInterface: LoginRepositoryInterface) : LoginUseCase
    {
        return LoginUseCase(loginRepositoryInterface)
    }

}