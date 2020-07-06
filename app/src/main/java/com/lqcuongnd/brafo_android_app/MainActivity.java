package com.lqcuongnd.brafo_android_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lqcuongnd.brafo_android_app.model.SOAnswersResponse;
import com.lqcuongnd.brafo_android_app.retrofit.ApiUtils;
import com.lqcuongnd.brafo_android_app.retrofit.SOService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public boolean isFirstOpenTime = true;
    Intent intent;

    //test
    private SOService soService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(navView, navController);

        soService = ApiUtils.getSOService();
        loadAnswers();
        intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);


    }

    private boolean isLogged() {
        return false;
    }

    public void loadAnswers() {
        soService.getAnswers().enqueue(new Callback<List<SOAnswersResponse>>() {
            @Override
            public void onResponse(Call<List<SOAnswersResponse>> call, Response<List<SOAnswersResponse>> response) {
                if (response.isSuccessful()) {
//                    mAdapter.updateAnswers(response.body().getItems());
                    Toast.makeText(MainActivity.this, response.body().get(0).getName(), Toast.LENGTH_SHORT).show();
                    Log.d("okokok", response.body().get(0).getName());
                } else {
                    int statusCode = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<List<SOAnswersResponse>> call, Throwable t) {
                showErrorMessage();
//                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                Log.d("loiAPI", "error loading from API");
            }
        });
    }


    public void showErrorMessage() {
        Toast.makeText(this, "lỗi", Toast.LENGTH_SHORT).show();
        ;
    }
}