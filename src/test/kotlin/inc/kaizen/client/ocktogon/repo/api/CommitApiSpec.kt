package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.ocktogon.repo.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class CommitApiSpec : FunSpec({
    val api = mockk<CommitApi>()
    val owner = "owner"; val repo = "repo"; val sha = "abc123"
    val commit = mockk<RepoCommit>()
    val commits = listOf(commit)
    val comment = mockk<CommitComment>()
    val status = mockk<CommitStatus>()
    val combinedStatus = mockk<CombinedCommitStatus>()
    val comparison = mockk<CommitComparison>()
    val branchShort = mockk<BranchShort>()
    val createCommentReq = CreateCommitCommentRequest(body = "Nice commit")
    val updateCommentReq = UpdateCommitCommentRequest(body = "Updated")
    val createStatusReq = CreateCommitStatusRequest(state = "success")

    test("listCommits returns commits") {
        coEvery { api.listCommits(owner, repo, any(), any(), any(), any(), any(), any(), any(), any()) } returns commits
        runBlocking { api.listCommits(owner, repo) } shouldBe commits
    }
    test("getCommit returns commit") {
        coEvery { api.getCommit(owner, repo, sha, any(), any()) } returns commit
        runBlocking { api.getCommit(owner, repo, sha) } shouldBe commit
    }
    test("listBranchesForHeadCommit returns branches") {
        coEvery { api.listBranchesForHeadCommit(owner, repo, sha) } returns listOf(branchShort)
        runBlocking { api.listBranchesForHeadCommit(owner, repo, sha) } shouldBe listOf(branchShort)
    }
    test("listCommitComments returns comments") {
        coEvery { api.listCommitComments(owner, repo, sha, any(), any()) } returns listOf(comment)
        runBlocking { api.listCommitComments(owner, repo, sha) } shouldBe listOf(comment)
    }
    test("createCommitComment returns comment") {
        coEvery { api.createCommitComment(owner, repo, sha, createCommentReq) } returns comment
        runBlocking { api.createCommitComment(owner, repo, sha, createCommentReq) } shouldBe comment
    }
    test("listCommitCommentsForRepo returns comments") {
        coEvery { api.listCommitCommentsForRepo(owner, repo, any(), any()) } returns listOf(comment)
        runBlocking { api.listCommitCommentsForRepo(owner, repo) } shouldBe listOf(comment)
    }
    test("getCommitComment returns comment") {
        coEvery { api.getCommitComment(owner, repo, 1L) } returns comment
        runBlocking { api.getCommitComment(owner, repo, 1L) } shouldBe comment
    }
    test("updateCommitComment returns comment") {
        coEvery { api.updateCommitComment(owner, repo, 1L, updateCommentReq) } returns comment
        runBlocking { api.updateCommitComment(owner, repo, 1L, updateCommentReq) } shouldBe comment
    }
    test("deleteCommitComment returns response") {
        coEvery { api.deleteCommitComment(owner, repo, 1L) } returns Response.success(Unit)
        runBlocking { api.deleteCommitComment(owner, repo, 1L).isSuccessful } shouldBe true
    }
    test("listCommitStatuses returns statuses") {
        coEvery { api.listCommitStatuses(owner, repo, sha, any(), any()) } returns listOf(status)
        runBlocking { api.listCommitStatuses(owner, repo, sha) } shouldBe listOf(status)
    }
    test("createCommitStatus returns status") {
        coEvery { api.createCommitStatus(owner, repo, sha, createStatusReq) } returns status
        runBlocking { api.createCommitStatus(owner, repo, sha, createStatusReq) } shouldBe status
    }
    test("getCombinedStatusForRef returns combined status") {
        coEvery { api.getCombinedStatusForRef(owner, repo, sha, any(), any()) } returns combinedStatus
        runBlocking { api.getCombinedStatusForRef(owner, repo, sha) } shouldBe combinedStatus
    }
    test("compareCommits returns comparison") {
        coEvery { api.compareCommits(owner, repo, "main...feature", any(), any(), any()) } returns comparison
        runBlocking { api.compareCommits(owner, repo, "main...feature") } shouldBe comparison
    }
})

