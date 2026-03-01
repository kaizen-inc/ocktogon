package inc.kaizen.client.ocktogon.repo.model

import inc.kaizen.client.ocktogon.common.*

// --- Autolink ---
data class Autolink(
    val id: Int? = null,
    val key_prefix: String? = null,
    val url_template: String? = null,
    val is_alphanumeric: Boolean? = null
)

data class CreateAutolinkRequest(
    val key_prefix: String,
    val url_template: String,
    val is_alphanumeric: Boolean? = null
)

// --- Branch ---
data class Branch(
    val name: String? = null,
    val commit: SimpleCommit? = null,
    val protected: Boolean? = null,
    val protection: BranchProtection? = null,
    val protection_url: String? = null
)

data class BranchProtection(
    val url: String? = null,
    val required_status_checks: RequiredStatusChecks? = null,
    val enforce_admins: ProtectedBranchAdminEnforced? = null,
    val required_pull_request_reviews: RequiredPullRequestReviews? = null,
    val restrictions: BranchRestrictionPolicy? = null,
    val required_linear_history: BooleanObject? = null,
    val allow_force_pushes: BooleanObject? = null,
    val allow_deletions: BooleanObject? = null,
    val block_creations: BooleanObject? = null,
    val required_conversation_resolution: BooleanObject? = null,
    val lock_branch: BooleanObject? = null,
    val allow_fork_syncing: BooleanObject? = null,
    val enabled: Boolean? = null
)

data class BooleanObject(val enabled: Boolean? = null)

data class RequiredStatusChecks(
    val strict: Boolean? = null,
    val contexts: List<String>? = null,
    val checks: List<StatusCheckItem>? = null,
    val contexts_url: String? = null,
    val url: String? = null,
    val enforcement_level: String? = null
)

data class StatusCheckItem(
    val context: String? = null,
    val app_id: Int? = null
)

data class RequiredPullRequestReviews(
    val url: String? = null,
    val dismissal_restrictions: DismissalRestrictions? = null,
    val bypass_pull_request_allowances: BypassPullRequestAllowances? = null,
    val dismiss_stale_reviews: Boolean? = null,
    val require_code_owner_reviews: Boolean? = null,
    val required_approving_review_count: Int? = null,
    val require_last_push_approval: Boolean? = null
)

data class DismissalRestrictions(
    val url: String? = null,
    val users_url: String? = null,
    val teams_url: String? = null,
    val users: List<User>? = null,
    val teams: List<Team>? = null
)

data class BypassPullRequestAllowances(
    val users: List<User>? = null,
    val teams: List<Team>? = null
)

data class ProtectedBranchAdminEnforced(
    val url: String? = null,
    val enabled: Boolean? = null
)

data class BranchRestrictionPolicy(
    val url: String? = null,
    val users_url: String? = null,
    val teams_url: String? = null,
    val apps_url: String? = null,
    val users: List<User>? = null,
    val teams: List<Team>? = null,
    val apps: List<Any>? = null
)

data class RenameBranchRequest(val new_name: String)

data class MergeBranchRequest(
    val base: String,
    val head: String,
    val commit_message: String? = null
)

data class MergeUpstreamRequest(val branch: String)

data class MergeUpstreamResponse(
    val message: String? = null,
    val merge_type: String? = null,
    val base_branch: String? = null
)

data class BranchProtectionRequest(
    val required_status_checks: RequiredStatusChecksRequest? = null,
    val enforce_admins: Boolean? = null,
    val required_pull_request_reviews: RequiredPullRequestReviewsRequest? = null,
    val restrictions: RestrictionsRequest? = null,
    val required_linear_history: Boolean? = null,
    val allow_force_pushes: Boolean? = null,
    val allow_deletions: Boolean? = null,
    val block_creations: Boolean? = null,
    val required_conversation_resolution: Boolean? = null,
    val lock_branch: Boolean? = null,
    val allow_fork_syncing: Boolean? = null
)

data class RequiredStatusChecksRequest(
    val strict: Boolean,
    val contexts: List<String>,
    val checks: List<StatusCheckItem>? = null
)

data class RequiredPullRequestReviewsRequest(
    val dismissal_restrictions: DismissalRestrictionsRequest? = null,
    val dismiss_stale_reviews: Boolean? = null,
    val require_code_owner_reviews: Boolean? = null,
    val required_approving_review_count: Int? = null,
    val require_last_push_approval: Boolean? = null,
    val bypass_pull_request_allowances: BypassAllowancesRequest? = null
)

data class DismissalRestrictionsRequest(
    val users: List<String>? = null,
    val teams: List<String>? = null,
    val apps: List<String>? = null
)

data class BypassAllowancesRequest(
    val users: List<String>? = null,
    val teams: List<String>? = null,
    val apps: List<String>? = null
)

data class RestrictionsRequest(
    val users: List<String>,
    val teams: List<String>,
    val apps: List<String>? = null
)

// --- Commit ---
data class RepoCommit(
    val sha: String? = null,
    val node_id: String? = null,
    val commit: CommitData? = null,
    val url: String? = null,
    val html_url: String? = null,
    val comments_url: String? = null,
    val author: User? = null,
    val committer: User? = null,
    val parents: List<SimpleCommit>? = null,
    val stats: CommitStats? = null,
    val files: List<CommitFile>? = null
)

data class CommitData(
    val author: Actor? = null,
    val committer: Actor? = null,
    val message: String? = null,
    val tree: SimpleCommit? = null,
    val url: String? = null,
    val comment_count: Int? = null,
    val verification: Verification? = null
)

data class CommitStats(
    val additions: Int? = null,
    val deletions: Int? = null,
    val total: Int? = null
)

data class CommitFile(
    val sha: String? = null,
    val filename: String? = null,
    val status: String? = null,
    val additions: Int? = null,
    val deletions: Int? = null,
    val changes: Int? = null,
    val blob_url: String? = null,
    val raw_url: String? = null,
    val contents_url: String? = null,
    val patch: String? = null,
    val previous_filename: String? = null
)

data class BranchShort(
    val name: String? = null,
    val commit: SimpleCommit? = null,
    val protected: Boolean? = null
)

data class CommitComment(
    val html_url: String? = null,
    val url: String? = null,
    val id: Int? = null,
    val node_id: String? = null,
    val body: String? = null,
    val path: String? = null,
    val position: Int? = null,
    val line: Int? = null,
    val commit_id: String? = null,
    val user: User? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val author_association: String? = null
)

data class CreateCommitCommentRequest(
    val body: String,
    val path: String? = null,
    val position: Int? = null,
    val line: Int? = null
)

data class UpdateCommitCommentRequest(val body: String)

data class CommitStatus(
    val url: String? = null,
    val id: Long? = null,
    val node_id: String? = null,
    val state: String? = null,
    val description: String? = null,
    val target_url: String? = null,
    val context: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val creator: User? = null
)

data class CreateCommitStatusRequest(
    val state: String,
    val target_url: String? = null,
    val description: String? = null,
    val context: String? = null
)

data class CombinedCommitStatus(
    val state: String? = null,
    val statuses: List<CommitStatus>? = null,
    val sha: String? = null,
    val total_count: Int? = null,
    val repository: Repository? = null,
    val commit_url: String? = null,
    val url: String? = null
)

data class CommitComparison(
    val url: String? = null,
    val html_url: String? = null,
    val permalink_url: String? = null,
    val diff_url: String? = null,
    val patch_url: String? = null,
    val base_commit: RepoCommit? = null,
    val merge_base_commit: RepoCommit? = null,
    val status: String? = null,
    val ahead_by: Int? = null,
    val behind_by: Int? = null,
    val total_commits: Int? = null,
    val commits: List<RepoCommit>? = null,
    val files: List<CommitFile>? = null
)

// --- Content ---
data class ContentFile(
    val type: String? = null,
    val encoding: String? = null,
    val size: Int? = null,
    val name: String? = null,
    val path: String? = null,
    val content: String? = null,
    val sha: String? = null,
    val url: String? = null,
    val git_url: String? = null,
    val html_url: String? = null,
    val download_url: String? = null,
    val _links: ContentLinks? = null
)

data class ContentLinks(
    val git: String? = null,
    val self: String? = null,
    val html: String? = null
)

data class CreateOrUpdateFileRequest(
    val message: String,
    val content: String,
    val sha: String? = null,
    val branch: String? = null,
    val committer: CommitAuthorRequest? = null,
    val author: CommitAuthorRequest? = null
)

data class DeleteFileRequest(
    val message: String,
    val sha: String,
    val branch: String? = null,
    val committer: CommitAuthorRequest? = null,
    val author: CommitAuthorRequest? = null
)

data class CommitAuthorRequest(
    val name: String,
    val email: String,
    val date: String? = null
)

data class FileCommitResponse(
    val content: ContentFile? = null,
    val commit: RepoCommitDetail? = null
)

data class RepoCommitDetail(
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

// --- Deploy Key ---
data class DeployKey(
    val id: Int? = null,
    val key: String? = null,
    val url: String? = null,
    val title: String? = null,
    val verified: Boolean? = null,
    val created_at: String? = null,
    val read_only: Boolean? = null,
    val added_by: String? = null,
    val last_used: String? = null
)

data class CreateDeployKeyRequest(
    val title: String? = null,
    val key: String,
    val read_only: Boolean? = null
)

// --- Repo ---
data class CreateRepoRequest(
    val name: String,
    val description: String? = null,
    val homepage: String? = null,
    val private: Boolean? = null,
    val visibility: String? = null,
    val has_issues: Boolean? = null,
    val has_projects: Boolean? = null,
    val has_wiki: Boolean? = null,
    val is_template: Boolean? = null,
    val team_id: Int? = null,
    val auto_init: Boolean? = null,
    val gitignore_template: String? = null,
    val license_template: String? = null,
    val allow_squash_merge: Boolean? = null,
    val allow_merge_commit: Boolean? = null,
    val allow_rebase_merge: Boolean? = null,
    val allow_auto_merge: Boolean? = null,
    val delete_branch_on_merge: Boolean? = null
)

data class UpdateRepoRequest(
    val name: String? = null,
    val description: String? = null,
    val homepage: String? = null,
    val private: Boolean? = null,
    val visibility: String? = null,
    val security_and_analysis: Any? = null,
    val has_issues: Boolean? = null,
    val has_projects: Boolean? = null,
    val has_wiki: Boolean? = null,
    val is_template: Boolean? = null,
    val default_branch: String? = null,
    val allow_squash_merge: Boolean? = null,
    val allow_merge_commit: Boolean? = null,
    val allow_rebase_merge: Boolean? = null,
    val allow_auto_merge: Boolean? = null,
    val delete_branch_on_merge: Boolean? = null,
    val archived: Boolean? = null,
    val allow_forking: Boolean? = null,
    val web_commit_signoff_required: Boolean? = null
)

data class ForkRequest(
    val organization: String? = null,
    val name: String? = null,
    val default_branch_only: Boolean? = null
)

data class TransferRepoRequest(
    val new_owner: String,
    val new_name: String? = null,
    val team_ids: List<Int>? = null
)

data class TopicsRequest(val names: List<String>)
data class TopicsResponse(val names: List<String>? = null)

data class RepoTag(
    val name: String? = null,
    val zipball_url: String? = null,
    val tarball_url: String? = null,
    val commit: SimpleCommit? = null,
    val node_id: String? = null
)

data class CreateRepoFromTemplateRequest(
    val owner: String? = null,
    val name: String,
    val description: String? = null,
    val include_all_branches: Boolean? = null,
    val private: Boolean? = null
)

// --- Repo Invitation ---
data class RepoInvitation(
    val id: Int? = null,
    val repository: Repository? = null,
    val invitee: User? = null,
    val inviter: User? = null,
    val permissions: String? = null,
    val created_at: String? = null,
    val expired: Boolean? = null,
    val url: String? = null,
    val html_url: String? = null,
    val node_id: String? = null
)

data class UpdateInvitationRequest(val permissions: String? = null)

// --- Repo Stats ---
data class ContributorStat(
    val author: User? = null,
    val total: Int? = null,
    val weeks: List<WeeklyCommitData>? = null
)

data class WeeklyCommitData(
    val w: Long? = null,
    val a: Int? = null,
    val d: Int? = null,
    val c: Int? = null
)

data class CommitActivity(
    val days: List<Int>? = null,
    val total: Int? = null,
    val week: Long? = null
)

data class ParticipationStats(
    val all: List<Int>? = null,
    val owner: List<Int>? = null
)

// --- Repo Traffic ---
data class ClonesTraffic(
    val count: Int? = null,
    val uniques: Int? = null,
    val clones: List<TrafficData>? = null
)

data class ViewsTraffic(
    val count: Int? = null,
    val uniques: Int? = null,
    val views: List<TrafficData>? = null
)

data class TrafficData(
    val timestamp: String? = null,
    val count: Int? = null,
    val uniques: Int? = null
)

data class TrafficPath(
    val path: String? = null,
    val title: String? = null,
    val count: Int? = null,
    val uniques: Int? = null
)

data class TrafficReferrer(
    val referrer: String? = null,
    val count: Int? = null,
    val uniques: Int? = null
)

