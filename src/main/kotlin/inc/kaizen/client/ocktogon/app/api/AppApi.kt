package inc.kaizen.client.ocktogon.app.api

import inc.kaizen.client.app.model.App
import inc.kaizen.client.app.model.Installation
import inc.kaizen.client.app.model.InstallationRequest
import inc.kaizen.client.app.model.Installations
import inc.kaizen.client.app.model.installation.InstallationAccessTokenRequest
import retrofit2.Response
import retrofit2.http.*

interface AppApi {

    @GET("/app")
    suspend fun getAuthenticatedApp(): App

    @POST("/app-manifests/{code}/conversions")
    suspend fun appManifestsConversions(
        @Path("code") code: Long
    ): App

    // Get an app by slug
    @GET("/apps/{app_slug}")
    suspend fun getAppBySlug(
        @Path("app_slug") appSlug: String
    ): App

    @GET("/app/installation-requests")
    suspend fun listInstallationRequests(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<InstallationRequest>

    // List installations for the authenticated app
    @GET("/app/installations")
    suspend fun listInstallations(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): Installations

    // Get a single installation
    @GET("/app/installations/{installation_id}")
    suspend fun getInstallation(
        @Path("installation_id") installationId: Long
    ): Response<Installation>

    @DELETE("/app/installations/{installation_id}")
    suspend fun deleteAppInstallation(
        @Path("installation_id") installationId: Long
    ): Response<Unit>

    @POST("/app/installations/{installation_id}/access_tokens")
    suspend fun getAccessToken(
        @Path("installation_id") installationId: Long,
        @Body body: InstallationAccessTokenRequest? = null
    ): Response<Unit>

    @PUT("/app/installations/{installation_id}")
    suspend fun suspendInstallation(
        @Path("installation_id") installationId: Long
    ): Response<Unit>

    // Unsuspend an installation
    @DELETE("/app/installations/{installation_id}/suspended")
    suspend fun unsuspendInstallation(
        @Path("installation_id") installationId: Long
    ): Response<Unit>

    // Delete an installation (for user/repo)
    @DELETE("/user/installations/{installation_id}")
    suspend fun deleteUserInstallation(
        @Path("installation_id") installationId: Long
    ): Response<Unit>

    // List repositories accessible to the installation
    @GET("/user/installations/{installation_id}/repositories")
    suspend fun listInstallationRepositories(
        @Path("installation_id") installationId: Long,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): Installations // Or a dedicated model for repositories

    // Add a repository to an app installation
    @PUT("/user/installations/{installation_id}/repositories/{repository_id}")
    suspend fun addRepositoryToInstallation(
        @Path("installation_id") installationId: Long,
        @Path("repository_id") repositoryId: Long
    ): Response<Unit>

    // Remove a repository from an app installation
    @DELETE("/user/installations/{installation_id}/repositories/{repository_id}")
    suspend fun removeRepositoryFromInstallation(
        @Path("installation_id") installationId: Long,
        @Path("repository_id") repositoryId: Long
    ): Response<Unit>
}
