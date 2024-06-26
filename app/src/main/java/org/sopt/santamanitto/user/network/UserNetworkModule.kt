package org.sopt.santamanitto.user.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.santamanitto.network.AuthRetrofitClient
import org.sopt.santamanitto.network.OtherRetrofitClient
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class UserNetworkModule {

    @Provides
    fun provideUserService(@OtherRetrofitClient retrofitClient: Retrofit): UserService =
            retrofitClient.create(UserService::class.java)

    @Provides
    fun provideUserAuthService(@AuthRetrofitClient retrofitClient: Retrofit): UserAuthService =
            retrofitClient.create(UserAuthService::class.java)
}