package inc.kaizen.client.releases.model

import inc.kaizen.client.user.model.User

data class ReleaseAsset(
    val browser_download_url: String,
    val content_type: String,
    val created_at: String,
    val download_count: Int,
    val id: Int,
    val label: String,
    val name: String,
    val node_id: String,
    val size: Int,
    val state: String,
    val updated_at: String,
    val uploader: User,
    val url: String
)