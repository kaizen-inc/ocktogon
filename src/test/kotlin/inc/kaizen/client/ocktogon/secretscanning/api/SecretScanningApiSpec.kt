package inc.kaizen.client.ocktogon.secretscanning.api

import inc.kaizen.client.ocktogon.secretscanning.model.SecretScanningAlert
import inc.kaizen.client.ocktogon.secretscanning.model.SecretScanningAlertLocation
import inc.kaizen.client.ocktogon.secretscanning.model.UpdateSecretScanningAlertRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class SecretScanningApiSpec : FunSpec({
    val api = mockk<SecretScanningApi>()
    val org = "my-org"; val owner = "owner"; val repo = "repo"; val alertNumber = 1
    val alert = mockk<SecretScanningAlert>()
    val alerts = listOf(alert)
    val location = mockk<SecretScanningAlertLocation>()
    val updateReq = UpdateSecretScanningAlertRequest(state = "resolved", resolution = "revoked")

    test("listOrgAlerts returns alerts") {
        coEvery { api.listOrgAlerts(org, any(), any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns alerts
        runBlocking { api.listOrgAlerts(org) shouldBe alerts }
    }
    test("listAlertsForRepo returns alerts") {
        coEvery { api.listAlertsForRepo(owner, repo, any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns alerts
        runBlocking { api.listAlertsForRepo(owner, repo) shouldBe alerts }
    }
    test("getAlert returns alert") {
        coEvery { api.getAlert(owner, repo, alertNumber) } returns alert
        runBlocking { api.getAlert(owner, repo, alertNumber) shouldBe alert }
    }
    test("updateAlert returns alert") {
        coEvery { api.updateAlert(owner, repo, alertNumber, updateReq) } returns alert
        runBlocking { api.updateAlert(owner, repo, alertNumber, updateReq) shouldBe alert }
    }
    test("listLocationsForAlert returns locations") {
        coEvery { api.listLocationsForAlert(owner, repo, alertNumber, any(), any()) } returns listOf(location)
        runBlocking { api.listLocationsForAlert(owner, repo, alertNumber) shouldBe listOf(location) }
    }
})

