package inc.kaizen.client.ocktogon.action.api

import inc.kaizen.client.ocktogon.action.model.variable.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class VariableApiSpec : FunSpec({
    val api = mockk<VariableApi>()
    val org = "my-org"
    val owner = "owner"
    val repo = "repo"
    val variableName = "MY_VAR"
    val environmentName = "production"
    val repositoryId = 42L
    val variablesResponse = mockk<VariablesResponse>()
    val variable = mockk<Variable>()
    val createVariableRequest = mockk<CreateVariableRequest>()
    val variableRepositoriesResponse = mockk<VariableRepositoriesResponse>()
    val setVariableRepositoriesRequest = mockk<SetVariableRepositoriesRequest>()

    test("listOrgVariables returns variables response") {
        coEvery { api.listOrgVariables(org, any(), any()) } returns variablesResponse
        runBlocking {
            api.listOrgVariables(org) shouldBe variablesResponse
        }
    }

    test("createOrgVariable returns unit response") {
        coEvery { api.createOrgVariable(org, createVariableRequest) } returns Response.success(Unit)
        runBlocking {
            api.createOrgVariable(org, createVariableRequest).isSuccessful shouldBe true
        }
    }

    test("getOrgVariable returns variable") {
        coEvery { api.getOrgVariable(org, variableName) } returns variable
        runBlocking {
            api.getOrgVariable(org, variableName) shouldBe variable
        }
    }

    test("updateOrgVariable returns unit response") {
        coEvery { api.updateOrgVariable(org, variableName, createVariableRequest) } returns Response.success(Unit)
        runBlocking {
            api.updateOrgVariable(org, variableName, createVariableRequest).isSuccessful shouldBe true
        }
    }

    test("deleteOrgVariable returns unit response") {
        coEvery { api.deleteOrgVariable(org, variableName) } returns Response.success(Unit)
        runBlocking {
            api.deleteOrgVariable(org, variableName).isSuccessful shouldBe true
        }
    }

    test("listSelectedReposForOrgVariable returns variable repositories response") {
        coEvery { api.listSelectedReposForOrgVariable(org, variableName, any(), any()) } returns variableRepositoriesResponse
        runBlocking {
            api.listSelectedReposForOrgVariable(org, variableName) shouldBe variableRepositoriesResponse
        }
    }

    test("setSelectedReposForOrgVariable returns unit response") {
        coEvery { api.setSelectedReposForOrgVariable(org, variableName, setVariableRepositoriesRequest) } returns Response.success(Unit)
        runBlocking {
            api.setSelectedReposForOrgVariable(org, variableName, setVariableRepositoriesRequest).isSuccessful shouldBe true
        }
    }

    test("addSelectedRepoToOrgVariable returns unit response") {
        coEvery { api.addSelectedRepoToOrgVariable(org, variableName, repositoryId) } returns Response.success(Unit)
        runBlocking {
            api.addSelectedRepoToOrgVariable(org, variableName, repositoryId).isSuccessful shouldBe true
        }
    }

    test("removeSelectedRepoFromOrgVariable returns unit response") {
        coEvery { api.removeSelectedRepoFromOrgVariable(org, variableName, repositoryId) } returns Response.success(Unit)
        runBlocking {
            api.removeSelectedRepoFromOrgVariable(org, variableName, repositoryId).isSuccessful shouldBe true
        }
    }

    test("listRepoVariables returns variables response") {
        coEvery { api.listRepoVariables(owner, repo, any(), any()) } returns variablesResponse
        runBlocking {
            api.listRepoVariables(owner, repo) shouldBe variablesResponse
        }
    }

    test("createRepoVariable returns unit response") {
        coEvery { api.createRepoVariable(owner, repo, createVariableRequest) } returns Response.success(Unit)
        runBlocking {
            api.createRepoVariable(owner, repo, createVariableRequest).isSuccessful shouldBe true
        }
    }

    test("getRepoVariable returns variable") {
        coEvery { api.getRepoVariable(owner, repo, variableName) } returns variable
        runBlocking {
            api.getRepoVariable(owner, repo, variableName) shouldBe variable
        }
    }

    test("updateRepoVariable returns unit response") {
        coEvery { api.updateRepoVariable(owner, repo, variableName, createVariableRequest) } returns Response.success(Unit)
        runBlocking {
            api.updateRepoVariable(owner, repo, variableName, createVariableRequest).isSuccessful shouldBe true
        }
    }

    test("deleteRepoVariable returns unit response") {
        coEvery { api.deleteRepoVariable(owner, repo, variableName) } returns Response.success(Unit)
        runBlocking {
            api.deleteRepoVariable(owner, repo, variableName).isSuccessful shouldBe true
        }
    }

    test("listRepoOrgVariables returns variables response") {
        coEvery { api.listRepoOrgVariables(owner, repo, any(), any()) } returns variablesResponse
        runBlocking {
            api.listRepoOrgVariables(owner, repo) shouldBe variablesResponse
        }
    }

    test("listEnvVariables returns variables response") {
        coEvery { api.listEnvVariables(owner, repo, environmentName, any(), any()) } returns variablesResponse
        runBlocking {
            api.listEnvVariables(owner, repo, environmentName) shouldBe variablesResponse
        }
    }

    test("createEnvVariable returns unit response") {
        coEvery { api.createEnvVariable(owner, repo, environmentName, createVariableRequest) } returns Response.success(Unit)
        runBlocking {
            api.createEnvVariable(owner, repo, environmentName, createVariableRequest).isSuccessful shouldBe true
        }
    }

    test("getEnvVariable returns variable") {
        coEvery { api.getEnvVariable(owner, repo, environmentName, variableName) } returns variable
        runBlocking {
            api.getEnvVariable(owner, repo, environmentName, variableName) shouldBe variable
        }
    }

    test("updateEnvVariable returns unit response") {
        coEvery { api.updateEnvVariable(owner, repo, environmentName, variableName, createVariableRequest) } returns Response.success(Unit)
        runBlocking {
            api.updateEnvVariable(owner, repo, environmentName, variableName, createVariableRequest).isSuccessful shouldBe true
        }
    }

    test("deleteEnvVariable returns unit response") {
        coEvery { api.deleteEnvVariable(owner, repo, environmentName, variableName) } returns Response.success(Unit)
        runBlocking {
            api.deleteEnvVariable(owner, repo, environmentName, variableName).isSuccessful shouldBe true
        }
    }
})

