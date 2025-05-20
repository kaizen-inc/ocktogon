package inc.kaizen.client.page.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PagesSiteSpec : StringSpec({
    "PagesSite, HttpsCertificate, and PagesSource should instantiate and compare correctly" {
        val cert = HttpsCertificate(
            state = "active",
            description = "desc",
            domains = listOf("example.com"),
            expires_at = "2025-12-31T23:59:59Z"
        )
        val source = PagesSource(branch = "main", path = "/docs")
        val site = PagesSite(
            url = "https://example.com",
            status = "built",
            cname = "cname.example.com",
            custom404 = false,
            html_url = "https://example.com/html",
            source = source,
            public = true,
            pending_domain_unverified_at = null,
            protected_domain_state = null,
            https_certificate = cert,
            https_enforced = true
        )
        site.url shouldBe "https://example.com"
        site.https_certificate shouldBe cert
        site.source shouldBe source
    }
})
