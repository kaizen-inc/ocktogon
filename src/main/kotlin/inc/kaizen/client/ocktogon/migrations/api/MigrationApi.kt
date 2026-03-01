package inc.kaizen.client.ocktogon.migrations.api

import inc.kaizen.client.common.Repository
import inc.kaizen.client.migrations.model.Migration
import inc.kaizen.client.migrations.model.StartMigrationRequest
import retrofit2.Response
import retrofit2.http.*

interface OrgMigrationApi {

    @GET("/orgs/{org}/migrations")
    suspend fun listOrgMigrations(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("exclude") exclude: List<String>? = null
    ): List<Migration>

    @POST("/orgs/{org}/migrations")
    suspend fun startOrgMigration(
        @Path("org") org: String,
        @Body body: StartMigrationRequest
    ): Migration

    @GET("/orgs/{org}/migrations/{migration_id}")
    suspend fun getOrgMigration(
        @Path("org") org: String,
        @Path("migration_id") migrationId: Long,
        @Query("exclude") exclude: List<String>? = null
    ): Migration

    @GET("/orgs/{org}/migrations/{migration_id}/archive")
    suspend fun downloadOrgMigrationArchive(
        @Path("org") org: String,
        @Path("migration_id") migrationId: Long
    ): Response<Unit>

    @DELETE("/orgs/{org}/migrations/{migration_id}/archive")
    suspend fun deleteOrgMigrationArchive(
        @Path("org") org: String,
        @Path("migration_id") migrationId: Long
    ): Response<Unit>

    @DELETE("/orgs/{org}/migrations/{migration_id}/repos/{repo_name}/lock")
    suspend fun unlockOrgRepoForMigration(
        @Path("org") org: String,
        @Path("migration_id") migrationId: Long,
        @Path("repo_name") repoName: String
    ): Response<Unit>

    @GET("/orgs/{org}/migrations/{migration_id}/repositories")
    suspend fun listReposForOrgMigration(
        @Path("org") org: String,
        @Path("migration_id") migrationId: Long,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repository>
}

interface UserMigrationApi {

    @GET("/user/migrations")
    suspend fun listUserMigrations(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Migration>

    @POST("/user/migrations")
    suspend fun startUserMigration(@Body body: StartMigrationRequest): Migration

    @GET("/user/migrations/{migration_id}")
    suspend fun getUserMigration(
        @Path("migration_id") migrationId: Long,
        @Query("exclude") exclude: List<String>? = null
    ): Migration

    @GET("/user/migrations/{migration_id}/archive")
    suspend fun getUserMigrationArchive(@Path("migration_id") migrationId: Long): Response<Unit>

    @DELETE("/user/migrations/{migration_id}/archive")
    suspend fun deleteUserMigrationArchive(@Path("migration_id") migrationId: Long): Response<Unit>

    @DELETE("/user/migrations/{migration_id}/repos/{repo_name}/lock")
    suspend fun unlockRepoForUserMigration(
        @Path("migration_id") migrationId: Long,
        @Path("repo_name") repoName: String
    ): Response<Unit>

    @GET("/user/migrations/{migration_id}/repositories")
    suspend fun listReposForUserMigration(
        @Path("migration_id") migrationId: Long,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Repository>
}
