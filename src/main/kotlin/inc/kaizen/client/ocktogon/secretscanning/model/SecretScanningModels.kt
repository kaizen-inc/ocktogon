package inc.kaizen.client.ocktogon.secretscanning.model

import inc.kaizen.client.ocktogon.common.Repository
import inc.kaizen.client.ocktogon.common.User

data class SecretScanningAlert(
    val number: Int? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val locations_url: String? = null,
    val state: String? = null,
    val resolution: String? = null,
    val resolved_at: String? = null,
    val resolved_by: User? = null,
    val resolution_comment: String? = null,
    val secret_type: String? = null,
    val secret_type_display_name: String? = null,
    val secret: String? = null,
    val repository: Repository? = null,
    val push_protection_bypassed: Boolean? = null,
    val push_protection_bypassed_by: User? = null,
    val push_protection_bypassed_at: String? = null,
    val validity: String? = null
)

data class SecretScanningAlertLocation(
    val type: String? = null,
    val details: SecretScanningLocationDetails? = null
)

data class SecretScanningLocationDetails(
    val path: String? = null,
    val start_line: Int? = null,
    val end_line: Int? = null,
    val start_column: Int? = null,
    val end_column: Int? = null,
    val blob_sha: String? = null,
    val blob_url: String? = null,
    val commit_sha: String? = null,
    val commit_url: String? = null
)

data class UpdateSecretScanningAlertRequest(
    val state: String,
    val resolution: String? = null,
    val resolution_comment: String? = null
)

