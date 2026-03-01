package inc.kaizen.client.ocktogon.codescanning.api

import inc.kaizen.client.ocktogon.codescanning.model.*
import retrofit2.http.*

interface CodeScanningApi {

    @GET("/orgs/{org}/code-scanning/alerts")
    suspend fun listOrgAlerts(
        @Path("org") org: String,
        @Query("tool_name") toolName: String? = null,
        @Query("tool_guid") toolGuid: String? = null,
        @Query("before") before: String? = null,
        @Query("after") after: String? = null,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30,
        @Query("direction") direction: String? = null,
        @Query("state") state: String? = null,
        @Query("sort") sort: String? = null,
        @Query("severity") severity: String? = null
    ): List<CodeScanningAlert>

    @GET("/repos/{owner}/{repo}/code-scanning/alerts")
    suspend fun listAlertsForRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("tool_name") toolName: String? = null,
        @Query("tool_guid") toolGuid: String? = null,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30,
        @Query("ref") ref: String? = null,
        @Query("direction") direction: String? = null,
        @Query("sort") sort: String? = null,
        @Query("state") state: String? = null,
        @Query("severity") severity: String? = null
    ): List<CodeScanningAlert>

    @GET("/repos/{owner}/{repo}/code-scanning/alerts/{alert_number}")
    suspend fun getAlert(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("alert_number") alertNumber: Int
    ): CodeScanningAlert

    @PATCH("/repos/{owner}/{repo}/code-scanning/alerts/{alert_number}")
    suspend fun updateAlert(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("alert_number") alertNumber: Int,
        @Body body: UpdateCodeScanningAlertRequest
    ): CodeScanningAlert

    @GET("/repos/{owner}/{repo}/code-scanning/alerts/{alert_number}/instances")
    suspend fun listAlertInstances(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("alert_number") alertNumber: Int,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30,
        @Query("ref") ref: String? = null
    ): List<CodeScanningAlertInstance>

    @GET("/repos/{owner}/{repo}/code-scanning/analyses")
    suspend fun listAnalysesForRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("tool_name") toolName: String? = null,
        @Query("tool_guid") toolGuid: String? = null,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30,
        @Query("ref") ref: String? = null,
        @Query("sarif_id") sarifId: String? = null,
        @Query("direction") direction: String? = null,
        @Query("sort") sort: String? = null
    ): List<CodeScanningAnalysis>

    @GET("/repos/{owner}/{repo}/code-scanning/analyses/{analysis_id}")
    suspend fun getAnalysis(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("analysis_id") analysisId: Long
    ): CodeScanningAnalysis

    @DELETE("/repos/{owner}/{repo}/code-scanning/analyses/{analysis_id}")
    suspend fun deleteAnalysis(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("analysis_id") analysisId: Long,
        @Query("confirm_delete") confirmDelete: String? = null
    ): CodeScanningAnalysisDeletion

    @GET("/repos/{owner}/{repo}/code-scanning/codeql/databases")
    suspend fun listCodeqlDatabases(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): List<CodeqlDatabase>

    @GET("/repos/{owner}/{repo}/code-scanning/codeql/databases/{language}")
    suspend fun getCodeqlDatabase(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("language") language: String
    ): CodeqlDatabase

    @GET("/repos/{owner}/{repo}/code-scanning/default-setup")
    suspend fun getDefaultSetup(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): CodeScanningDefaultSetup

    @PATCH("/repos/{owner}/{repo}/code-scanning/default-setup")
    suspend fun updateDefaultSetup(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: UpdateCodeScanningDefaultSetupRequest
    ): CodeScanningDefaultSetupResponse

    @POST("/repos/{owner}/{repo}/code-scanning/sarifs")
    suspend fun uploadSarif(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: UploadSarifRequest
    ): SarifUploadInfo

    @GET("/repos/{owner}/{repo}/code-scanning/sarifs/{sarif_id}")
    suspend fun getSarifUploadInfo(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("sarif_id") sarifId: String
    ): SarifUploadInfo
}

