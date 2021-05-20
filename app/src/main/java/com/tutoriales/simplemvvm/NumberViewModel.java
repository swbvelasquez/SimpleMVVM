package com.tutoriales.simplemvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumberViewModel extends ViewModel {
    private MutableLiveData<Double> result;

    public NumberViewModel() {
    }

    public MutableLiveData<Double> getResult() {
        if(result ==null){
            result = new MutableLiveData<>();
        }
        return result;
    }

    public void setResult(MutableLiveData<Double> result) {
        this.result = result;
    }

    public void Elevate(double number, double exponent){
        this.result.setValue(NumberUseCase.Elevate(number,exponent)); //para hilo principal ui
        //this.result.postValue();  //para hilo alternativo background
    }
}
