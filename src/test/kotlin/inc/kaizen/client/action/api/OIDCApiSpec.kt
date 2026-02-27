package inc.kaizen.client.action.api

import inc.kaizen.client.action.model.oidc.OIDCTemplate
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class OIDCApiSpec : FunSpec({
    val api = mockk<OIDCApi>()
    val org = "my-org"
    val owner = "owner"
    val repo = "repo"
    val template = mockk<OIDCTemplate>()

    test("getOrgOIDCCustomTemplate returns template") {
        coEvery { api.getOrgOIDCCustomTemplate(org) } returns template
        runBlocking {
            api.getOrgOIDCCustomTemplate(org) shouldBe template
        }
    }

    test("setOrgOIDCCustomTemplate returns unit response") {
        coEvery { api.setOrgOIDCCustomTemplate(org, template) } returns Response.success(Unit)
        runBlocking {
            api.setOrgOIDCCustomTemplate(org, template).isSuccessful shouldBe true
        }
    }

    test("getRepoOIDCCustomTemplate returns template") {
        coEvery { api.getRepoOIDCCustomTemplate(owner, repo) } returns template
        runBlocking {
            api.getRepoOIDCCustomTemplate(owner, repo) shouldBe template
        }
    }

    test("setRepoOIDCCustomTemplate returns unit response") {
        coEvery { api.setRepoOIDCCustomTemplate(owner, repo, template) } returns Response.success(Unit)
        runBlocking {
            api.setRepoOIDCCustomTemplate(owner, repo, template).isSuccessful shouldBe true
        }
    }
})

