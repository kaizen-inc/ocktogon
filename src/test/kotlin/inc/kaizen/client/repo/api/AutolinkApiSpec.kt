package inc.kaizen.client.repo.api

import inc.kaizen.client.repo.model.Autolink
import inc.kaizen.client.repo.model.CreateAutolinkRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class AutolinkApiSpec : FunSpec({
    val api = mockk<AutolinkApi>()
    val owner = "owner"; val repo = "repo"; val autolinkId = 1
    val autolink = mockk<Autolink>()
    val autolinks = listOf(autolink)
    val createReq = CreateAutolinkRequest(key_prefix = "JIRA-", url_template = "https://jira.example.com/issues/<num>")

    test("listAutolinks returns autolinks") {
        coEvery { api.listAutolinks(owner, repo, any()) } returns autolinks
        runBlocking { api.listAutolinks(owner, repo) } shouldBe autolinks
    }
    test("createAutolink returns autolink") {
        coEvery { api.createAutolink(owner, repo, createReq) } returns autolink
        runBlocking { api.createAutolink(owner, repo, createReq) } shouldBe autolink
    }
    test("getAutolink returns autolink") {
        coEvery { api.getAutolink(owner, repo, autolinkId) } returns autolink
        runBlocking { api.getAutolink(owner, repo, autolinkId) } shouldBe autolink
    }
    test("deleteAutolink returns response") {
        coEvery { api.deleteAutolink(owner, repo, autolinkId) } returns Response.success(Unit)
        runBlocking { api.deleteAutolink(owner, repo, autolinkId).isSuccessful } shouldBe true
    }
})

