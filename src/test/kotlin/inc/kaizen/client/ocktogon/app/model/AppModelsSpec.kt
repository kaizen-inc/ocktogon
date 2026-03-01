package inc.kaizen.client.ocktogon.app.model

import inc.kaizen.client.ocktogon.app.model.installation.InstallationAccessTokenRequest
import inc.kaizen.client.ocktogon.app.model.installation.Permissions
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AppModelsSpec : StringSpec({

    "App should instantiate and compare correctly" {
        val app = App(
            id = 1L, slug = "my-app", node_id = "node", name = "My App",
            owner = null, description = "desc", external_url = "https://example.com",
            html_url = "https://github.com/apps/my-app", created_at = "2025-01-01T00:00:00Z",
            updated_at = "2025-06-01T00:00:00Z", permissions = mapOf("issues" to "write"),
            events = listOf("push"), client_id = "cid", client_secret = null,
            webhook_secret = null, pem = null
        )
        app.id shouldBe 1L
        app.name shouldBe "My App"
        app.permissions?.get("issues") shouldBe "write"
    }

    "Installation should instantiate and compare correctly" {
        val install = Installation(
            id = 1L, account = null, app_id = 10L, app_slug = "my-app",
            target_id = 100L, target_type = "Organization", permissions = mapOf("issues" to "write"),
            events = listOf("push"), created_at = "2025-01-01T00:00:00Z",
            updated_at = "2025-06-01T00:00:00Z", single_file_name = null,
            repository_selection = "all", access_tokens_url = "url",
            repositories_url = "url", html_url = "url",
            has_multiple_single_files = false, single_file_paths = null
        )
        install.id shouldBe 1L
        install.repository_selection shouldBe "all"
    }

    "Installations should instantiate and compare correctly" {
        val install = Installation(id = 1L, account = null, app_id = 10L, app_slug = "app",
            target_id = null, target_type = null, permissions = null, events = null,
            created_at = null, updated_at = null, single_file_name = null,
            repository_selection = null, access_tokens_url = null, repositories_url = null,
            html_url = null, has_multiple_single_files = null, single_file_paths = null)
        val installations = Installations(total_count = 1, installations = listOf(install))
        installations.total_count shouldBe 1
        installations.installations.size shouldBe 1
    }

    "InstallationRequest should instantiate and compare correctly" {
        val req = InstallationRequest(id = 1L, node_id = "node", account = null, requester = null, created_at = null)
        req.id shouldBe 1L
    }

    "MarketplacePlan should instantiate and compare correctly" {
        val plan = MarketplacePlan(id = 1L, name = "Free", monthly_price_in_cents = 0, state = "active")
        plan.id shouldBe 1L
        plan.name shouldBe "Free"
    }

    "MarketplacePendingChange should instantiate and compare correctly" {
        val change = MarketplacePendingChange(is_installed = true, effective_date = "2025-01-01", unit_count = 1, id = 1L, plan = null)
        change.is_installed shouldBe true
    }

    "MarketplacePurchase should instantiate and compare correctly" {
        val purchase = MarketplacePurchase(billing_cycle = "monthly", is_installed = true, on_free_trial = false)
        purchase.billing_cycle shouldBe "monthly"
    }

    "MarketplaceAccount should instantiate and compare correctly" {
        val account = MarketplaceAccount(url = "url", id = 1L, type = "Organization", login = "my-org")
        account.login shouldBe "my-org"
        account.type shouldBe "Organization"
    }

    "UserMarketplacePurchase should instantiate and compare correctly" {
        val purchase = UserMarketplacePurchase(billing_cycle = "monthly", on_free_trial = false)
        purchase.billing_cycle shouldBe "monthly"
    }

    "OAuthApp should instantiate and compare correctly" {
        val app = OAuthApp(client_id = "cid", name = "My OAuth App", url = "url")
        app.name shouldBe "My OAuth App"
    }

    "OAuthToken should instantiate and compare correctly" {
        val token = OAuthToken(id = 1, token = "gho_abc123", app = OAuthApp(client_id = "cid", name = "App"))
        token.token shouldBe "gho_abc123"
    }

    "CheckTokenRequest should instantiate and compare correctly" {
        val req = CheckTokenRequest(access_token = "gho_abc123")
        req.access_token shouldBe "gho_abc123"
    }

    "ScopedAccessTokenRequest should instantiate and compare correctly" {
        val req = ScopedAccessTokenRequest(access_token = "gho_abc123", target = "my-org", repositories = listOf("repo1"))
        req.access_token shouldBe "gho_abc123"
        req.target shouldBe "my-org"
    }

    "InstallationAccessTokenRequest should instantiate and compare correctly" {
        val req = InstallationAccessTokenRequest(repositories = listOf("repo1"), repository_ids = null, permissions = null)
        req.repositories shouldBe listOf("repo1")
    }

    "Permissions should instantiate and compare correctly" {
        val perms = Permissions(actions = "write", issues = "read", contents = "write")
        perms.actions shouldBe "write"
        perms.issues shouldBe "read"
    }
})

