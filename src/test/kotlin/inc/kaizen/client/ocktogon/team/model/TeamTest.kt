package inc.kaizen.client.ocktogon.team.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TeamTest : StringSpec({

    "Team should instantiate with all fields" {
        val parentTeam = Team(id = 1, name = "parent-team", slug = "parent-team")
        val org = Organization(id = 10, login = "my-org", name = "My Org")
        val team = Team(
            id = 2,
            node_id = "node123",
            url = "https://api.github.com/teams/2",
            html_url = "https://github.com/orgs/my-org/teams/my-team",
            name = "my-team",
            slug = "my-team",
            description = "A team",
            privacy = "closed",
            notification_setting = "notifications_enabled",
            permission = "push",
            members_url = "https://api.github.com/teams/2/members{/member}",
            repositories_url = "https://api.github.com/teams/2/repos",
            parent = parentTeam,
            members_count = 5,
            repos_count = 3,
            created_at = "2025-01-01T00:00:00Z",
            updated_at = "2025-06-01T00:00:00Z",
            organization = org
        )
        team.id shouldBe 2
        team.name shouldBe "my-team"
        team.slug shouldBe "my-team"
        team.parent shouldBe parentTeam
        team.organization shouldBe org
    }

    "Team should instantiate with null defaults" {
        val team = Team()
        team.id shouldBe null
        team.name shouldBe null
        team.parent shouldBe null
    }

    "CreateTeamBody should instantiate with all fields" {
        val body = CreateTeamBody(
            name = "new-team",
            description = "A new team",
            maintainers = listOf("user1", "user2"),
            repo_names = listOf("org/repo1"),
            privacy = "closed",
            notification_setting = "notifications_enabled",
            permission = "push",
            parent_team_id = 1
        )
        body.name shouldBe "new-team"
        body.description shouldBe "A new team"
        body.maintainers shouldBe listOf("user1", "user2")
        body.parent_team_id shouldBe 1
    }

    "CreateTeamBody should instantiate with only required name field" {
        val body = CreateTeamBody(name = "minimal-team")
        body.name shouldBe "minimal-team"
        body.description shouldBe null
        body.privacy shouldBe null
    }
})

