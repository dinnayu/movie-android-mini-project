package com.example.movie_android_mini_project.network;

import com.example.movie_android_mini_project.model.Genre;
import com.example.movie_android_mini_project.model.Genres;
import com.example.movie_android_mini_project.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.themoviedb.org/";
    private static final String API_KEY = "fc69ae8afb318e3ffe8ed397dc523ae5";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface GetDataService {

        @GET("/3/genre/movie/list?api_key=fc69ae8afb318e3ffe8ed397dc523ae5&language=en-US")
        Call<Genres> getAllGenres();
    }
}
