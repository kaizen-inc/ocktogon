package inc.kaizen.client.checks.model

import inc.kaizen.client.common.Actor
import inc.kaizen.client.common.Repository
import inc.kaizen.client.common.User

data class CheckRun(
    val id: Long? = null,
    val head_sha: String? = null,
    val node_id: String? = null,
    val external_id: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val details_url: String? = null,
    val status: String? = null,
    val conclusion: String? = null,
    val started_at: String? = null,
    val completed_at: String? = null,
    val output: CheckOutput? = null,
    val name: String? = null,
    val check_suite: CheckSuiteRef? = null,
    val app: CheckApp? = null,
    val pull_requests: List<CheckRunPullRequest>? = null
)

data class CheckSuite(
    val id: Long? = null,
    val node_id: String? = null,
    val head_branch: String? = null,
    val head_sha: String? = null,
    val status: String? = null,
    val conclusion: String? = null,
    val url: String? = null,
    val before: String? = null,
    val after: String? = null,
    val pull_requests: List<CheckRunPullRequest>? = null,
    val app: CheckApp? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val latest_check_runs_count: Int? = null,
    val check_runs_url: String? = null,
    val head_commit: CheckCommit? = null,
    val repository: Repository? = null,
    val rerequestable: Boolean? = null,
    val runs_rerequestable: Boolean? = null
)

data class CheckOutput(
    val title: String? = null,
    val summary: String? = null,
    val text: String? = null,
    val annotations_count: Int? = null,
    val annotations_url: String? = null
)

data class CheckAnnotation(
    val path: String? = null,
    val start_line: Int? = null,
    val end_line: Int? = null,
    val start_column: Int? = null,
    val end_column: Int? = null,
    val annotation_level: String? = null,
    val title: String? = null,
    val message: String? = null,
    val raw_details: String? = null,
    val blob_href: String? = null
)

data class CheckApp(
    val id: Int? = null,
    val slug: String? = null,
    val node_id: String? = null,
    val owner: User? = null,
    val name: String? = null,
    val description: String? = null,
    val external_url: String? = null,
    val html_url: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val permissions: Map<String, String>? = null,
    val events: List<String>? = null
)

data class CheckCommit(
    val id: String? = null,
    val tree_id: String? = null,
    val message: String? = null,
    val timestamp: String? = null,
    val author: Actor? = null,
    val committer: Actor? = null
)

data class CheckSuiteRef(val id: Long? = null)

data class CheckRunPullRequest(
    val url: String? = null,
    val id: Int? = null,
    val number: Int? = null,
    val head: CheckRunRef? = null,
    val base: CheckRunRef? = null
)

data class CheckRunRef(
    val sha: String? = null,
    val ref: String? = null,
    val repo: CheckRunRepo? = null
)

data class CheckRunRepo(
    val id: Int? = null,
    val url: String? = null,
    val name: String? = null
)

data class CheckRunsResponse(
    val total_count: Int? = null,
    val check_runs: List<CheckRun>? = null
)

data class CheckSuitesResponse(
    val total_count: Int? = null,
    val check_suites: List<CheckSuite>? = null
)

data class CreateCheckRunRequest(
    val name: String,
    val head_sha: String,
    val details_url: String? = null,
    val external_id: String? = null,
    val status: String? = null,
    val started_at: String? = null,
    val conclusion: String? = null,
    val completed_at: String? = null,
    val output: CreateCheckOutputRequest? = null,
    val actions: List<CheckRunAction>? = null
)

data class UpdateCheckRunRequest(
    val name: String? = null,
    val details_url: String? = null,
    val external_id: String? = null,
    val started_at: String? = null,
    val status: String? = null,
    val conclusion: String? = null,
    val completed_at: String? = null,
    val output: CreateCheckOutputRequest? = null,
    val actions: List<CheckRunAction>? = null
)

data class CreateCheckOutputRequest(
    val title: String,
    val summary: String,
    val text: String? = null,
    val annotations: List<CreateAnnotationRequest>? = null,
    val images: List<CheckImage>? = null
)

data class CreateAnnotationRequest(
    val path: String,
    val start_line: Int,
    val end_line: Int,
    val start_column: Int? = null,
    val end_column: Int? = null,
    val annotation_level: String,
    val message: String,
    val title: String? = null,
    val raw_details: String? = null
)

data class CheckImage(
    val alt: String,
    val image_url: String,
    val caption: String? = null
)

data class CheckRunAction(
    val label: String,
    val description: String,
    val identifier: String
)

data class CreateCheckSuiteRequest(val head_sha: String)

data class CheckSuitePreferencesRequest(
    val auto_trigger_checks: List<AutoTriggerCheck>? = null
)

data class AutoTriggerCheck(
    val app_id: Int,
    val setting: Boolean
)

data class CheckSuitePreferencesResponse(
    val preferences: CheckSuitePreferences? = null,
    val repository: Repository? = null
)

data class CheckSuitePreferences(
    val auto_trigger_checks: List<AutoTriggerCheck>? = null
)

