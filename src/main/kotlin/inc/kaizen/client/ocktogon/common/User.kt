package inc.kaizen.client.ocktogon.common

data class User(
    val id: Int? = null,
    val login: String? = null,
    val node_id: String? = null,
    val avatar_url: String? = null,
    val gravatar_id: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val followers_url: String? = null,
    val following_url: String? = null,
    val gists_url: String? = null,
    val starred_url: String? = null,
    val subscriptions_url: String? = null,
    val organizations_url: String? = null,
    val repos_url: String? = null,
    val events_url: String? = null,
    val received_events_url: String? = null,
    val type: String? = null,
    val site_admin: Boolean? = null,
    val name: String? = null,
    val company: String? = null,
    val blog: String? = null,
    val location: String? = null,
    val email: String? = null,
    val hireable: Boolean? = null,
    val bio: String? = null,
    val twitter_username: String? = null,
    val public_repos: Int? = null,
    val public_gists: Int? = null,
    val followers: Int? = null,
    val following: Int? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val private_gists: Int? = null,
    val total_private_repos: Int? = null,
    val owned_private_repos: Int? = null,
    val disk_usage: Int? = null,
    val collaborators: Int? = null,
    val two_factor_authentication: Boolean? = null,
    val plan: Plan? = null
)

data class Plan(
    val name: String? = null,
    val space: Int? = null,
    val private_repos: Int? = null,
    val collaborators: Int? = null,
    val filled_seats: Int? = null,
    val seats: Int? = null
)

