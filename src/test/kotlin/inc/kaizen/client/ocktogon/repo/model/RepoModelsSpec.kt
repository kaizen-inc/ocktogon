package inc.kaizen.client.ocktogon.repo.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RepoModelsSpec : StringSpec({

    "Autolink should instantiate and compare correctly" {
        val autolink = Autolink(id = 1, key_prefix = "JIRA-", url_template = "https://jira.example.com/browse/JIRA-<num>", is_alphanumeric = true)
        autolink.id shouldBe 1
        autolink.key_prefix shouldBe "JIRA-"
    }

    "CreateAutolinkRequest should instantiate and compare correctly" {
        val req = CreateAutolinkRequest(key_prefix = "JIRA-", url_template = "https://jira.example.com/browse/JIRA-<num>")
        req.key_prefix shouldBe "JIRA-"
    }

    "BooleanObject should instantiate and compare correctly" {
        val obj = BooleanObject(enabled = true)
        obj.enabled shouldBe true
    }

    "RenameBranchRequest should instantiate and compare correctly" {
        val req = RenameBranchRequest(new_name = "main")
        req.new_name shouldBe "main"
    }

    "MergeBranchRequest should instantiate and compare correctly" {
        val req = MergeBranchRequest(base = "main", head = "feature", commit_message = "Merge feature into main")
        req.base shouldBe "main"
        req.head shouldBe "feature"
    }

    "MergeUpstreamRequest should instantiate and compare correctly" {
        val req = MergeUpstreamRequest(branch = "main")
        req.branch shouldBe "main"
    }

    "MergeUpstreamResponse should instantiate and compare correctly" {
        val resp = MergeUpstreamResponse(message = "Merged", merge_type = "merge", base_branch = "main")
        resp.message shouldBe "Merged"
    }

    "CommitStats should instantiate and compare correctly" {
        val stats = CommitStats(additions = 10, deletions = 5, total = 15)
        stats.additions shouldBe 10
        stats.total shouldBe 15
    }

    "CommitFile should instantiate and compare correctly" {
        val file = CommitFile(sha = "abc123", filename = "src/main.kt", status = "modified", additions = 5, deletions = 2, changes = 7)
        file.filename shouldBe "src/main.kt"
        file.status shouldBe "modified"
    }

    "BranchShort should instantiate and compare correctly" {
        val branch = BranchShort(name = "main", protected = true)
        branch.name shouldBe "main"
        branch.protected shouldBe true
    }

    "CommitComment should instantiate and compare correctly" {
        val comment = CommitComment(id = 1, body = "Nice commit!", commit_id = "abc123", author_association = "OWNER")
        comment.id shouldBe 1
        comment.body shouldBe "Nice commit!"
    }

    "CreateCommitCommentRequest should instantiate and compare correctly" {
        val req = CreateCommitCommentRequest(body = "Nice commit!", path = "src/main.kt", line = 10)
        req.body shouldBe "Nice commit!"
        req.path shouldBe "src/main.kt"
    }

    "UpdateCommitCommentRequest should instantiate and compare correctly" {
        val req = UpdateCommitCommentRequest(body = "Updated comment")
        req.body shouldBe "Updated comment"
    }

    "CommitStatus should instantiate and compare correctly" {
        val status = CommitStatus(id = 1L, state = "success", context = "ci/test", description = "All tests passed")
        status.state shouldBe "success"
        status.context shouldBe "ci/test"
    }

    "CreateCommitStatusRequest should instantiate and compare correctly" {
        val req = CreateCommitStatusRequest(state = "pending", context = "ci/test", description = "Tests in progress")
        req.state shouldBe "pending"
        req.context shouldBe "ci/test"
    }

    "CombinedCommitStatus should instantiate and compare correctly" {
        val combined = CombinedCommitStatus(state = "success", sha = "abc123", total_count = 2)
        combined.state shouldBe "success"
        combined.total_count shouldBe 2
    }

    "ContentLinks should instantiate and compare correctly" {
        val links = ContentLinks(git = "git_url", self = "self_url", html = "html_url")
        links.git shouldBe "git_url"
        links.html shouldBe "html_url"
    }

    "ContentFile should instantiate and compare correctly" {
        val file = ContentFile(type = "file", name = "README.md", path = "README.md", sha = "abc123", size = 100, encoding = "base64")
        file.name shouldBe "README.md"
        file.type shouldBe "file"
    }

    "CommitAuthorRequest should instantiate and compare correctly" {
        val author = CommitAuthorRequest(name = "Octocat", email = "octocat@github.com")
        author.name shouldBe "Octocat"
        author.email shouldBe "octocat@github.com"
    }

    "CreateOrUpdateFileRequest should instantiate and compare correctly" {
        val req = CreateOrUpdateFileRequest(message = "Create file", content = "base64content")
        req.message shouldBe "Create file"
        req.content shouldBe "base64content"
    }

    "DeleteFileRequest should instantiate and compare correctly" {
        val req = DeleteFileRequest(message = "Delete file", sha = "abc123")
        req.message shouldBe "Delete file"
        req.sha shouldBe "abc123"
    }

    "DeployKey should instantiate and compare correctly" {
        val key = DeployKey(id = 1, title = "Deploy Key", verified = true, read_only = true)
        key.id shouldBe 1
        key.read_only shouldBe true
    }

    "CreateDeployKeyRequest should instantiate and compare correctly" {
        val req = CreateDeployKeyRequest(key = "ssh-rsa AAAA...", title = "CI Deploy Key", read_only = true)
        req.key shouldBe "ssh-rsa AAAA..."
        req.read_only shouldBe true
    }

    "CreateRepoRequest should instantiate and compare correctly" {
        val req = CreateRepoRequest(name = "new-repo", description = "My new repo", private = true)
        req.name shouldBe "new-repo"
        req.private shouldBe true
    }

    "UpdateRepoRequest should instantiate and compare correctly" {
        val req = UpdateRepoRequest(name = "renamed-repo", archived = false)
        req.name shouldBe "renamed-repo"
        req.archived shouldBe false
    }

    "ForkRequest should instantiate and compare correctly" {
        val req = ForkRequest(organization = "my-org", name = "forked-repo", default_branch_only = true)
        req.organization shouldBe "my-org"
        req.default_branch_only shouldBe true
    }

    "TransferRepoRequest should instantiate and compare correctly" {
        val req = TransferRepoRequest(new_owner = "new-owner", new_name = "new-name", team_ids = listOf(1, 2))
        req.new_owner shouldBe "new-owner"
        req.team_ids shouldBe listOf(1, 2)
    }

    "TopicsRequest should instantiate and compare correctly" {
        val req = TopicsRequest(names = listOf("kotlin", "github"))
        req.names shouldBe listOf("kotlin", "github")
    }

    "TopicsResponse should instantiate and compare correctly" {
        val resp = TopicsResponse(names = listOf("kotlin"))
        resp.names shouldBe listOf("kotlin")
    }

    "RepoTag should instantiate and compare correctly" {
        val tag = RepoTag(name = "v1.0.0", zipball_url = "url", tarball_url = "url")
        tag.name shouldBe "v1.0.0"
    }

    "RepoInvitation should instantiate and compare correctly" {
        val inv = RepoInvitation(id = 1, permissions = "push", expired = false)
        inv.id shouldBe 1
        inv.permissions shouldBe "push"
    }

    "UpdateInvitationRequest should instantiate and compare correctly" {
        val req = UpdateInvitationRequest(permissions = "admin")
        req.permissions shouldBe "admin"
    }

    "WeeklyCommitData should instantiate and compare correctly" {
        val data = WeeklyCommitData(w = 1735689600L, a = 10, d = 5, c = 3)
        data.a shouldBe 10
        data.c shouldBe 3
    }

    "ContributorStat should instantiate and compare correctly" {
        val stat = ContributorStat(total = 100, weeks = listOf())
        stat.total shouldBe 100
        stat.weeks?.size shouldBe 0
    }

    "CommitActivity should instantiate and compare correctly" {
        val activity = CommitActivity(days = listOf(0, 1, 2, 3, 4, 5, 6), total = 21, week = 1735689600L)
        activity.total shouldBe 21
        activity.days?.size shouldBe 7
    }

    "ParticipationStats should instantiate and compare correctly" {
        val stats = ParticipationStats(all = listOf(1, 2, 3), owner = listOf(1, 0, 2))
        stats.all?.size shouldBe 3
        stats.owner?.size shouldBe 3
    }

    "TrafficData should instantiate and compare correctly" {
        val data = TrafficData(timestamp = "2025-01-01T00:00:00Z", count = 100, uniques = 50)
        data.count shouldBe 100
        data.uniques shouldBe 50
    }

    "ClonesTraffic should instantiate and compare correctly" {
        val clones = ClonesTraffic(count = 100, uniques = 50, clones = listOf())
        clones.count shouldBe 100
        clones.clones?.size shouldBe 0
    }

    "ViewsTraffic should instantiate and compare correctly" {
        val views = ViewsTraffic(count = 200, uniques = 80, views = listOf())
        views.count shouldBe 200
    }

    "TrafficPath should instantiate and compare correctly" {
        val path = TrafficPath(path = "/readme", title = "README", count = 10, uniques = 5)
        path.path shouldBe "/readme"
        path.count shouldBe 10
    }

    "TrafficReferrer should instantiate and compare correctly" {
        val referrer = TrafficReferrer(referrer = "google.com", count = 30, uniques = 15)
        referrer.referrer shouldBe "google.com"
        referrer.count shouldBe 30
    }

    "Branch should instantiate and compare correctly" {
        val branch = Branch(name = "main", protected = true, protection_url = "https://api.github.com/repos/o/r/branches/main/protection")
        branch.name shouldBe "main"
        branch.protected shouldBe true
    }

    "StatusCheckItem should instantiate and compare correctly" {
        val item = StatusCheckItem(context = "ci/test", app_id = 1)
        item.context shouldBe "ci/test"
        item.app_id shouldBe 1
    }

    "RequiredStatusChecks should instantiate and compare correctly" {
        val checks = RequiredStatusChecks(strict = true, contexts = listOf("ci/test"), enforcement_level = "off")
        checks.strict shouldBe true
        checks.contexts shouldBe listOf("ci/test")
    }

    "DismissalRestrictions should instantiate and compare correctly" {
        val dr = DismissalRestrictions(url = "url", users = listOf(), teams = listOf())
        dr.url shouldBe "url"
        dr.users?.size shouldBe 0
    }

    "BypassPullRequestAllowances should instantiate and compare correctly" {
        val bypass = BypassPullRequestAllowances(users = listOf(), teams = listOf())
        bypass.users?.size shouldBe 0
        bypass.teams?.size shouldBe 0
    }

    "RequiredPullRequestReviews should instantiate and compare correctly" {
        val reviews = RequiredPullRequestReviews(dismiss_stale_reviews = true, required_approving_review_count = 1, require_code_owner_reviews = false)
        reviews.dismiss_stale_reviews shouldBe true
        reviews.required_approving_review_count shouldBe 1
    }

    "ProtectedBranchAdminEnforced should instantiate and compare correctly" {
        val admin = ProtectedBranchAdminEnforced(url = "url", enabled = true)
        admin.enabled shouldBe true
        admin.url shouldBe "url"
    }

    "BranchRestrictionPolicy should instantiate and compare correctly" {
        val policy = BranchRestrictionPolicy(url = "url", users = listOf(), teams = listOf(), apps = listOf())
        policy.url shouldBe "url"
        policy.users?.size shouldBe 0
    }

    "BranchProtection should instantiate and compare correctly" {
        val protection = BranchProtection(url = "url", enabled = true, required_linear_history = BooleanObject(true))
        protection.url shouldBe "url"
        protection.enabled shouldBe true
        protection.required_linear_history?.enabled shouldBe true
    }

    "BranchProtectionRequest should instantiate and compare correctly" {
        val req = BranchProtectionRequest(enforce_admins = true, allow_force_pushes = false, required_linear_history = true)
        req.enforce_admins shouldBe true
        req.allow_force_pushes shouldBe false
    }

    "RequiredStatusChecksRequest should instantiate and compare correctly" {
        val req = RequiredStatusChecksRequest(strict = true, contexts = listOf("ci/test"))
        req.strict shouldBe true
        req.contexts shouldBe listOf("ci/test")
    }

    "DismissalRestrictionsRequest should instantiate and compare correctly" {
        val req = DismissalRestrictionsRequest(users = listOf("octocat"), teams = listOf("devs"))
        req.users shouldBe listOf("octocat")
        req.teams shouldBe listOf("devs")
    }

    "BypassAllowancesRequest should instantiate and compare correctly" {
        val req = BypassAllowancesRequest(users = listOf("octocat"), teams = listOf())
        req.users shouldBe listOf("octocat")
    }

    "RequiredPullRequestReviewsRequest should instantiate and compare correctly" {
        val req = RequiredPullRequestReviewsRequest(dismiss_stale_reviews = true, required_approving_review_count = 2)
        req.dismiss_stale_reviews shouldBe true
        req.required_approving_review_count shouldBe 2
    }

    "RestrictionsRequest should instantiate and compare correctly" {
        val req = RestrictionsRequest(users = listOf("octocat"), teams = listOf("devs"), apps = listOf("my-app"))
        req.users shouldBe listOf("octocat")
        req.teams shouldBe listOf("devs")
    }

    "CommitData should instantiate and compare correctly" {
        val data = CommitData(message = "Initial commit", comment_count = 0)
        data.message shouldBe "Initial commit"
        data.comment_count shouldBe 0
    }

    "CommitComparison should instantiate and compare correctly" {
        val comparison = CommitComparison(status = "ahead", ahead_by = 3, behind_by = 0, total_commits = 3)
        comparison.status shouldBe "ahead"
        comparison.ahead_by shouldBe 3
        comparison.total_commits shouldBe 3
    }

    "RepoCommitDetail should instantiate and compare correctly" {
        val detail = RepoCommitDetail(sha = "abc123", message = "Fix bug", url = "url")
        detail.sha shouldBe "abc123"
        detail.message shouldBe "Fix bug"
    }

    "FileCommitResponse should instantiate and compare correctly" {
        val detail = RepoCommitDetail(sha = "abc123", message = "Add file")
        val file = ContentFile(name = "README.md", type = "file")
        val resp = FileCommitResponse(content = file, commit = detail)
        resp.commit?.sha shouldBe "abc123"
        resp.content?.name shouldBe "README.md"
    }

    "CreateRepoFromTemplateRequest should instantiate and compare correctly" {
        val req = CreateRepoFromTemplateRequest(name = "new-repo", owner = "octocat", private = true, include_all_branches = false)
        req.name shouldBe "new-repo"
        req.owner shouldBe "octocat"
        req.private shouldBe true
    }
})
