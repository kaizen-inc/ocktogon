package inc.kaizen.client.codescanning.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CodeScanningModelsSpec : StringSpec({

    "CodeScanningRule should instantiate and compare correctly" {
        val rule = CodeScanningRule(id = "rule-1", name = "SQL Injection", severity = "high")
        rule.id shouldBe "rule-1"
        rule.severity shouldBe "high"
    }

    "CodeScanningTool should instantiate and compare correctly" {
        val tool = CodeScanningTool(name = "CodeQL", version = "2.x", guid = null)
        tool.name shouldBe "CodeQL"
    }

    "CodeScanningMessage should instantiate and compare correctly" {
        val msg = CodeScanningMessage(text = "Potential SQL injection")
        msg.text shouldBe "Potential SQL injection"
    }

    "CodeScanningLocation should instantiate and compare correctly" {
        val loc = CodeScanningLocation(path = "src/main.kt", start_line = 10, end_line = 15, start_column = 5, end_column = 20)
        loc.path shouldBe "src/main.kt"
        loc.start_line shouldBe 10
    }

    "CodeScanningAlertInstance should instantiate and compare correctly" {
        val instance = CodeScanningAlertInstance(ref = "refs/heads/main", state = "open", commit_sha = "abc123")
        instance.ref shouldBe "refs/heads/main"
        instance.state shouldBe "open"
    }

    "CodeScanningAlert should instantiate and compare correctly" {
        val alert = CodeScanningAlert(number = 1, state = "open", url = "url", html_url = "html_url")
        alert.number shouldBe 1
        alert.state shouldBe "open"
    }

    "CodeScanningAnalysis should instantiate and compare correctly" {
        val analysis = CodeScanningAnalysis(id = 1L, ref = "refs/heads/main", commit_sha = "abc123", results_count = 5)
        analysis.id shouldBe 1L
        analysis.results_count shouldBe 5
    }

    "CodeScanningAnalysisDeletion should instantiate and compare correctly" {
        val deletion = CodeScanningAnalysisDeletion(next_analysis_url = "url", confirm_delete_url = "delete_url")
        deletion.next_analysis_url shouldBe "url"
    }

    "CodeqlDatabase should instantiate and compare correctly" {
        val db = CodeqlDatabase(id = 1L, name = "java-db", language = "java", size = 1024L)
        db.id shouldBe 1L
        db.language shouldBe "java"
    }

    "CodeScanningDefaultSetup should instantiate and compare correctly" {
        val setup = CodeScanningDefaultSetup(state = "configured", languages = listOf("java", "kotlin"), query_suite = "default")
        setup.state shouldBe "configured"
        setup.languages shouldBe listOf("java", "kotlin")
    }

    "CodeScanningDefaultSetupResponse should instantiate and compare correctly" {
        val resp = CodeScanningDefaultSetupResponse(run_id = 1L, run_url = "url")
        resp.run_id shouldBe 1L
    }

    "UpdateCodeScanningAlertRequest should instantiate and compare correctly" {
        val req = UpdateCodeScanningAlertRequest(state = "dismissed", dismissed_reason = "false positive")
        req.state shouldBe "dismissed"
        req.dismissed_reason shouldBe "false positive"
    }

    "UpdateCodeScanningDefaultSetupRequest should instantiate and compare correctly" {
        val req = UpdateCodeScanningDefaultSetupRequest(state = "configured", query_suite = "extended", languages = listOf("java"))
        req.state shouldBe "configured"
        req.languages shouldBe listOf("java")
    }

    "UploadSarifRequest should instantiate and compare correctly" {
        val req = UploadSarifRequest(commit_sha = "abc123", ref = "refs/heads/main", sarif = "base64sarif")
        req.commit_sha shouldBe "abc123"
        req.sarif shouldBe "base64sarif"
    }

    "SarifUploadInfo should instantiate and compare correctly" {
        val info = SarifUploadInfo(id = "upload-id", url = "url", processing_status = "complete")
        info.id shouldBe "upload-id"
        info.processing_status shouldBe "complete"
    }
})

