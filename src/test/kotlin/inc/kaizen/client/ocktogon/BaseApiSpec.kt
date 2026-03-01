package inc.kaizen.client.ocktogon

import io.kotest.core.spec.style.FunSpec

abstract class BaseApiSpec: FunSpec({

    val ocktogon: Ocktogon

    beforeTest {
    }
})