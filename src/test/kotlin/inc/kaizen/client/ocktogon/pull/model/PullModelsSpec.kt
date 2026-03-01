package inc.kaizen.client.ocktogon.pull.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PullModelsSpec : StringSpec({

    "Direction enum should have correct values" {
        Direction.values().size shouldBe 2
        Direction.asc.name shouldBe "asc"
        Direction.desc.name shouldBe "desc"
    }

    "SortType enum should have correct values" {
        SortType.values().size shouldBe 4
        SortType.created.name shouldBe "created"
        SortType.updated.name shouldBe "updated"
        SortType.popularity.name shouldBe "popularity"
        SortType.long_running.name shouldBe "long_running"
    }

    "State enum should have correct values" {
        State.values().size shouldBe 3
        State.open.name shouldBe "open"
        State.closed.name shouldBe "closed"
        State.all.name shouldBe "all"
    }

    "CreatePullRequest should instantiate and compare correctly" {
        val req = CreatePullRequest(title = "My PR", head = "feature", base = "main", body = "Description", draft = false)
        req.title shouldBe "My PR"
        req.head shouldBe "feature"
        req.base shouldBe "main"
    }

    "UpdatePullRequest should instantiate and compare correctly" {
        val req = UpdatePullRequest(title = "Updated PR", state = "closed")
        req.title shouldBe "Updated PR"
        req.state shouldBe "closed"
    }

    "CreateReviewCommentRequest should instantiate and compare correctly" {
        val req = CreateReviewCommentRequest(body = "Please fix this", commit_id = "abc123", path = "src/main.kt", line = 10)
        req.body shouldBe "Please fix this"
        req.commit_id shouldBe "abc123"
    }

    "UpdateReviewCommentRequest should instantiate and compare correctly" {
        val req = UpdateReviewCommentRequest(body = "Updated comment")
        req.body shouldBe "Updated comment"
    }

    "ReplyReviewCommentRequest should instantiate and compare correctly" {
        val req = ReplyReviewCommentRequest(body = "Reply comment")
        req.body shouldBe "Reply comment"
    }

    "PullReview should instantiate and compare correctly" {
        val review = PullReview(id = 1L, body = "LGTM", state = "APPROVED", commit_id = "abc123")
        review.id shouldBe 1L
        review.state shouldBe "APPROVED"
    }

    "ReviewCommentDraft should instantiate and compare correctly" {
        val draft = ReviewCommentDraft(path = "src/main.kt", body = "Fix this", line = 10, side = "RIGHT")
        draft.path shouldBe "src/main.kt"
        draft.body shouldBe "Fix this"
    }

    "CreateReviewRequest should instantiate and compare correctly" {
        val req = CreateReviewRequest(commit_id = "abc123", event = "APPROVE", body = "LGTM")
        req.commit_id shouldBe "abc123"
        req.event shouldBe "APPROVE"
    }

    "UpdateReviewRequest should instantiate and compare correctly" {
        val req = UpdateReviewRequest(body = "Updated review")
        req.body shouldBe "Updated review"
    }

    "DismissReviewRequest should instantiate and compare correctly" {
        val req = DismissReviewRequest(message = "Dismissing for now")
        req.message shouldBe "Dismissing for now"
        req.event shouldBe "DISMISS"
    }

    "SubmitReviewRequest should instantiate and compare correctly" {
        val req = SubmitReviewRequest(body = "LGTM", event = "APPROVE")
        req.event shouldBe "APPROVE"
    }

    "MergePullRequestRequest should instantiate and compare correctly" {
        val req = MergePullRequestRequest(commit_title = "Merge PR", merge_method = "squash")
        req.commit_title shouldBe "Merge PR"
        req.merge_method shouldBe "squash"
    }

    "MergeResult should instantiate and compare correctly" {
        val result = MergeResult(sha = "abc123", merged = true, message = "Pull Request successfully merged")
        result.sha shouldBe "abc123"
        result.merged shouldBe true
        result.message shouldBe "Pull Request successfully merged"
    }

    "RequestReviewersRequest should instantiate and compare correctly" {
        val req = RequestReviewersRequest(reviewers = listOf("octocat"), team_reviewers = listOf("devs"))
        req.reviewers shouldBe listOf("octocat")
        req.team_reviewers shouldBe listOf("devs")
    }
})
