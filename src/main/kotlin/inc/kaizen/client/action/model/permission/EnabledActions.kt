package inc.kaizen.client.action.model.permission

import inc.kaizen.client.repo.model.repo.Repo

data class EnabledActions(
    val total_count: Int,
    val repositories: List<Repo>
)
