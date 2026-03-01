package inc.kaizen.client.ocktogon.page.api

import inc.kaizen.client.page.model.*
import retrofit2.Response
import retrofit2.http.*

interface GitHubPagesApi {

    // Get a GitHub Pages site
    @GET("/repos/{owner}/{repo}/pages")
    suspend fun getPagesSite(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<PagesSite>

    // Create or update a GitHub Pages site
    @POST("/repos/{owner}/{repo}/pages")
    suspend fun createOrUpdatePagesSite(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: PagesSiteRequest
    ): Response<PagesSite>

    // update a GitHub Pages site information
    @PUT("/repos/{owner}/{repo}/pages")
    suspend fun updatePagesSiteInformation(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: PagesSiteInformationRequest
    ): Response<Unit>

    // Delete a GitHub Pages site
    @DELETE("/repos/{owner}/{repo}/pages")
    suspend fun deletePagesSite(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<Unit>

    // List GitHub Pages builds
    @GET("/repos/{owner}/{repo}/pages/builds")
    suspend fun listPagesBuilds(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): Response<List<PagesBuild>>

    // request a new GitHub Pages build
    @POST("/repos/{owner}/{repo}/pages/builds")
    suspend fun requestPagesBuild(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<PagesBuild>

    // get latest GitHub Pages build
    @GET("/repos/{owner}/{repo}/pages/builds/latest")
    suspend fun getLatestPagesBuild(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<PagesBuild>

    // Get a specific GitHub Pages build
    @GET("/repos/{owner}/{repo}/pages/builds/{build_id}")
    suspend fun getPagesBuild(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("build_id") buildId: String
    ): Response<PagesBuild>

    // Create a GitHub Pages deployment
    @POST("/repos/{owner}/{repo}/pages/deployments")
    suspend fun createPagesDeployment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: PagesSiteRequest
    ): Response<PageDeployment>

    // Get the status of a GitHub Pages deployment
    @GET("/repos/{owner}/{repo}/pages/deployments/{pages_deployment_id}")
    suspend fun getPagesDeployment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pages_deployment_id") pagesDeploymentId: String
    ): Response<PageDeploymentStatus>

    // Cancel a GitHub Pages deployment
    @POST("/repos/{owner}/{repo}/pages/deployments/{pages_deployment_id}/cancel")
    suspend fun cancelPagesDeployment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("pages_deployment_id") pagesDeploymentId: String
    ): Response<Unit>

    // Get a DNS health check for GitHub Pages
    @GET("/repos/{owner}/{repo}/pages/dns-health")
    suspend fun getPagesDnsHealth(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Response<PagesDnsHealth>
}
