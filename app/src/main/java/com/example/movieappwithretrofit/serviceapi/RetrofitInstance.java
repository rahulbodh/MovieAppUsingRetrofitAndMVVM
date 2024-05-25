package com.example.movieappwithretrofit.serviceapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    // Acts as a central configuration point for
    // defining how HTTP requests and responses
    // should be handled.

    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.themoviedb.org/3/";    // base url

    public static MovieApiService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(MovieApiService.class);
    }

}
