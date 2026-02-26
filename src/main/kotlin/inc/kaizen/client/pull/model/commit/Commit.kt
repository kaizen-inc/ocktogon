package inc.kaizen.client.pull.model.commit

import inc.kaizen.client.common.Actor
import inc.kaizen.client.common.Verification

data class Commit(
    val author: Actor? = null,
    val comment_count: Int? = null,
    val committer: Actor? = null,
    val message: String? = null,
    val tree: Tree? = null,
    val url: String? = null,
    val verification: Verification? = null
)