package com.example.model;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class FIndexModel extends ViewModel {
    private MediatorLiveData<Integer> index;



    public MediatorLiveData<Integer> getIndex() {
        if (index == null) {
            index = new MediatorLiveData<>();
            index.setValue(0);
        }
        return index;
    }

    public void setIndex(int index) {
        this.index.setValue( this.index.getValue() + index);
    }
}
