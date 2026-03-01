package inc.kaizen.client.ocktogon.gitignore.api

import inc.kaizen.client.ocktogon.gitignore.model.GitignoreTemplate
import retrofit2.http.GET
import retrofit2.http.Path

interface GitignoreApi {

    @GET("/gitignore/templates")
    suspend fun getAllGitignoreTemplates(): List<String>

    @GET("/gitignore/templates/{name}")
    suspend fun getGitignoreTemplate(
        @Path("name") name: String
    ): GitignoreTemplate
}
