package com.octoprice.android.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class OctopusApiService {
    private val httpClient: OkHttpClient = OkHttpClient.Builder()
        .build()

    val octopusClient: OctopusApi = Retrofit.Builder()
        .baseUrl(Constants.API_URL)
        .client(httpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(OctopusApi::class.java)
}