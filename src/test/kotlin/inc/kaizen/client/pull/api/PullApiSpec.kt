package inc.kaizen.client.pull.api

import inc.kaizen.client.pull.model.*
import inc.kaizen.client.pull.model.commit.PullCommit
import inc.kaizen.client.pull.model.file.PullFile
import inc.kaizen.client.pull.model.pull.Pull
import inc.kaizen.client.pull.model.review.ReviewComment
import inc.kaizen.client.pull.model.reviewer.RequestedReviewer
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class PullApiSpec : FunSpec({
    val api = mockk<PullApi>()
    val owner = "owner"; val repo = "repo"
    val pullNumber = "42"; val pullNumberInt = 42
    val commentIdLong = 1L
    val pull = mockk<Pull>()
    val pulls = listOf(pull)
    val commit = mockk<PullCommit>()
    val file = mockk<PullFile>()
    val reviewComment = mockk<ReviewComment>()
    val requestedReviewer = mockk<RequestedReviewer>()
    val createReq = CreatePullRequest(head = "feature", base = "main")
    val updateReq = UpdatePullRequest(state = "closed")
    val createReviewCommentReq = CreateReviewCommentRequest(body = "Fix this", commit_id = "abc", path = "src/main.kt")
    val updateCommentReq = UpdateReviewCommentRequest(body = "Updated")
    val replyCommentReq = ReplyReviewCommentRequest(body = "Reply")

    test("getPulls returns pulls") {
        every { api.getPulls(owner, repo, any(), any(), any(), any(), any(), any(), any()) } returns pulls
        api.getPulls(owner, repo, head = "", base = "") shouldBe pulls
    }
    test("getPull returns pull") {
        every { api.getPull(owner, repo, pullNumber) } returns pull
        api.getPull(owner, repo, pullNumber) shouldBe pull
    }
    test("getPullCommits returns commits") {
        every { api.getPullCommits(owner, repo, pullNumber, any(), any()) } returns listOf(commit)
        api.getPullCommits(owner, repo, pullNumber) shouldBe listOf(commit)
    }
    test("getPullFiles returns files") {
        every { api.getPullFiles(owner, repo, pullNumber, any(), any()) } returns listOf(file)
        api.getPullFiles(owner, repo, pullNumber) shouldBe listOf(file)
    }
    test("isPullMerged returns response") {
        every { api.isPullMerged(owner, repo, pullNumber) } returns Response.success(Unit)
        api.isPullMerged(owner, repo, pullNumber).isSuccessful shouldBe true
    }
    test("getRepositoryReviewComments returns comments") {
        every { api.getRepositoryReviewComments(owner, repo, any(), any(), any(), any(), any()) } returns listOf(reviewComment)
        api.getRepositoryReviewComments(owner, repo) shouldBe listOf(reviewComment)
    }
    test("getRepositoryReviewComment returns comment") {
        every { api.getRepositoryReviewComment(owner, repo, "1") } returns reviewComment
        api.getRepositoryReviewComment(owner, repo, "1") shouldBe reviewComment
    }
    test("getPullReviewComments returns comments") {
        every { api.getPullReviewComments(owner, repo, pullNumber, any(), any(), any(), any(), any()) } returns listOf(reviewComment)
        api.getPullReviewComments(owner, repo, pullNumber) shouldBe listOf(reviewComment)
    }
    test("getPullRequestedReviewers returns requested reviewers") {
        every { api.getPullRequestedReviewers(owner, repo, pullNumber) } returns requestedReviewer
        api.getPullRequestedReviewers(owner, repo, pullNumber) shouldBe requestedReviewer
    }
    test("createPull returns pull") {
        coEvery { api.createPull(owner, repo, createReq) } returns pull
        runBlocking { api.createPull(owner, repo, createReq) } shouldBe pull
    }
    test("updatePull returns pull") {
        coEvery { api.updatePull(owner, repo, pullNumberInt, updateReq) } returns pull
        runBlocking { api.updatePull(owner, repo, pullNumberInt, updateReq) } shouldBe pull
    }
    test("createReviewComment returns review comment") {
        coEvery { api.createReviewComment(owner, repo, pullNumberInt, createReviewCommentReq) } returns reviewComment
        runBlocking { api.createReviewComment(owner, repo, pullNumberInt, createReviewCommentReq) } shouldBe reviewComment
    }
    test("deleteReviewComment returns response") {
        coEvery { api.deleteReviewComment(owner, repo, commentIdLong) } returns Response.success(Unit)
        runBlocking { api.deleteReviewComment(owner, repo, commentIdLong).isSuccessful } shouldBe true
    }
    test("updateReviewComment returns review comment") {
        coEvery { api.updateReviewComment(owner, repo, commentIdLong, updateCommentReq) } returns reviewComment
        runBlocking { api.updateReviewComment(owner, repo, commentIdLong, updateCommentReq) } shouldBe reviewComment
    }
    test("createReplyForReviewComment returns review comment") {
        coEvery { api.createReplyForReviewComment(owner, repo, pullNumberInt, commentIdLong, replyCommentReq) } returns reviewComment
        runBlocking { api.createReplyForReviewComment(owner, repo, pullNumberInt, commentIdLong, replyCommentReq) } shouldBe reviewComment
    }
})
