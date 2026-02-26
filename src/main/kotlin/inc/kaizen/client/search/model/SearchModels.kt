package inc.kaizen.client.search.model

import inc.kaizen.client.common.*

data class CodeSearchResult(
    val total_count: Int? = null,
    val incomplete_results: Boolean? = null,
    val items: List<CodeSearchItem>? = null
)

data class CodeSearchItem(
    val name: String? = null,
    val path: String? = null,
    val sha: String? = null,
    val url: String? = null,
    val git_url: String? = null,
    val html_url: String? = null,
    val repository: Repository? = null,
    val score: Double? = null
)

data class CommitSearchResult(
    val total_count: Int? = null,
    val incomplete_results: Boolean? = null,
    val items: List<CommitSearchItem>? = null
)

data class CommitSearchItem(
    val url: String? = null,
    val sha: String? = null,
    val html_url: String? = null,
    val comments_url: String? = null,
    val commit: CommitSearchData? = null,
    val author: User? = null,
    val committer: User? = null,
    val parents: List<SimpleCommit>? = null,
    val repository: Repository? = null,
    val score: Double? = null,
    val node_id: String? = null
)

data class CommitSearchData(
    val author: Actor? = null,
    val committer: Actor? = null,
    val message: String? = null,
    val tree: SimpleCommit? = null,
    val url: String? = null,
    val comment_count: Int? = null
)

data class IssueSearchResult(
    val total_count: Int? = null,
    val incomplete_results: Boolean? = null,
    val items: List<IssueSearchItem>? = null
)

data class IssueSearchItem(
    val url: String? = null,
    val repository_url: String? = null,
    val labels_url: String? = null,
    val comments_url: String? = null,
    val events_url: String? = null,
    val html_url: String? = null,
    val id: Int? = null,
    val node_id: String? = null,
    val number: Int? = null,
    val title: String? = null,
    val user: User? = null,
    val labels: List<Label>? = null,
    val state: String? = null,
    val assignee: User? = null,
    val milestone: Milestone? = null,
    val comments: Int? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val closed_at: String? = null,
    val body: String? = null,
    val score: Double? = null,
    val pull_request: PullRequestRef? = null,
    val draft: Boolean? = null,
    val author_association: String? = null
)

data class PullRequestRef(
    val merged_at: String? = null,
    val diff_url: String? = null,
    val html_url: String? = null,
    val patch_url: String? = null,
    val url: String? = null
)

data class LabelSearchResult(
    val total_count: Int? = null,
    val incomplete_results: Boolean? = null,
    val items: List<LabelSearchItem>? = null
)

data class LabelSearchItem(
    val id: Int? = null,
    val node_id: String? = null,
    val url: String? = null,
    val name: String? = null,
    val color: String? = null,
    val default: Boolean? = null,
    val description: String? = null,
    val score: Double? = null
)

data class RepoSearchResult(
    val total_count: Int? = null,
    val incomplete_results: Boolean? = null,
    val items: List<Repository>? = null
)

data class TopicSearchResult(
    val total_count: Int? = null,
    val incomplete_results: Boolean? = null,
    val items: List<TopicSearchItem>? = null
)

data class TopicSearchItem(
    val name: String? = null,
    val display_name: String? = null,
    val short_description: String? = null,
    val description: String? = null,
    val created_by: String? = null,
    val released: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val featured: Boolean? = null,
    val curated: Boolean? = null,
    val score: Double? = null,
    val repository_count: Int? = null,
    val logo_url: String? = null,
    val related: List<TopicRelation>? = null,
    val aliases: List<TopicAlias>? = null
)

data class TopicRelation(val topic_relation: TopicRelationItem? = null)
data class TopicRelationItem(
    val id: Int? = null,
    val name: String? = null,
    val topic_id: Int? = null,
    val relation_type: String? = null
)
data class TopicAlias(val topic_relation: TopicRelationItem? = null)

data class UserSearchResult(
    val total_count: Int? = null,
    val incomplete_results: Boolean? = null,
    val items: List<User>? = null
)

