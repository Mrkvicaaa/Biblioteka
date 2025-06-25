package com.example.knjizara.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.knjizara.Repository.FireBaseAuthRepository;

public class AuthViewModel extends ViewModel {

    private final FireBaseAuthRepository authRepository = new FireBaseAuthRepository();

    private final MutableLiveData<Boolean> loginResult = new MutableLiveData<>();
    private final MutableLiveData<Boolean> registerResult = new MutableLiveData<>();

    public LiveData<Boolean> getLoginResult() {
        return loginResult;
    }

    public LiveData<Boolean> getRegisterResult() {
        return registerResult;
    }

    public void login(String email, String password) {
        authRepository.loginUser(email, password, loginResult::postValue);
    }

    public void register(String email, String password) {
        authRepository.registerUser(email, password, registerResult::postValue);
    }
}
