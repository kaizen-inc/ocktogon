package inc.kaizen.client.common

data class Milestone(
    val url: String? = null,
    val html_url: String? = null,
    val labels_url: String? = null,
    val id: Int? = null,
    val node_id: String? = null,
    val number: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val creator: User? = null,
    val open_issues: Int? = null,
    val closed_issues: Int? = null,
    val state: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val due_on: String? = null,
    val closed_at: String? = null
)

