package inc.kaizen.client.ocktogon.action.api

import inc.kaizen.client.action.model.secret.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class SecretApiSpec : FunSpec({
    val api = mockk<SecretApi>()
    val org = "my-org"
    val secretName = "MY_SECRET"
    val repositoryId = "42"
    val secrets = mockk<Secrets>()
    val secret = mockk<Secret>()
    val orgSecret = mockk<OrgSecret>()
    val key = mockk<Key>()
    val repositories = mockk<Repositories>()

    test("getOrgSecrets returns secrets") {
        coEvery { api.getOrgSecrets(org, any(), any()) } returns secrets
        runBlocking {
            api.getOrgSecrets(org) shouldBe secrets
        }
    }

    test("getOrgSecret returns secret") {
        coEvery { api.getOrgSecret(org, secretName) } returns secret
        runBlocking {
            api.getOrgSecret(org, secretName) shouldBe secret
        }
    }

    test("deleteOrgSecret returns unit response") {
        coEvery { api.deleteOrgSecret(org, secretName) } returns Response.success(Unit)
        runBlocking {
            api.deleteOrgSecret(org, secretName).isSuccessful shouldBe true
        }
    }

    test("createOrUpdateOrgSecret returns unit response") {
        coEvery { api.createOrUpdateOrgSecret(org, secretName, orgSecret) } returns Response.success(Unit)
        runBlocking {
            api.createOrUpdateOrgSecret(org, secretName, orgSecret).isSuccessful shouldBe true
        }
    }

    test("getOrgPublicKeys returns key") {
        coEvery { api.getOrgPublicKeys(org, any(), any()) } returns key
        runBlocking {
            api.getOrgPublicKeys(org) shouldBe key
        }
    }

    test("getOrgReposOfSecret returns repositories") {
        coEvery { api.getOrgReposOfSecret(org, secretName, any(), any()) } returns repositories
        runBlocking {
            api.getOrgReposOfSecret(org, secretName) shouldBe repositories
        }
    }

    test("setOrgReposOfSecret returns unit response") {
        coEvery { api.setOrgReposOfSecret(org, secretName, any()) } returns Response.success(Unit)
        runBlocking {
            api.setOrgReposOfSecret(org, secretName, listOf(1, 2)).isSuccessful shouldBe true
        }
    }

    test("addRepoToOrgSecret returns unit response") {
        coEvery { api.addRepoToOrgSecret(org, secretName, repositoryId) } returns Response.success(Unit)
        runBlocking {
            api.addRepoToOrgSecret(org, secretName, repositoryId).isSuccessful shouldBe true
        }
    }

    test("removeRepoFromOrgSecret returns unit response") {
        coEvery { api.removeRepoFromOrgSecret(org, secretName, repositoryId) } returns Response.success(Unit)
        runBlocking {
            api.removeRepoFromOrgSecret(org, secretName, repositoryId).isSuccessful shouldBe true
        }
    }
})

