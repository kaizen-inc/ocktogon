package inc.kaizen.client.ocktogon.search.api

import inc.kaizen.client.search.model.*
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("/search/code")
    suspend fun searchCode(
        @Query("q") query: String,
        @Query("sort") sort: String? = null,
        @Query("order") order: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): CodeSearchResult

    @GET("/search/commits")
    suspend fun searchCommits(
        @Query("q") query: String,
        @Query("sort") sort: String? = null,
        @Query("order") order: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): CommitSearchResult

    @GET("/search/issues")
    suspend fun searchIssuesAndPullRequests(
        @Query("q") query: String,
        @Query("sort") sort: String? = null,
        @Query("order") order: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): IssueSearchResult

    @GET("/search/labels")
    suspend fun searchLabels(
        @Query("repository_id") repositoryId: Int,
        @Query("q") query: String,
        @Query("sort") sort: String? = null,
        @Query("order") order: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): LabelSearchResult

    @GET("/search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String? = null,
        @Query("order") order: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): RepoSearchResult

    @GET("/search/topics")
    suspend fun searchTopics(
        @Query("q") query: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): TopicSearchResult

    @GET("/search/users")
    suspend fun searchUsers(
        @Query("q") query: String,
        @Query("sort") sort: String? = null,
        @Query("order") order: String? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): UserSearchResult
}

