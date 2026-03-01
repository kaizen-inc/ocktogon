package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.repo.model.CommitActivity
import inc.kaizen.client.repo.model.ContributorStat
import inc.kaizen.client.repo.model.ParticipationStats
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoStatApi {

    @GET("/repos/{owner}/{repo}/stats/contributors")
    suspend fun getContributorStats(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): List<ContributorStat>

    @GET("/repos/{owner}/{repo}/stats/commit_activity")
    suspend fun getCommitActivityStats(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): List<CommitActivity>

    @GET("/repos/{owner}/{repo}/stats/code_frequency")
    suspend fun getCodeFrequencyStats(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): List<List<Int>>

    @GET("/repos/{owner}/{repo}/stats/participation")
    suspend fun getParticipationStats(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): ParticipationStats

    @GET("/repos/{owner}/{repo}/stats/punch_card")
    suspend fun getPunchCardStats(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): List<List<Int>>
}
