package inc.kaizen.client.repo.api

import inc.kaizen.client.repo.model.ContentFile
import inc.kaizen.client.repo.model.CreateOrUpdateFileRequest
import inc.kaizen.client.repo.model.DeleteFileRequest
import inc.kaizen.client.repo.model.FileCommitResponse
import retrofit2.Response
import retrofit2.http.*

interface ContentApi {

    @GET("/repos/{owner}/{repo}/readme")
    suspend fun getReadme(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("ref") ref: String? = null
    ): ContentFile

    @GET("/repos/{owner}/{repo}/readme/{dir}")
    suspend fun getReadmeInDir(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("dir") dir: String,
        @Query("ref") ref: String? = null
    ): ContentFile

    @GET("/repos/{owner}/{repo}/contents/{path}")
    suspend fun getContent(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("path", encoded = true) path: String,
        @Query("ref") ref: String? = null
    ): Any // Can be ContentFile or List<ContentFile> (directory listing)

    @PUT("/repos/{owner}/{repo}/contents/{path}")
    suspend fun createOrUpdateFileContent(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("path", encoded = true) path: String,
        @Body body: CreateOrUpdateFileRequest
    ): FileCommitResponse

    @DELETE("/repos/{owner}/{repo}/contents/{path}")
    suspend fun deleteFile(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("path", encoded = true) path: String,
        @Body body: DeleteFileRequest
    ): FileCommitResponse

    @GET("/repos/{owner}/{repo}/tarball/{ref}")
    suspend fun downloadTarball(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ref") ref: String
    ): Response<Unit>

    @GET("/repos/{owner}/{repo}/zipball/{ref}")
    suspend fun downloadZipball(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("ref") ref: String
    ): Response<Unit>
}
