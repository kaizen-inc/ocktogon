package inc.kaizen.client.collaborator.api

import com.jayway.jsonpath.DocumentContext
import com.jayway.jsonpath.JsonPath
import com.jayway.jsonpath.ReadContext
import inc.kaizen.client.Ocktogon
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CollaboratorApiSpec: FunSpec({

    lateinit var api: CollaboratorApi
    lateinit var context: ReadContext

    beforeSpec {
        val fileContent = this::class.java.classLoader.getResource("config.json")?.readText().toString()
//        val authors = JsonPath.read(fileContent, "$.store.book[*].author")
        context = JsonPath.parse(fileContent)
        api = Ocktogon.createService(CollaboratorApi::class.java)
    }

    test("get repository collaborators") {

        val owner = context.read<String>("owner")
        val repo = context.read<String>("repo")
        val collaborators = api.getRepoCollaborators(owner, repo)
        shouldBe(collaborators.isNotEmpty())
        shouldBe(collaborators.size == 1)
    }
})