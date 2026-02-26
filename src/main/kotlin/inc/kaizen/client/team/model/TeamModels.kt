package inc.kaizen.client.team.model

data class CreateTeamBody(
    val name: String,
    val description: String? = null,
    val maintainers: List<String>? = null,
    val repo_names: List<String>? = null,
    val privacy: String? = null,
    val notification_setting: String? = null,
    val permission: String? = null,
    val parent_team_id: Int? = null
)

