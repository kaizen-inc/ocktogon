package inc.kaizen.client.ocktogon.releases.api

import inc.kaizen.client.ocktogon.releases.model.ReleaseAsset
import inc.kaizen.client.ocktogon.releases.model.ReleaseAssetRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class ReleaseAssetApiSpec : FunSpec({
    val api = mockk<ReleaseAssetApi>()
    val owner = "owner"
    val repo = "repo"
    val releaseId = 1L
    val assetId = 2L
    val asset = mockk<ReleaseAsset>()
    val assetList = listOf(asset)
    val assetRequest = mockk<ReleaseAssetRequest>()
    val assetBytes = byteArrayOf(1, 2, 3)
    val name = "asset.zip"
    val label = "Asset Label"

    test("getReleaseAsset returns release asset") {
        coEvery { api.getReleaseAsset(owner, repo, assetId) } returns Response.success(asset)
        runBlocking {
            api.getReleaseAsset(owner, repo, assetId).body() shouldBe asset
        }
    }

    test("updateReleaseAsset returns updated asset") {
        coEvery { api.updateReleaseAsset(owner, repo, assetId, assetRequest) } returns Response.success(asset)
        runBlocking {
            api.updateReleaseAsset(owner, repo, assetId, assetRequest).body() shouldBe asset
        }
    }

    test("deleteReleaseAsset returns unit response") {
        coEvery { api.deleteReleaseAsset(owner, repo, assetId) } returns Response.success(Unit)
        runBlocking {
            api.deleteReleaseAsset(owner, repo, assetId).isSuccessful shouldBe true
        }
    }

    test("listReleaseAssets returns asset list") {
        coEvery { api.listReleaseAssets(owner, repo, releaseId, any(), any()) } returns Response.success(assetList)
        runBlocking {
            api.listReleaseAssets(owner, repo, releaseId).body() shouldBe assetList
        }
    }

    test("uploadReleaseAsset returns uploaded asset") {
        coEvery { api.uploadReleaseAsset(owner, repo, releaseId, name, label, assetBytes) } returns Response.success(asset)
        runBlocking {
            api.uploadReleaseAsset(owner, repo, releaseId, name, label, assetBytes).body() shouldBe asset
        }
    }
})
