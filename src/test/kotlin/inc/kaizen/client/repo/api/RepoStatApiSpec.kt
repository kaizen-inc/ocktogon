package inc.kaizen.client.repo.api

import inc.kaizen.client.repo.model.CommitActivity
import inc.kaizen.client.repo.model.ContributorStat
import inc.kaizen.client.repo.model.ParticipationStats
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

class RepoStatApiSpec : FunSpec({
    val api = mockk<RepoStatApi>()
    val owner = "owner"; val repo = "repo"
    val contributorStat = mockk<ContributorStat>()
    val commitActivity = mockk<CommitActivity>()
    val participationStats = mockk<ParticipationStats>()

    test("getContributorStats returns stats") {
        coEvery { api.getContributorStats(owner, repo) } returns listOf(contributorStat)
        runBlocking { api.getContributorStats(owner, repo) } shouldBe listOf(contributorStat)
    }
    test("getCommitActivityStats returns activity") {
        coEvery { api.getCommitActivityStats(owner, repo) } returns listOf(commitActivity)
        runBlocking { api.getCommitActivityStats(owner, repo) } shouldBe listOf(commitActivity)
    }
    test("getCodeFrequencyStats returns frequency") {
        val freq = listOf(listOf(1, 2, 3))
        coEvery { api.getCodeFrequencyStats(owner, repo) } returns freq
        runBlocking { api.getCodeFrequencyStats(owner, repo) } shouldBe freq
    }
    test("getParticipationStats returns participation") {
        coEvery { api.getParticipationStats(owner, repo) } returns participationStats
        runBlocking { api.getParticipationStats(owner, repo) } shouldBe participationStats
    }
    test("getPunchCardStats returns punch card") {
        val punchCard = listOf(listOf(0, 9, 5))
        coEvery { api.getPunchCardStats(owner, repo) } returns punchCard
        runBlocking { api.getPunchCardStats(owner, repo) } shouldBe punchCard
    }
})

