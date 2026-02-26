package inc.kaizen.client.secretscanning.api

import inc.kaizen.client.secretscanning.model.SecretScanningAlert
import inc.kaizen.client.secretscanning.model.SecretScanningAlertLocation
import inc.kaizen.client.secretscanning.model.UpdateSecretScanningAlertRequest
import retrofit2.http.*

interface SecretScanningApi {

    @GET("/orgs/{org}/secret-scanning/alerts")
    suspend fun listOrgAlerts(
        @Path("org") org: String,
        @Query("state") state: String? = null,
        @Query("secret_type") secretType: String? = null,
        @Query("resolution") resolution: String? = null,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30,
        @Query("before") before: String? = null,
        @Query("after") after: String? = null,
        @Query("validity") validity: String? = null
    ): List<SecretScanningAlert>

    @GET("/repos/{owner}/{repo}/secret-scanning/alerts")
    suspend fun listAlertsForRepo(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("state") state: String? = null,
        @Query("secret_type") secretType: String? = null,
        @Query("resolution") resolution: String? = null,
        @Query("sort") sort: String? = null,
        @Query("direction") direction: String? = null,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30,
        @Query("before") before: String? = null,
        @Query("after") after: String? = null,
        @Query("validity") validity: String? = null
    ): List<SecretScanningAlert>

    @GET("/repos/{owner}/{repo}/secret-scanning/alerts/{alert_number}")
    suspend fun getAlert(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("alert_number") alertNumber: Int
    ): SecretScanningAlert

    @PATCH("/repos/{owner}/{repo}/secret-scanning/alerts/{alert_number}")
    suspend fun updateAlert(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("alert_number") alertNumber: Int,
        @Body body: UpdateSecretScanningAlertRequest
    ): SecretScanningAlert

    @GET("/repos/{owner}/{repo}/secret-scanning/alerts/{alert_number}/locations")
    suspend fun listLocationsForAlert(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("alert_number") alertNumber: Int,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30
    ): List<SecretScanningAlertLocation>
}
