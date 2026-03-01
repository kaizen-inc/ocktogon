package inc.kaizen.client.ocktogon.ratelimit.api

import inc.kaizen.client.ratelimit.model.RateLimitOverview
import retrofit2.http.GET

interface RateLimitApi {

    @GET("/rate_limit")
    suspend fun getRateLimit(): RateLimitOverview
}
