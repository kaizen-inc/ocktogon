package inc.kaizen.client.ocktogon.pull.model.commit

import inc.kaizen.client.common.User

data class PullCommit(
    val author: User? = null,
    val comments_url: String? = null,
    val commit: Commit? = null,
    val committer: User? = null,
    val html_url: String? = null,
    val node_id: String? = null,
    val parents: List<Tree>? = null,
    val sha: String? = null,
    val url: String? = null
)