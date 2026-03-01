package inc.kaizen.client.ocktogon.action.api

import inc.kaizen.client.ocktogon.action.model.variable.*
import retrofit2.Response
import retrofit2.http.*

interface VariableApi {

    @GET("/orgs/{org}/actions/variables")
    suspend fun listOrgVariables(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): VariablesResponse

    @POST("/orgs/{org}/actions/variables")
    suspend fun createOrgVariable(
        @Path("org") org: String,
        @Body body: CreateVariableRequest
    ): Response<Unit>

    @GET("/orgs/{org}/actions/variables/{variable_name}")
    suspend fun getOrgVariable(
        @Path("org") org: String,
        @Path("variable_name") variableName: String
    ): Variable

    @PATCH("/orgs/{org}/actions/variables/{variable_name}")
    suspend fun updateOrgVariable(
        @Path("org") org: String,
        @Path("variable_name") variableName: String,
        @Body body: CreateVariableRequest
    ): Response<Unit>

    @DELETE("/orgs/{org}/actions/variables/{variable_name}")
    suspend fun deleteOrgVariable(
        @Path("org") org: String,
        @Path("variable_name") variableName: String
    ): Response<Unit>

    @GET("/orgs/{org}/actions/variables/{variable_name}/repositories")
    suspend fun listSelectedReposForOrgVariable(
        @Path("org") org: String,
        @Path("variable_name") variableName: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): VariableRepositoriesResponse

    @PUT("/orgs/{org}/actions/variables/{variable_name}/repositories")
    suspend fun setSelectedReposForOrgVariable(
        @Path("org") org: String,
        @Path("variable_name") variableName: String,
        @Body body: SetVariableRepositoriesRequest
    ): Response<Unit>

    @PUT("/orgs/{org}/actions/variables/{variable_name}/repositories/{repository_id}")
    suspend fun addSelectedRepoToOrgVariable(
        @Path("org") org: String,
        @Path("variable_name") variableName: String,
        @Path("repository_id") repositoryId: Long
    ): Response<Unit>

    @DELETE("/orgs/{org}/actions/variables/{variable_name}/repositories/{repository_id}")
    suspend fun removeSelectedRepoFromOrgVariable(
        @Path("org") org: String,
        @Path("variable_name") variableName: String,
        @Path("repository_id") repositoryId: Long
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/variables")
    suspend fun listRepoVariables(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): VariablesResponse

    @POST("/repos/{owner}/{repo}/actions/variables")
    suspend fun createRepoVariable(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateVariableRequest
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/variables/{variable_name}")
    suspend fun getRepoVariable(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("variable_name") variableName: String
    ): Variable

    @PATCH("/repos/{owner}/{repo}/actions/variables/{variable_name}")
    suspend fun updateRepoVariable(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("variable_name") variableName: String,
        @Body body: CreateVariableRequest
    ): Response<Unit>

    @DELETE("/repos/{owner}/{repo}/actions/variables/{variable_name}")
    suspend fun deleteRepoVariable(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("variable_name") variableName: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/organization-variables")
    suspend fun listRepoOrgVariables(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): VariablesResponse

    @GET("/repos/{owner}/{repo}/environments/{environment_name}/variables")
    suspend fun listEnvVariables(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): VariablesResponse

    @POST("/repos/{owner}/{repo}/environments/{environment_name}/variables")
    suspend fun createEnvVariable(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Body body: CreateVariableRequest
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/environments/{environment_name}/variables/{variable_name}")
    suspend fun getEnvVariable(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Path("variable_name") variableName: String
    ): Variable

    @PATCH("/repos/{owner}/{repo}/environments/{environment_name}/variables/{variable_name}")
    suspend fun updateEnvVariable(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Path("variable_name") variableName: String,
        @Body body: CreateVariableRequest
    ): Response<Unit>

    @DELETE("/repos/{owner}/{repo}/environments/{environment_name}/variables/{variable_name}")
    suspend fun deleteEnvVariable(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("environment_name") environmentName: String,
        @Path("variable_name") variableName: String
    ): Response<Unit>
}

