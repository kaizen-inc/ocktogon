package inc.kaizen.client.checks.api

import inc.kaizen.client.checks.model.*
import retrofit2.Response
import retrofit2.http.*

interface CheckRunApi {

    @POST("/repos/{owner}/{repo}/check-runs")
    suspend fun createCheckRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateCheckRunRequest
    ): CheckRun

    @GET("/repos/{owner}/{repo}/check-runs/{check_run_id}")
    suspend fun getCheckRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("check_run_id") checkRunId: Long
    ): CheckRun

    @PATCH("/repos/{owner}/{repo}/check-runs/{check_run_id}")
    suspend fun updateCheckRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("check_run_id") checkRunId: Long,
        @Body body: UpdateCheckRunRequest
    ): CheckRun

    @GET("/repos/{owner}/{repo}/check-runs/{check_run_id}/annotations")
    suspend fun listCheckRunAnnotations(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("check_run_id") checkRunId: Long,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<CheckAnnotation>

    @POST("/repos/{owner}/{repo}/check-runs/{check_run_id}/rerequest")
    suspend fun rerequestCheckRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("check_run_id") checkRunId: Long
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/commits/{ref}/check-runs")
    suspend fun listCheckRunsForRef(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ref") ref: String,
        @Query("check_name") checkName: String? = null,
        @Query("status") status: String? = null,
        @Query("filter") filter: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("app_id") appId: Int? = null
    ): CheckRunsResponse

    @GET("/repos/{owner}/{repo}/check-suites/{check_suite_id}/check-runs")
    suspend fun listCheckRunsInCheckSuite(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("check_suite_id") checkSuiteId: Long,
        @Query("check_name") checkName: String? = null,
        @Query("status") status: String? = null,
        @Query("filter") filter: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): CheckRunsResponse
}

interface CheckSuiteApi {

    @POST("/repos/{owner}/{repo}/check-suites")
    suspend fun createCheckSuite(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateCheckSuiteRequest
    ): CheckSuite

    @PATCH("/repos/{owner}/{repo}/check-suites/preferences")
    suspend fun updateCheckSuitePreferences(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CheckSuitePreferencesRequest
    ): CheckSuitePreferencesResponse

    @GET("/repos/{owner}/{repo}/check-suites/{check_suite_id}")
    suspend fun getCheckSuite(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("check_suite_id") checkSuiteId: Long
    ): CheckSuite

    @POST("/repos/{owner}/{repo}/check-suites/{check_suite_id}/rerequest")
    suspend fun rerequestCheckSuite(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("check_suite_id") checkSuiteId: Long
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/commits/{ref}/check-suites")
    suspend fun listCheckSuitesForRef(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ref") ref: String,
        @Query("app_id") appId: Int? = null,
        @Query("check_name") checkName: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): CheckSuitesResponse
}
