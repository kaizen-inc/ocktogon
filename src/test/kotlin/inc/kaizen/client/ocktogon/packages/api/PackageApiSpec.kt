package inc.kaizen.client.ocktogon.packages.api

import inc.kaizen.client.packages.model.PackageVersion
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class PackageApiSpec : FunSpec({
    val api = mockk<PackageApi>()
    val org = "my-org"; val username = "octocat"; val pkgType = "npm"; val pkgName = "my-pkg"; val versionId = 1L
    val pkg = mockk<Package>()
    val pkgs = listOf(pkg)
    val version = mockk<PackageVersion>()
    val versions = listOf(version)

    test("listOrgPackages returns packages") {
        coEvery { api.listOrgPackages(org, pkgType, any(), any(), any()) } returns pkgs
        runBlocking { api.listOrgPackages(org, pkgType) shouldBe pkgs }
    }
    test("getOrgPackage returns package") {
        coEvery { api.getOrgPackage(org, pkgType, pkgName) } returns pkg
        runBlocking { api.getOrgPackage(org, pkgType, pkgName) shouldBe pkg }
    }
    test("deleteOrgPackage returns response") {
        coEvery { api.deleteOrgPackage(org, pkgType, pkgName) } returns Response.success(Unit)
        runBlocking { api.deleteOrgPackage(org, pkgType, pkgName).isSuccessful shouldBe true }
    }
    test("restoreOrgPackage returns response") {
        coEvery { api.restoreOrgPackage(org, pkgType, pkgName, any()) } returns Response.success(Unit)
        runBlocking { api.restoreOrgPackage(org, pkgType, pkgName).isSuccessful shouldBe true }
    }
    test("listOrgPackageVersions returns versions") {
        coEvery { api.listOrgPackageVersions(org, pkgType, pkgName, any(), any(), any()) } returns versions
        runBlocking { api.listOrgPackageVersions(org, pkgType, pkgName) shouldBe versions }
    }
    test("getOrgPackageVersion returns version") {
        coEvery { api.getOrgPackageVersion(org, pkgType, pkgName, versionId) } returns version
        runBlocking { api.getOrgPackageVersion(org, pkgType, pkgName, versionId) shouldBe version }
    }
    test("deleteOrgPackageVersion returns response") {
        coEvery { api.deleteOrgPackageVersion(org, pkgType, pkgName, versionId) } returns Response.success(Unit)
        runBlocking { api.deleteOrgPackageVersion(org, pkgType, pkgName, versionId).isSuccessful shouldBe true }
    }
    test("restoreOrgPackageVersion returns response") {
        coEvery { api.restoreOrgPackageVersion(org, pkgType, pkgName, versionId) } returns Response.success(Unit)
        runBlocking { api.restoreOrgPackageVersion(org, pkgType, pkgName, versionId).isSuccessful shouldBe true }
    }
    test("listPackagesForAuthenticatedUser returns packages") {
        coEvery { api.listPackagesForAuthenticatedUser(pkgType, any(), any(), any()) } returns pkgs
        runBlocking { api.listPackagesForAuthenticatedUser(pkgType) shouldBe pkgs }
    }
    test("getPackageForAuthenticatedUser returns package") {
        coEvery { api.getPackageForAuthenticatedUser(pkgType, pkgName) } returns pkg
        runBlocking { api.getPackageForAuthenticatedUser(pkgType, pkgName) shouldBe pkg }
    }
    test("listPackageVersionsForAuthenticatedUser returns versions") {
        coEvery { api.listPackageVersionsForAuthenticatedUser(pkgType, pkgName, any(), any(), any()) } returns versions
        runBlocking { api.listPackageVersionsForAuthenticatedUser(pkgType, pkgName) shouldBe versions }
    }
    test("listPackagesForUser returns packages") {
        coEvery { api.listPackagesForUser(username, pkgType, any(), any(), any()) } returns pkgs
        runBlocking { api.listPackagesForUser(username, pkgType) shouldBe pkgs }
    }
    test("getPackageForUser returns package") {
        coEvery { api.getPackageForUser(username, pkgType, pkgName) } returns pkg
        runBlocking { api.getPackageForUser(username, pkgType, pkgName) shouldBe pkg }
    }
})

