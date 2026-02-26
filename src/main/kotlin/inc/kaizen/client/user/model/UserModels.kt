package inc.kaizen.client.user.model

data class UpdateUserRequest(
    val name: String? = null,
    val email: String? = null,
    val blog: String? = null,
    val twitter_username: String? = null,
    val company: String? = null,
    val location: String? = null,
    val hireable: Boolean? = null,
    val bio: String? = null
)

data class UserEmail(
    val email: String? = null,
    val primary: Boolean? = null,
    val verified: Boolean? = null,
    val visibility: String? = null
)

data class AddEmailRequest(val emails: List<String>)
data class DeleteEmailRequest(val emails: List<String>)

data class SshKey(
    val id: Long? = null,
    val key: String? = null,
    val title: String? = null,
    val verified: Boolean? = null,
    val created_at: String? = null,
    val read_only: Boolean? = null,
    val url: String? = null
)

data class CreateSshKeyRequest(val title: String? = null, val key: String)

data class GpgKey(
    val id: Long? = null,
    val name: String? = null,
    val primary_key_id: Long? = null,
    val key_id: String? = null,
    val public_key: String? = null,
    val emails: List<GpgKeyEmail>? = null,
    val subkeys: List<GpgKey>? = null,
    val can_sign: Boolean? = null,
    val can_encrypt_comms: Boolean? = null,
    val can_encrypt_storage: Boolean? = null,
    val can_certify: Boolean? = null,
    val created_at: String? = null,
    val expires_at: String? = null,
    val revoked: Boolean? = null,
    val raw_key: String? = null
)

data class GpgKeyEmail(val email: String? = null, val verified: Boolean? = null)
data class CreateGpgKeyRequest(val name: String? = null, val armored_public_key: String)

data class SocialAccount(
    val provider: String? = null,
    val url: String? = null
)

data class AddSocialAccountRequest(val account_urls: List<String>)
data class DeleteSocialAccountRequest(val account_urls: List<String>)

data class SshSigningKey(
    val id: Long? = null,
    val key: String? = null,
    val title: String? = null,
    val created_at: String? = null
)

