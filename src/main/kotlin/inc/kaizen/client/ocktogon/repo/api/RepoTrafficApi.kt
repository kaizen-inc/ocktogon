package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.ocktogon.repo.model.ClonesTraffic
import inc.kaizen.client.ocktogon.repo.model.TrafficPath
import inc.kaizen.client.ocktogon.repo.model.TrafficReferrer
import inc.kaizen.client.ocktogon.repo.model.ViewsTraffic
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepoTrafficApi {

    @GET("/repos/{owner}/{repo}/traffic/clones")
    suspend fun getClones(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per") per: String? = null
    ): ClonesTraffic

    @GET("/repos/{owner}/{repo}/traffic/popular/paths")
    suspend fun getTopPaths(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): List<TrafficPath>

    @GET("/repos/{owner}/{repo}/traffic/popular/referrers")
    suspend fun getTopReferrers(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): List<TrafficReferrer>

    @GET("/repos/{owner}/{repo}/traffic/views")
    suspend fun getViews(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per") per: String? = null
    ): ViewsTraffic
}
