package inc.kaizen.client.ocktogon.codescanning.model

import inc.kaizen.client.common.Repository
import inc.kaizen.client.common.User

data class CodeScanningAlert(
    val number: Int? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val instances_url: String? = null,
    val state: String? = null,
    val fixed_at: String? = null,
    val dismissed_by: User? = null,
    val dismissed_at: String? = null,
    val dismissed_reason: String? = null,
    val dismissed_comment: String? = null,
    val rule: CodeScanningRule? = null,
    val tool: CodeScanningTool? = null,
    val most_recent_instance: CodeScanningAlertInstance? = null,
    val repository: Repository? = null,
    val auto_dismissed_at: String? = null
)

data class CodeScanningRule(
    val id: String? = null,
    val name: String? = null,
    val severity: String? = null,
    val security_severity_level: String? = null,
    val description: String? = null,
    val full_description: String? = null,
    val tags: List<String>? = null,
    val help: String? = null,
    val help_uri: String? = null
)

data class CodeScanningTool(
    val name: String? = null,
    val version: String? = null,
    val guid: String? = null
)

data class CodeScanningAlertInstance(
    val ref: String? = null,
    val analysis_key: String? = null,
    val environment: String? = null,
    val category: String? = null,
    val state: String? = null,
    val commit_sha: String? = null,
    val message: CodeScanningMessage? = null,
    val location: CodeScanningLocation? = null,
    val html_url: String? = null,
    val classifications: List<String>? = null
)

data class CodeScanningMessage(val text: String? = null)

data class CodeScanningLocation(
    val path: String? = null,
    val start_line: Int? = null,
    val end_line: Int? = null,
    val start_column: Int? = null,
    val end_column: Int? = null
)

data class CodeScanningAnalysis(
    val ref: String? = null,
    val commit_sha: String? = null,
    val analysis_key: String? = null,
    val environment: String? = null,
    val category: String? = null,
    val error: String? = null,
    val created_at: String? = null,
    val results_count: Int? = null,
    val rules_count: Int? = null,
    val id: Long? = null,
    val url: String? = null,
    val sarif_id: String? = null,
    val tool: CodeScanningTool? = null,
    val deletable: Boolean? = null,
    val warning: String? = null
)

data class CodeScanningAnalysisDeletion(
    val next_analysis_url: String? = null,
    val confirm_delete_url: String? = null
)

data class CodeqlDatabase(
    val id: Long? = null,
    val name: String? = null,
    val language: String? = null,
    val uploader: User? = null,
    val content_type: String? = null,
    val size: Long? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val url: String? = null,
    val commit_oid: String? = null
)

data class CodeScanningDefaultSetup(
    val state: String? = null,
    val languages: List<String>? = null,
    val query_suite: String? = null,
    val updated_at: String? = null,
    val schedule: String? = null
)

data class CodeScanningDefaultSetupResponse(
    val run_id: Long? = null,
    val run_url: String? = null
)

data class UpdateCodeScanningAlertRequest(
    val state: String,
    val dismissed_reason: String? = null,
    val dismissed_comment: String? = null
)

data class UpdateCodeScanningDefaultSetupRequest(
    val state: String? = null,
    val query_suite: String? = null,
    val languages: List<String>? = null
)

data class UploadSarifRequest(
    val commit_sha: String,
    val ref: String,
    val sarif: String,
    val checkout_uri: String? = null,
    val started_at: String? = null,
    val tool_name: String? = null,
    val validate: Boolean? = null
)

data class SarifUploadInfo(
    val id: String? = null,
    val url: String? = null,
    val processing_status: String? = null,
    val analyses_url: String? = null,
    val errors: List<String>? = null
)

