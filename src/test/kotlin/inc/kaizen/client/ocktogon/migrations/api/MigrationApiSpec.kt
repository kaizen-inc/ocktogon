package inc.kaizen.client.ocktogon.migrations.api

import inc.kaizen.client.common.Repository
import inc.kaizen.client.migrations.model.Migration
import inc.kaizen.client.migrations.model.StartMigrationRequest
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class MigrationApiSpec : FunSpec({
    val orgApi = mockk<OrgMigrationApi>()
    val userApi = mockk<UserMigrationApi>()
    val org = "my-org"; val migId = 1L; val repoName = "my-repo"; val username = "octocat"
    val migration = mockk<Migration>()
    val migrations = listOf(migration)
    val repos = listOf<Repository>()
    val startReq = StartMigrationRequest(repositories = listOf("owner/repo"))

    test("listOrgMigrations returns migrations") {
        coEvery { orgApi.listOrgMigrations(org, any(), any(), any()) } returns migrations
        runBlocking { orgApi.listOrgMigrations(org) shouldBe migrations }
    }
    test("startOrgMigration returns migration") {
        coEvery { orgApi.startOrgMigration(org, startReq) } returns migration
        runBlocking { orgApi.startOrgMigration(org, startReq) shouldBe migration }
    }
    test("getOrgMigration returns migration") {
        coEvery { orgApi.getOrgMigration(org, migId, any()) } returns migration
        runBlocking { orgApi.getOrgMigration(org, migId) shouldBe migration }
    }
    test("downloadOrgMigrationArchive returns response") {
        coEvery { orgApi.downloadOrgMigrationArchive(org, migId) } returns Response.success(Unit)
        runBlocking { orgApi.downloadOrgMigrationArchive(org, migId).isSuccessful shouldBe true }
    }
    test("deleteOrgMigrationArchive returns response") {
        coEvery { orgApi.deleteOrgMigrationArchive(org, migId) } returns Response.success(Unit)
        runBlocking { orgApi.deleteOrgMigrationArchive(org, migId).isSuccessful shouldBe true }
    }
    test("unlockOrgRepoForMigration returns response") {
        coEvery { orgApi.unlockOrgRepoForMigration(org, migId, repoName) } returns Response.success(Unit)
        runBlocking { orgApi.unlockOrgRepoForMigration(org, migId, repoName).isSuccessful shouldBe true }
    }
    test("listReposForOrgMigration returns repos") {
        coEvery { orgApi.listReposForOrgMigration(org, migId, any(), any()) } returns repos
        runBlocking { orgApi.listReposForOrgMigration(org, migId) shouldBe repos }
    }
    test("listUserMigrations returns migrations") {
        coEvery { userApi.listUserMigrations(any(), any()) } returns migrations
        runBlocking { userApi.listUserMigrations() shouldBe migrations }
    }
    test("startUserMigration returns migration") {
        coEvery { userApi.startUserMigration(startReq) } returns migration
        runBlocking { userApi.startUserMigration(startReq) shouldBe migration }
    }
    test("getUserMigration returns migration") {
        coEvery { userApi.getUserMigration(migId, any()) } returns migration
        runBlocking { userApi.getUserMigration(migId) shouldBe migration }
    }
    test("deleteUserMigrationArchive returns response") {
        coEvery { userApi.deleteUserMigrationArchive(migId) } returns Response.success(Unit)
        runBlocking { userApi.deleteUserMigrationArchive(migId).isSuccessful shouldBe true }
    }
    test("unlockRepoForUserMigration returns response") {
        coEvery { userApi.unlockRepoForUserMigration(migId, repoName) } returns Response.success(Unit)
        runBlocking { userApi.unlockRepoForUserMigration(migId, repoName).isSuccessful shouldBe true }
    }
    test("listReposForUserMigration returns repos") {
        coEvery { userApi.listReposForUserMigration(migId, any(), any()) } returns repos
        runBlocking { userApi.listReposForUserMigration(migId) shouldBe repos }
    }
})

