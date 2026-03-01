package inc.kaizen.client.ocktogon.meta.api

import inc.kaizen.client.ocktogon.meta.model.GitHubMeta
import retrofit2.http.GET
import retrofit2.http.Query

interface MetaApi {

    @GET("/meta")
    suspend fun getApiMeta(): GitHubMeta

    @GET("/octocat")
    suspend fun getOctocat(@Query("s") s: String? = null): String

    @GET("/zen")
    suspend fun getZen(): String

    @GET("/versions")
    suspend fun getAllApiVersions(): List<String>

    @GET("/")
    suspend fun getRoot(): Map<String, String>
}
