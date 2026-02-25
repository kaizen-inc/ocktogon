package inc.kaizen.client.page.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PagesDnsHealthSpec : StringSpec({
    "PagesDnsHealth and Domain should instantiate and compare correctly" {
        val domain = Domain(
            caa_error = null,
            dns_resolves = true,
            enforces_https = true,
            has_cname_record = true,
            has_mx_records_present = false,
            host = "example.com",
            https_error = null,
            is_a_record = false,
            is_apex_domain = false,
            is_cloudflare_ip = false,
            is_cname_to_fastly = false,
            is_cname_to_github_user_domain = false,
            is_cname_to_pages_dot_github_dot_com = true,
            is_fastly_ip = false,
            is_https_eligible = true,
            is_non_github_pages_ip_present = false,
            is_old_ip_address = false,
            is_pages_domain = true,
            is_pointed_to_github_pages_ip = true,
            is_proxied = false,
            is_served_by_pages = true,
            is_valid = true,
            is_valid_domain = true,
            nameservers = "ns1.example.com",
            reason = null,
            responds_to_https = true,
            should_be_a_record = false,
            uri = "https://example.com"
        )
        val dnsHealth = PagesDnsHealth(
            alt_domain = domain,
            domain = domain
        )
        dnsHealth.alt_domain shouldBe domain
        dnsHealth.domain shouldBe domain
    }
})
