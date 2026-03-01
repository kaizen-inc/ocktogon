package inc.kaizen.client.ocktogon.action.model.workflow

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WorkflowModelsSpec : StringSpec({

    "Workflow should instantiate with all fields" {
        val workflow = Workflow(
            id = 1L,
            node_id = "node123",
            name = "CI",
            path = ".github/workflows/ci.yml",
            state = "active",
            created_at = "2025-01-01T00:00:00Z",
            updated_at = "2025-06-01T00:00:00Z",
            url = "https://api.github.com/repos/owner/repo/actions/workflows/1",
            html_url = "https://github.com/owner/repo/actions/workflows/ci.yml",
            badge_url = "https://github.com/owner/repo/workflows/CI/badge.svg"
        )
        workflow.id shouldBe 1L
        workflow.name shouldBe "CI"
        workflow.state shouldBe "active"
    }

    "Workflow should instantiate with all null defaults" {
        val workflow = Workflow()
        workflow.id shouldBe null
        workflow.name shouldBe null
    }

    "WorkflowsResponse should instantiate and compare correctly" {
        val workflow = Workflow(id = 1L, name = "CI")
        val response = WorkflowsResponse(total_count = 1, workflows = listOf(workflow))
        response.total_count shouldBe 1
        response.workflows?.size shouldBe 1
        response.workflows?.get(0) shouldBe workflow
    }

    "WorkflowRun should instantiate with fields" {
        val run = WorkflowRun(
            id = 100L,
            name = "CI",
            status = "completed",
            conclusion = "success",
            run_number = 5
        )
        run.id shouldBe 100L
        run.status shouldBe "completed"
        run.conclusion shouldBe "success"
    }

    "WorkflowRunsResponse should instantiate and compare correctly" {
        val run = WorkflowRun(id = 1L, name = "CI")
        val response = WorkflowRunsResponse(total_count = 1, workflow_runs = listOf(run))
        response.total_count shouldBe 1
        response.workflow_runs?.size shouldBe 1
    }

    "WorkflowStep should instantiate and compare correctly" {
        val step = WorkflowStep(
            name = "Checkout",
            status = "completed",
            conclusion = "success",
            number = 1,
            started_at = "2025-01-01T00:00:00Z",
            completed_at = "2025-01-01T00:01:00Z"
        )
        step.name shouldBe "Checkout"
        step.status shouldBe "completed"
        step.number shouldBe 1
    }

    "WorkflowJob should instantiate and compare correctly" {
        val job = WorkflowJob(
            id = 1L,
            run_id = 100L,
            name = "build",
            status = "completed",
            conclusion = "success",
            steps = listOf()
        )
        job.id shouldBe 1L
        job.name shouldBe "build"
        job.steps?.size shouldBe 0
    }

    "JobsResponse should instantiate and compare correctly" {
        val job = WorkflowJob(id = 1L, name = "build", status = "completed")
        val response = JobsResponse(total_count = 1, jobs = listOf(job))
        response.total_count shouldBe 1
        response.jobs?.size shouldBe 1
        response.jobs?.get(0)?.name shouldBe "build"
    }

    "WorkflowRunUsage should instantiate and compare correctly" {
        val usage = WorkflowRunUsage(billable = mapOf("UBUNTU" to "1000"), run_duration_ms = 5000L)
        usage.run_duration_ms shouldBe 5000L
        usage.billable?.get("UBUNTU") shouldBe "1000"
    }

    "WorkflowUsage should instantiate and compare correctly" {
        val usage = WorkflowUsage(billable = mapOf("UBUNTU" to "2000"))
        usage.billable?.get("UBUNTU") shouldBe "2000"
    }

    "WorkflowDispatchRequest should instantiate and compare correctly" {
        val req = WorkflowDispatchRequest(ref = "main", inputs = mapOf("env" to "prod"))
        req.ref shouldBe "main"
        req.inputs?.get("env") shouldBe "prod"
    }
})
