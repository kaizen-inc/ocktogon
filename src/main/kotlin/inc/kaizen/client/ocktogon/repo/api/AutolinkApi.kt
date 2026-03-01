package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.ocktogon.repo.model.Autolink
import inc.kaizen.client.ocktogon.repo.model.CreateAutolinkRequest
import retrofit2.Response
import retrofit2.http.*

interface AutolinkApi {

    @GET("/repos/{owner}/{repo}/autolinks")
    suspend fun listAutolinks(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("page") page: Int = 1
    ): List<Autolink>

    @POST("/repos/{owner}/{repo}/autolinks")
    suspend fun createAutolink(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateAutolinkRequest
    ): Autolink

    @GET("/repos/{owner}/{repo}/autolinks/{autolink_id}")
    suspend fun getAutolink(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("autolink_id") autolinkId: Int
    ): Autolink

    @DELETE("/repos/{owner}/{repo}/autolinks/{autolink_id}")
    suspend fun deleteAutolink(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("autolink_id") autolinkId: Int
    ): Response<Unit>
}
