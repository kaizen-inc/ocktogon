package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.repo.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class BranchApiSpec : FunSpec({
    val api = mockk<BranchApi>()
    val owner = "owner"; val repo = "repo"; val branch = "main"
    val branchObj = mockk<Branch>()
    val branches = listOf(branchObj)
    val protection = mockk<BranchProtection>()
    val adminEnforced = mockk<ProtectedBranchAdminEnforced>()
    val restrictions = mockk<BranchRestrictionPolicy>()
    val statusChecks = mockk<RequiredStatusChecks>()
    val prReviews = mockk<RequiredPullRequestReviews>()
    val commit = mockk<inc.kaizen.client.repo.model.RepoCommit>()

    test("listBranches returns branches") {
        coEvery { api.listBranches(owner, repo, any(), any(), any()) } returns branches
        runBlocking { api.listBranches(owner, repo) } shouldBe branches
    }
    test("getBranch returns branch") {
        coEvery { api.getBranch(owner, repo, branch) } returns branchObj
        runBlocking { api.getBranch(owner, repo, branch) } shouldBe branchObj
    }
    test("renameBranch returns branch") {
        val req = RenameBranchRequest(new_name = "new-main")
        coEvery { api.renameBranch(owner, repo, branch, req) } returns branchObj
        runBlocking { api.renameBranch(owner, repo, branch, req) } shouldBe branchObj
    }
    test("mergeBranch returns commit") {
        val req = MergeBranchRequest(base = "main", head = "feature")
        coEvery { api.mergeBranch(owner, repo, req) } returns commit
        runBlocking { api.mergeBranch(owner, repo, req) } shouldBe commit
    }
    test("mergeUpstream returns response") {
        val req = MergeUpstreamRequest(branch = "main")
        val resp = mockk<MergeUpstreamResponse>()
        coEvery { api.mergeUpstream(owner, repo, req) } returns resp
        runBlocking { api.mergeUpstream(owner, repo, req) } shouldBe resp
    }
    test("getBranchProtection returns protection") {
        coEvery { api.getBranchProtection(owner, repo, branch) } returns protection
        runBlocking { api.getBranchProtection(owner, repo, branch) } shouldBe protection
    }
    test("deleteBranchProtection returns response") {
        coEvery { api.deleteBranchProtection(owner, repo, branch) } returns Response.success(Unit)
        runBlocking { api.deleteBranchProtection(owner, repo, branch).isSuccessful } shouldBe true
    }
    test("getStatusChecksProtection returns status checks") {
        coEvery { api.getStatusChecksProtection(owner, repo, branch) } returns statusChecks
        runBlocking { api.getStatusChecksProtection(owner, repo, branch) } shouldBe statusChecks
    }
    test("removeStatusChecksProtection returns response") {
        coEvery { api.removeStatusChecksProtection(owner, repo, branch) } returns Response.success(Unit)
        runBlocking { api.removeStatusChecksProtection(owner, repo, branch).isSuccessful } shouldBe true
    }
    test("getPullRequestReviewProtection returns reviews") {
        coEvery { api.getPullRequestReviewProtection(owner, repo, branch) } returns prReviews
        runBlocking { api.getPullRequestReviewProtection(owner, repo, branch) } shouldBe prReviews
    }
    test("deletePullRequestReviewProtection returns response") {
        coEvery { api.deletePullRequestReviewProtection(owner, repo, branch) } returns Response.success(Unit)
        runBlocking { api.deletePullRequestReviewProtection(owner, repo, branch).isSuccessful } shouldBe true
    }
    test("getAdminBranchProtection returns admin enforced") {
        coEvery { api.getAdminBranchProtection(owner, repo, branch) } returns adminEnforced
        runBlocking { api.getAdminBranchProtection(owner, repo, branch) } shouldBe adminEnforced
    }
    test("setAdminBranchProtection returns admin enforced") {
        coEvery { api.setAdminBranchProtection(owner, repo, branch) } returns adminEnforced
        runBlocking { api.setAdminBranchProtection(owner, repo, branch) } shouldBe adminEnforced
    }
    test("deleteAdminBranchProtection returns response") {
        coEvery { api.deleteAdminBranchProtection(owner, repo, branch) } returns Response.success(Unit)
        runBlocking { api.deleteAdminBranchProtection(owner, repo, branch).isSuccessful } shouldBe true
    }
    test("getAccessRestrictions returns restrictions") {
        coEvery { api.getAccessRestrictions(owner, repo, branch) } returns restrictions
        runBlocking { api.getAccessRestrictions(owner, repo, branch) } shouldBe restrictions
    }
    test("deleteAccessRestrictions returns response") {
        coEvery { api.deleteAccessRestrictions(owner, repo, branch) } returns Response.success(Unit)
        runBlocking { api.deleteAccessRestrictions(owner, repo, branch).isSuccessful } shouldBe true
    }
    test("getAppsWithAccessToProtectedBranch returns list") {
        coEvery { api.getAppsWithAccessToProtectedBranch(owner, repo, branch) } returns listOf()
        runBlocking { api.getAppsWithAccessToProtectedBranch(owner, repo, branch) } shouldBe listOf()
    }
    test("getTeamsWithAccessToProtectedBranch returns list") {
        coEvery { api.getTeamsWithAccessToProtectedBranch(owner, repo, branch) } returns listOf()
        runBlocking { api.getTeamsWithAccessToProtectedBranch(owner, repo, branch) } shouldBe listOf()
    }
    test("getUsersWithAccessToProtectedBranch returns list") {
        coEvery { api.getUsersWithAccessToProtectedBranch(owner, repo, branch) } returns listOf()
        runBlocking { api.getUsersWithAccessToProtectedBranch(owner, repo, branch) } shouldBe listOf()
    }
})

