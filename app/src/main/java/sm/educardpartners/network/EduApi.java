package sm.educardpartners.network;


import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EduApi {

    @POST("register/")
    Observable<Response<Object>> register(
            @Query("name") String name,
            @Query("pass") String pass,
            @Query("email") String email
    );
//
//    @POST("oauth/revoke_token/")
//    Observable<Response<Objects>> logOut(@Query("token") String token, @Query("client_id") String clientId);
//
//    @POST("oauth/register/")
//    Observable<Response<Register>> register(@Body Register register);
//
//    @Streaming
//    @Multipart
//    @POST("events/")
//    Observable<Response<UserEvent>> postmEvent(
//            @Part("id")
//                    Integer id,
//            @Part("title")
//                    String title,
//            @Part("description")
//                    String description,
//            @Part("creator")
//                    Creator creator,
//            @Part MultipartBody.Part picture,
//            @Part("attenders")
//                    Integer attenders,
//            @Part("start_time")
//                    String startTime,
//            @Part("coordinates")
//                    String coordinates,
//            @Part("location")
//                    String location,
//            @Part("type")
//                    String type,
//            @Part("is_private")
//                    Boolean isPrivate,
////            @Part("video")
////                    RequestBody video,
//            @Part("likes")
//                    Integer likes,
//            @Part("dislikes")
//                    Integer dislikes
//    );
//
//    @POST("events/")
//    Observable<Response<UserEvent>> postEvent(
//            @Body UserEvent event);
//
//    /**
//     * These 3 params together provide geographical filtering for the events. As the server is using SRID 4326 for calculating distances, specification is needed:
//     * -180 <= lat <= 0 for the Western hemisphere and 0 <= lat <= 180 for the Eastern one.
//     * Likewise -90 <= lon <= 0 for the Southern hemisphere, and 0 <= lon <= 90 for the Northern hemisphere.
//     *
//     * @param latitude
//     * @param longitude //     * @param radius
//     * @return
//     */
//    @GET("events/")
//    Observable<Response<List<UserEvent>>> getEvents(
//            @Query("lat") double latitude,
//            @Query("lon") double longitude
//    );
//
//    /**
//     * These 3 params together provide geographical filtering for the events. As the server is using SRID 4326 for calculating distances, specification is needed:
//     * -180 <= lat <= 0 for the Western hemisphere and 0 <= lat <= 180 for the Eastern one.
//     * Likewise -90 <= lon <= 0 for the Southern hemisphere, and 0 <= lon <= 90 for the Northern hemisphere.
//     *
//     * @param latitude
//     * @param longitude //     * @param radius
//     * @return
//     */
//    @GET("events/")
//    Observable<Response<List<UserEvent>>> getEvents(
//            @Query("lat") double latitude,
//            @Query("lon") double longitude,
//            @Query("radius") int radius
//    );
//
//    /**
//     * These 3 params together provide geographical filtering for the events. As the server is using SRID 4326 for calculating distances, specification is needed:
//     * -180 <= lat <= 0 for the Western hemisphere and 0 <= lat <= 180 for the Eastern one.
//     * Likewise -90 <= lon <= 0 for the Southern hemisphere, and 0 <= lon <= 90 for the Northern hemisphere.
//     * <p>
//     * text - which enables a full text search through event fields.
//     *
//     * @param latitude
//     * @param longitude
//     * @param radius
//     * @return
//     */
//    @FormUrlEncoded
//    @GET("events/")
//    Observable<Response<List<UserEvent>>> getEvents(
//            @Query("lat") double latitude,
//            @Query("lon") double longitude,
//            @Query("radius") double radius,
//            @Query("text") String searchKey
//    );
//
//    @DELETE("/events/{id}/")
//    Observable<Response<UserEvent>> deleteEvent(@Path("id") int eventId);
//
//    @POST("profile/")
//    Observable<Object> setProfile(@Body UserProfile profile);
//
//    @GET("profile/")
//    Observable<Response<UserProfile>> getProfile();
//
//    @GET("/users/search/")
//    Observable<Response<ArrayList<SearchResult>>> searchUser(@Query("name") String name);
//
//    @POST("users/{id}/add_friend/")
//    Observable<Response<LoginResponse>> friendRequest(@Path("id") String id);
//
//    @POST("/events/{id}/dislike/")
//    Observable<Response<UserEvent>> likeEvent(@Path("id") int eventId);
//
//    @POST("/events/{id}/dislike/")
//    Observable<Response<UserEvent>> dislikeEvent(@Path("id") int eventId);
//
//    @POST("/events/{id}/openCommentView/")
//    Observable<Response<Comment>> addComment(@Path("id") int eventId, @Body Comment comment);
//
//    @GET("/events/{id}/comments/")
//    Observable<Response<List<Comment>>> getComments(@Path("id") int evetId);
//
//    @GET("/friends/")
//    Observable<Response<List<UserProfile>>> getFriends();
//
//    @GET("/friends/requests/")
//    Observable<Response<List<Object>>> getFriendRequests();


}
