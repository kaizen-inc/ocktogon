package inc.kaizen.client.pull.model.commit

data class Commit(
    val author: Actor,
    val comment_count: Int,
    val committer: Actor,
    val message: String,
    val tree: Tree,
    val url: String,
    val verification: Verification
)