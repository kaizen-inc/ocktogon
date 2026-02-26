package inc.kaizen.client.repo.api

import inc.kaizen.client.repo.model.CreateDeployKeyRequest
import inc.kaizen.client.repo.model.DeployKey
import retrofit2.Response
import retrofit2.http.*

interface DeployKeyApi {

    @GET("/repos/{owner}/{repo}/keys")
    suspend fun listDeployKeys(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<DeployKey>

    @POST("/repos/{owner}/{repo}/keys")
    suspend fun createDeployKey(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateDeployKeyRequest
    ): DeployKey

    @GET("/repos/{owner}/{repo}/keys/{key_id}")
    suspend fun getDeployKey(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("key_id") keyId: Long
    ): DeployKey

    @DELETE("/repos/{owner}/{repo}/keys/{key_id}")
    suspend fun deleteDeployKey(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("key_id") keyId: Long
    ): Response<Unit>
}
