package inc.kaizen.client.ocktogon.action.model.secret

import inc.kaizen.client.repo.model.repo.Repo

data class Repositories(
    val repositories: List<Repo>,
    val total_count: Int
)