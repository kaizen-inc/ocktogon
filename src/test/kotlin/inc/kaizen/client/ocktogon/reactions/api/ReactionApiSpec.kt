package inc.kaizen.client.ocktogon.reactions.api

import inc.kaizen.client.ocktogon.reactions.model.CreateReactionRequest
import inc.kaizen.client.ocktogon.reactions.model.Reaction
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class ReactionApiSpec : FunSpec({
    val api = mockk<ReactionApi>()
    val owner = "owner"; val repo = "repo"
    val commentId = 1L; val issueNumber = 1; val prNumber = 1
    val discussionNumber = 1; val reactionId = 1L; val teamSlug = "team"; val org = "org"
    val reaction = mockk<Reaction>()
    val reactions = listOf(reaction)
    val createReq = CreateReactionRequest(content = "+1")

    test("listReactionsForCommitComment returns reactions") {
        coEvery { api.listReactionsForCommitComment(owner, repo, commentId, any(), any(), any()) } returns reactions
        runBlocking { api.listReactionsForCommitComment(owner, repo, commentId) shouldBe reactions }
    }
    test("createReactionForCommitComment returns reaction") {
        coEvery { api.createReactionForCommitComment(owner, repo, commentId, createReq) } returns reaction
        runBlocking { api.createReactionForCommitComment(owner, repo, commentId, createReq) shouldBe reaction }
    }
    test("deleteReactionForCommitComment returns response") {
        coEvery { api.deleteReactionForCommitComment(owner, repo, commentId, reactionId) } returns Response.success(Unit)
        runBlocking { api.deleteReactionForCommitComment(owner, repo, commentId, reactionId).isSuccessful shouldBe true }
    }
    test("listReactionsForIssue returns reactions") {
        coEvery { api.listReactionsForIssue(owner, repo, issueNumber, any(), any(), any()) } returns reactions
        runBlocking { api.listReactionsForIssue(owner, repo, issueNumber) shouldBe reactions }
    }
    test("createReactionForIssue returns reaction") {
        coEvery { api.createReactionForIssue(owner, repo, issueNumber, createReq) } returns reaction
        runBlocking { api.createReactionForIssue(owner, repo, issueNumber, createReq) shouldBe reaction }
    }
    test("deleteReactionForIssue returns response") {
        coEvery { api.deleteReactionForIssue(owner, repo, issueNumber, reactionId) } returns Response.success(Unit)
        runBlocking { api.deleteReactionForIssue(owner, repo, issueNumber, reactionId).isSuccessful shouldBe true }
    }
    test("listReactionsForIssueComment returns reactions") {
        coEvery { api.listReactionsForIssueComment(owner, repo, commentId, any(), any(), any()) } returns reactions
        runBlocking { api.listReactionsForIssueComment(owner, repo, commentId) shouldBe reactions }
    }
    test("createReactionForIssueComment returns reaction") {
        coEvery { api.createReactionForIssueComment(owner, repo, commentId, createReq) } returns reaction
        runBlocking { api.createReactionForIssueComment(owner, repo, commentId, createReq) shouldBe reaction }
    }
    test("deleteReactionForIssueComment returns response") {
        coEvery { api.deleteReactionForIssueComment(owner, repo, commentId, reactionId) } returns Response.success(Unit)
        runBlocking { api.deleteReactionForIssueComment(owner, repo, commentId, reactionId).isSuccessful shouldBe true }
    }
    test("listReactionsForPullRequestReviewComment returns reactions") {
        coEvery { api.listReactionsForPullRequestReviewComment(owner, repo, commentId, any(), any(), any()) } returns reactions
        runBlocking { api.listReactionsForPullRequestReviewComment(owner, repo, commentId) shouldBe reactions }
    }
    test("createReactionForPullRequestReviewComment returns reaction") {
        coEvery { api.createReactionForPullRequestReviewComment(owner, repo, commentId, createReq) } returns reaction
        runBlocking { api.createReactionForPullRequestReviewComment(owner, repo, commentId, createReq) shouldBe reaction }
    }
    test("deleteReactionForPullRequestReviewComment returns response") {
        coEvery { api.deleteReactionForPullRequestReviewComment(owner, repo, commentId, reactionId) } returns Response.success(Unit)
        runBlocking { api.deleteReactionForPullRequestReviewComment(owner, repo, commentId, reactionId).isSuccessful shouldBe true }
    }
    test("listReactionsForTeamDiscussion returns reactions") {
        coEvery { api.listReactionsForTeamDiscussion(org, teamSlug, discussionNumber, any(), any(), any()) } returns reactions
        runBlocking { api.listReactionsForTeamDiscussion(org, teamSlug, discussionNumber) shouldBe reactions }
    }
    test("createReactionForTeamDiscussion returns reaction") {
        coEvery { api.createReactionForTeamDiscussion(org, teamSlug, discussionNumber, createReq) } returns reaction
        runBlocking { api.createReactionForTeamDiscussion(org, teamSlug, discussionNumber, createReq) shouldBe reaction }
    }
    test("deleteReactionForTeamDiscussion returns response") {
        coEvery { api.deleteReactionForTeamDiscussion(org, teamSlug, discussionNumber, reactionId) } returns Response.success(Unit)
        runBlocking { api.deleteReactionForTeamDiscussion(org, teamSlug, discussionNumber, reactionId).isSuccessful shouldBe true }
    }
    test("listReactionsForTeamDiscussionComment returns reactions") {
        coEvery { api.listReactionsForTeamDiscussionComment(org, teamSlug, discussionNumber, commentId.toInt(), any(), any(), any()) } returns reactions
        runBlocking { api.listReactionsForTeamDiscussionComment(org, teamSlug, discussionNumber, commentId.toInt()) shouldBe reactions }
    }
    test("createReactionForTeamDiscussionComment returns reaction") {
        coEvery { api.createReactionForTeamDiscussionComment(org, teamSlug, discussionNumber, commentId.toInt(), createReq) } returns reaction
        runBlocking { api.createReactionForTeamDiscussionComment(org, teamSlug, discussionNumber, commentId.toInt(), createReq) shouldBe reaction }
    }
    test("deleteReactionForTeamDiscussionComment returns response") {
        coEvery { api.deleteReactionForTeamDiscussionComment(org, teamSlug, discussionNumber, commentId.toInt(), reactionId) } returns Response.success(Unit)
        runBlocking { api.deleteReactionForTeamDiscussionComment(org, teamSlug, discussionNumber, commentId.toInt(), reactionId).isSuccessful shouldBe true }
    }
})

