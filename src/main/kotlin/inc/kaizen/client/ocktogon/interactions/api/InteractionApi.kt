package inc.kaizen.client.ocktogon.interactions.api

import inc.kaizen.client.ocktogon.interactions.model.InteractionLimit
import inc.kaizen.client.ocktogon.interactions.model.SetInteractionLimitRequest
import retrofit2.Response
import retrofit2.http.*

interface InteractionApi {

    // Organization interactions
    @GET("/orgs/{org}/interaction-limits")
    suspend fun getOrgInteractionRestrictions(@Path("org") org: String): InteractionLimit

    @PUT("/orgs/{org}/interaction-limits")
    suspend fun setOrgInteractionRestrictions(
        @Path("org") org: String,
        @Body body: SetInteractionLimitRequest
    ): InteractionLimit

    @DELETE("/orgs/{org}/interaction-limits")
    suspend fun removeOrgInteractionRestrictions(@Path("org") org: String): Response<Unit>

    // Repository interactions
    @GET("/repos/{owner}/{repo}/interaction-limits")
    suspend fun getRepoInteractionRestrictions(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): InteractionLimit

    @PUT("/repos/{owner}/{repo}/interaction-limits")
    suspend fun setRepoInteractionRestrictions(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: SetInteractionLimitRequest
    ): InteractionLimit

    @DELETE("/repos/{owner}/{repo}/interaction-limits")
    suspend fun removeRepoInteractionRestrictions(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    // User interactions
    @GET("/user/interaction-limits")
    suspend fun getUserInteractionRestrictions(): InteractionLimit

    @PUT("/user/interaction-limits")
    suspend fun setUserInteractionRestrictions(@Body body: SetInteractionLimitRequest): InteractionLimit

    @DELETE("/user/interaction-limits")
    suspend fun removeUserInteractionRestrictions(): Response<Unit>
}
