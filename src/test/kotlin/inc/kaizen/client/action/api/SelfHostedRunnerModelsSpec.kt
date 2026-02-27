package inc.kaizen.client.action.api

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SelfHostedRunnerModelsSpec : StringSpec({

    "RunnerLabel should instantiate and compare correctly" {
        val label = RunnerLabel(id = 1L, name = "self-hosted", type = "read-only")
        label.id shouldBe 1L
        label.name shouldBe "self-hosted"
        label.type shouldBe "read-only"
    }

    "Runner should instantiate and compare correctly" {
        val label = RunnerLabel(id = 1L, name = "self-hosted", type = "read-only")
        val runner = Runner(
            id = 10L,
            runner_group_id = 1L,
            name = "my-runner",
            os = "linux",
            status = "online",
            busy = false,
            labels = listOf(label),
            ephemeral = false
        )
        runner.id shouldBe 10L
        runner.name shouldBe "my-runner"
        runner.busy shouldBe false
        runner.labels?.size shouldBe 1
    }

    "Runner should instantiate with null fields" {
        val runner = Runner()
        runner.id shouldBe null
        runner.name shouldBe null
    }

    "RunnersResponse should instantiate and compare correctly" {
        val runner = Runner(id = 1L, name = "runner")
        val response = RunnersResponse(total_count = 1, runners = listOf(runner))
        response.total_count shouldBe 1
        response.runners?.size shouldBe 1
    }

    "RunnerApplication should instantiate and compare correctly" {
        val app = RunnerApplication(
            os = "linux",
            architecture = "x64",
            download_url = "https://example.com/runner.tar.gz",
            filename = "runner.tar.gz",
            temp_download_token = "token123",
            sha256_checksum = "abc123"
        )
        app.os shouldBe "linux"
        app.architecture shouldBe "x64"
        app.filename shouldBe "runner.tar.gz"
    }

    "RunnerToken should instantiate and compare correctly" {
        val token = RunnerToken(token = "abc123token", expires_at = "2025-12-31T23:59:59Z")
        token.token shouldBe "abc123token"
        token.expires_at shouldBe "2025-12-31T23:59:59Z"
    }

    "RunnerJitConfig should instantiate and compare correctly" {
        val runner = Runner(id = 1L, name = "runner")
        val config = RunnerJitConfig(runner = runner, encoded_jit_config = "encoded==")
        config.runner shouldBe runner
        config.encoded_jit_config shouldBe "encoded=="
    }

    "RunnerLabelsResponse should instantiate and compare correctly" {
        val label = RunnerLabel(id = 1L, name = "self-hosted")
        val response = RunnerLabelsResponse(total_count = 1, labels = listOf(label))
        response.total_count shouldBe 1
        response.labels?.size shouldBe 1
    }

    "RunnerLabelsRequest should instantiate and compare correctly" {
        val request = RunnerLabelsRequest(labels = listOf("self-hosted", "linux"))
        request.labels shouldBe listOf("self-hosted", "linux")
    }

    "GenerateRunnerConfigRequest should instantiate and compare correctly" {
        val request = GenerateRunnerConfigRequest(
            name = "my-runner",
            runner_group_id = 1,
            labels = listOf("self-hosted"),
            work_folder = "_work"
        )
        request.name shouldBe "my-runner"
        request.runner_group_id shouldBe 1
        request.work_folder shouldBe "_work"
    }

    "GenerateRunnerConfigRequest should instantiate without work_folder" {
        val request = GenerateRunnerConfigRequest(
            name = "runner",
            runner_group_id = 1,
            labels = listOf("self-hosted")
        )
        request.work_folder shouldBe null
    }
})

