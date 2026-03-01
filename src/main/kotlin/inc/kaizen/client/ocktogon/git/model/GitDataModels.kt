package inc.kaizen.client.ocktogon.git.model

import inc.kaizen.client.ocktogon.common.Actor
import inc.kaizen.client.ocktogon.common.SimpleCommit
import inc.kaizen.client.ocktogon.common.Verification

data class GitBlob(
    val content: String? = null,
    val encoding: String? = null,
    val url: String? = null,
    val sha: String? = null,
    val size: Int? = null,
    val node_id: String? = null,
    val highlighted_content: String? = null
)

data class GitBlobRef(
    val url: String? = null,
    val sha: String? = null
)

data class CreateBlobRequest(
    val content: String,
    val encoding: String? = null
)

data class GitCommit(
    val sha: String? = null,
    val node_id: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val author: Actor? = null,
    val committer: Actor? = null,
    val message: String? = null,
    val tree: SimpleCommit? = null,
    val parents: List<SimpleCommit>? = null,
    val verification: Verification? = null
)

data class CreateGitCommitRequest(
    val message: String,
    val tree: String,
    val parents: List<String>? = null,
    val author: GitCommitAuthorRequest? = null,
    val committer: GitCommitAuthorRequest? = null,
    val signature: String? = null
)

data class GitCommitAuthorRequest(
    val name: String? = null,
    val email: String? = null,
    val date: String? = null
)

data class GitRef(
    val ref: String? = null,
    val node_id: String? = null,
    val url: String? = null,
    val `object`: GitRefObject? = null
)

data class GitRefObject(
    val type: String? = null,
    val sha: String? = null,
    val url: String? = null
)

data class CreateRefRequest(
    val ref: String,
    val sha: String,
    val key: String? = null
)

data class UpdateRefRequest(
    val sha: String,
    val force: Boolean? = null
)

data class GitTag(
    val node_id: String? = null,
    val tag: String? = null,
    val sha: String? = null,
    val url: String? = null,
    val message: String? = null,
    val tagger: GitCommitAuthorRequest? = null,
    val `object`: GitRefObject? = null,
    val verification: Verification? = null
)

data class CreateTagRequest(
    val tag: String,
    val message: String,
    val `object`: String,
    val type: String,
    val tagger: GitCommitAuthorRequest? = null
)

data class GitTree(
    val sha: String? = null,
    val url: String? = null,
    val tree: List<GitTreeItem>? = null,
    val truncated: Boolean? = null
)

data class GitTreeItem(
    val path: String? = null,
    val mode: String? = null,
    val type: String? = null,
    val size: Int? = null,
    val sha: String? = null,
    val url: String? = null
)

data class CreateTreeRequest(
    val tree: List<CreateTreeItem>,
    val base_tree: String? = null
)

data class CreateTreeItem(
    val path: String? = null,
    val mode: String? = null,
    val type: String? = null,
    val sha: String? = null,
    val content: String? = null
)

