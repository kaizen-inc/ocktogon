package inc.kaizen.client.ocktogon.orgs.model

import inc.kaizen.client.common.User

data class TeamMembership(
    val url: String? = null,
    val role: String? = null,
    val state: String? = null
)

data class TeamMembershipRequest(val role: String? = null)
data class TeamRepoPermissionRequest(val permission: String? = null)

data class CreateTeamRequest(
    val name: String,
    val description: String? = null,
    val maintainers: List<String>? = null,
    val repo_names: List<String>? = null,
    val privacy: String? = null,
    val notification_setting: String? = null,
    val permission: String? = null,
    val parent_team_id: Int? = null
)

data class UpdateTeamRequest(
    val name: String? = null,
    val description: String? = null,
    val privacy: String? = null,
    val notification_setting: String? = null,
    val permission: String? = null,
    val parent_team_id: Int? = null
)

data class TeamDiscussion(
    val author: User? = null,
    val body: String? = null,
    val body_html: String? = null,
    val body_version: String? = null,
    val comments_count: Int? = null,
    val comments_url: String? = null,
    val created_at: String? = null,
    val last_edited_at: String? = null,
    val html_url: String? = null,
    val node_id: String? = null,
    val number: Int? = null,
    val pinned: Boolean? = null,
    val private: Boolean? = null,
    val team_url: String? = null,
    val title: String? = null,
    val updated_at: String? = null,
    val url: String? = null
)

data class TeamDiscussionComment(
    val author: User? = null,
    val body: String? = null,
    val body_html: String? = null,
    val body_version: String? = null,
    val created_at: String? = null,
    val last_edited_at: String? = null,
    val discussion_url: String? = null,
    val html_url: String? = null,
    val node_id: String? = null,
    val number: Int? = null,
    val updated_at: String? = null,
    val url: String? = null
)

data class CreateDiscussionRequest(
    val title: String,
    val body: String,
    val private: Boolean? = null
)

data class UpdateDiscussionRequest(
    val title: String? = null,
    val body: String? = null
)

data class CreateDiscussionCommentRequest(val body: String)

