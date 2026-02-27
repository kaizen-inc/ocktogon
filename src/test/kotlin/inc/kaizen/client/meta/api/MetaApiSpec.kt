package inc.kaizen.client.meta.api

import inc.kaizen.client.meta.model.GitHubMeta
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class MetaApiSpec : FunSpec({
    val api = mockk<MetaApi>()
    val meta = GitHubMeta(verifiable_password_authentication = true)

    test("getApiMeta returns meta") {
        coEvery { api.getApiMeta() } returns meta
        runBlocking { api.getApiMeta() shouldBe meta }
    }
    test("getOctocat returns string") {
        coEvery { api.getOctocat(any()) } returns "MONA"
        runBlocking { api.getOctocat() shouldBe "MONA" }
    }
    test("getZen returns string") {
        coEvery { api.getZen() } returns "Keep it logically awesome."
        runBlocking { api.getZen() shouldBe "Keep it logically awesome." }
    }
    test("getAllApiVersions returns list") {
        coEvery { api.getAllApiVersions() } returns listOf("2022-11-28")
        runBlocking { api.getAllApiVersions() shouldBe listOf("2022-11-28") }
    }
    test("getRoot returns map") {
        val root = mapOf("current_user_url" to "https://api.github.com/user")
        coEvery { api.getRoot() } returns root
        runBlocking { api.getRoot() shouldBe root }
    }
})

