package com.mediatechindo.kakilima.merchant.helper

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by akira on 14/11/17.
 */

object ApiManager {

    private const val BASE_URL: String = "https://www.googleapis.com/books/v1/"
    //    var retrofit: Retrofit
    private lateinit var myApiService: ApiService

    init {
        val retrofit = initRetrofit()
        initServices(retrofit)
    }


    private fun initRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            networkInterceptors().add(Interceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                        .header("Accept", "application/json")
                        .method(original.method(), original.body())
                        .build()
                chain.proceed(request)
            })
            addInterceptor(interceptor)
        }
        client.readTimeout(2000000, TimeUnit.MILLISECONDS)
        client.retryOnConnectionFailure(true)

/*
            val gson = GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create()
*/

        return Retrofit.Builder().baseUrl(BASE_URL)
                //.addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(createMoshiConverter())
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
                .build()
    }

    private fun createMoshiConverter(): MoshiConverterFactory = MoshiConverterFactory.create()

    private fun initServices(retrofit: Retrofit) {
        myApiService = retrofit.create(ApiService::class.java)
    }


    //SEARCH
    fun searchByIsdb(isbn: String) =
            myApiService.searchBookByIsdb("isbn:$isbn")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

}
