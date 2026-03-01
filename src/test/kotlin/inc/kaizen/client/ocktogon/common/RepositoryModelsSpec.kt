package inc.kaizen.client.ocktogon.common

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RepositoryModelsSpec : StringSpec({

    "RepositoryPermissions should instantiate and compare correctly" {
        val perms = RepositoryPermissions(admin = true, maintain = true, push = true, triage = false, pull = true)
        perms.admin shouldBe true
        perms.push shouldBe true
        perms.triage shouldBe false
    }

    "StatusObject should instantiate and compare correctly" {
        val status = StatusObject(status = "enabled")
        status.status shouldBe "enabled"
    }

    "SecurityAndAnalysis should instantiate and compare correctly" {
        val enabled = StatusObject(status = "enabled")
        val disabled = StatusObject(status = "disabled")
        val secAnalysis = SecurityAndAnalysis(
            advanced_security = enabled,
            secret_scanning = enabled,
            secret_scanning_push_protection = disabled
        )
        secAnalysis.advanced_security?.status shouldBe "enabled"
        secAnalysis.secret_scanning_push_protection?.status shouldBe "disabled"
    }

    "Repository should instantiate with key fields" {
        val owner = User(id = 1, login = "octocat")
        val license = License(key = "mit", name = "MIT License")
        val repo = Repository(
            id = 1,
            node_id = "node123",
            name = "Hello-World",
            full_name = "octocat/Hello-World",
            owner = owner,
            `private` = false,
            html_url = "https://github.com/octocat/Hello-World",
            description = "My first repository",
            fork = false,
            url = "https://api.github.com/repos/octocat/Hello-World",
            created_at = "2011-01-26T19:01:12Z",
            updated_at = "2022-05-10T10:10:10Z",
            pushed_at = "2022-05-10T10:10:10Z",
            homepage = "https://github.com",
            size = 108,
            stargazers_count = 80,
            watchers_count = 80,
            language = "Kotlin",
            has_issues = true,
            has_projects = true,
            has_downloads = true,
            has_wiki = true,
            has_pages = false,
            forks_count = 9,
            archived = false,
            disabled = false,
            open_issues_count = 0,
            license = license,
            visibility = "public",
            default_branch = "main"
        )
        repo.id shouldBe 1
        repo.name shouldBe "Hello-World"
        repo.owner shouldBe owner
        repo.license shouldBe license
        repo.`private` shouldBe false
    }

    "Repository should instantiate with all null defaults" {
        val repo = Repository()
        repo.id shouldBe null
        repo.name shouldBe null
        repo.owner shouldBe null
    }
})

