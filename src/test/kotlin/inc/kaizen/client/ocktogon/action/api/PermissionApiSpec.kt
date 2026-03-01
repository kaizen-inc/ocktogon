package inc.kaizen.client.ocktogon.action.api

import inc.kaizen.client.action.model.permission.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class PermissionApiSpec : FunSpec({
    val api = mockk<PermissionApi>()
    val org = "my-org"
    val owner = "owner"
    val repo = "repo"
    val permission = mockk<Permission>()
    val enabledActions = mockk<EnabledActions>()
    val allowedActionsReusableWorkflows = mockk<AllowedActionsReusableWorkflows>()
    val defaultWorkflowPermission = mockk<DefaultWorkflowPermission>()
    val actionPermission = mockk<ActionPermission>()
    val accessLevel = mockk<AccessLevel>()

    test("getOrgActionPermissions returns permission") {
        coEvery { api.getOrgActionPermissions(org) } returns permission
        runBlocking {
            api.getOrgActionPermissions(org) shouldBe permission
        }
    }

    test("setOrgActionPermissions returns unit response") {
        coEvery { api.getOrgActionPermissions(org, permission) } returns Response.success(Unit)
        runBlocking {
            api.getOrgActionPermissions(org, permission).isSuccessful shouldBe true
        }
    }

    test("getOrgEnabledActions returns enabled actions") {
        coEvery { api.getOrgEnabledActions(org) } returns enabledActions
        runBlocking {
            api.getOrgEnabledActions(org) shouldBe enabledActions
        }
    }

    test("enableActionsForReposInOrg returns unit response") {
        coEvery { api.enableActionsForReposInOrg(org, any()) } returns Response.success(Unit)
        runBlocking {
            api.enableActionsForReposInOrg(org, listOf(1, 2)).isSuccessful shouldBe true
        }
    }

    test("enableActionsForRepoInOrg returns unit response") {
        coEvery { api.enableActionsForRepoInOrg(org, 1) } returns Response.success(Unit)
        runBlocking {
            api.enableActionsForRepoInOrg(org, 1).isSuccessful shouldBe true
        }
    }

    test("disableActionsForRepoInOrg returns unit response") {
        coEvery { api.disableActionsForRepoInOrg(org, 1) } returns Response.success(Unit)
        runBlocking {
            api.disableActionsForRepoInOrg(org, 1).isSuccessful shouldBe true
        }
    }

    test("getOrgAllowedActionsAndReusableWorkflows returns allowed actions") {
        coEvery { api.getOrgAllowedActionsAndReusableWorkflows(org) } returns allowedActionsReusableWorkflows
        runBlocking {
            api.getOrgAllowedActionsAndReusableWorkflows(org) shouldBe allowedActionsReusableWorkflows
        }
    }

    test("setOrgAllowedActionsAndReusableWorkflows returns unit response") {
        coEvery { api.setOrgAllowedActionsAndReusableWorkflows(org, allowedActionsReusableWorkflows) } returns Response.success(Unit)
        runBlocking {
            api.setOrgAllowedActionsAndReusableWorkflows(org, allowedActionsReusableWorkflows).isSuccessful shouldBe true
        }
    }

    test("getOrgDefaultWorkflowPermission returns default workflow permission") {
        coEvery { api.getOrgDefaultWorkflowPermission(org) } returns defaultWorkflowPermission
        runBlocking {
            api.getOrgDefaultWorkflowPermission(org) shouldBe defaultWorkflowPermission
        }
    }

    test("setOrgDefaultWorkflowPermission executes without error") {
        coEvery { api.setOrgDefaultWorkflowPermission(org, defaultWorkflowPermission) } returns Unit
        runBlocking {
            api.setOrgDefaultWorkflowPermission(org, defaultWorkflowPermission)
        }
    }

    test("getRepoActionPermission returns action permission") {
        coEvery { api.getRepoActionPermission(owner, repo) } returns actionPermission
        runBlocking {
            api.getRepoActionPermission(owner, repo) shouldBe actionPermission
        }
    }

    test("setRepoActionPermission executes without error") {
        coEvery { api.setRepoActionPermission(owner, repo, actionPermission) } returns Unit
        runBlocking {
            api.setRepoActionPermission(owner, repo, actionPermission)
        }
    }

    test("getRepoWorkflowAccessLevel returns access level") {
        coEvery { api.getRepoWorkflowAccessLevel(owner, repo) } returns accessLevel
        runBlocking {
            api.getRepoWorkflowAccessLevel(owner, repo) shouldBe accessLevel
        }
    }

    test("setRepoWorkflowAccessLevel returns unit response") {
        coEvery { api.setRepoWorkflowAccessLevel(owner, repo, accessLevel) } returns Response.success(Unit)
        runBlocking {
            api.setRepoWorkflowAccessLevel(owner, repo, accessLevel).isSuccessful shouldBe true
        }
    }

    test("getRepoAllowedActionsAndReusableWorkflows returns allowed actions") {
        coEvery { api.getRepoAllowedActionsAndReusableWorkflows(owner, repo) } returns allowedActionsReusableWorkflows
        runBlocking {
            api.getRepoAllowedActionsAndReusableWorkflows(owner, repo) shouldBe allowedActionsReusableWorkflows
        }
    }

    test("setRepoAllowedActionsAndReusableWorkflows returns unit response") {
        coEvery { api.setRepoAllowedActionsAndReusableWorkflows(owner, repo, allowedActionsReusableWorkflows) } returns Response.success(Unit)
        runBlocking {
            api.setRepoAllowedActionsAndReusableWorkflows(owner, repo, allowedActionsReusableWorkflows).isSuccessful shouldBe true
        }
    }

    test("getRepoDefaultWorkflowPermission returns default workflow permission") {
        coEvery { api.getRepoDefaultWorkflowPermission(org) } returns defaultWorkflowPermission
        runBlocking {
            api.getRepoDefaultWorkflowPermission(org) shouldBe defaultWorkflowPermission
        }
    }

    test("setRepoDefaultWorkflowPermission executes without error") {
        coEvery { api.setRepoDefaultWorkflowPermission(org, defaultWorkflowPermission) } returns Unit
        runBlocking {
            api.setRepoDefaultWorkflowPermission(org, defaultWorkflowPermission)
        }
    }
})

