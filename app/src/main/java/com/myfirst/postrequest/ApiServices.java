package com.myfirst.postrequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("posts")
    Call<ResponseBody> postData(@Body RequestBody requestBody);

}
