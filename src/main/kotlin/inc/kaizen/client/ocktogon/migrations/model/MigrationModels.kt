package inc.kaizen.client.ocktogon.migrations.model

import inc.kaizen.client.ocktogon.common.Repository
import inc.kaizen.client.ocktogon.common.User

data class Migration(
    val id: Long? = null,
    val owner: User? = null,
    val guid: String? = null,
    val state: String? = null,
    val lock_repositories: Boolean? = null,
    val exclude_metadata: Boolean? = null,
    val exclude_git_data: Boolean? = null,
    val exclude_attachments: Boolean? = null,
    val exclude_releases: Boolean? = null,
    val exclude_owner_projects: Boolean? = null,
    val org_metadata_only: Boolean? = null,
    val repositories: List<Repository>? = null,
    val url: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val node_id: String? = null,
    val archive_url: String? = null,
    val exclude: List<String>? = null
)

data class StartMigrationRequest(
    val repositories: List<String>,
    val lock_repositories: Boolean? = null,
    val exclude_metadata: Boolean? = null,
    val exclude_git_data: Boolean? = null,
    val exclude_attachments: Boolean? = null,
    val exclude_releases: Boolean? = null,
    val exclude_owner_projects: Boolean? = null,
    val org_metadata_only: Boolean? = null,
    val exclude: List<String>? = null
)

