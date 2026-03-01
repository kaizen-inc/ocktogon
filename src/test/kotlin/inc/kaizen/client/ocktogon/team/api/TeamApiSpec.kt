package inc.kaizen.client.ocktogon.team.api

import inc.kaizen.client.ocktogon.common.Team
import inc.kaizen.client.ocktogon.team.model.CreateTeamBody
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class TeamApiSpec : FunSpec({
    val api = mockk<TeamApi>()
    val org = "my-org"
    val teamSlug = "my-team"
    val team = mockk<Team>()
    val teamList = listOf(team)
    val createTeamBody = mockk<CreateTeamBody>()

    test("listTeams returns list of teams") {
        coEvery { api.listTeams(org, any(), any()) } returns teamList
        runBlocking {
            api.listTeams(org) shouldBe teamList
        }
    }

    test("createTeam returns created team") {
        coEvery { api.createTeam(org, createTeamBody) } returns team
        runBlocking {
            api.createTeam(org, createTeamBody) shouldBe team
        }
    }

    test("getTeamByName returns team") {
        coEvery { api.getTeamByName(org, teamSlug) } returns team
        runBlocking {
            api.getTeamByName(org, teamSlug) shouldBe team
        }
    }

    test("updateTeam returns updated team") {
        coEvery { api.updateTeam(org, teamSlug, createTeamBody) } returns team
        runBlocking {
            api.updateTeam(org, teamSlug, createTeamBody) shouldBe team
        }
    }

    test("deleteTeam returns unit response") {
        coEvery { api.deleteTeam(org, teamSlug) } returns Response.success(Unit)
        runBlocking {
            api.deleteTeam(org, teamSlug).isSuccessful shouldBe true
        }
    }

    test("listTeamsForAuthenticatedUser returns list of teams") {
        coEvery { api.listTeamsForAuthenticatedUser(any(), any()) } returns teamList
        runBlocking {
            api.listTeamsForAuthenticatedUser() shouldBe teamList
        }
    }
})

