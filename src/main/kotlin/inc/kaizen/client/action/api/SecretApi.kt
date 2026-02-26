package inc.kaizen.client.action.api

import inc.kaizen.client.action.model.secret.*
import retrofit2.Response
import retrofit2.http.*

interface SecretApi {

    @GET("/orgs/{org}/actions/secrets")
    suspend fun getOrgSecrets(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): Secrets

    @GET("/orgs/{org}/actions/secrets/{secret_name}")
    suspend fun getOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String
    ): Secret

    @DELETE("/orgs/{org}/actions/secrets/{secret_name}")
    suspend fun deleteOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String
    ): Response<Unit>

    @PUT("/orgs/{org}/actions/secrets/{secret_name}")
    suspend fun createOrUpdateOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String,
        @Body orgSecret: OrgSecret
    ): Response<Unit>

    @GET("/orgs/{org}/actions/secrets")
    suspend fun getOrgPublicKeys(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): Key

    @GET("/orgs/{org}/actions/secrets/{secret_name}/repositories")
    suspend fun getOrgReposOfSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): Repositories

    @PUT("/orgs/{org}/actions/secrets/{secret_name}/repositories")
    suspend fun setOrgReposOfSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String,
        @Body selectedRepositoryIds: List<Int>
    ): Response<Unit>

    @PUT("/orgs/{org}/actions/secrets/{secret_name}/repositories/{repository_id}")
    suspend fun addRepoToOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String,
        @Path("repository_id") repositoryId: String
    ): Response<Unit>

    @DELETE("/orgs/{org}/actions/secrets/{secret_name}/repositories/{repository_id}")
    suspend fun removeRepoFromOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String,
        @Path("repository_id") repositoryId: String
    ): Response<Unit>
}