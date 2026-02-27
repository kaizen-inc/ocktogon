package inc.kaizen.client.checks.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CheckModelsSpec : StringSpec({

    "CheckOutput should instantiate and compare correctly" {
        val output = CheckOutput(title = "Check Output", summary = "3 issues found", annotations_count = 3)
        output.title shouldBe "Check Output"
        output.annotations_count shouldBe 3
    }

    "CheckAnnotation should instantiate and compare correctly" {
        val annotation = CheckAnnotation(path = "src/main.kt", start_line = 1, end_line = 5, annotation_level = "warning", message = "Warning message")
        annotation.path shouldBe "src/main.kt"
        annotation.annotation_level shouldBe "warning"
    }

    "CheckApp should instantiate and compare correctly" {
        val app = CheckApp(id = 1, slug = "my-app", name = "My App", html_url = "url")
        app.id shouldBe 1
        app.name shouldBe "My App"
    }

    "CheckCommit should instantiate and compare correctly" {
        val commit = CheckCommit(id = "abc123", message = "Initial commit", timestamp = "2025-01-01T00:00:00Z")
        commit.id shouldBe "abc123"
        commit.message shouldBe "Initial commit"
    }

    "CheckSuiteRef should instantiate and compare correctly" {
        val ref = CheckSuiteRef(id = 1L)
        ref.id shouldBe 1L
    }

    "CheckRunRepo should instantiate and compare correctly" {
        val repo = CheckRunRepo(id = 1, url = "url", name = "my-repo")
        repo.name shouldBe "my-repo"
    }

    "CheckRunRef should instantiate and compare correctly" {
        val runRef = CheckRunRef(sha = "abc123", ref = "refs/heads/main")
        runRef.sha shouldBe "abc123"
    }

    "CheckRunPullRequest should instantiate and compare correctly" {
        val head = CheckRunRef(sha = "abc", ref = "refs/heads/main")
        val base = CheckRunRef(sha = "def", ref = "refs/heads/base")
        val pr = CheckRunPullRequest(url = "url", id = 1, number = 42, head = head, base = base)
        pr.number shouldBe 42
    }

    "CheckRun should instantiate and compare correctly" {
        val run = CheckRun(id = 1L, head_sha = "abc123", name = "CI", status = "completed", conclusion = "success")
        run.id shouldBe 1L
        run.name shouldBe "CI"
        run.conclusion shouldBe "success"
    }

    "CheckSuite should instantiate and compare correctly" {
        val suite = CheckSuite(id = 1L, head_branch = "main", head_sha = "abc123", status = "completed", conclusion = "success")
        suite.id shouldBe 1L
        suite.head_branch shouldBe "main"
    }

    "CheckRunsResponse should instantiate and compare correctly" {
        val run = CheckRun(id = 1L, name = "CI")
        val response = CheckRunsResponse(total_count = 1, check_runs = listOf(run))
        response.total_count shouldBe 1
        response.check_runs?.size shouldBe 1
    }

    "CheckSuitesResponse should instantiate and compare correctly" {
        val suite = CheckSuite(id = 1L, head_branch = "main")
        val response = CheckSuitesResponse(total_count = 1, check_suites = listOf(suite))
        response.total_count shouldBe 1
    }

    "CreateCheckOutputRequest should instantiate and compare correctly" {
        val req = CreateCheckOutputRequest(title = "Output", summary = "All clear", text = "Details here")
        req.title shouldBe "Output"
        req.summary shouldBe "All clear"
    }

    "CreateAnnotationRequest should instantiate and compare correctly" {
        val req = CreateAnnotationRequest(path = "src/main.kt", start_line = 1, end_line = 1, annotation_level = "warning", message = "msg")
        req.path shouldBe "src/main.kt"
        req.annotation_level shouldBe "warning"
    }

    "CheckImage should instantiate and compare correctly" {
        val img = CheckImage(alt = "Alt text", image_url = "https://example.com/img.png", caption = "Caption")
        img.alt shouldBe "Alt text"
        img.caption shouldBe "Caption"
    }

    "CheckRunAction should instantiate and compare correctly" {
        val action = CheckRunAction(label = "Fix", description = "Fix the issue", identifier = "fix")
        action.label shouldBe "Fix"
        action.identifier shouldBe "fix"
    }

    "CreateCheckRunRequest should instantiate and compare correctly" {
        val req = CreateCheckRunRequest(name = "CI", head_sha = "abc123", status = "in_progress")
        req.name shouldBe "CI"
        req.head_sha shouldBe "abc123"
    }

    "UpdateCheckRunRequest should instantiate and compare correctly" {
        val req = UpdateCheckRunRequest(name = "CI", status = "completed", conclusion = "success")
        req.name shouldBe "CI"
        req.conclusion shouldBe "success"
    }

    "CreateCheckSuiteRequest should instantiate and compare correctly" {
        val req = CreateCheckSuiteRequest(head_sha = "abc123")
        req.head_sha shouldBe "abc123"
    }

    "AutoTriggerCheck should instantiate and compare correctly" {
        val check = AutoTriggerCheck(app_id = 1, setting = true)
        check.app_id shouldBe 1
        check.setting shouldBe true
    }

    "CheckSuitePreferences should instantiate and compare correctly" {
        val pref = CheckSuitePreferences(auto_trigger_checks = listOf(AutoTriggerCheck(1, true)))
        pref.auto_trigger_checks?.size shouldBe 1
    }

    "CheckSuitePreferencesRequest should instantiate and compare correctly" {
        val req = CheckSuitePreferencesRequest(auto_trigger_checks = listOf(AutoTriggerCheck(1, false)))
        req.auto_trigger_checks?.get(0)?.setting shouldBe false
    }

    "CheckSuitePreferencesResponse should instantiate and compare correctly" {
        val pref = CheckSuitePreferences()
        val resp = CheckSuitePreferencesResponse(preferences = pref, repository = null)
        resp.preferences shouldBe pref
    }
})

