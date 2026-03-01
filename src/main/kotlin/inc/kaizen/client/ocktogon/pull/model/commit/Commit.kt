package inc.kaizen.client.ocktogon.pull.model.commit

data class Commit(
    val author: Actor? = null,
    val comment_count: Int? = null,
    val committer: Actor? = null,
    val message: String? = null,
    val tree: Tree? = null,
    val url: String? = null,
    val verification: Verification? = null
)