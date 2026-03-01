package inc.kaizen.client.ocktogon.action.model.workflow

import inc.kaizen.client.common.Repository
import inc.kaizen.client.common.User

data class Workflow(
    val id: Long? = null,
    val node_id: String? = null,
    val name: String? = null,
    val path: String? = null,
    val state: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val badge_url: String? = null
)

data class WorkflowsResponse(
    val total_count: Int? = null,
    val workflows: List<Workflow>? = null
)

data class WorkflowRun(
    val id: Long? = null,
    val name: String? = null,
    val node_id: String? = null,
    val check_suite_id: Long? = null,
    val check_suite_node_id: String? = null,
    val head_branch: String? = null,
    val head_sha: String? = null,
    val path: String? = null,
    val run_number: Int? = null,
    val run_attempt: Int? = null,
    val event: String? = null,
    val display_title: String? = null,
    val status: String? = null,
    val conclusion: String? = null,
    val workflow_id: Long? = null,
    val url: String? = null,
    val html_url: String? = null,
    val pull_requests: List<Any>? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val actor: User? = null,
    val triggering_actor: User? = null,
    val run_started_at: String? = null,
    val jobs_url: String? = null,
    val logs_url: String? = null,
    val check_suite_url: String? = null,
    val artifacts_url: String? = null,
    val cancel_url: String? = null,
    val rerun_url: String? = null,
    val workflow_url: String? = null,
    val repository: Repository? = null,
    val head_repository: Repository? = null
)

data class WorkflowRunsResponse(
    val total_count: Int? = null,
    val workflow_runs: List<WorkflowRun>? = null
)

data class WorkflowJob(
    val id: Long? = null,
    val run_id: Long? = null,
    val workflow_name: String? = null,
    val head_branch: String? = null,
    val run_url: String? = null,
    val run_attempt: Int? = null,
    val node_id: String? = null,
    val head_sha: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val status: String? = null,
    val conclusion: String? = null,
    val created_at: String? = null,
    val started_at: String? = null,
    val completed_at: String? = null,
    val name: String? = null,
    val steps: List<WorkflowStep>? = null,
    val check_run_url: String? = null,
    val labels: List<String>? = null,
    val runner_id: Long? = null,
    val runner_name: String? = null,
    val runner_group_id: Long? = null,
    val runner_group_name: String? = null
)

data class WorkflowStep(
    val name: String? = null,
    val status: String? = null,
    val conclusion: String? = null,
    val number: Int? = null,
    val started_at: String? = null,
    val completed_at: String? = null
)

data class JobsResponse(
    val total_count: Int? = null,
    val jobs: List<WorkflowJob>? = null
)

data class WorkflowRunUsage(
    val billable: Map<String, Any>? = null,
    val run_duration_ms: Long? = null
)

data class WorkflowUsage(val billable: Map<String, Any>? = null)

data class WorkflowDispatchRequest(
    val ref: String,
    val inputs: Map<String, Any>? = null
)

