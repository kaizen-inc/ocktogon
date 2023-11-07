package inc.kaizen.client.user.api

import inc.kaizen.client.user.model.ContextInfo
import inc.kaizen.client.user.model.SubjectType
import inc.kaizen.client.user.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {

    @GET("/user")
    fun getLoggedInUser(): User

    @GET("/users")
    fun getUsers(
        @Query("since") since: Int,
        @Query("per_page") perPage: Int = 30
    ): List<User>

    @GET("/users/{username}")
    fun getUser(
        @Path("username") username: String
    ): User

    @GET("/users/{username}/hovercard")
    fun getUserContext(
        @Path("username") username: String,
        @Query("subject_type") subjectType: SubjectType,
        @Query("subjectId") subjectId: String
    ): ContextInfo

    @GET("/user/blocks")
    fun getLoggedInUserBlocks(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 30
    ): List<User>

    @GET("/user/blocks/{username}")
    fun isUserBlockedByLoggedInUser(
        @Path("username") username: String
    ): Response<Unit>
}