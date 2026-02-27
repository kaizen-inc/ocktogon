package inc.kaizen.client.action.model.variable

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class VariableModelsSpec : StringSpec({

    "Variable should instantiate with all optional fields" {
        val variable = Variable(
            name = "MY_VAR",
            value = "my_value",
            created_at = "2025-01-01T00:00:00Z",
            updated_at = "2025-06-01T00:00:00Z",
            visibility = "all",
            selected_repositories_url = "https://api.github.com/orgs/my-org/actions/variables/MY_VAR/repositories"
        )
        variable.name shouldBe "MY_VAR"
        variable.value shouldBe "my_value"
        variable.visibility shouldBe "all"
    }

    "Variable should instantiate with defaults (all nulls)" {
        val variable = Variable()
        variable.name shouldBe null
        variable.value shouldBe null
        variable.visibility shouldBe null
    }

    "VariablesResponse should instantiate and compare correctly" {
        val variable = Variable(name = "VAR1", value = "v1")
        val response = VariablesResponse(total_count = 1, variables = listOf(variable))
        response.total_count shouldBe 1
        response.variables?.size shouldBe 1
        response.variables?.get(0) shouldBe variable
    }

    "CreateVariableRequest should instantiate and compare correctly" {
        val req = CreateVariableRequest(
            name = "NEW_VAR",
            value = "new_value",
            visibility = "selected",
            selected_repository_ids = listOf(1, 2)
        )
        req.name shouldBe "NEW_VAR"
        req.value shouldBe "new_value"
        req.visibility shouldBe "selected"
        req.selected_repository_ids shouldBe listOf(1, 2)
    }

    "SetVariableRepositoriesRequest should instantiate and compare correctly" {
        val req = SetVariableRepositoriesRequest(selected_repository_ids = listOf(10, 20))
        req.selected_repository_ids shouldBe listOf(10, 20)
    }

    "VariableRepositoriesResponse should instantiate and compare correctly" {
        val response = VariableRepositoriesResponse(total_count = 1, repositories = listOf())
        response.total_count shouldBe 1
        response.repositories?.size shouldBe 0
    }
})
