package inc.kaizen.client.pull.model.reviewer

data class Team(
    val description: String,
    val html_url: String,
    val id: Int,
    val members_url: String,
    val name: String,
    val node_id: String,
    val notification_setting: String,
    val parent: Any,
    val permission: String,
    val privacy: String,
    val repositories_url: String,
    val slug: String,
    val url: String
)