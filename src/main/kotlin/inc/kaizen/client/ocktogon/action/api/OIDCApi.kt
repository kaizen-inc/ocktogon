package inc.kaizen.client.ocktogon.action.api

import inc.kaizen.client.action.model.oidc.OIDCTemplate
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface OIDCApi {

    @GET("/orgs/{org}/actions/oidc/customization/sub")
    suspend fun getOrgOIDCCustomTemplate(
        @Path("org") org: String,
    ): OIDCTemplate

    @PUT("/orgs/{org}/actions/oidc/customization/sub")
    suspend fun setOrgOIDCCustomTemplate(
        @Path("org") org: String,
        @Body template: OIDCTemplate
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/actions/oidc/customization/sub")
    suspend fun getRepoOIDCCustomTemplate(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): OIDCTemplate

    @PUT("/repos/{owner}/{repo}/actions/oidc/customization/sub")
    suspend fun setRepoOIDCCustomTemplate(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body template: OIDCTemplate
    ): Response<Unit>
}