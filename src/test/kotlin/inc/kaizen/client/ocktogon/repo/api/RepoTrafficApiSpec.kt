package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.ocktogon.repo.model.ClonesTraffic
import inc.kaizen.client.ocktogon.repo.model.TrafficPath
import inc.kaizen.client.ocktogon.repo.model.TrafficReferrer
import inc.kaizen.client.ocktogon.repo.model.ViewsTraffic
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class RepoTrafficApiSpec : FunSpec({
    val api = mockk<RepoTrafficApi>()
    val owner = "owner"; val repo = "repo"
    val clonesTraffic = mockk<ClonesTraffic>()
    val viewsTraffic = mockk<ViewsTraffic>()
    val trafficPath = mockk<TrafficPath>()
    val trafficReferrer = mockk<TrafficReferrer>()

    test("getClones returns clones traffic") {
        coEvery { api.getClones(owner, repo, any()) } returns clonesTraffic
        runBlocking { api.getClones(owner, repo) } shouldBe clonesTraffic
    }
    test("getTopPaths returns paths") {
        coEvery { api.getTopPaths(owner, repo) } returns listOf(trafficPath)
        runBlocking { api.getTopPaths(owner, repo) } shouldBe listOf(trafficPath)
    }
    test("getTopReferrers returns referrers") {
        coEvery { api.getTopReferrers(owner, repo) } returns listOf(trafficReferrer)
        runBlocking { api.getTopReferrers(owner, repo) } shouldBe listOf(trafficReferrer)
    }
    test("getViews returns views traffic") {
        coEvery { api.getViews(owner, repo, any()) } returns viewsTraffic
        runBlocking { api.getViews(owner, repo) } shouldBe viewsTraffic
    }
})

