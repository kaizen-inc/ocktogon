package inc.kaizen.client.ocktogon.app.api

import inc.kaizen.client.app.model.App
import inc.kaizen.client.app.model.Installation
import inc.kaizen.client.app.model.InstallationRequest
import inc.kaizen.client.app.model.Installations
import inc.kaizen.client.app.model.installation.InstallationAccessTokenRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class AppApiSpec : FunSpec({
    val api = mockk<AppApi>()
    val app = mockk<App>()
    val installationId = 1L
    val installation = mockk<Installation>()
    val installations = Installations(total_count = 0, installations = listOf())
    val installReq = mockk<InstallationRequest>()
    val installReqs = listOf(installReq)
    val accessTokenReq = mockk<InstallationAccessTokenRequest>()

    test("getAuthenticatedApp returns app") {
        coEvery { api.getAuthenticatedApp() } returns app
        runBlocking { api.getAuthenticatedApp() shouldBe app }
    }
    test("appManifestsConversions returns app") {
        coEvery { api.appManifestsConversions(1L) } returns app
        runBlocking { api.appManifestsConversions(1L) shouldBe app }
    }
    test("getAppBySlug returns app") {
        coEvery { api.getAppBySlug("my-app") } returns app
        runBlocking { api.getAppBySlug("my-app") shouldBe app }
    }
    test("listInstallationRequests returns requests") {
        coEvery { api.listInstallationRequests(any(), any()) } returns installReqs
        runBlocking { api.listInstallationRequests() shouldBe installReqs }
    }
    test("listInstallations returns installations") {
        coEvery { api.listInstallations(any(), any()) } returns installations
        runBlocking { api.listInstallations() shouldBe installations }
    }
    test("getInstallation returns installation") {
        coEvery { api.getInstallation(installationId) } returns Response.success(installation)
        runBlocking { api.getInstallation(installationId).body() shouldBe installation }
    }
    test("deleteAppInstallation returns response") {
        coEvery { api.deleteAppInstallation(installationId) } returns Response.success(Unit)
        runBlocking { api.deleteAppInstallation(installationId).isSuccessful shouldBe true }
    }
    test("getAccessToken returns response") {
        coEvery { api.getAccessToken(installationId, any()) } returns Response.success(Unit)
        runBlocking { api.getAccessToken(installationId).isSuccessful shouldBe true }
    }
    test("suspendInstallation returns response") {
        coEvery { api.suspendInstallation(installationId) } returns Response.success(Unit)
        runBlocking { api.suspendInstallation(installationId).isSuccessful shouldBe true }
    }
    test("unsuspendInstallation returns response") {
        coEvery { api.unsuspendInstallation(installationId) } returns Response.success(Unit)
        runBlocking { api.unsuspendInstallation(installationId).isSuccessful shouldBe true }
    }
    test("deleteUserInstallation returns response") {
        coEvery { api.deleteUserInstallation(installationId) } returns Response.success(Unit)
        runBlocking { api.deleteUserInstallation(installationId).isSuccessful shouldBe true }
    }
    test("listInstallationRepositories returns installations") {
        coEvery { api.listInstallationRepositories(installationId, any(), any()) } returns installations
        runBlocking { api.listInstallationRepositories(installationId) shouldBe installations }
    }
})

