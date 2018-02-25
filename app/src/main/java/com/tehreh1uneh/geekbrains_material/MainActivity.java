package com.tehreh1uneh.geekbrains_material;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String emailPattern = "^([A-Z|a-z|0-9](\\.|_){0,1})+[A-Z|a-z|0-9]\\@([A-Z|a-z|0-9])+((\\.){0,1}[A-Z|a-z|0-9]){2}\\.[a-z]{2,3}$";
    private TextInputLayout textInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayout = findViewById(R.id.textInputLayoutEmail);

        EditText editTextEmail = findViewById(R.id.editTextEmail);
        editTextEmail.addTextChangedListener(new emailTextWatcher());
    }

    private class emailTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!emailMatches(s)) {
                textInputLayout.setError("not email");
            } else if (!TextUtils.isEmpty(textInputLayout.getError())) {
                textInputLayout.setErrorEnabled(false);
            }
        }

        private boolean emailMatches(CharSequence s) {
            return s.toString().matches(emailPattern);
        }
    }

}
