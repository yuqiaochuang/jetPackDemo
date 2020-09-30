package com.example.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.mydemo.MainActivity;

public class ScoreViewModel extends ViewModel {
    //    private MutableLiveData<Integer> aScore;
//    private MutableLiveData<Integer> bScore;
    private int aScoreBack = DEFAULT_SCORE;
    private int bScoreBack = DEFAULT_SCORE;
    private SavedStateHandle stateHandle;
    final static private int DEFAULT_SCORE = 0;

    public ScoreViewModel(SavedStateHandle stateHandle) {
        this.stateHandle = stateHandle;

    }

    public MutableLiveData<Integer> getAScore() {
//        if (aScore == null) {
//            aScore = new MutableLiveData<>();
//            aScore.setValue(0);
//        }
//        return aScore;
        if (!stateHandle.contains(MainActivity.KEY_A_SCORE)) {
            stateHandle.set(MainActivity.KEY_A_SCORE, DEFAULT_SCORE);
        }
        return stateHandle.getLiveData(MainActivity.KEY_A_SCORE);
    }

    public MutableLiveData<Integer> getBScore() {
//        if (bScore == null) {
//            bScore = new MutableLiveData<>();
//            bScore.setValue(0);
//        }
//        return bScore;

        if (!stateHandle.contains(MainActivity.KEY_B_SCORE)) {
            stateHandle.set(MainActivity.KEY_B_SCORE, DEFAULT_SCORE);
        }
        return stateHandle.getLiveData(MainActivity.KEY_B_SCORE);
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
