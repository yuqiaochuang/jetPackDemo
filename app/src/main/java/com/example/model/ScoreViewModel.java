package com.example.model;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.mydemo.ScoreActivity;

//public class ScoreViewModel extends ViewModel {
public class ScoreViewModel extends AndroidViewModel {
    //    private MutableLiveData<Integer> aScore;
//    private MutableLiveData<Integer> bScore;
    static final private String SP_STORE_NAME = "spStoreName";
    private int aScoreBack = DEFAULT_SCORE;
    private int bScoreBack = DEFAULT_SCORE;
    private SavedStateHandle stateHandle;
    final static private int DEFAULT_SCORE = 0;
    private SharedPreferences sp;

    public ScoreViewModel(@NonNull Application application, SavedStateHandle stateHandle) {
        super(application);
        this.stateHandle = stateHandle;

    }

    //    public ScoreViewModel(SavedStateHandle stateHandle) {
//        this.stateHandle = stateHandle;
//    }
    private SharedPreferences getSp() {
        if (sp == null) {
            sp = getApplication().getSharedPreferences(SP_STORE_NAME, Context.MODE_PRIVATE);
        }
        return sp;
    }

    public void save() {
        SharedPreferences.Editor editor = getSp().edit();
        editor.putInt(ScoreActivity.KEY_A_SCORE, getAScore().getValue());
        editor.putInt(ScoreActivity.KEY_B_SCORE, getBScore().getValue());
        editor.apply();
    }

    public MutableLiveData<Integer> getAScore() {
//        if (aScore == null) {
//            aScore = new MutableLiveData<>();
//            aScore.setValue(0);
//        }
//        return aScore;
        if (!stateHandle.contains(ScoreActivity.KEY_A_SCORE)) {
            stateHandle.set(ScoreActivity.KEY_A_SCORE, getSp().getInt(ScoreActivity.KEY_A_SCORE, DEFAULT_SCORE));
        }
        return stateHandle.getLiveData(ScoreActivity.KEY_A_SCORE);
    }

    public MutableLiveData<Integer> getBScore() {
//        if (bScore == null) {
//            bScore = new MutableLiveData<>();
//            bScore.setValue(0);
//        }
//        return bScore;
        if (!stateHandle.contains(ScoreActivity.KEY_B_SCORE)) {
            stateHandle.set(ScoreActivity.KEY_B_SCORE, getSp().getInt(ScoreActivity.KEY_B_SCORE, DEFAULT_SCORE));
        }

        return stateHandle.getLiveData(ScoreActivity.KEY_B_SCORE);
    }

    private void saveOldScore() {
//        aScoreBack = aScore.getValue();
//        bScoreBack = bScore.getValue();
        aScoreBack = getAScore().getValue();
        bScoreBack = getBScore().getValue();
    }

    public void addScore2A(int score) {
        saveOldScore();
//        aScore.setValue(aScoreBack + score);
        getAScore().setValue(aScoreBack + score);
    }

    public void addScore2B(int score) {
        saveOldScore();
//        bScore.setValue(bScoreBack + score);
        getBScore().setValue(bScoreBack + score);
    }

    public void undo() {
//        aScore.setValue(aScoreBack);
//        bScore.setValue(bScoreBack);
        getAScore().setValue(aScoreBack);
        getBScore().setValue(bScoreBack);
    }

    public void reset() {
//        aScore.setValue(DEFAULT_SCORE);
//        bScore.setValue(DEFAULT_SCORE);
        getAScore().setValue(DEFAULT_SCORE);
        getBScore().setValue(DEFAULT_SCORE);
    }

}
