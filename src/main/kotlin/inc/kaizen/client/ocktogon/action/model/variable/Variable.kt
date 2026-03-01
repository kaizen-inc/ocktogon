package inc.kaizen.client.ocktogon.action.model.variable

import inc.kaizen.client.ocktogon.common.Repository

data class Variable(
    val name: String? = null,
    val value: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
    val visibility: String? = null,
    val selected_repositories_url: String? = null
)

data class VariablesResponse(
    val total_count: Int? = null,
    val variables: List<Variable>? = null
)

data class VariableRepositoriesResponse(
    val total_count: Int? = null,
    val repositories: List<Repository>? = null
)

data class CreateVariableRequest(
    val name: String,
    val value: String,
    val visibility: String? = null,
    val selected_repository_ids: List<Int>? = null
)

data class SetVariableRepositoriesRequest(val selected_repository_ids: List<Int>)

