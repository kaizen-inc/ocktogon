package inc.kaizen.client.securityadvisories.api

import inc.kaizen.client.securityadvisories.model.*
import retrofit2.http.*

interface SecurityAdvisoryApi {

    @GET("/advisories")
    suspend fun listGlobalSecurityAdvisories(
        @Query("ghsa_id") ghsaId: String? = null,
        @Query("type") type: String? = null,
        @Query("cve_id") cveId: String? = null,
        @Query("ecosystem") ecosystem: String? = null,
        @Query("severity") severity: String? = null,
        @Query("cwes") cwes: List<String>? = null,
        @Query("is_withdrawn") isWithdrawn: Boolean? = null,
        @Query("affects") affects: List<String>? = null,
        @Query("published") published: String? = null,
        @Query("updated") updated: String? = null,
        @Query("modified") modified: String? = null,
        @Query("before") before: String? = null,
        @Query("after") after: String? = null,
        @Query("direction") direction: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("sort") sort: String? = null
    ): List<GlobalSecurityAdvisory>

    @GET("/advisories/{ghsa_id}")
    suspend fun getGlobalSecurityAdvisory(@Path("ghsa_id") ghsaId: String): GlobalSecurityAdvisory

    @GET("/repos/{owner}/{repo}/security-advisories")
    suspend fun listRepoSecurityAdvisories(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("direction") direction: String? = null,
        @Query("sort") sort: String? = null,
        @Query("before") before: String? = null,
        @Query("after") after: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("state") state: String? = null
    ): List<RepositoryAdvisory>

    @POST("/repos/{owner}/{repo}/security-advisories")
    suspend fun createRepoSecurityAdvisory(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: CreateRepositoryAdvisoryRequest
    ): RepositoryAdvisory

    @GET("/repos/{owner}/{repo}/security-advisories/{ghsa_id}")
    suspend fun getRepoSecurityAdvisory(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ghsa_id") ghsaId: String
    ): RepositoryAdvisory

    @PATCH("/repos/{owner}/{repo}/security-advisories/{ghsa_id}")
    suspend fun updateRepoSecurityAdvisory(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ghsa_id") ghsaId: String,
        @Body body: UpdateRepositoryAdvisoryRequest
    ): RepositoryAdvisory

    @POST("/repos/{owner}/{repo}/security-advisories/{ghsa_id}/cve")
    suspend fun requestCveForRepoSecurityAdvisory(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ghsa_id") ghsaId: String
    ): RepositoryAdvisory

    @POST("/repos/{owner}/{repo}/security-advisories/{ghsa_id}/publish")
    suspend fun publishRepoSecurityAdvisory(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ghsa_id") ghsaId: String
    ): RepositoryAdvisory

    @POST("/repos/{owner}/{repo}/security-advisories/reports")
    suspend fun createPrivateVulnerabilityReport(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: PrivateVulnerabilityReportRequest
    ): RepositoryAdvisory
}
