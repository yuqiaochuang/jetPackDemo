package com.example.mydemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.model.ScoreViewModel;
import com.example.mydemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ScoreViewModel scoreViewModel;
    ActivityMainBinding mainBinding;
    final static public String KEY_A_SCORE = "aScore";
    final static public String KEY_B_SCORE = "bScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        scoreViewModel = new ViewModelProvider(this,
//                new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(ScoreViewModel.class);
//        if (savedInstanceState != null) {
//            scoreViewModel.getAScore().setValue(savedInstanceState.getInt(KEY_A_SCORE, 0));
//            scoreViewModel.getBScore().setValue(savedInstanceState.getInt(KEY_B_SCORE, 0));
//        }

        scoreViewModel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(ScoreViewModel.class);
        mainBinding.setModel(scoreViewModel);
        mainBinding.setLifecycleOwner(this);

    }

    @Override
    protected void onPause() {
        scoreViewModel.save();
        super.onPause();
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(KEY_A_SCORE, scoreViewModel.getAScore().getValue());
//        outState.putInt(KEY_B_SCORE, scoreViewModel.getBScore().getValue());
//    }
}