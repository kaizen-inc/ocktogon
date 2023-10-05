package inc.kaizen.client.pull.model.commit

import inc.kaizen.client.user.model.User

data class PullCommit(
    val author: User,
    val comments_url: String,
    val commit: Commit,
    val committer: User,
    val html_url: String,
    val node_id: String,
    val parents: List<Tree>,
    val sha: String,
    val url: String
)