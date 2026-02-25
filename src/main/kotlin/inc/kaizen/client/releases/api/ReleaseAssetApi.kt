package inc.kaizen.client.releases.api

import inc.kaizen.client.releases.model.ReleaseAsset
import inc.kaizen.client.releases.model.ReleaseAssetRequest
import retrofit2.Response
import retrofit2.http.*

interface ReleaseAssetApi {

    // Get a release asset
    @GET("/repos/{owner}/{repo}/releases/assets/{asset_id}")
    suspend fun getReleaseAsset(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("asset_id") assetId: Long
    ): Response<ReleaseAsset>

    // update a release asset
    @PATCH("/repos/{owner}/{repo}/releases/assets/{asset_id}")
    suspend fun updateReleaseAsset(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("asset_id") assetId: Long,
        @Body body: ReleaseAssetRequest
    ): Response<ReleaseAsset>

    // Delete a release asset
    @DELETE("/repos/{owner}/{repo}/releases/assets/{asset_id}")
    suspend fun deleteReleaseAsset(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("asset_id") assetId: Long
    ): Response<Unit>

    // List release assets
    @GET("/repos/{owner}/{repo}/releases/{release_id}/assets")
    suspend fun listReleaseAssets(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("release_id") releaseId: Long,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): Response<List<ReleaseAsset>>

    // Upload a release asset
    @POST("/repos/{owner}/{repo}/releases/{release_id}/assets")
    suspend fun uploadReleaseAsset(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("release_id") releaseId: Long,
        @Query("name") name: String,
        @Query("label") label: String,
        @Body body: ByteArray
    ): Response<ReleaseAsset>
}