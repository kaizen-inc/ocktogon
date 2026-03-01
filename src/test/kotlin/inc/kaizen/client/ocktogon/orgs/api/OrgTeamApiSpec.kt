package inc.kaizen.client.ocktogon.orgs.api

import inc.kaizen.client.ocktogon.common.Repository
import inc.kaizen.client.ocktogon.common.Team
import inc.kaizen.client.ocktogon.common.User
import inc.kaizen.client.ocktogon.orgs.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class OrgTeamApiSpec : FunSpec({
    val api = mockk<OrgTeamApi>()
    val org = "my-org"; val teamSlug = "dev-team"; val username = "octocat"
    val owner = "owner"; val repo = "repo"
    val discussionNumber = 1; val commentNumber = 1
    val team = mockk<Team>()
    val teams = listOf(team)
    val user = mockk<User>()
    val repository = mockk<Repository>()
    val membership = mockk<TeamMembership>()
    val discussion = mockk<TeamDiscussion>()
    val comment = mockk<TeamDiscussionComment>()
    val createTeamReq = mockk<CreateTeamRequest>()
    val updateTeamReq = mockk<UpdateTeamRequest>()
    val createDiscussionReq = mockk<CreateDiscussionRequest>()
    val updateDiscussionReq = mockk<UpdateDiscussionRequest>()
    val createCommentReq = mockk<CreateDiscussionCommentRequest>()

    test("listTeams returns teams") {
        coEvery { api.listTeams(org, any(), any()) } returns teams
        runBlocking { api.listTeams(org) } shouldBe teams
    }
    test("createTeam returns team") {
        coEvery { api.createTeam(org, createTeamReq) } returns team
        runBlocking { api.createTeam(org, createTeamReq) } shouldBe team
    }
    test("getTeamByName returns team") {
        coEvery { api.getTeamByName(org, teamSlug) } returns team
        runBlocking { api.getTeamByName(org, teamSlug) } shouldBe team
    }
    test("updateTeam returns team") {
        coEvery { api.updateTeam(org, teamSlug, updateTeamReq) } returns team
        runBlocking { api.updateTeam(org, teamSlug, updateTeamReq) } shouldBe team
    }
    test("deleteTeam returns response") {
        coEvery { api.deleteTeam(org, teamSlug) } returns Response.success(Unit)
        runBlocking { api.deleteTeam(org, teamSlug).isSuccessful } shouldBe true
    }
    test("listTeamMembers returns users") {
        coEvery { api.listTeamMembers(org, teamSlug, any(), any(), any()) } returns listOf(user)
        runBlocking { api.listTeamMembers(org, teamSlug) } shouldBe listOf(user)
    }
    test("getTeamMembership returns membership") {
        coEvery { api.getTeamMembership(org, teamSlug, username) } returns membership
        runBlocking { api.getTeamMembership(org, teamSlug, username) } shouldBe membership
    }
    test("addOrUpdateTeamMembership returns membership") {
        coEvery { api.addOrUpdateTeamMembership(org, teamSlug, username, any()) } returns membership
        runBlocking { api.addOrUpdateTeamMembership(org, teamSlug, username) } shouldBe membership
    }
    test("removeTeamMembership returns response") {
        coEvery { api.removeTeamMembership(org, teamSlug, username) } returns Response.success(Unit)
        runBlocking { api.removeTeamMembership(org, teamSlug, username).isSuccessful } shouldBe true
    }
    test("listTeamRepos returns repos") {
        coEvery { api.listTeamRepos(org, teamSlug, any(), any()) } returns listOf(repository)
        runBlocking { api.listTeamRepos(org, teamSlug) } shouldBe listOf(repository)
    }
    test("checkTeamPermissionsForRepo returns repo") {
        coEvery { api.checkTeamPermissionsForRepo(org, teamSlug, owner, repo) } returns repository
        runBlocking { api.checkTeamPermissionsForRepo(org, teamSlug, owner, repo) } shouldBe repository
    }
    test("addOrUpdateTeamRepoPermissions returns response") {
        coEvery { api.addOrUpdateTeamRepoPermissions(org, teamSlug, owner, repo, any()) } returns Response.success(Unit)
        runBlocking { api.addOrUpdateTeamRepoPermissions(org, teamSlug, owner, repo).isSuccessful } shouldBe true
    }
    test("removeTeamRepoPermissions returns response") {
        coEvery { api.removeTeamRepoPermissions(org, teamSlug, owner, repo) } returns Response.success(Unit)
        runBlocking { api.removeTeamRepoPermissions(org, teamSlug, owner, repo).isSuccessful } shouldBe true
    }
    test("listChildTeams returns teams") {
        coEvery { api.listChildTeams(org, teamSlug, any(), any()) } returns teams
        runBlocking { api.listChildTeams(org, teamSlug) } shouldBe teams
    }
    test("listDiscussions returns discussions") {
        coEvery { api.listDiscussions(org, teamSlug, any(), any(), any(), any()) } returns listOf(discussion)
        runBlocking { api.listDiscussions(org, teamSlug) } shouldBe listOf(discussion)
    }
    test("createDiscussion returns discussion") {
        coEvery { api.createDiscussion(org, teamSlug, createDiscussionReq) } returns discussion
        runBlocking { api.createDiscussion(org, teamSlug, createDiscussionReq) } shouldBe discussion
    }
    test("getDiscussion returns discussion") {
        coEvery { api.getDiscussion(org, teamSlug, discussionNumber) } returns discussion
        runBlocking { api.getDiscussion(org, teamSlug, discussionNumber) } shouldBe discussion
    }
    test("updateDiscussion returns discussion") {
        coEvery { api.updateDiscussion(org, teamSlug, discussionNumber, updateDiscussionReq) } returns discussion
        runBlocking { api.updateDiscussion(org, teamSlug, discussionNumber, updateDiscussionReq) } shouldBe discussion
    }
    test("deleteDiscussion returns response") {
        coEvery { api.deleteDiscussion(org, teamSlug, discussionNumber) } returns Response.success(Unit)
        runBlocking { api.deleteDiscussion(org, teamSlug, discussionNumber).isSuccessful } shouldBe true
    }
    test("listDiscussionComments returns comments") {
        coEvery { api.listDiscussionComments(org, teamSlug, discussionNumber, any(), any(), any()) } returns listOf(comment)
        runBlocking { api.listDiscussionComments(org, teamSlug, discussionNumber) } shouldBe listOf(comment)
    }
    test("createDiscussionComment returns comment") {
        coEvery { api.createDiscussionComment(org, teamSlug, discussionNumber, createCommentReq) } returns comment
        runBlocking { api.createDiscussionComment(org, teamSlug, discussionNumber, createCommentReq) } shouldBe comment
    }
    test("getDiscussionComment returns comment") {
        coEvery { api.getDiscussionComment(org, teamSlug, discussionNumber, commentNumber) } returns comment
        runBlocking { api.getDiscussionComment(org, teamSlug, discussionNumber, commentNumber) } shouldBe comment
    }
    test("updateDiscussionComment returns comment") {
        coEvery { api.updateDiscussionComment(org, teamSlug, discussionNumber, commentNumber, createCommentReq) } returns comment
        runBlocking { api.updateDiscussionComment(org, teamSlug, discussionNumber, commentNumber, createCommentReq) } shouldBe comment
    }
    test("deleteDiscussionComment returns response") {
        coEvery { api.deleteDiscussionComment(org, teamSlug, discussionNumber, commentNumber) } returns Response.success(Unit)
        runBlocking { api.deleteDiscussionComment(org, teamSlug, discussionNumber, commentNumber).isSuccessful } shouldBe true
    }
    test("listTeamsForAuthenticatedUser returns teams") {
        coEvery { api.listTeamsForAuthenticatedUser(any(), any()) } returns teams
        runBlocking { api.listTeamsForAuthenticatedUser() } shouldBe teams
    }
})

