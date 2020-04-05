package com.rigelr.watchedmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Digits;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Max;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

public class RequestActivity extends AppCompatActivity
        implements Validator.ValidationListener {

    Validator validator;
    @NotEmpty
    private TextInputEditText movieInput;
    @NotEmpty
    @Max(value = 2021)
    private TextInputEditText yearInput;
    private TextInputEditText directorInput;
    @NotEmpty
    @Email
    private TextInputEditText emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        movieInput = findViewById(R.id.textTitle);
        yearInput = findViewById(R.id.textYear);
        directorInput = findViewById(R.id.textDirector);
        emailInput = findViewById(R.id.textEmail);

        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "Send Request. check your email", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            }
        }
        if (errors.size() > 0) {
            if (errors.get(0).getView() instanceof EditText) {
                errors.get(0).getView().requestFocus();
            } else {
                String message = errors.get(0).getCollatedErrorMessage(this);
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void handleRequest(View view) {
        validator.validate();
    }
}
