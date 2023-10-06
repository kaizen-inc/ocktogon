package inc.kaizen.client.action.api

import inc.kaizen.client.action.model.cache.*
import inc.kaizen.client.pull.model.Direction
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CacheApi {

    @GET("/orgs/{org}/actions/cache/usage")
    fun getOrgCacheUsage(
        @Path("org") org: String,
    ): CacheUsage

    @GET("/orgs/{org}/actions/cache/usage-by-repository")
    fun getOrgCacheUsagePerRepositories(
        @Path("org") org: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
    ): CacheUsagePerRepo

    @GET("/repos/{owner}/{repo}/actions/cache/usage")
    fun getRepoCacheUsage(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): RepositoryCacheUsage

    @GET("/repos/{owner}/{repo}/actions/caches")
    fun getRepoCache(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1,
        @Query("ref") ref: String,
        @Query("sort") sort: SortCache = SortCache.last_accessed_at,
        @Query("direction") direction: Direction
    ): ActionCaches

    @DELETE("/repos/{owner}/{repo}/actions/caches")
    fun deleteRepoCaches(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("key") key: String,
        @Query("ref") ref: String
    ): ActionCaches

    @DELETE("/repos/{owner}/{repo}/actions/caches/{cache_id}")
    fun deleteRepoCache(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("cache_id") cacheId: String,
    ): Response<Unit>
}