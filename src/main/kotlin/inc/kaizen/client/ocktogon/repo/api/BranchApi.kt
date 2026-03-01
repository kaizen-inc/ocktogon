package inc.kaizen.client.ocktogon.repo.api

import inc.kaizen.client.ocktogon.pull.model.reviewer.Team
import inc.kaizen.client.ocktogon.repo.model.*
import inc.kaizen.client.ocktogon.user.model.User

import retrofit2.Response
import retrofit2.http.*

interface BranchApi {

    @GET("/repos/{owner}/{repo}/branches")
    suspend fun listBranches(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("protected") protected: Boolean? = null,
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Branch>

    @GET("/repos/{owner}/{repo}/branches/{branch}")
    suspend fun getBranch(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): Branch

    @POST("/repos/{owner}/{repo}/branches/{branch}/rename")
    suspend fun renameBranch(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String,
        @Body body: RenameBranchRequest
    ): Branch

    @POST("/repos/{owner}/{repo}/merges")
    suspend fun mergeBranch(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: MergeBranchRequest
    ): RepoCommit

    @POST("/repos/{owner}/{repo}/merge-upstream")
    suspend fun mergeUpstream(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body body: MergeUpstreamRequest
    ): MergeUpstreamResponse

    @GET("/repos/{owner}/{repo}/branches/{branch}/protection")
    suspend fun getBranchProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): BranchProtection

    @PUT("/repos/{owner}/{repo}/branches/{branch}/protection")
    suspend fun updateBranchProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String,
        @Body body: BranchProtectionRequest
    ): BranchProtection

    @DELETE("/repos/{owner}/{repo}/branches/{branch}/protection")
    suspend fun deleteBranchProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/branches/{branch}/protection/required_status_checks")
    suspend fun getStatusChecksProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): RequiredStatusChecks

    @PATCH("/repos/{owner}/{repo}/branches/{branch}/protection/required_status_checks")
    suspend fun updateStatusChecksProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String,
        @Body body: RequiredStatusChecksRequest
    ): RequiredStatusChecks

    @DELETE("/repos/{owner}/{repo}/branches/{branch}/protection/required_status_checks")
    suspend fun removeStatusChecksProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/branches/{branch}/protection/required_pull_request_reviews")
    suspend fun getPullRequestReviewProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): RequiredPullRequestReviews

    @PATCH("/repos/{owner}/{repo}/branches/{branch}/protection/required_pull_request_reviews")
    suspend fun updatePullRequestReviewProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String,
        @Body body: RequiredPullRequestReviewsRequest
    ): RequiredPullRequestReviews

    @DELETE("/repos/{owner}/{repo}/branches/{branch}/protection/required_pull_request_reviews")
    suspend fun deletePullRequestReviewProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/branches/{branch}/protection/enforce_admins")
    suspend fun getAdminBranchProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): ProtectedBranchAdminEnforced

    @POST("/repos/{owner}/{repo}/branches/{branch}/protection/enforce_admins")
    suspend fun setAdminBranchProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): ProtectedBranchAdminEnforced

    @DELETE("/repos/{owner}/{repo}/branches/{branch}/protection/enforce_admins")
    suspend fun deleteAdminBranchProtection(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/branches/{branch}/protection/restrictions")
    suspend fun getAccessRestrictions(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): BranchRestrictionPolicy

    @DELETE("/repos/{owner}/{repo}/branches/{branch}/protection/restrictions")
    suspend fun deleteAccessRestrictions(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/branches/{branch}/protection/restrictions/apps")
    suspend fun getAppsWithAccessToProtectedBranch(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): List<Any>

    @GET("/repos/{owner}/{repo}/branches/{branch}/protection/restrictions/teams")
    suspend fun getTeamsWithAccessToProtectedBranch(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): List<Team>

    @GET("/repos/{owner}/{repo}/branches/{branch}/protection/restrictions/users")
    suspend fun getUsersWithAccessToProtectedBranch(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("branch") branch: String
    ): List<User>
}
