package inc.kaizen.client.ocktogon.action.model.oidc

data class OIDCTemplate(
    val use_default: Boolean? = false,
    val include_claim_keys: List<String>
)