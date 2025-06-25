package com.example.knjizara.Repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FireBaseAuthRepository {

    private FirebaseAuth firebaseAuth;

    public FireBaseAuthRepository() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void registerUser(String email, String password, OnAuthResult callback) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> callback.onComplete(task.isSuccessful()));
    }

    public void loginUser(String email, String password, OnAuthResult callback) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> callback.onComplete(task.isSuccessful()));
    }

    public FirebaseUser getCurrentUser() {
        return firebaseAuth.getCurrentUser();
    }

    public void logout() {
        firebaseAuth.signOut();
    }

    public interface OnAuthResult {
        void onComplete(boolean success);
    }
}
