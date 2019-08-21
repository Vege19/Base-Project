package github.vege19.mybaseproject.di

import dagger.Module
import dagger.Provides
import github.vege19.mybaseproject.api.ApiInterface
import github.vege19.mybaseproject.utils.Const
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    // Declare retrofit callbacks here //

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit) : ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

}