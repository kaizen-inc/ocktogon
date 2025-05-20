package inc.kaizen.client.page.model

data class PagesDnsHealth(
    val alt_domain: Domain,
    val domain: Domain
)

data class Domain(
    val caa_error: Any?,
    val dns_resolves: Boolean,
    val enforces_https: Boolean,
    val has_cname_record: Boolean,
    val has_mx_records_present: Boolean,
    val host: String,
    val https_error: Any?,
    val is_a_record: Boolean,
    val is_apex_domain: Boolean,
    val is_cloudflare_ip: Boolean,
    val is_cname_to_fastly: Boolean,
    val is_cname_to_github_user_domain: Boolean,
    val is_cname_to_pages_dot_github_dot_com: Boolean,
    val is_fastly_ip: Boolean,
    val is_https_eligible: Boolean,
    val is_non_github_pages_ip_present: Boolean,
    val is_old_ip_address: Boolean,
    val is_pages_domain: Boolean,
    val is_pointed_to_github_pages_ip: Boolean,
    val is_proxied: Boolean,
    val is_served_by_pages: Boolean,
    val is_valid: Boolean,
    val is_valid_domain: Boolean,
    val nameservers: String,
    val reason: Any?,
    val responds_to_https: Boolean,
    val should_be_a_record: Boolean,
    val uri: String
)