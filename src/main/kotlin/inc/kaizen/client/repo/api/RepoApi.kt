package inc.kaizen.client.repo.api

import inc.kaizen.client.repo.model.repo.Repo
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoApi {

    @GET("/orgs/{org}/repos")
    fun getRepos(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30
    ): List<Repo>
}