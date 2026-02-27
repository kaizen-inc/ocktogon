package inc.kaizen.client.user.api

import inc.kaizen.client.common.User
import inc.kaizen.client.user.model.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class UserApiSpec : FunSpec({
    val api = mockk<UserApi>()
    val username = "octocat"
    val targetUser = "target"
    val keyId = 1L
    val gpgKeyId = 2L
    val sshSigningKeyId = 3L
    val user = mockk<User>()
    val userList = listOf(user)
    val updateUserRequest = mockk<UpdateUserRequest>()
    val contextInfo = mockk<ContextInfo>()
    val userEmail = mockk<UserEmail>()
    val userEmailList = listOf(userEmail)
    val addEmailRequest = mockk<AddEmailRequest>()
    val deleteEmailRequest = mockk<DeleteEmailRequest>()
    val sshKey = mockk<SshKey>()
    val sshKeyList = listOf(sshKey)
    val createSshKeyRequest = mockk<CreateSshKeyRequest>()
    val gpgKey = mockk<GpgKey>()
    val gpgKeyList = listOf(gpgKey)
    val createGpgKeyRequest = mockk<CreateGpgKeyRequest>()
    val socialAccount = mockk<SocialAccount>()
    val socialAccountList = listOf(socialAccount)
    val addSocialAccountRequest = mockk<AddSocialAccountRequest>()
    val deleteSocialAccountRequest = mockk<DeleteSocialAccountRequest>()
    val sshSigningKey = mockk<SshSigningKey>()
    val sshSigningKeyList = listOf(sshSigningKey)

    test("getAuthenticatedUser returns user") {
        coEvery { api.getAuthenticatedUser() } returns user
        runBlocking { api.getAuthenticatedUser() shouldBe user }
    }

    test("updateAuthenticatedUser returns user") {
        coEvery { api.updateAuthenticatedUser(updateUserRequest) } returns user
        runBlocking { api.updateAuthenticatedUser(updateUserRequest) shouldBe user }
    }

    test("listUsers returns user list") {
        coEvery { api.listUsers(any(), any()) } returns userList
        runBlocking { api.listUsers() shouldBe userList }
    }

    test("getUser returns user") {
        coEvery { api.getUser(username) } returns user
        runBlocking { api.getUser(username) shouldBe user }
    }

    test("getUserContextualInfo returns context info") {
        coEvery { api.getUserContextualInfo(username, any(), any()) } returns contextInfo
        runBlocking { api.getUserContextualInfo(username) shouldBe contextInfo }
    }

    test("listBlockedUsers returns user list") {
        coEvery { api.listBlockedUsers(any(), any()) } returns userList
        runBlocking { api.listBlockedUsers() shouldBe userList }
    }

    test("checkIfUserIsBlocked returns unit response") {
        coEvery { api.checkIfUserIsBlocked(username) } returns Response.success(Unit)
        runBlocking { api.checkIfUserIsBlocked(username).isSuccessful shouldBe true }
    }

    test("blockUser returns unit response") {
        coEvery { api.blockUser(username) } returns Response.success(Unit)
        runBlocking { api.blockUser(username).isSuccessful shouldBe true }
    }

    test("unblockUser returns unit response") {
        coEvery { api.unblockUser(username) } returns Response.success(Unit)
        runBlocking { api.unblockUser(username).isSuccessful shouldBe true }
    }

    test("listFollowersOfAuthenticatedUser returns user list") {
        coEvery { api.listFollowersOfAuthenticatedUser(any(), any()) } returns userList
        runBlocking { api.listFollowersOfAuthenticatedUser() shouldBe userList }
    }

    test("listFollowersOfUser returns user list") {
        coEvery { api.listFollowersOfUser(username, any(), any()) } returns userList
        runBlocking { api.listFollowersOfUser(username) shouldBe userList }
    }

    test("listFollowedByAuthenticatedUser returns user list") {
        coEvery { api.listFollowedByAuthenticatedUser(any(), any()) } returns userList
        runBlocking { api.listFollowedByAuthenticatedUser() shouldBe userList }
    }

    test("listFollowingForUser returns user list") {
        coEvery { api.listFollowingForUser(username, any(), any()) } returns userList
        runBlocking { api.listFollowingForUser(username) shouldBe userList }
    }

    test("checkIfPersonIsFollowedByAuthenticated returns unit response") {
        coEvery { api.checkIfPersonIsFollowedByAuthenticated(username) } returns Response.success(Unit)
        runBlocking { api.checkIfPersonIsFollowedByAuthenticated(username).isSuccessful shouldBe true }
    }

    test("followUser returns unit response") {
        coEvery { api.followUser(username) } returns Response.success(Unit)
        runBlocking { api.followUser(username).isSuccessful shouldBe true }
    }

    test("unfollowUser returns unit response") {
        coEvery { api.unfollowUser(username) } returns Response.success(Unit)
        runBlocking { api.unfollowUser(username).isSuccessful shouldBe true }
    }

    test("checkIfUserFollowsAnother returns unit response") {
        coEvery { api.checkIfUserFollowsAnother(username, targetUser) } returns Response.success(Unit)
        runBlocking { api.checkIfUserFollowsAnother(username, targetUser).isSuccessful shouldBe true }
    }

    test("listEmailsForAuthenticatedUser returns email list") {
        coEvery { api.listEmailsForAuthenticatedUser(any(), any()) } returns userEmailList
        runBlocking { api.listEmailsForAuthenticatedUser() shouldBe userEmailList }
    }

    test("addEmailForAuthenticatedUser returns email list") {
        coEvery { api.addEmailForAuthenticatedUser(addEmailRequest) } returns userEmailList
        runBlocking { api.addEmailForAuthenticatedUser(addEmailRequest) shouldBe userEmailList }
    }

    test("deleteEmailForAuthenticatedUser returns unit response") {
        coEvery { api.deleteEmailForAuthenticatedUser(deleteEmailRequest) } returns Response.success(Unit)
        runBlocking { api.deleteEmailForAuthenticatedUser(deleteEmailRequest).isSuccessful shouldBe true }
    }

    test("listPublicEmailsForAuthenticatedUser returns email list") {
        coEvery { api.listPublicEmailsForAuthenticatedUser(any(), any()) } returns userEmailList
        runBlocking { api.listPublicEmailsForAuthenticatedUser() shouldBe userEmailList }
    }

    test("listPublicSshKeysForAuthenticatedUser returns ssh key list") {
        coEvery { api.listPublicSshKeysForAuthenticatedUser(any(), any()) } returns sshKeyList
        runBlocking { api.listPublicSshKeysForAuthenticatedUser() shouldBe sshKeyList }
    }

    test("createPublicSshKeyForAuthenticatedUser returns ssh key") {
        coEvery { api.createPublicSshKeyForAuthenticatedUser(createSshKeyRequest) } returns sshKey
        runBlocking { api.createPublicSshKeyForAuthenticatedUser(createSshKeyRequest) shouldBe sshKey }
    }

    test("getPublicSshKeyForAuthenticatedUser returns ssh key") {
        coEvery { api.getPublicSshKeyForAuthenticatedUser(keyId) } returns sshKey
        runBlocking { api.getPublicSshKeyForAuthenticatedUser(keyId) shouldBe sshKey }
    }

    test("deletePublicSshKeyForAuthenticatedUser returns unit response") {
        coEvery { api.deletePublicSshKeyForAuthenticatedUser(keyId) } returns Response.success(Unit)
        runBlocking { api.deletePublicSshKeyForAuthenticatedUser(keyId).isSuccessful shouldBe true }
    }

    test("listPublicKeysForUser returns ssh key list") {
        coEvery { api.listPublicKeysForUser(username, any(), any()) } returns sshKeyList
        runBlocking { api.listPublicKeysForUser(username) shouldBe sshKeyList }
    }

    test("listGpgKeysForAuthenticatedUser returns gpg key list") {
        coEvery { api.listGpgKeysForAuthenticatedUser(any(), any()) } returns gpgKeyList
        runBlocking { api.listGpgKeysForAuthenticatedUser() shouldBe gpgKeyList }
    }

    test("createGpgKeyForAuthenticatedUser returns gpg key") {
        coEvery { api.createGpgKeyForAuthenticatedUser(createGpgKeyRequest) } returns gpgKey
        runBlocking { api.createGpgKeyForAuthenticatedUser(createGpgKeyRequest) shouldBe gpgKey }
    }

    test("getGpgKeyForAuthenticatedUser returns gpg key") {
        coEvery { api.getGpgKeyForAuthenticatedUser(gpgKeyId) } returns gpgKey
        runBlocking { api.getGpgKeyForAuthenticatedUser(gpgKeyId) shouldBe gpgKey }
    }

    test("deleteGpgKeyForAuthenticatedUser returns unit response") {
        coEvery { api.deleteGpgKeyForAuthenticatedUser(gpgKeyId) } returns Response.success(Unit)
        runBlocking { api.deleteGpgKeyForAuthenticatedUser(gpgKeyId).isSuccessful shouldBe true }
    }

    test("listGpgKeysForUser returns gpg key list") {
        coEvery { api.listGpgKeysForUser(username, any(), any()) } returns gpgKeyList
        runBlocking { api.listGpgKeysForUser(username) shouldBe gpgKeyList }
    }

    test("listSocialAccountsForAuthenticatedUser returns social account list") {
        coEvery { api.listSocialAccountsForAuthenticatedUser(any(), any()) } returns socialAccountList
        runBlocking { api.listSocialAccountsForAuthenticatedUser() shouldBe socialAccountList }
    }

    test("addSocialAccountForAuthenticatedUser returns social account list") {
        coEvery { api.addSocialAccountForAuthenticatedUser(addSocialAccountRequest) } returns socialAccountList
        runBlocking { api.addSocialAccountForAuthenticatedUser(addSocialAccountRequest) shouldBe socialAccountList }
    }

    test("deleteSocialAccountForAuthenticatedUser returns unit response") {
        coEvery { api.deleteSocialAccountForAuthenticatedUser(deleteSocialAccountRequest) } returns Response.success(Unit)
        runBlocking { api.deleteSocialAccountForAuthenticatedUser(deleteSocialAccountRequest).isSuccessful shouldBe true }
    }

    test("listSocialAccountsForUser returns social account list") {
        coEvery { api.listSocialAccountsForUser(username, any(), any()) } returns socialAccountList
        runBlocking { api.listSocialAccountsForUser(username) shouldBe socialAccountList }
    }

    test("listSshSigningKeysForAuthenticatedUser returns signing key list") {
        coEvery { api.listSshSigningKeysForAuthenticatedUser(any(), any()) } returns sshSigningKeyList
        runBlocking { api.listSshSigningKeysForAuthenticatedUser() shouldBe sshSigningKeyList }
    }

    test("createSshSigningKeyForAuthenticatedUser returns signing key") {
        coEvery { api.createSshSigningKeyForAuthenticatedUser(createSshKeyRequest) } returns sshSigningKey
        runBlocking { api.createSshSigningKeyForAuthenticatedUser(createSshKeyRequest) shouldBe sshSigningKey }
    }

    test("getSshSigningKeyForAuthenticatedUser returns signing key") {
        coEvery { api.getSshSigningKeyForAuthenticatedUser(sshSigningKeyId) } returns sshSigningKey
        runBlocking { api.getSshSigningKeyForAuthenticatedUser(sshSigningKeyId) shouldBe sshSigningKey }
    }

    test("deleteSshSigningKeyForAuthenticatedUser returns unit response") {
        coEvery { api.deleteSshSigningKeyForAuthenticatedUser(sshSigningKeyId) } returns Response.success(Unit)
        runBlocking { api.deleteSshSigningKeyForAuthenticatedUser(sshSigningKeyId).isSuccessful shouldBe true }
    }

    test("listSshSigningKeysForUser returns signing key list") {
        coEvery { api.listSshSigningKeysForUser(username, any(), any()) } returns sshSigningKeyList
        runBlocking { api.listSshSigningKeysForUser(username) shouldBe sshSigningKeyList }
    }
})

