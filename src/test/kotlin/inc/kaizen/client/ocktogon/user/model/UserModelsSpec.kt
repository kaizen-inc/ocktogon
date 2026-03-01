package inc.kaizen.client.ocktogon.user.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class UserModelsSpec : StringSpec({

    "SubjectType enum should have correct values" {
        SubjectType.values().size shouldBe 4
        SubjectType.organization.name shouldBe "organization"
        SubjectType.repository.name shouldBe "repository"
        SubjectType.issue.name shouldBe "issue"
        SubjectType.pull_request.name shouldBe "pull_request"
    }

    "Context should instantiate and compare correctly" {
        val ctx = Context(message = "Following", octicon = "person")
        ctx.message shouldBe "Following"
        ctx.octicon shouldBe "person"
    }

    "ContextInfo should instantiate and compare correctly" {
        val ctx = Context(message = "Following", octicon = "person")
        val info = ContextInfo(contexts = listOf(ctx))
        info.contexts.size shouldBe 1
        info.contexts[0] shouldBe ctx
    }

    "UpdateUserRequest should instantiate with all fields" {
        val req = UpdateUserRequest(
            name = "New Name",
            email = "new@example.com",
            blog = "https://blog.example.com",
            twitter_username = "newuser",
            company = "New Company",
            location = "New Location",
            hireable = true,
            bio = "New bio"
        )
        req.name shouldBe "New Name"
        req.email shouldBe "new@example.com"
        req.hireable shouldBe true
    }

    "UpdateUserRequest should instantiate with null defaults" {
        val req = UpdateUserRequest()
        req.name shouldBe null
        req.email shouldBe null
    }

    "UserEmail should instantiate and compare correctly" {
        val email = UserEmail(
            email = "user@example.com",
            primary = true,
            verified = true,
            visibility = "public"
        )
        email.email shouldBe "user@example.com"
        email.primary shouldBe true
        email.verified shouldBe true
    }

    "AddEmailRequest and DeleteEmailRequest should instantiate correctly" {
        val addReq = AddEmailRequest(emails = listOf("new@example.com"))
        val delReq = DeleteEmailRequest(emails = listOf("old@example.com"))
        addReq.emails shouldBe listOf("new@example.com")
        delReq.emails shouldBe listOf("old@example.com")
    }

    "SshKey should instantiate and compare correctly" {
        val key = SshKey(
            id = 1L,
            key = "ssh-rsa AAAA...",
            title = "My SSH Key",
            verified = true,
            created_at = "2025-01-01T00:00:00Z",
            read_only = false,
            url = "https://api.github.com/user/keys/1"
        )
        key.id shouldBe 1L
        key.title shouldBe "My SSH Key"
        key.verified shouldBe true
    }

    "CreateSshKeyRequest should instantiate and compare correctly" {
        val req = CreateSshKeyRequest(title = "My Key", key = "ssh-rsa AAAA...")
        req.title shouldBe "My Key"
        req.key shouldBe "ssh-rsa AAAA..."
    }

    "CreateSshKeyRequest should instantiate without title" {
        val req = CreateSshKeyRequest(key = "ssh-rsa AAAA...")
        req.title shouldBe null
    }

    "GpgKeyEmail should instantiate and compare correctly" {
        val email = GpgKeyEmail(email = "user@example.com", verified = true)
        email.email shouldBe "user@example.com"
        email.verified shouldBe true
    }

    "GpgKey should instantiate and compare correctly" {
        val gpgKey = GpgKey(
            id = 1L,
            name = "My GPG Key",
            key_id = "keyid123",
            can_sign = true,
            can_encrypt_comms = true,
            can_encrypt_storage = false,
            can_certify = true,
            created_at = "2025-01-01T00:00:00Z",
            revoked = false
        )
        gpgKey.id shouldBe 1L
        gpgKey.name shouldBe "My GPG Key"
        gpgKey.can_sign shouldBe true
    }

    "CreateGpgKeyRequest should instantiate and compare correctly" {
        val req = CreateGpgKeyRequest(name = "My GPG Key", armored_public_key = "-----BEGIN PGP PUBLIC KEY BLOCK-----...")
        req.name shouldBe "My GPG Key"
        req.armored_public_key shouldBe "-----BEGIN PGP PUBLIC KEY BLOCK-----..."
    }

    "SocialAccount should instantiate and compare correctly" {
        val account = SocialAccount(provider = "twitter", url = "https://twitter.com/octocat")
        account.provider shouldBe "twitter"
        account.url shouldBe "https://twitter.com/octocat"
    }

    "AddSocialAccountRequest and DeleteSocialAccountRequest should instantiate correctly" {
        val addReq = AddSocialAccountRequest(account_urls = listOf("https://twitter.com/octocat"))
        val delReq = DeleteSocialAccountRequest(account_urls = listOf("https://twitter.com/old"))
        addReq.account_urls shouldBe listOf("https://twitter.com/octocat")
        delReq.account_urls shouldBe listOf("https://twitter.com/old")
    }

    "SshSigningKey should instantiate and compare correctly" {
        val key = SshSigningKey(
            id = 1L,
            key = "ssh-rsa AAAA...",
            title = "My Signing Key",
            created_at = "2025-01-01T00:00:00Z"
        )
        key.id shouldBe 1L
        key.title shouldBe "My Signing Key"
    }
})

