package inc.kaizen.client.ocktogon.gitignore.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class GitignoreModelsSpec : StringSpec({

    "GitignoreTemplate should instantiate and compare correctly" {
        val template = GitignoreTemplate(name = "Kotlin", source = "*.class\n*.jar\n")
        template.name shouldBe "Kotlin"
        template.source shouldBe "*.class\n*.jar\n"
    }

    "GitignoreTemplate should instantiate with null defaults" {
        val template = GitignoreTemplate()
        template.name shouldBe null
        template.source shouldBe null
    }
})

