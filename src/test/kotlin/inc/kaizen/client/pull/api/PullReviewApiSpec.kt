package inc.kaizen.client.pull.api

import inc.kaizen.client.pull.model.*
import inc.kaizen.client.pull.model.pull.Pull
import inc.kaizen.client.pull.model.review.ReviewComment
import inc.kaizen.client.pull.model.reviewer.RequestedReviewer
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class PullReviewApiSpec : FunSpec({
    val api = mockk<PullReviewApi>()
    val owner = "owner"; val repo = "repo"; val pullNumber = 1; val reviewId = 1L
    val review = mockk<PullReview>()
    val reviews = listOf(review)
    val reviewComment = mockk<ReviewComment>()
    val mergeResult = mockk<MergeResult>()
    val requestedReviewer = mockk<RequestedReviewer>()
    val pull = mockk<Pull>()
    val createReviewReq = CreateReviewRequest(event = "APPROVE", body = "LGTM")
    val updateReviewReq = UpdateReviewRequest(body = "Updated")
    val dismissReq = DismissReviewRequest(message = "Dismissing")
    val submitReq = SubmitReviewRequest(body = "LGTM", event = "APPROVE")
    val mergeReq = MergePullRequestRequest(commit_title = "Merge PR")
    val requestReviewersReq = mockk<RequestReviewersRequest>()

    test("listReviews returns reviews") {
        coEvery { api.listReviews(owner, repo, pullNumber, any(), any()) } returns reviews
        runBlocking { api.listReviews(owner, repo, pullNumber) } shouldBe reviews
    }
    test("createReview returns review") {
        coEvery { api.createReview(owner, repo, pullNumber, createReviewReq) } returns review
        runBlocking { api.createReview(owner, repo, pullNumber, createReviewReq) } shouldBe review
    }
    test("getReview returns review") {
        coEvery { api.getReview(owner, repo, pullNumber, reviewId) } returns review
        runBlocking { api.getReview(owner, repo, pullNumber, reviewId) } shouldBe review
    }
    test("updateReview returns review") {
        coEvery { api.updateReview(owner, repo, pullNumber, reviewId, updateReviewReq) } returns review
        runBlocking { api.updateReview(owner, repo, pullNumber, reviewId, updateReviewReq) } shouldBe review
    }
    test("deletePendingReview returns review") {
        coEvery { api.deletePendingReview(owner, repo, pullNumber, reviewId) } returns review
        runBlocking { api.deletePendingReview(owner, repo, pullNumber, reviewId) } shouldBe review
    }
    test("listCommentsForReview returns comments") {
        coEvery { api.listCommentsForReview(owner, repo, pullNumber, reviewId, any(), any()) } returns listOf(reviewComment)
        runBlocking { api.listCommentsForReview(owner, repo, pullNumber, reviewId) } shouldBe listOf(reviewComment)
    }
    test("dismissReview returns review") {
        coEvery { api.dismissReview(owner, repo, pullNumber, reviewId, dismissReq) } returns review
        runBlocking { api.dismissReview(owner, repo, pullNumber, reviewId, dismissReq) } shouldBe review
    }
    test("submitReview returns review") {
        coEvery { api.submitReview(owner, repo, pullNumber, reviewId, submitReq) } returns review
        runBlocking { api.submitReview(owner, repo, pullNumber, reviewId, submitReq) } shouldBe review
    }
    test("mergePullRequest returns merge result") {
        coEvery { api.mergePullRequest(owner, repo, pullNumber, any()) } returns mergeResult
        runBlocking { api.mergePullRequest(owner, repo, pullNumber, mergeReq) } shouldBe mergeResult
    }
    test("getRequestedReviewers returns reviewer") {
        coEvery { api.getRequestedReviewers(owner, repo, pullNumber) } returns requestedReviewer
        runBlocking { api.getRequestedReviewers(owner, repo, pullNumber) } shouldBe requestedReviewer
    }
    test("requestReviewers returns pull") {
        coEvery { api.requestReviewers(owner, repo, pullNumber, requestReviewersReq) } returns pull
        runBlocking { api.requestReviewers(owner, repo, pullNumber, requestReviewersReq) } shouldBe pull
    }
    test("removeRequestedReviewers returns pull") {
        coEvery { api.removeRequestedReviewers(owner, repo, pullNumber, requestReviewersReq) } returns pull
        runBlocking { api.removeRequestedReviewers(owner, repo, pullNumber, requestReviewersReq) } shouldBe pull
    }
})

