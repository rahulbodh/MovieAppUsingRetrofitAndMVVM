package com.example.movieappwithretrofit.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movieappwithretrofit.R;
import com.example.movieappwithretrofit.serviceapi.MovieApiService;
import com.example.movieappwithretrofit.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class MovieRepository {
    // used to abstract the data source details and
    // provides a clean API for the ViewModel to
    // fetch and manage data

    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application; // use for access res


    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieApiService movieApiService = RetrofitInstance.getService();

        Call<Result> call = movieApiService.
                getPopularMovies(application.getApplicationContext().getString(R.string.api_key));

        return mutableLiveData;


    }
}
