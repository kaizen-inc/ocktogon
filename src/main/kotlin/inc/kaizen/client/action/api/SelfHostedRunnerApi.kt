package inc.kaizen.client.action.api

import retrofit2.Response
import retrofit2.http.*

interface SelfHostedRunnerApi {

    @GET("/orgs/{org}/actions/runners")
    suspend fun listOrgRunners(
        @Path("org") org: String,
        @Query("name") name: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): RunnersResponse

    @GET("/orgs/{org}/actions/runners/downloads")
    suspend fun listRunnerApplicationsForOrg(
        @Path("org") org: String
    ): List<RunnerApplication>

    @POST("/orgs/{org}/actions/runners/generate-jitconfig")
    suspend fun generateConfigForOrgRunner(
        @Path("org") org: String,
        @Body body: GenerateRunnerConfigRequest
    ): RunnerJitConfig

    @POST("/orgs/{org}/actions/runners/registration-token")
    suspend fun createRegistrationTokenForOrg(
        @Path("org") org: String
    ): RunnerToken

    @POST("/orgs/{org}/actions/runners/remove-token")
    suspend fun createRemoveTokenForOrg(
        @Path("org") org: String
    ): RunnerToken

    @GET("/orgs/{org}/actions/runners/{runner_id}")
    suspend fun getOrgRunner(
        @Path("org") org: String,
        @Path("runner_id") runnerId: Long
    ): Runner

    @DELETE("/orgs/{org}/actions/runners/{runner_id}")
    suspend fun deleteOrgRunner(
        @Path("org") org: String,
        @Path("runner_id") runnerId: Long
    ): Response<Unit>

    @GET("/orgs/{org}/actions/runners/{runner_id}/labels")
    suspend fun listLabelsForOrgRunner(
        @Path("org") org: String,
        @Path("runner_id") runnerId: Long
    ): RunnerLabelsResponse

    @POST("/orgs/{org}/actions/runners/{runner_id}/labels")
    suspend fun addCustomLabelsToOrgRunner(
        @Path("org") org: String,
        @Path("runner_id") runnerId: Long,
        @Body body: RunnerLabelsRequest
    ): RunnerLabelsResponse

    @PUT("/orgs/{org}/actions/runners/{runner_id}/labels")
    suspend fun setCustomLabelsForOrgRunner(
        @Path("org") org: String,
        @Path("runner_id") runnerId: Long,
        @Body body: RunnerLabelsRequest
    ): RunnerLabelsResponse

    @DELETE("/orgs/{org}/actions/runners/{runner_id}/labels")
    suspend fun removeAllCustomLabelsFromOrgRunner(
        @Path("org") org: String,
        @Path("runner_id") runnerId: Long
    ): RunnerLabelsResponse

    @DELETE("/orgs/{org}/actions/runners/{runner_id}/labels/{name}")
    suspend fun removeCustomLabelFromOrgRunner(
        @Path("org") org: String,
        @Path("runner_id") runnerId: Long,
        @Path("name") name: String
    ): RunnerLabelsResponse

    @GET("/repos/{owner}/{repo}/actions/runners")
    suspend fun listRepoRunners(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("name") name: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): RunnersResponse

    @GET("/repos/{owner}/{repo}/actions/runners/downloads")
    suspend fun listRunnerApplicationsForRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): List<RunnerApplication>

    @POST("/repos/{owner}/{repo}/actions/runners/generate-jitconfig")
    suspend fun generateConfigForRepoRunner(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: GenerateRunnerConfigRequest
    ): RunnerJitConfig

    @POST("/repos/{owner}/{repo}/actions/runners/registration-token")
    suspend fun createRegistrationTokenForRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): RunnerToken

    @POST("/repos/{owner}/{repo}/actions/runners/remove-token")
    suspend fun createRemoveTokenForRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): RunnerToken

    @GET("/repos/{owner}/{repo}/actions/runners/{runner_id}")
    suspend fun getRepoRunner(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("runner_id") runnerId: Long
    ): Runner

    @DELETE("/repos/{owner}/{repo}/actions/runners/{runner_id}")
    suspend fun deleteRepoRunner(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("runner_id") runnerId: Long
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/runners/{runner_id}/labels")
    suspend fun listLabelsForRepoRunner(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("runner_id") runnerId: Long
    ): RunnerLabelsResponse

    @POST("/repos/{owner}/{repo}/actions/runners/{runner_id}/labels")
    suspend fun addCustomLabelsToRepoRunner(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("runner_id") runnerId: Long,
        @Body body: RunnerLabelsRequest
    ): RunnerLabelsResponse

    @PUT("/repos/{owner}/{repo}/actions/runners/{runner_id}/labels")
    suspend fun setCustomLabelsForRepoRunner(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("runner_id") runnerId: Long,
        @Body body: RunnerLabelsRequest
    ): RunnerLabelsResponse

    @DELETE("/repos/{owner}/{repo}/actions/runners/{runner_id}/labels")
    suspend fun removeAllCustomLabelsFromRepoRunner(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("runner_id") runnerId: Long
    ): RunnerLabelsResponse

    @DELETE("/repos/{owner}/{repo}/actions/runners/{runner_id}/labels/{name}")
    suspend fun removeCustomLabelFromRepoRunner(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("runner_id") runnerId: Long,
        @Path("name") name: String
    ): RunnerLabelsResponse
}

data class Runner(
    val id: Long? = null,
    val runner_group_id: Long? = null,
    val name: String? = null,
    val os: String? = null,
    val status: String? = null,
    val busy: Boolean? = null,
    val labels: List<RunnerLabel>? = null,
    val ephemeral: Boolean? = null
)

data class RunnerLabel(
    val id: Long? = null,
    val name: String? = null,
    val type: String? = null
)

data class RunnersResponse(
    val total_count: Int? = null,
    val runners: List<Runner>? = null
)

data class RunnerApplication(
    val os: String? = null,
    val architecture: String? = null,
    val download_url: String? = null,
    val filename: String? = null,
    val temp_download_token: String? = null,
    val sha256_checksum: String? = null
)

data class RunnerToken(
    val token: String? = null,
    val expires_at: String? = null
)

data class RunnerJitConfig(
    val runner: Runner? = null,
    val encoded_jit_config: String? = null
)

data class RunnerLabelsResponse(
    val total_count: Int? = null,
    val labels: List<RunnerLabel>? = null
)

data class RunnerLabelsRequest(val labels: List<String>)

data class GenerateRunnerConfigRequest(
    val name: String,
    val runner_group_id: Int,
    val labels: List<String>,
    val work_folder: String? = null
)

