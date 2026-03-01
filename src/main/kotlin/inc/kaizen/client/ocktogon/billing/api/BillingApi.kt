package inc.kaizen.client.ocktogon.billing.api

import inc.kaizen.client.ocktogon.billing.model.BillingReport
import inc.kaizen.client.ocktogon.billing.model.PackageBilling
import inc.kaizen.client.ocktogon.billing.model.StorageBilling
import inc.kaizen.client.ocktogon.billing.model.TokenBilling
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BillingApi {

    // Organization Billing
    @GET("/orgs/{org}/settings/billing/actions")
    suspend fun getOrgActionsBilling(
        @Path("org") org: String
    ): Response<TokenBilling>

    @GET("/orgs/{org}/settings/billing/packages")
    suspend fun getOrgPackagesBilling(
        @Path("org") org: String
    ): Response<PackageBilling>

    @GET("/orgs/{org}/settings/billing/shared-storage")
    suspend fun getOrgSharedStorageBilling(
        @Path("org") org: String
    ): Response<StorageBilling>

    // User Billing
    @GET("/users/{username}/settings/billing/actions")
    suspend fun getUserActionsBilling(
        @Path("username") username: String
    ): Response<TokenBilling>

    @GET("/users/{username}/settings/billing/packages")
    suspend fun getUserPackagesBilling(
        @Path("username") username: String
    ): Response<PackageBilling>

    @GET("/users/{username}/settings/billing/shared-storage")
    suspend fun getUserSharedStorageBilling(
        @Path("username") username: String
    ): Response<StorageBilling>

    @GET("/organizations/{org}/settings/billing/usage")
    suspend fun getOrganizationBillingReport(
        @Path("org") org: String,
        @Query("year") year: String? = null,
        @Query("month") month: String? = null,
        @Query("day") day: String? = null,
        @Query("hour") hour: String? = null
    ): Response<BillingReport>

    @GET("/users/{username}/settings/billing/usage")
    suspend fun getUserBillingReport(
        @Path("username") username: String,
        @Query("year") year: String? = null,
        @Query("month") month: String? = null,
        @Query("day") day: String? = null,
        @Query("hour") hour: String? = null
    ): Response<BillingReport>
}
