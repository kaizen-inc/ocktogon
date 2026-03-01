package inc.kaizen.client.ocktogon.pull.model.pull

data class RequestedTeam(
    val description: String,
    val html_url: String,
    val id: Int,
    val members_url: String,
    val name: String,
    val node_id: String,
    val notification_setting: String,
    val permission: String,
    val privacy: String,
    val repositories_url: String,
    val slug: String,
    val url: String
)