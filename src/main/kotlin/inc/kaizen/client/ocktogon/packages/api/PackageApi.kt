package inc.kaizen.client.ocktogon.packages.api

import inc.kaizen.client.packages.model.PackageVersion
import retrofit2.Response
import retrofit2.http.*

interface PackageApi {

    @GET("/orgs/{org}/packages")
    suspend fun listOrgPackages(
        @Path("org") org: String,
        @Query("package_type") packageType: String,
        @Query("visibility") visibility: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Package>

    @GET("/orgs/{org}/packages/{package_type}/{package_name}")
    suspend fun getOrgPackage(
        @Path("org") org: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String
    ): Package

    @DELETE("/orgs/{org}/packages/{package_type}/{package_name}")
    suspend fun deleteOrgPackage(
        @Path("org") org: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String
    ): Response<Unit>

    @POST("/orgs/{org}/packages/{package_type}/{package_name}/restore")
    suspend fun restoreOrgPackage(
        @Path("org") org: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Query("token") token: String? = null
    ): Response<Unit>

    @GET("/orgs/{org}/packages/{package_type}/{package_name}/versions")
    suspend fun listOrgPackageVersions(
        @Path("org") org: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("state") state: String? = null
    ): List<PackageVersion>

    @GET("/orgs/{org}/packages/{package_type}/{package_name}/versions/{package_version_id}")
    suspend fun getOrgPackageVersion(
        @Path("org") org: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Path("package_version_id") packageVersionId: Long
    ): PackageVersion

    @DELETE("/orgs/{org}/packages/{package_type}/{package_name}/versions/{package_version_id}")
    suspend fun deleteOrgPackageVersion(
        @Path("org") org: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Path("package_version_id") packageVersionId: Long
    ): Response<Unit>

    @POST("/orgs/{org}/packages/{package_type}/{package_name}/versions/{package_version_id}/restore")
    suspend fun restoreOrgPackageVersion(
        @Path("org") org: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Path("package_version_id") packageVersionId: Long
    ): Response<Unit>

    @GET("/user/packages")
    suspend fun listPackagesForAuthenticatedUser(
        @Query("package_type") packageType: String,
        @Query("visibility") visibility: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Package>

    @GET("/user/packages/{package_type}/{package_name}")
    suspend fun getPackageForAuthenticatedUser(
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String
    ): Package

    @DELETE("/user/packages/{package_type}/{package_name}")
    suspend fun deletePackageForAuthenticatedUser(
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String
    ): Response<Unit>

    @POST("/user/packages/{package_type}/{package_name}/restore")
    suspend fun restorePackageForAuthenticatedUser(
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Query("token") token: String? = null
    ): Response<Unit>

    @GET("/user/packages/{package_type}/{package_name}/versions")
    suspend fun listPackageVersionsForAuthenticatedUser(
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("state") state: String? = null
    ): List<PackageVersion>

    @GET("/user/packages/{package_type}/{package_name}/versions/{package_version_id}")
    suspend fun getPackageVersionForAuthenticatedUser(
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Path("package_version_id") packageVersionId: Long
    ): PackageVersion

    @DELETE("/user/packages/{package_type}/{package_name}/versions/{package_version_id}")
    suspend fun deletePackageVersionForAuthenticatedUser(
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Path("package_version_id") packageVersionId: Long
    ): Response<Unit>

    @POST("/user/packages/{package_type}/{package_name}/versions/{package_version_id}/restore")
    suspend fun restorePackageVersionForAuthenticatedUser(
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Path("package_version_id") packageVersionId: Long
    ): Response<Unit>

    @GET("/users/{username}/packages")
    suspend fun listPackagesForUser(
        @Path("username") username: String,
        @Query("package_type") packageType: String,
        @Query("visibility") visibility: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Package>

    @GET("/users/{username}/packages/{package_type}/{package_name}")
    suspend fun getPackageForUser(
        @Path("username") username: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String
    ): Package

    @DELETE("/users/{username}/packages/{package_type}/{package_name}")
    suspend fun deletePackageForUser(
        @Path("username") username: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String
    ): Response<Unit>

    @POST("/users/{username}/packages/{package_type}/{package_name}/restore")
    suspend fun restorePackageForUser(
        @Path("username") username: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Query("token") token: String? = null
    ): Response<Unit>

    @GET("/users/{username}/packages/{package_type}/{package_name}/versions")
    suspend fun listPackageVersionsForUser(
        @Path("username") username: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("state") state: String? = null
    ): List<PackageVersion>

    @GET("/users/{username}/packages/{package_type}/{package_name}/versions/{package_version_id}")
    suspend fun getPackageVersionForUser(
        @Path("username") username: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Path("package_version_id") packageVersionId: Long
    ): PackageVersion

    @DELETE("/users/{username}/packages/{package_type}/{package_name}/versions/{package_version_id}")
    suspend fun deletePackageVersionForUser(
        @Path("username") username: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Path("package_version_id") packageVersionId: Long
    ): Response<Unit>

    @POST("/users/{username}/packages/{package_type}/{package_name}/versions/{package_version_id}/restore")
    suspend fun restorePackageVersionForUser(
        @Path("username") username: String,
        @Path("package_type") packageType: String,
        @Path("package_name") packageName: String,
        @Path("package_version_id") packageVersionId: Long
    ): Response<Unit>
}

