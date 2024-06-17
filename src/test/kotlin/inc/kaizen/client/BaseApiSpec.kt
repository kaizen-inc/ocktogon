package inc.kaizen.client

import io.kotest.core.spec.style.FunSpec

abstract class BaseApiSpec: FunSpec({

    val ocktogon: Ocktogon

    beforeTest {
    }
})