package inc.kaizen.client.ocktogon.app.model

import inc.kaizen.client.ocktogon.common.User

data class MarketplacePlan(
    val url: String? = null,
    val accounts_url: String? = null,
    val id: Long? = null,
    val number: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val monthly_price_in_cents: Int? = null,
    val yearly_price_in_cents: Int? = null,
    val price_model: String? = null,
    val has_free_trial: Boolean? = null,
    val unit_name: String? = null,
    val state: String? = null,
    val bullets: List<String>? = null
)

data class MarketplaceAccount(
    val url: String? = null,
    val id: Long? = null,
    val type: String? = null,
    val node_id: String? = null,
    val login: String? = null,
    val email: String? = null,
    val organization_billing_email: String? = null,
    val marketplace_pending_change: MarketplacePendingChange? = null,
    val marketplace_purchase: MarketplacePurchase? = null
)

data class MarketplacePendingChange(
    val is_installed: Boolean? = null,
    val effective_date: String? = null,
    val unit_count: Int? = null,
    val id: Long? = null,
    val plan: MarketplacePlan? = null
)

data class MarketplacePurchase(
    val billing_cycle: String? = null,
    val next_billing_date: String? = null,
    val is_installed: Boolean? = null,
    val unit_count: Int? = null,
    val on_free_trial: Boolean? = null,
    val free_trial_ends_on: String? = null,
    val updated_at: String? = null,
    val plan: MarketplacePlan? = null
)

data class UserMarketplacePurchase(
    val billing_cycle: String? = null,
    val next_billing_date: String? = null,
    val unit_count: Int? = null,
    val on_free_trial: Boolean? = null,
    val free_trial_ends_on: String? = null,
    val updated_at: String? = null,
    val account: MarketplaceAccount? = null,
    val plan: MarketplacePlan? = null
)

data class OAuthToken(
    val id: Int? = null,
    val url: String? = null,
    val scopes: List<String>? = null,
    val token: String? = null,
    val token_last_eight: String? = null,
    val hashed_token: String? = null,
    val app: OAuthApp? = null,
    val note: String? = null,
    val note_url: String? = null,
    val updated_at: String? = null,
    val created_at: String? = null,
    val fingerprint: String? = null,
    val user: User? = null,
    val installation: Any? = null,
    val expires_at: String? = null
)

data class OAuthApp(
    val client_id: String? = null,
    val name: String? = null,
    val url: String? = null
)

data class CheckTokenRequest(val access_token: String)

data class ScopedAccessTokenRequest(
    val access_token: String,
    val target: String? = null,
    val target_id: Int? = null,
    val repositories: List<String>? = null,
    val repository_ids: List<Int>? = null,
    val permissions: Map<String, String>? = null
)

