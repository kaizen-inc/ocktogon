package inc.kaizen.client.ocktogon.checks.api

import inc.kaizen.client.ocktogon.checks.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class CheckApiSpec : FunSpec({
    val runApi = mockk<CheckRunApi>()
    val suiteApi = mockk<CheckSuiteApi>()
    val owner = "owner"; val repo = "repo"; val ref = "main"
    val checkRunId = 1L; val checkSuiteId = 1L
    val checkRun = mockk<CheckRun>()
    val checkSuite = mockk<CheckSuite>()
    val annotation = mockk<CheckAnnotation>()
    val runsResponse = CheckRunsResponse(total_count = 1, check_runs = listOf(checkRun))
    val suitesResponse = CheckSuitesResponse(total_count = 1, check_suites = listOf(checkSuite))
    val suitePrefsResponse = mockk<CheckSuitePreferencesResponse>()
    val createRunReq = CreateCheckRunRequest(name = "CI", head_sha = "abc123")
    val updateRunReq = UpdateCheckRunRequest(name = "CI")
    val createSuiteReq = CreateCheckSuiteRequest(head_sha = "abc123")
    val suitePrefsReq = CheckSuitePreferencesRequest()

    test("createCheckRun returns check run") {
        coEvery { runApi.createCheckRun(owner, repo, createRunReq) } returns checkRun
        runBlocking { runApi.createCheckRun(owner, repo, createRunReq) shouldBe checkRun }
    }
    test("getCheckRun returns check run") {
        coEvery { runApi.getCheckRun(owner, repo, checkRunId) } returns checkRun
        runBlocking { runApi.getCheckRun(owner, repo, checkRunId) shouldBe checkRun }
    }
    test("updateCheckRun returns check run") {
        coEvery { runApi.updateCheckRun(owner, repo, checkRunId, updateRunReq) } returns checkRun
        runBlocking { runApi.updateCheckRun(owner, repo, checkRunId, updateRunReq) shouldBe checkRun }
    }
    test("listCheckRunAnnotations returns annotations") {
        coEvery { runApi.listCheckRunAnnotations(owner, repo, checkRunId, any(), any()) } returns listOf(annotation)
        runBlocking { runApi.listCheckRunAnnotations(owner, repo, checkRunId) shouldBe listOf(annotation) }
    }
    test("rerequestCheckRun returns response") {
        coEvery { runApi.rerequestCheckRun(owner, repo, checkRunId) } returns Response.success(Unit)
        runBlocking { runApi.rerequestCheckRun(owner, repo, checkRunId).isSuccessful shouldBe true }
    }
    test("listCheckRunsForRef returns runs response") {
        coEvery { runApi.listCheckRunsForRef(owner, repo, ref, any(), any(), any(), any(), any(), any()) } returns runsResponse
        runBlocking { runApi.listCheckRunsForRef(owner, repo, ref) shouldBe runsResponse }
    }
    test("listCheckRunsInCheckSuite returns runs response") {
        coEvery { runApi.listCheckRunsInCheckSuite(owner, repo, checkSuiteId, any(), any(), any(), any(), any()) } returns runsResponse
        runBlocking { runApi.listCheckRunsInCheckSuite(owner, repo, checkSuiteId) shouldBe runsResponse }
    }
    test("createCheckSuite returns check suite") {
        coEvery { suiteApi.createCheckSuite(owner, repo, createSuiteReq) } returns checkSuite
        runBlocking { suiteApi.createCheckSuite(owner, repo, createSuiteReq) shouldBe checkSuite }
    }
    test("updateCheckSuitePreferences returns preferences response") {
        coEvery { suiteApi.updateCheckSuitePreferences(owner, repo, suitePrefsReq) } returns suitePrefsResponse
        runBlocking { suiteApi.updateCheckSuitePreferences(owner, repo, suitePrefsReq) shouldBe suitePrefsResponse }
    }
    test("getCheckSuite returns check suite") {
        coEvery { suiteApi.getCheckSuite(owner, repo, checkSuiteId) } returns checkSuite
        runBlocking { suiteApi.getCheckSuite(owner, repo, checkSuiteId) shouldBe checkSuite }
    }
    test("rerequestCheckSuite returns response") {
        coEvery { suiteApi.rerequestCheckSuite(owner, repo, checkSuiteId) } returns Response.success(Unit)
        runBlocking { suiteApi.rerequestCheckSuite(owner, repo, checkSuiteId).isSuccessful shouldBe true }
    }
    test("listCheckSuitesForRef returns suites response") {
        coEvery { suiteApi.listCheckSuitesForRef(owner, repo, ref, any(), any(), any(), any()) } returns suitesResponse
        runBlocking { suiteApi.listCheckSuitesForRef(owner, repo, ref) shouldBe suitesResponse }
    }
})

