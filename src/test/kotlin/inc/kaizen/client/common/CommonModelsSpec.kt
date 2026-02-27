package inc.kaizen.client.common

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CommonModelsSpec : StringSpec({

    "HRef should instantiate and compare correctly" {
        val href = HRef(href = "https://example.com")
        href.href shouldBe "https://example.com"
    }

    "HRef should instantiate with null default" {
        val href = HRef()
        href.href shouldBe null
    }

    "PullRequestLinks should instantiate and compare correctly" {
        val href = HRef(href = "https://example.com")
        val links = PullRequestLinks(
            self = href,
            html = href,
            issue = href,
            comments = href,
            review_comments = href,
            review_comment = href,
            commits = href,
            statuses = href
        )
        links.self shouldBe href
        links.html shouldBe href
        links.commits shouldBe href
    }

    "ReviewCommentLinks should instantiate and compare correctly" {
        val href = HRef(href = "https://example.com")
        val links = ReviewCommentLinks(self = href, html = href, pull_request = href)
        links.self shouldBe href
        links.pull_request shouldBe href
    }

    "Actor should instantiate and compare correctly" {
        val actor = Actor(date = "2025-01-01T00:00:00Z", email = "user@example.com", name = "User")
        actor.date shouldBe "2025-01-01T00:00:00Z"
        actor.email shouldBe "user@example.com"
        actor.name shouldBe "User"
    }

    "Verification should instantiate and compare correctly" {
        val verification = Verification(verified = true, reason = "valid", signature = null, payload = null)
        verification.verified shouldBe true
        verification.reason shouldBe "valid"
    }

    "User should instantiate and compare correctly" {
        val user = User(id = 1, login = "octocat", name = "The Octocat", email = "octocat@github.com", site_admin = false, type = "User")
        user.id shouldBe 1
        user.login shouldBe "octocat"
        user.name shouldBe "The Octocat"
        user.site_admin shouldBe false
    }

    "User should instantiate with null defaults" {
        val user = User()
        user.id shouldBe null
        user.login shouldBe null
    }

    "Plan should instantiate and compare correctly" {
        val plan = Plan(name = "free", space = 976562499, private_repos = 10000, collaborators = 0, filled_seats = 1, seats = 1)
        plan.name shouldBe "free"
        plan.space shouldBe 976562499
        plan.collaborators shouldBe 0
    }

    "Plan should instantiate with null defaults" {
        val plan = Plan()
        plan.name shouldBe null
        plan.seats shouldBe null
    }

    "SimpleCommit should instantiate and compare correctly" {
        val commit = SimpleCommit(sha = "abc123", url = "https://api.github.com/repos/o/r/commits/abc123")
        commit.sha shouldBe "abc123"
        commit.url shouldBe "https://api.github.com/repos/o/r/commits/abc123"
    }

    "PagedList should instantiate and compare correctly" {
        val paged = PagedList(total_count = 3, items = listOf("a", "b", "c"))
        paged.total_count shouldBe 3
        paged.items.size shouldBe 3
        paged.items[0] shouldBe "a"
    }

    "PagedList should instantiate with defaults" {
        val paged = PagedList<String>()
        paged.total_count shouldBe 0
        paged.items.size shouldBe 0
    }

    "HookConfig should instantiate and compare correctly" {
        val config = HookConfig(url = "https://example.com/webhook", content_type = "json", secret = "mysecret")
        config.url shouldBe "https://example.com/webhook"
        config.content_type shouldBe "json"
        config.secret shouldBe "mysecret"
    }

    "HookLastResponse should instantiate and compare correctly" {
        val response = HookLastResponse(code = 200, status = "active", message = "OK")
        response.code shouldBe 200
        response.status shouldBe "active"
    }

    "Hook should instantiate and compare correctly" {
        val config = HookConfig(url = "https://example.com/webhook")
        val lastResponse = HookLastResponse(code = 200, status = "active")
        val hook = Hook(
            type = "Repository",
            id = 1,
            name = "web",
            active = true,
            events = listOf("push", "pull_request"),
            config = config,
            updated_at = "2025-06-01T00:00:00Z",
            created_at = "2025-01-01T00:00:00Z",
            url = "https://api.github.com/repos/owner/repo/hooks/1",
            test_url = "https://api.github.com/repos/owner/repo/hooks/1/test",
            ping_url = "https://api.github.com/repos/owner/repo/hooks/1/pings",
            deliveries_url = "https://api.github.com/repos/owner/repo/hooks/1/deliveries",
            last_response = lastResponse
        )
        hook.id shouldBe 1
        hook.active shouldBe true
        hook.events?.size shouldBe 2
        hook.config shouldBe config
    }

    "HookDeliveryRequest and HookDeliveryResponse should instantiate correctly" {
        val req = HookDeliveryRequest(headers = mapOf("Content-Type" to "application/json"), payload = null)
        val resp = HookDeliveryResponse(headers = mapOf("Status" to "200 OK"), payload = "{}")
        req.headers?.get("Content-Type") shouldBe "application/json"
        resp.payload shouldBe "{}"
    }

    "HookDelivery should instantiate and compare correctly" {
        val delivery = HookDelivery(
            id = 1,
            guid = "guid-123",
            delivered_at = "2025-01-01T00:00:00Z",
            redelivery = false,
            duration = 0.5,
            status = "OK",
            status_code = 200,
            event = "push",
            action = null,
            installation_id = null,
            repository_id = 1,
            url = "https://api.github.com/repos/owner/repo/hooks/1/deliveries/1"
        )
        delivery.id shouldBe 1
        delivery.status_code shouldBe 200
        delivery.event shouldBe "push"
    }

    "CreateHookRequest should instantiate with required fields" {
        val config = HookConfig(url = "https://example.com/webhook")
        val req = CreateHookRequest(config = config, events = listOf("push"), active = true)
        req.name shouldBe "web"
        req.config shouldBe config
        req.events shouldBe listOf("push")
    }

    "UpdateHookRequest should instantiate with optional fields" {
        val config = HookConfig(url = "https://example.com/webhook")
        val req = UpdateHookRequest(
            config = config,
            events = listOf("push"),
            add_events = listOf("issues"),
            remove_events = listOf("pull_request"),
            active = true
        )
        req.config shouldBe config
        req.add_events shouldBe listOf("issues")
        req.remove_events shouldBe listOf("pull_request")
    }

    "Label should instantiate and compare correctly" {
        val label = Label(id = 1, node_id = "node", url = "url", name = "bug", color = "d73a4a", default = true, description = "Something isn't working")
        label.name shouldBe "bug"
        label.color shouldBe "d73a4a"
        label.default shouldBe true
    }

    "License should instantiate and compare correctly" {
        val license = License(
            key = "mit",
            name = "MIT License",
            spdx_id = "MIT",
            url = "https://api.github.com/licenses/mit",
            node_id = "MDc6TGljZW5zZTEz",
            featured = true
        )
        license.key shouldBe "mit"
        license.name shouldBe "MIT License"
        license.featured shouldBe true
    }

    "Milestone should instantiate and compare correctly" {
        val milestone = Milestone(
            id = 1,
            node_id = "node",
            number = 1,
            title = "v1.0",
            description = "First milestone",
            state = "open",
            open_issues = 5,
            closed_issues = 3,
            created_at = "2025-01-01T00:00:00Z"
        )
        milestone.title shouldBe "v1.0"
        milestone.state shouldBe "open"
        milestone.open_issues shouldBe 5
    }
})
