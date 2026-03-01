package inc.kaizen.client.ocktogon.app.model

import inc.kaizen.client.user.model.User

data class App(
    val id: Long,
    val slug: String?,
    val node_id: String?,
    val name: String?,
    val owner: User?,
    val description: String?,
    val external_url: String?,
    val html_url: String?,
    val created_at: String?,
    val updated_at: String?,
    val permissions: Map<String, String>?,
    val events: List<String>?,
    val client_id: String?,
    val client_secret: String?,
    val webhook_secret: String?,
    val pem: String?
)
