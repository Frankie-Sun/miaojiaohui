package com.example.miaojiaohui2.ui.gongying;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class gongyingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public gongyingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}