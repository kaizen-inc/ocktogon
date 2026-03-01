package inc.kaizen.client.ocktogon.packages.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PackageModelsSpec : StringSpec({

    "ContainerMetadata should instantiate and compare correctly" {
        val metadata = ContainerMetadata(tags = listOf("latest", "v1.0"))
        metadata.tags shouldBe listOf("latest", "v1.0")
    }

    "DockerMetadata should instantiate and compare correctly" {
        val metadata = DockerMetadata(tag = listOf("latest"))
        metadata.tag shouldBe listOf("latest")
    }

    "PackageVersionMetadata should instantiate and compare correctly" {
        val container = ContainerMetadata(tags = listOf("latest"))
        val metadata = PackageVersionMetadata(package_type = "container", container = container)
        metadata.package_type shouldBe "container"
        metadata.container shouldBe container
    }

    "PackageVersion should instantiate and compare correctly" {
        val version = PackageVersion(id = 1L, name = "v1.0.0", url = "url", description = "First version")
        version.id shouldBe 1L
        version.name shouldBe "v1.0.0"
    }

    "Package should instantiate and compare correctly" {
        val pkg = Package(id = 1, name = "my-package", package_type = "npm", visibility = "public", version_count = 5)
        pkg.id shouldBe 1
        pkg.name shouldBe "my-package"
        pkg.version_count shouldBe 5
    }

    "Package should instantiate with null defaults" {
        val pkg = Package()
        pkg.id shouldBe null
        pkg.name shouldBe null
    }
})

