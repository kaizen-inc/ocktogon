package inc.kaizen.client.ocktogon.user.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class UserTest : StringSpec({

    "User should instantiate with all fields" {
        val plan = Plan(name = "pro", space = 5000, private_repos = 100, collaborators = 10)
        val user = User(
            id = 1,
            login = "octocat",
            node_id = "MDQ6VXNlcjE=",
            avatar_url = "https://github.com/images/error/octocat.gif",
            gravatar_id = "",
            url = "https://api.github.com/users/octocat",
            html_url = "https://github.com/octocat",
            followers_url = "https://api.github.com/users/octocat/followers",
            following_url = "https://api.github.com/users/octocat/following{/other_user}",
            gists_url = "https://api.github.com/users/octocat/gists{/gist_id}",
            starred_url = "https://api.github.com/users/octocat/starred{/owner}{/repo}",
            subscriptions_url = "https://api.github.com/users/octocat/subscriptions",
            organizations_url = "https://api.github.com/users/octocat/orgs",
            repos_url = "https://api.github.com/users/octocat/repos",
            events_url = "https://api.github.com/users/octocat/events{/privacy}",
            received_events_url = "https://api.github.com/users/octocat/received_events",
            type = "User",
            site_admin = false,
            name = "The Octocat",
            company = "GitHub",
            blog = "https://github.com/blog",
            location = "San Francisco",
            email = "octocat@github.com",
            hireable = false,
            bio = "A cool user",
            twitter_username = "octocat",
            public_repos = 2,
            public_gists = 1,
            followers = 20,
            following = 0,
            created_at = "2011-01-25T18:44:36Z",
            updated_at = "2022-05-10T08:00:00Z",
            private_gists = 3,
            total_private_repos = 5,
            owned_private_repos = 5,
            disk_usage = 10000,
            collaborators = 2,
            two_factor_authentication = true,
            plan = plan
        )
        user.id shouldBe 1
        user.login shouldBe "octocat"
        user.name shouldBe "The Octocat"
        user.plan shouldBe plan
        user.site_admin shouldBe false
    }

    "User should instantiate with null defaults" {
        val user = User()
        user.id shouldBe null
        user.login shouldBe null
        user.plan shouldBe null
    }
})

