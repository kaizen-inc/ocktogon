package inc.kaizen.client.page.model

import inc.kaizen.client.user.model.User

data class PagesBuild(
    val url: String,
    val status: String,
    val error: PagesBuildError?,
    val pusher: User?,
    val commit: String?,
    val created_at: String?,
    val updated_at: String?
)
