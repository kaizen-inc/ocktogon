package inc.kaizen.client.licenses.api

import inc.kaizen.client.common.License
import inc.kaizen.client.licenses.model.LicenseSimple
import inc.kaizen.client.licenses.model.RepoLicenseContent
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class LicenseApiSpec : FunSpec({
    val api = mockk<LicenseApi>()
    val owner = "owner"; val repo = "repo"
    val licenseSimple = LicenseSimple(key = "mit", name = "MIT License")
    val license = License(key = "mit", name = "MIT License")
    val content = RepoLicenseContent(name = "LICENSE", path = "LICENSE", sha = "abc")

    test("getAllCommonlyUsedLicenses returns list") {
        coEvery { api.getAllCommonlyUsedLicenses(any(), any(), any()) } returns listOf(licenseSimple)
        runBlocking { api.getAllCommonlyUsedLicenses() shouldBe listOf(licenseSimple) }
    }
    test("getLicense returns license") {
        coEvery { api.getLicense("mit") } returns license
        runBlocking { api.getLicense("mit") shouldBe license }
    }
    test("getRepoLicense returns content") {
        coEvery { api.getRepoLicense(owner, repo, any()) } returns content
        runBlocking { api.getRepoLicense(owner, repo) shouldBe content }
    }
})

