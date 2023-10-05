package inc.kaizen.client

import inc.kaizen.base.infrastructure.ApiClient
import okhttp3.Interceptor

object Ocktogon {

    private const val BASE_URL = "https://api.github.com"

    private val apiClient = ApiClient(BASE_URL)

    fun <S> createService(serviceClass: Class<S>, interceptor: Interceptor? = null): S {
        return apiClient.createService(serviceClass, interceptor)
    }
}