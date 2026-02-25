package inc.kaizen.client.page.model

data class PageDeploymentStatus(
    val status: BuildStatus
)

enum class BuildStatus {
    DEPLOYMENT_IN_PROGRESS,
    SYNCING_FILES,
    FINISHED_FILE_SYNC,
    UPDATING_PAGES,
    PURGING_CDN,
    DEPLOYMENT_CANCELLED,
    DEPLOYMENT_FAILED,
    DEPLOYMENT_CONTENT_FAILED,
    DEPLOYMENT_ATTEMPT_ERROR,
    DEPLOYMENT_LOST,
    SUCCEED
}