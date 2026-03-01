package inc.kaizen.client.ocktogon.action.model.artifact
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
class ArtifactSpec : StringSpec({
    "WorkflowRun should instantiate correctly" {
        val wr = WorkflowRun("main", 1, "sha", 42, 10)
        wr.head_branch shouldBe "main"
        wr.id shouldBe 42
    }
    "Artifact should instantiate correctly" {
        val wr = WorkflowRun("main", 1, "sha", 1, 2)
        val a = Artifact("url","2025-01-01",false,"2026-01-01",1,"name","node",1024,"2025-06-01","url",wr)
        a.name shouldBe "name"
        a.expired shouldBe false
    }
    "Artifacts should instantiate correctly" {
        val wr = WorkflowRun("main",1,"sha",1,2)
        val a = Artifact("u","2025-01-01",false,"2026-01-01",1,"art","node",100,"2025-01-01","u",wr)
        val arts = Artifacts(listOf(a),1)
        arts.total_count shouldBe 1
        arts.artifacts.size shouldBe 1
    }
})