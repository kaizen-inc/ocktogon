package inc.kaizen.client.app.model

import inc.kaizen.client.user.model.User

data class Installation(
    val id: Long,
    val account: User?,
    val app_id: Long?,
    val app_slug: String?,
    val target_id: Long?,
    val target_type: String?,
    val permissions: Map<String, String>?,
    val events: List<String>?,
    val created_at: String?,
    val updated_at: String?,
    val single_file_name: String?,
    val repository_selection: String?,
    val access_tokens_url: String?,
    val repositories_url: String?,
    val html_url: String?,
    val has_multiple_single_files: Boolean?,
    val single_file_paths: List<String>?,
)

data class Installations(
    val total_count: Int,
    val installations: List<Installation>
)

data class InstallationRequest(
    val id: Long,
    val node_id: String?,
    val account: User?,
    val requester: User?,
    val created_at: String?,
)
