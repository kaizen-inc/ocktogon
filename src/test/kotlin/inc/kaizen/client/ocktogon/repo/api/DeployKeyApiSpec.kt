package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.ocktogon.repo.model.CreateDeployKeyRequest
import inc.kaizen.client.ocktogon.repo.model.DeployKey
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class DeployKeyApiSpec : FunSpec({
    val api = mockk<DeployKeyApi>()
    val owner = "owner"; val repo = "repo"; val keyId = 1L
    val deployKey = mockk<DeployKey>()
    val keys = listOf(deployKey)
    val createReq = CreateDeployKeyRequest(title = "Deploy Key", key = "ssh-rsa AAAA...")

    test("listDeployKeys returns keys") {
        coEvery { api.listDeployKeys(owner, repo, any(), any()) } returns keys
        runBlocking { api.listDeployKeys(owner, repo) } shouldBe keys
    }
    test("createDeployKey returns key") {
        coEvery { api.createDeployKey(owner, repo, createReq) } returns deployKey
        runBlocking { api.createDeployKey(owner, repo, createReq) } shouldBe deployKey
    }
    test("getDeployKey returns key") {
        coEvery { api.getDeployKey(owner, repo, keyId) } returns deployKey
        runBlocking { api.getDeployKey(owner, repo, keyId) } shouldBe deployKey
    }
    test("deleteDeployKey returns response") {
        coEvery { api.deleteDeployKey(owner, repo, keyId) } returns Response.success(Unit)
        runBlocking { api.deleteDeployKey(owner, repo, keyId).isSuccessful } shouldBe true
    }
})

