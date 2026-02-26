package inc.kaizen.client.user.api

import inc.kaizen.client.common.User
import inc.kaizen.client.user.model.*
import retrofit2.Response
import retrofit2.http.*

interface UserApi {

    @GET("/user")
    suspend fun getAuthenticatedUser(): User

    @PATCH("/user")
    suspend fun updateAuthenticatedUser(@Body body: UpdateUserRequest): User

    @GET("/users")
    suspend fun listUsers(
        @Query("since") since: Int? = null,
        @Query("per_page") perPage: Int = 30
    ): List<User>

    @GET("/users/{username}")
    suspend fun getUser(@Path("username") username: String): User

    @GET("/users/{username}/hovercard")
    suspend fun getUserContextualInfo(
        @Path("username") username: String,
        @Query("subject_type") subjectType: SubjectType? = null,
        @Query("subject_id") subjectId: String? = null
    ): ContextInfo

    @GET("/user/blocks")
    suspend fun listBlockedUsers(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30
    ): List<User>

    @GET("/user/blocks/{username}")
    suspend fun checkIfUserIsBlocked(@Path("username") username: String): Response<Unit>

    @PUT("/user/blocks/{username}")
    suspend fun blockUser(@Path("username") username: String): Response<Unit>

    @DELETE("/user/blocks/{username}")
    suspend fun unblockUser(@Path("username") username: String): Response<Unit>

    @GET("/user/followers")
    suspend fun listFollowersOfAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @GET("/users/{username}/followers")
    suspend fun listFollowersOfUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @GET("/user/following")
    suspend fun listFollowedByAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @GET("/users/{username}/following")
    suspend fun listFollowingForUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<User>

    @GET("/user/following/{username}")
    suspend fun checkIfPersonIsFollowedByAuthenticated(@Path("username") username: String): Response<Unit>

    @PUT("/user/following/{username}")
    suspend fun followUser(@Path("username") username: String): Response<Unit>

    @DELETE("/user/following/{username}")
    suspend fun unfollowUser(@Path("username") username: String): Response<Unit>

    @GET("/users/{username}/following/{target_user}")
    suspend fun checkIfUserFollowsAnother(
        @Path("username") username: String,
        @Path("target_user") targetUser: String
    ): Response<Unit>

    @GET("/user/emails")
    suspend fun listEmailsForAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<UserEmail>

    @POST("/user/emails")
    suspend fun addEmailForAuthenticatedUser(@Body body: AddEmailRequest): List<UserEmail>

    @DELETE("/user/emails")
    suspend fun deleteEmailForAuthenticatedUser(@Body body: DeleteEmailRequest): Response<Unit>

    @GET("/user/public_emails")
    suspend fun listPublicEmailsForAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<UserEmail>

    @GET("/user/keys")
    suspend fun listPublicSshKeysForAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<SshKey>

    @POST("/user/keys")
    suspend fun createPublicSshKeyForAuthenticatedUser(@Body body: CreateSshKeyRequest): SshKey

    @GET("/user/keys/{key_id}")
    suspend fun getPublicSshKeyForAuthenticatedUser(@Path("key_id") keyId: Long): SshKey

    @DELETE("/user/keys/{key_id}")
    suspend fun deletePublicSshKeyForAuthenticatedUser(@Path("key_id") keyId: Long): Response<Unit>

    @GET("/users/{username}/keys")
    suspend fun listPublicKeysForUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<SshKey>

    @GET("/user/gpg_keys")
    suspend fun listGpgKeysForAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<GpgKey>

    @POST("/user/gpg_keys")
    suspend fun createGpgKeyForAuthenticatedUser(@Body body: CreateGpgKeyRequest): GpgKey

    @GET("/user/gpg_keys/{gpg_key_id}")
    suspend fun getGpgKeyForAuthenticatedUser(@Path("gpg_key_id") gpgKeyId: Long): GpgKey

    @DELETE("/user/gpg_keys/{gpg_key_id}")
    suspend fun deleteGpgKeyForAuthenticatedUser(@Path("gpg_key_id") gpgKeyId: Long): Response<Unit>

    @GET("/users/{username}/gpg_keys")
    suspend fun listGpgKeysForUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<GpgKey>

    @GET("/user/social_accounts")
    suspend fun listSocialAccountsForAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<SocialAccount>

    @POST("/user/social_accounts")
    suspend fun addSocialAccountForAuthenticatedUser(@Body body: AddSocialAccountRequest): List<SocialAccount>

    @DELETE("/user/social_accounts")
    suspend fun deleteSocialAccountForAuthenticatedUser(@Body body: DeleteSocialAccountRequest): Response<Unit>

    @GET("/users/{username}/social_accounts")
    suspend fun listSocialAccountsForUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<SocialAccount>

    @GET("/user/ssh_signing_keys")
    suspend fun listSshSigningKeysForAuthenticatedUser(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<SshSigningKey>

    @POST("/user/ssh_signing_keys")
    suspend fun createSshSigningKeyForAuthenticatedUser(@Body body: CreateSshKeyRequest): SshSigningKey

    @GET("/user/ssh_signing_keys/{ssh_signing_key_id}")
    suspend fun getSshSigningKeyForAuthenticatedUser(@Path("ssh_signing_key_id") sshSigningKeyId: Long): SshSigningKey

    @DELETE("/user/ssh_signing_keys/{ssh_signing_key_id}")
    suspend fun deleteSshSigningKeyForAuthenticatedUser(@Path("ssh_signing_key_id") sshSigningKeyId: Long): Response<Unit>

    @GET("/users/{username}/ssh_signing_keys")
    suspend fun listSshSigningKeysForUser(
        @Path("username") username: String,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<SshSigningKey>
}
