package inc.kaizen.client.gists.model

import inc.kaizen.client.common.User

data class Gist(
    val url: String? = null,
    val forks_url: String? = null,
    val commits_url: String? = null,
    val git_pull_url: String? = null,
    val git_push_url: String? = null,
    val html_url: String? = null,
    val id: String? = null,
    val node_id: String? = null,
    val files: Map<String, GistFile>? = null,
    val public: Boolean? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val description: String? = null,
    val comments: Int? = null,
    val user: User? = null,
    val comments_url: String? = null,
    val owner: User? = null,
    val truncated: Boolean? = null,
    val forks: List<GistFork>? = null,
    val history: List<GistCommit>? = null
)

data class GistFile(
    val filename: String? = null,
    val type: String? = null,
    val language: String? = null,
    val raw_url: String? = null,
    val size: Int? = null,
    val truncated: Boolean? = null,
    val content: String? = null
)

data class GistFork(
    val user: User? = null,
    val url: String? = null,
    val id: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null
)

data class GistCommit(
    val url: String? = null,
    val version: String? = null,
    val user: User? = null,
    val change_status: GistChangeStatus? = null,
    val committed_at: String? = null
)

data class GistChangeStatus(
    val total: Int? = null,
    val additions: Int? = null,
    val deletions: Int? = null
)

data class GistComment(
    val id: Int? = null,
    val node_id: String? = null,
    val url: String? = null,
    val body: String? = null,
    val user: User? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val author_association: String? = null
)

data class CreateGistRequest(
    val description: String? = null,
    val files: Map<String, GistFileRequest>,
    val public: Boolean? = null
)

data class UpdateGistRequest(
    val description: String? = null,
    val files: Map<String, GistFileRequest?>? = null
)

data class GistFileRequest(
    val content: String? = null,
    val filename: String? = null
)

data class CreateGistCommentRequest(val body: String)

