package inc.kaizen.client.releases.model

import inc.kaizen.client.common.User

data class ReleaseAsset(
    val browser_download_url: String? = null,
    val content_type: String? = null,
    val created_at: String? = null,
    val download_count: Int? = null,
    val id: Int? = null,
    val label: String? = null,
    val name: String? = null,
    val node_id: String? = null,
    val size: Int? = null,
    val state: String? = null,
    val updated_at: String? = null,
    val uploader: User? = null,
    val url: String? = null
)