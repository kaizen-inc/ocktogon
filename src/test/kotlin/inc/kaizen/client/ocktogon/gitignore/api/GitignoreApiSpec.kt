package inc.kaizen.client.ocktogon.gitignore.api

import inc.kaizen.client.gitignore.model.GitignoreTemplate
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class GitignoreApiSpec : FunSpec({
    val api = mockk<GitignoreApi>()
    val template = GitignoreTemplate(name = "Kotlin", source = "*.class\n")
    val templates = listOf("Java", "Kotlin", "Python")

    test("getAllGitignoreTemplates returns list of template names") {
        coEvery { api.getAllGitignoreTemplates() } returns templates
        runBlocking { api.getAllGitignoreTemplates() shouldBe templates }
    }
    test("getGitignoreTemplate returns template") {
        coEvery { api.getGitignoreTemplate("Kotlin") } returns template
        runBlocking { api.getGitignoreTemplate("Kotlin") shouldBe template }
    }
})

