package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.repo.model.*
import inc.kaizen.client.repo.model.repo.Repo
import retrofit2.Response
import retrofit2.http.*

interface RepoApi {

    @GET("/user/repos")
    suspend fun listReposForAuthenticatedUser(
        @Query("visibility") visibility: String? = null,
        @Query("affiliation") affiliation: String? = null,
        @Query("type") type: String? = null,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("since") since: String? = null,
        @Query("before") before: String? = null
    ): List<Repo>

    @GET("/users/{username}/repos")
    suspend fun listReposForUser(
        @Path("username") username: String,
        @Query("type") type: String? = null,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repo>

    @GET("/orgs/{org}/repos")
    suspend fun listOrgRepos(
        @Path("org") org: String,
        @Query("type") type: String? = null,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repo>

    @POST("/user/repos")
    suspend fun createRepoForAuthenticatedUser(
        @Body body: CreateRepoRequest
    ): Repo

    @POST("/orgs/{org}/repos")
    suspend fun createOrgRepo(
        @Path("org") org: String,
        @Body body: CreateRepoRequest
    ): Repo

    @GET("/repos/{owner}/{repo}")
    suspend fun getRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Repo

    @PATCH("/repos/{owner}/{repo}")
    suspend fun updateRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: UpdateRepoRequest
    ): Repo

    @DELETE("/repos/{owner}/{repo}")
    suspend fun deleteRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    @POST("/repos/{owner}/{repo}/forks")
    suspend fun createFork(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: ForkRequest? = null
    ): Repo

    @GET("/repos/{owner}/{repo}/forks")
    suspend fun listForks(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("sort") sort: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repo>

    @POST("/repos/{owner}/{repo}/transfer")
    suspend fun transferRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: TransferRepoRequest
    ): Repo

    @GET("/repos/{owner}/{repo}/topics")
    suspend fun getRepoTopics(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): TopicsResponse

    @PUT("/repos/{owner}/{repo}/topics")
    suspend fun replaceRepoTopics(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: TopicsRequest
    ): TopicsResponse

    @GET("/repos/{owner}/{repo}/languages")
    suspend fun listRepoLanguages(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Map<String, Int>

    @GET("/repos/{owner}/{repo}/tags")
    suspend fun listRepoTags(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<RepoTag>

    @GET("/repos/{owner}/{repo}/teams")
    suspend fun listRepoTeams(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<inc.kaizen.client.common.Team>

    @GET("/repositories")
    suspend fun listPublicRepos(
        @Query("since") since: Int? = null,
        @Query("per_page") perPage: Int = 30
    ): List<Repo>

    @GET("/repos/{owner}/{repo}/vulnerability-alerts")
    suspend fun checkVulnerabilityAlertsEnabled(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    @PUT("/repos/{owner}/{repo}/vulnerability-alerts")
    suspend fun enableVulnerabilityAlerts(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    @DELETE("/repos/{owner}/{repo}/vulnerability-alerts")
    suspend fun disableVulnerabilityAlerts(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    @PUT("/repos/{owner}/{repo}/automated-security-fixes")
    suspend fun enableAutomatedSecurityFixes(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    @DELETE("/repos/{owner}/{repo}/automated-security-fixes")
    suspend fun disableAutomatedSecurityFixes(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    @GET("/repos/{template_owner}/{template_repo}/generate")
    suspend fun createRepoFromTemplate(
        @Path("template_owner") templateOwner: String,
        @Path("template_repo") templateRepo: String,
        @Body body: CreateRepoFromTemplateRequest
    ): Repo
}
