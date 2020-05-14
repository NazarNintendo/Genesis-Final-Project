package apitests;

import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TrelloApi {

    // относительный урл, полынй в борде. или можно полный
    @POST("/1/board")
    Call<Board> createBoard(@Body Board board, @Query("name") String name);

    @POST("/1/boards/{id}/lists")
    Call<List> createList(@Body List list, @Path("id") String id, @Query("name") String Name);

    @POST("/1/cards/")
    Call<Card> createCard(@Body Card card, @Query("idList") String idList, @Query("name") String name);

    @POST("/1/cards/{id}/checklists")
    Call<CheckList> createCheckList(@Body CheckList checkList, @Path("id") String id, @Query("name") String name);

    @POST("/1/checklists/{id}/checkItems")
    Call<CheckList> addCheckItem(@Body CheckList checkList, @Path("id") String id, @Query("name") String name);

}
