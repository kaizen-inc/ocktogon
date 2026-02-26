package inc.kaizen.client.licenses.api

import inc.kaizen.client.common.License
import inc.kaizen.client.licenses.model.LicenseSimple
import inc.kaizen.client.licenses.model.RepoLicenseContent
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LicenseApi {

    @GET("/licenses")
    suspend fun getAllCommonlyUsedLicenses(
        @Query("featured") featured: Boolean? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<LicenseSimple>

    @GET("/licenses/{license}")
    suspend fun getLicense(@Path("license") license: String): License

    @GET("/repos/{owner}/{repo}/license")
    suspend fun getRepoLicense(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("ref") ref: String? = null
    ): RepoLicenseContent
}
