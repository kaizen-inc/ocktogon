package inc.kaizen.client.codescanning.api

import inc.kaizen.client.codescanning.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class CodeScanningApiSpec : FunSpec({
    val api = mockk<CodeScanningApi>()
    val org = "my-org"; val owner = "owner"; val repo = "repo"; val alertNumber = 1
    val analysisId = 1L
    val alert = mockk<CodeScanningAlert>()
    val alerts = listOf(alert)
    val instance = mockk<CodeScanningAlertInstance>()
    val analysis = mockk<CodeScanningAnalysis>()
    val analysisDeletion = mockk<CodeScanningAnalysisDeletion>()
    val codeqlDb = mockk<CodeqlDatabase>()
    val defaultSetup = mockk<CodeScanningDefaultSetup>()
    val defaultSetupResponse = mockk<CodeScanningDefaultSetupResponse>()
    val sarifUploadInfo = mockk<SarifUploadInfo>()
    val updateAlertReq = UpdateCodeScanningAlertRequest(state = "dismissed")
    val updateSetupReq = UpdateCodeScanningDefaultSetupRequest(state = "configured")
    val uploadSarifReq = UploadSarifRequest(commit_sha = "abc", ref = "refs/heads/main", sarif = "data")

    test("listOrgAlerts returns alerts") {
        coEvery { api.listOrgAlerts(org, any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns alerts
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
        coEvery { api.updateAlert(owner, repo, alertNumber, updateAlertReq) } returns alert
        runBlocking { api.updateAlert(owner, repo, alertNumber, updateAlertReq) shouldBe alert }
    }
    test("listAlertInstances returns instances") {
        coEvery { api.listAlertInstances(owner, repo, alertNumber, any(), any(), any()) } returns listOf(instance)
        runBlocking { api.listAlertInstances(owner, repo, alertNumber) shouldBe listOf(instance) }
    }
    test("listAnalysesForRepo returns analyses") {
        coEvery { api.listAnalysesForRepo(owner, repo, any(), any(), any(), any(), any(), any(), any(), any()) } returns listOf(analysis)
        runBlocking { api.listAnalysesForRepo(owner, repo) shouldBe listOf(analysis) }
    }
    test("getAnalysis returns analysis") {
        coEvery { api.getAnalysis(owner, repo, analysisId) } returns analysis
        runBlocking { api.getAnalysis(owner, repo, analysisId) shouldBe analysis }
    }
    test("deleteAnalysis returns deletion info") {
        coEvery { api.deleteAnalysis(owner, repo, analysisId, any()) } returns analysisDeletion
        runBlocking { api.deleteAnalysis(owner, repo, analysisId) shouldBe analysisDeletion }
    }
    test("listCodeqlDatabases returns databases") {
        coEvery { api.listCodeqlDatabases(owner, repo) } returns listOf(codeqlDb)
        runBlocking { api.listCodeqlDatabases(owner, repo) shouldBe listOf(codeqlDb) }
    }
    test("getCodeqlDatabase returns database") {
        coEvery { api.getCodeqlDatabase(owner, repo, "java") } returns codeqlDb
        runBlocking { api.getCodeqlDatabase(owner, repo, "java") shouldBe codeqlDb }
    }
    test("getDefaultSetup returns setup") {
        coEvery { api.getDefaultSetup(owner, repo) } returns defaultSetup
        runBlocking { api.getDefaultSetup(owner, repo) shouldBe defaultSetup }
    }
    test("updateDefaultSetup returns response") {
        coEvery { api.updateDefaultSetup(owner, repo, updateSetupReq) } returns defaultSetupResponse
        runBlocking { api.updateDefaultSetup(owner, repo, updateSetupReq) shouldBe defaultSetupResponse }
    }
    test("uploadSarif returns upload info") {
        coEvery { api.uploadSarif(owner, repo, uploadSarifReq) } returns sarifUploadInfo
        runBlocking { api.uploadSarif(owner, repo, uploadSarifReq) shouldBe sarifUploadInfo }
    }
    test("getSarifUploadInfo returns upload info") {
        coEvery { api.getSarifUploadInfo(owner, repo, "sarif-id") } returns sarifUploadInfo
        runBlocking { api.getSarifUploadInfo(owner, repo, "sarif-id") shouldBe sarifUploadInfo }
    }
})


