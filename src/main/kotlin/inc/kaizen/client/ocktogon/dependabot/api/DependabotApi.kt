package inc.kaizen.client.ocktogon.dependabot.api

import inc.kaizen.client.dependabot.model.*
import retrofit2.Response
import retrofit2.http.*

interface DependabotApi {

    // Org-level alerts
    @GET("/orgs/{org}/dependabot/alerts")
    suspend fun listOrgAlerts(
        @Path("org") org: String,
        @Query("state") state: String? = null,
        @Query("severity") severity: String? = null,
        @Query("ecosystem") ecosystem: String? = null,
        @Query("package") packageName: String? = null,
        @Query("scope") scope: String? = null,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("before") before: String? = null,
        @Query("after") after: String? = null,
        @Query("first") first: Int? = null,
        @Query("last") last: Int? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<DependabotAlert>

    // Repo-level alerts
    @GET("/repos/{owner}/{repo}/dependabot/alerts")
    suspend fun listRepoAlerts(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("state") state: String? = null,
        @Query("severity") severity: String? = null,
        @Query("ecosystem") ecosystem: String? = null,
        @Query("package") packageName: String? = null,
        @Query("scope") scope: String? = null,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("before") before: String? = null,
        @Query("after") after: String? = null,
        @Query("first") first: Int? = null,
        @Query("last") last: Int? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<DependabotAlert>

    @GET("/repos/{owner}/{repo}/dependabot/alerts/{alert_number}")
    suspend fun getRepoAlert(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("alert_number") alertNumber: Int
    ): DependabotAlert

    @PATCH("/repos/{owner}/{repo}/dependabot/alerts/{alert_number}")
    suspend fun updateRepoAlert(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("alert_number") alertNumber: Int,
        @Body body: UpdateDependabotAlertRequest
    ): DependabotAlert

    // Secrets
    @GET("/orgs/{org}/dependabot/secrets")
    suspend fun listOrgSecrets(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): DependabotSecretsResponse

    @GET("/orgs/{org}/dependabot/secrets/public-key")
    suspend fun getOrgPublicKey(
        @Path("org") org: String
    ): DependabotPublicKey

    @GET("/orgs/{org}/dependabot/secrets/{secret_name}")
    suspend fun getOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String
    ): DependabotSecret

    @PUT("/orgs/{org}/dependabot/secrets/{secret_name}")
    suspend fun createOrUpdateOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String,
        @Body body: CreateDependabotSecretRequest
    ): Response<Unit>

    @DELETE("/orgs/{org}/dependabot/secrets/{secret_name}")
    suspend fun deleteOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String
    ): Response<Unit>

    @GET("/orgs/{org}/dependabot/secrets/{secret_name}/repositories")
    suspend fun listSelectedReposForOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): DependabotSecretRepositoriesResponse

    @PUT("/orgs/{org}/dependabot/secrets/{secret_name}/repositories")
    suspend fun setSelectedReposForOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String,
        @Body body: SetSelectedReposRequest
    ): Response<Unit>

    @PUT("/orgs/{org}/dependabot/secrets/{secret_name}/repositories/{repository_id}")
    suspend fun addSelectedRepoToOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String,
        @Path("repository_id") repositoryId: Long
    ): Response<Unit>

    @DELETE("/orgs/{org}/dependabot/secrets/{secret_name}/repositories/{repository_id}")
    suspend fun removeSelectedRepoFromOrgSecret(
        @Path("org") org: String,
        @Path("secret_name") secretName: String,
        @Path("repository_id") repositoryId: Long
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/dependabot/secrets")
    suspend fun listRepoSecrets(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): DependabotSecretsResponse

    @GET("/repos/{owner}/{repo}/dependabot/secrets/public-key")
    suspend fun getRepoPublicKey(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): DependabotPublicKey

    @GET("/repos/{owner}/{repo}/dependabot/secrets/{secret_name}")
    suspend fun getRepoSecret(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("secret_name") secretName: String
    ): DependabotSecret

    @PUT("/repos/{owner}/{repo}/dependabot/secrets/{secret_name}")
    suspend fun createOrUpdateRepoSecret(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("secret_name") secretName: String,
        @Body body: CreateDependabotSecretRequest
    ): Response<Unit>

    @DELETE("/repos/{owner}/{repo}/dependabot/secrets/{secret_name}")
    suspend fun deleteRepoSecret(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("secret_name") secretName: String
    ): Response<Unit>
}

