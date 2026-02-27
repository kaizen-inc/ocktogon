package inc.kaizen.client.meta.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MetaModelsSpec : StringSpec({

    "GitHubMetaDomains should instantiate and compare correctly" {
        val domains = GitHubMetaDomains(
            website = listOf("github.com"),
            codespaces = listOf("codespaces.github.com"),
            copilot = listOf("copilot.github.com"),
            packages = listOf("pkg.github.com"),
            actions = listOf("actions.github.com")
        )
        domains.website shouldBe listOf("github.com")
        domains.actions shouldBe listOf("actions.github.com")
    }

    "GitHubMeta should instantiate and compare correctly" {
        val meta = GitHubMeta(
            verifiable_password_authentication = true,
            ssh_keys = listOf("key1", "key2"),
            hooks = listOf("192.30.252.0/22"),
            web = listOf("192.30.252.0/22"),
            api = listOf("192.30.252.0/22"),
            git = listOf("192.30.252.0/22"),
            packages = listOf("192.30.252.0/22"),
            pages = listOf("192.30.252.153/32"),
            actions = listOf("192.30.252.153/32"),
            dependabot = listOf("192.30.252.153/32")
        )
        meta.verifiable_password_authentication shouldBe true
        meta.ssh_keys?.size shouldBe 2
    }

    "GitHubMeta should instantiate with null defaults" {
        val meta = GitHubMeta()
        meta.verifiable_password_authentication shouldBe null
        meta.ssh_keys shouldBe null
    }
})

