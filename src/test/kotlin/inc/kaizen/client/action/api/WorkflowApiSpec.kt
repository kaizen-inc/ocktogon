package inc.kaizen.client.action.api

import inc.kaizen.client.action.model.workflow.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class WorkflowApiSpec : FunSpec({
    val api = mockk<WorkflowApi>()
    val owner = "owner"
    val repo = "repo"
    val workflowId = "ci.yml"
    val runId = 100L
    val jobId = 200L
    val attemptNumber = 1
    val workflow = mockk<Workflow>()
    val workflowsResponse = mockk<WorkflowsResponse>()
    val workflowRun = mockk<WorkflowRun>()
    val workflowRunsResponse = mockk<WorkflowRunsResponse>()
    val jobsResponse = mockk<JobsResponse>()
    val workflowJob = mockk<WorkflowJob>()
    val workflowRunUsage = mockk<WorkflowRunUsage>()
    val workflowUsage = mockk<WorkflowUsage>()
    val workflowDispatchRequest = mockk<WorkflowDispatchRequest>()

    test("listWorkflows returns workflows response") {
        coEvery { api.listWorkflows(owner, repo, any(), any()) } returns workflowsResponse
        runBlocking {
            api.listWorkflows(owner, repo) shouldBe workflowsResponse
        }
    }

    test("getWorkflow returns workflow") {
        coEvery { api.getWorkflow(owner, repo, workflowId) } returns workflow
        runBlocking {
            api.getWorkflow(owner, repo, workflowId) shouldBe workflow
        }
    }

    test("disableWorkflow returns unit response") {
        coEvery { api.disableWorkflow(owner, repo, workflowId) } returns Response.success(Unit)
        runBlocking {
            api.disableWorkflow(owner, repo, workflowId).isSuccessful shouldBe true
        }
    }

    test("createWorkflowDispatch returns unit response") {
        coEvery { api.createWorkflowDispatch(owner, repo, workflowId, workflowDispatchRequest) } returns Response.success(Unit)
        runBlocking {
            api.createWorkflowDispatch(owner, repo, workflowId, workflowDispatchRequest).isSuccessful shouldBe true
        }
    }

    test("enableWorkflow returns unit response") {
        coEvery { api.enableWorkflow(owner, repo, workflowId) } returns Response.success(Unit)
        runBlocking {
            api.enableWorkflow(owner, repo, workflowId).isSuccessful shouldBe true
        }
    }

    test("listWorkflowRuns returns workflow runs response") {
        coEvery { api.listWorkflowRuns(owner, repo, workflowId, any(), any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns workflowRunsResponse
        runBlocking {
            api.listWorkflowRuns(owner, repo, workflowId) shouldBe workflowRunsResponse
        }
    }

    test("listWorkflowRunsForRepo returns workflow runs response") {
        coEvery { api.listWorkflowRunsForRepo(owner, repo, any(), any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns workflowRunsResponse
        runBlocking {
            api.listWorkflowRunsForRepo(owner, repo) shouldBe workflowRunsResponse
        }
    }

    test("getWorkflowRun returns workflow run") {
        coEvery { api.getWorkflowRun(owner, repo, runId, any()) } returns workflowRun
        runBlocking {
            api.getWorkflowRun(owner, repo, runId) shouldBe workflowRun
        }
    }

    test("deleteWorkflowRun returns unit response") {
        coEvery { api.deleteWorkflowRun(owner, repo, runId) } returns Response.success(Unit)
        runBlocking {
            api.deleteWorkflowRun(owner, repo, runId).isSuccessful shouldBe true
        }
    }

    test("getReviewsForRun returns list") {
        coEvery { api.getReviewsForRun(owner, repo, runId) } returns listOf()
        runBlocking {
            api.getReviewsForRun(owner, repo, runId).size shouldBe 0
        }
    }

    test("approveWorkflowRun returns response") {
        coEvery { api.approveWorkflowRun(owner, repo, runId) } returns Response.success(Unit)
        runBlocking {
            api.approveWorkflowRun(owner, repo, runId).isSuccessful shouldBe true
        }
    }

    test("getWorkflowRunAttempt returns workflow run") {
        coEvery { api.getWorkflowRunAttempt(owner, repo, runId, attemptNumber, any()) } returns workflowRun
        runBlocking {
            api.getWorkflowRunAttempt(owner, repo, runId, attemptNumber) shouldBe workflowRun
        }
    }

    test("downloadWorkflowRunAttemptLogs returns unit response") {
        coEvery { api.downloadWorkflowRunAttemptLogs(owner, repo, runId, attemptNumber) } returns Response.success(Unit)
        runBlocking {
            api.downloadWorkflowRunAttemptLogs(owner, repo, runId, attemptNumber).isSuccessful shouldBe true
        }
    }

    test("cancelWorkflowRun returns response") {
        coEvery { api.cancelWorkflowRun(owner, repo, runId) } returns Response.success(Unit)
        runBlocking {
            api.cancelWorkflowRun(owner, repo, runId).isSuccessful shouldBe true
        }
    }

    test("forceCancelWorkflowRun returns response") {
        coEvery { api.forceCancelWorkflowRun(owner, repo, runId) } returns Response.success(Unit)
        runBlocking {
            api.forceCancelWorkflowRun(owner, repo, runId).isSuccessful shouldBe true
        }
    }

    test("listJobsForWorkflowRun returns jobs response") {
        coEvery { api.listJobsForWorkflowRun(owner, repo, runId, any(), any(), any()) } returns jobsResponse
        runBlocking {
            api.listJobsForWorkflowRun(owner, repo, runId) shouldBe jobsResponse
        }
    }

    test("deleteWorkflowRunLogs returns unit response") {
        coEvery { api.deleteWorkflowRunLogs(owner, repo, runId) } returns Response.success(Unit)
        runBlocking {
            api.deleteWorkflowRunLogs(owner, repo, runId).isSuccessful shouldBe true
        }
    }

    test("downloadWorkflowRunLogs returns unit response") {
        coEvery { api.downloadWorkflowRunLogs(owner, repo, runId) } returns Response.success(Unit)
        runBlocking {
            api.downloadWorkflowRunLogs(owner, repo, runId).isSuccessful shouldBe true
        }
    }

    test("reviewCustomDeploymentProtectionRules returns list") {
        coEvery { api.reviewCustomDeploymentProtectionRules(owner, repo, runId, any()) } returns listOf()
        runBlocking {
            api.reviewCustomDeploymentProtectionRules(owner, repo, runId, mapOf<String, Any>()).size shouldBe 0
        }
    }

    test("reRunWorkflow returns response") {
        coEvery { api.reRunWorkflow(owner, repo, runId, any()) } returns Response.success(Unit)
        runBlocking {
            api.reRunWorkflow(owner, repo, runId).isSuccessful shouldBe true
        }
    }

    test("reRunFailedJobs returns response") {
        coEvery { api.reRunFailedJobs(owner, repo, runId, any()) } returns Response.success(Unit)
        runBlocking {
            api.reRunFailedJobs(owner, repo, runId).isSuccessful shouldBe true
        }
    }

    test("getWorkflowRunUsage returns workflow run usage") {
        coEvery { api.getWorkflowRunUsage(owner, repo, runId) } returns workflowRunUsage
        runBlocking {
            api.getWorkflowRunUsage(owner, repo, runId) shouldBe workflowRunUsage
        }
    }

    test("getJobForWorkflowRun returns workflow job") {
        coEvery { api.getJobForWorkflowRun(owner, repo, jobId) } returns workflowJob
        runBlocking {
            api.getJobForWorkflowRun(owner, repo, jobId) shouldBe workflowJob
        }
    }

    test("downloadJobLogsForWorkflowRun returns unit response") {
        coEvery { api.downloadJobLogsForWorkflowRun(owner, repo, jobId) } returns Response.success(Unit)
        runBlocking {
            api.downloadJobLogsForWorkflowRun(owner, repo, jobId).isSuccessful shouldBe true
        }
    }

    test("reRunJobForWorkflowRun returns response") {
        coEvery { api.reRunJobForWorkflowRun(owner, repo, jobId, any()) } returns Response.success(Unit)
        runBlocking {
            api.reRunJobForWorkflowRun(owner, repo, jobId).isSuccessful shouldBe true
        }
    }

    test("getWorkflowUsage returns workflow usage") {
        coEvery { api.getWorkflowUsage(owner, repo, workflowId) } returns workflowUsage
        runBlocking {
            api.getWorkflowUsage(owner, repo, workflowId) shouldBe workflowUsage
        }
    }
})

