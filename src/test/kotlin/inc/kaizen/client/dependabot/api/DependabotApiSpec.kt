package inc.kaizen.client.dependabot.api

import inc.kaizen.client.dependabot.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class DependabotApiSpec : FunSpec({
    val api = mockk<DependabotApi>()
    val org = "my-org"; val owner = "owner"; val repo = "repo"
    val alertNumber = 1; val secretName = "MY_SECRET"
    val alert = mockk<DependabotAlert>()
    val alerts = listOf(alert)
    val secret = mockk<DependabotSecret>()
    val publicKey = DependabotPublicKey(key_id = "kid", key = "key")
    val secretsResponse = DependabotSecretsResponse(total_count = 1, secrets = listOf(secret))
    val reposResponse = DependabotSecretRepositoriesResponse(total_count = 0, repositories = listOf())
    val updateAlertReq = UpdateDependabotAlertRequest(state = "dismissed")
    val createSecretReq = CreateDependabotSecretRequest(encrypted_value = "enc", key_id = "kid")
    val setReposReq = SetSelectedReposRequest(selected_repository_ids = listOf(1))

    test("listOrgAlerts returns alerts") {
        coEvery { api.listOrgAlerts(org, any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns alerts
        runBlocking { api.listOrgAlerts(org) shouldBe alerts }
    }
    test("listRepoAlerts returns alerts") {
        coEvery { api.listRepoAlerts(owner, repo, any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns alerts
        runBlocking { api.listRepoAlerts(owner, repo) shouldBe alerts }
    }
    test("getRepoAlert returns alert") {
        coEvery { api.getRepoAlert(owner, repo, alertNumber) } returns alert
        runBlocking { api.getRepoAlert(owner, repo, alertNumber) shouldBe alert }
    }
    test("updateRepoAlert returns alert") {
        coEvery { api.updateRepoAlert(owner, repo, alertNumber, updateAlertReq) } returns alert
        runBlocking { api.updateRepoAlert(owner, repo, alertNumber, updateAlertReq) shouldBe alert }
    }
    test("listOrgSecrets returns secrets response") {
        coEvery { api.listOrgSecrets(org, any(), any()) } returns secretsResponse
        runBlocking { api.listOrgSecrets(org) shouldBe secretsResponse }
    }
    test("getOrgPublicKey returns public key") {
        coEvery { api.getOrgPublicKey(org) } returns publicKey
        runBlocking { api.getOrgPublicKey(org) shouldBe publicKey }
    }
    test("getOrgSecret returns secret") {
        coEvery { api.getOrgSecret(org, secretName) } returns secret
        runBlocking { api.getOrgSecret(org, secretName) shouldBe secret }
    }
    test("createOrUpdateOrgSecret returns response") {
        coEvery { api.createOrUpdateOrgSecret(org, secretName, createSecretReq) } returns Response.success(Unit)
        runBlocking { api.createOrUpdateOrgSecret(org, secretName, createSecretReq).isSuccessful shouldBe true }
    }
    test("deleteOrgSecret returns response") {
        coEvery { api.deleteOrgSecret(org, secretName) } returns Response.success(Unit)
        runBlocking { api.deleteOrgSecret(org, secretName).isSuccessful shouldBe true }
    }
    test("listSelectedReposForOrgSecret returns repos response") {
        coEvery { api.listSelectedReposForOrgSecret(org, secretName, any(), any()) } returns reposResponse
        runBlocking { api.listSelectedReposForOrgSecret(org, secretName) shouldBe reposResponse }
    }
    test("setSelectedReposForOrgSecret returns response") {
        coEvery { api.setSelectedReposForOrgSecret(org, secretName, setReposReq) } returns Response.success(Unit)
        runBlocking { api.setSelectedReposForOrgSecret(org, secretName, setReposReq).isSuccessful shouldBe true }
    }
    test("listRepoSecrets returns secrets response") {
        coEvery { api.listRepoSecrets(owner, repo, any(), any()) } returns secretsResponse
        runBlocking { api.listRepoSecrets(owner, repo) shouldBe secretsResponse }
    }
    test("getRepoPublicKey returns public key") {
        coEvery { api.getRepoPublicKey(owner, repo) } returns publicKey
        runBlocking { api.getRepoPublicKey(owner, repo) shouldBe publicKey }
    }
    test("getRepoSecret returns secret") {
        coEvery { api.getRepoSecret(owner, repo, secretName) } returns secret
        runBlocking { api.getRepoSecret(owner, repo, secretName) shouldBe secret }
    }
    test("createOrUpdateRepoSecret returns response") {
        coEvery { api.createOrUpdateRepoSecret(owner, repo, secretName, createSecretReq) } returns Response.success(Unit)
        runBlocking { api.createOrUpdateRepoSecret(owner, repo, secretName, createSecretReq).isSuccessful shouldBe true }
    }
    test("deleteRepoSecret returns response") {
        coEvery { api.deleteRepoSecret(owner, repo, secretName) } returns Response.success(Unit)
        runBlocking { api.deleteRepoSecret(owner, repo, secretName).isSuccessful shouldBe true }
    }
})

