package com.stalary.web.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Stalary
 * @description
 * @date 2017/12/7
 */
public interface GetRequest_Interface {

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<Translation> getCall();

}
