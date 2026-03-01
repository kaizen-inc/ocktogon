package inc.kaizen.client.ocktogon.team.model

import inc.kaizen.client.ocktogon.common.Plan
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OrganizationTest : StringSpec({

    "Organization should instantiate with all fields" {
        val plan = Plan(name = "free", space = 1000, private_repos = 5, collaborators = 3)
        val org = Organization(
            id = 1,
            login = "my-org",
            node_id = "node123",
            url = "https://api.github.com/orgs/my-org",
            repos_url = "https://api.github.com/orgs/my-org/repos",
            events_url = "https://api.github.com/orgs/my-org/events",
            hooks_url = "https://api.github.com/orgs/my-org/hooks",
            issues_url = "https://api.github.com/orgs/my-org/issues",
            members_url = "https://api.github.com/orgs/my-org/members{/member}",
            public_members_url = "https://api.github.com/orgs/my-org/public_members{/member}",
            avatar_url = "https://github.com/images/error/octocat.gif",
            description = "A cool org",
            name = "My Organization",
            company = "My Company",
            blog = "https://blog.example.com",
            location = "San Francisco",
            email = "org@example.com",
            twitter_username = "myorg",
            is_verified = true,
            has_organization_projects = true,
            has_repository_projects = true,
            public_repos = 10,
            public_gists = 2,
            followers = 100,
            following = 5,
            html_url = "https://github.com/my-org",
            type = "Organization",
            total_private_repos = 20,
            owned_private_repos = 20,
            private_gists = 3,
            disk_usage = 50000,
            collaborators = 15,
            billing_email = "billing@example.com",
            plan = plan,
            default_repository_permission = "read",
            members_can_create_repositories = true,
            two_factor_requirement_enabled = false,
            members_allowed_repository_creation_type = "all",
            members_can_create_public_repositories = true,
            members_can_create_private_repositories = true,
            members_can_create_internal_repositories = false,
            members_can_create_pages = true,
            members_can_create_public_pages = true,
            members_can_create_private_pages = false,
            members_can_fork_private_repositories = false,
            web_commit_signoff_required = false,
            created_at = "2025-01-01T00:00:00Z",
            updated_at = "2025-06-01T00:00:00Z",
            archived_at = null
        )
        org.id shouldBe 1
        org.login shouldBe "my-org"
        org.name shouldBe "My Organization"
        org.plan shouldBe plan
        org.is_verified shouldBe true
    }

    "Organization should instantiate with null defaults" {
        val org = Organization()
        org.id shouldBe null
        org.login shouldBe null
        org.plan shouldBe null
    }
})

