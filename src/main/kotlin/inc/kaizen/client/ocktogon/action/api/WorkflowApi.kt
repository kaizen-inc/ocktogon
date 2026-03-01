package inc.kaizen.client.ocktogon.action.api

import inc.kaizen.client.action.model.workflow.*
import retrofit2.Response
import retrofit2.http.*

interface WorkflowApi {

    @GET("/repos/{owner}/{repo}/actions/workflows")
    suspend fun listWorkflows(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): WorkflowsResponse

    @GET("/repos/{owner}/{repo}/actions/workflows/{workflow_id}")
    suspend fun getWorkflow(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("workflow_id") workflowId: String
    ): Workflow

    @PUT("/repos/{owner}/{repo}/actions/workflows/{workflow_id}/disable")
    suspend fun disableWorkflow(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("workflow_id") workflowId: String
    ): Response<Unit>

    @POST("/repos/{owner}/{repo}/actions/workflows/{workflow_id}/dispatches")
    suspend fun createWorkflowDispatch(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("workflow_id") workflowId: String,
        @Body body: WorkflowDispatchRequest
    ): Response<Unit>

    @PUT("/repos/{owner}/{repo}/actions/workflows/{workflow_id}/enable")
    suspend fun enableWorkflow(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("workflow_id") workflowId: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/workflows/{workflow_id}/runs")
    suspend fun listWorkflowRuns(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("workflow_id") workflowId: String,
        @Query("actor") actor: String? = null,
        @Query("branch") branch: String? = null,
        @Query("event") event: String? = null,
        @Query("status") status: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("created") created: String? = null,
        @Query("exclude_pull_requests") excludePullRequests: Boolean? = null,
        @Query("check_suite_id") checkSuiteId: Long? = null,
        @Query("head_sha") headSha: String? = null
    ): WorkflowRunsResponse

    @GET("/repos/{owner}/{repo}/actions/runs")
    suspend fun listWorkflowRunsForRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("actor") actor: String? = null,
        @Query("branch") branch: String? = null,
        @Query("event") event: String? = null,
        @Query("status") status: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("created") created: String? = null,
        @Query("exclude_pull_requests") excludePullRequests: Boolean? = null,
        @Query("check_suite_id") checkSuiteId: Long? = null,
        @Query("head_sha") headSha: String? = null
    ): WorkflowRunsResponse

    @GET("/repos/{owner}/{repo}/actions/runs/{run_id}")
    suspend fun getWorkflowRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long,
        @Query("exclude_pull_requests") excludePullRequests: Boolean? = null
    ): WorkflowRun

    @DELETE("/repos/{owner}/{repo}/actions/runs/{run_id}")
    suspend fun deleteWorkflowRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/runs/{run_id}/approvals")
    suspend fun getReviewsForRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long
    ): List<Any>

    @POST("/repos/{owner}/{repo}/actions/runs/{run_id}/approve")
    suspend fun approveWorkflowRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long
    ): Response<Any>

    @GET("/repos/{owner}/{repo}/actions/runs/{run_id}/attempts/{attempt_number}")
    suspend fun getWorkflowRunAttempt(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long,
        @Path("attempt_number") attemptNumber: Int,
        @Query("exclude_pull_requests") excludePullRequests: Boolean? = null
    ): WorkflowRun

    @GET("/repos/{owner}/{repo}/actions/runs/{run_id}/attempts/{attempt_number}/logs")
    suspend fun downloadWorkflowRunAttemptLogs(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long,
        @Path("attempt_number") attemptNumber: Int
    ): Response<Unit>

    @POST("/repos/{owner}/{repo}/actions/runs/{run_id}/cancel")
    suspend fun cancelWorkflowRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long
    ): Response<Any>

    @POST("/repos/{owner}/{repo}/actions/runs/{run_id}/force-cancel")
    suspend fun forceCancelWorkflowRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long
    ): Response<Any>

    @GET("/repos/{owner}/{repo}/actions/runs/{run_id}/jobs")
    suspend fun listJobsForWorkflowRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long,
        @Query("filter") filter: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): JobsResponse

    @DELETE("/repos/{owner}/{repo}/actions/runs/{run_id}/logs")
    suspend fun deleteWorkflowRunLogs(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/runs/{run_id}/logs")
    suspend fun downloadWorkflowRunLogs(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long
    ): Response<Unit>

    @POST("/repos/{owner}/{repo}/actions/runs/{run_id}/pending_deployments")
    suspend fun reviewCustomDeploymentProtectionRules(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long,
        @Body body: Any
    ): List<Any>

    @POST("/repos/{owner}/{repo}/actions/runs/{run_id}/rerun")
    suspend fun reRunWorkflow(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long,
        @Body body: Any? = null
    ): Response<Any>

    @POST("/repos/{owner}/{repo}/actions/runs/{run_id}/rerun-failed-jobs")
    suspend fun reRunFailedJobs(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long,
        @Body body: Any? = null
    ): Response<Any>

    @GET("/repos/{owner}/{repo}/actions/runs/{run_id}/timing")
    suspend fun getWorkflowRunUsage(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("run_id") runId: Long
    ): WorkflowRunUsage

    @GET("/repos/{owner}/{repo}/actions/jobs/{job_id}")
    suspend fun getJobForWorkflowRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("job_id") jobId: Long
    ): WorkflowJob

    @GET("/repos/{owner}/{repo}/actions/jobs/{job_id}/logs")
    suspend fun downloadJobLogsForWorkflowRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("job_id") jobId: Long
    ): Response<Unit>

    @POST("/repos/{owner}/{repo}/actions/jobs/{job_id}/rerun")
    suspend fun reRunJobForWorkflowRun(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("job_id") jobId: Long,
        @Body body: Any? = null
    ): Response<Any>

    @GET("/repos/{owner}/{repo}/actions/workflows/{workflow_id}/timing")
    suspend fun getWorkflowUsage(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("workflow_id") workflowId: String
    ): WorkflowUsage
}

