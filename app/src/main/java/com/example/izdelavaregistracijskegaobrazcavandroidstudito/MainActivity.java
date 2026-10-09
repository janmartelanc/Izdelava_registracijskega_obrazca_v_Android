package com.example.izdelavaregistracijskegaobrazcavandroidstudito;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername, etFullName, etCountry, etEmail, etPhone, etPassword;
    private RadioGroup rgGender;
    private CheckBox cbTerms;
    private Button btnCreateAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.editTextText9);
        etFullName = findViewById(R.id.editTextText10);
        etCountry = findViewById(R.id.editTextText11);
        etEmail = findViewById(R.id.editTextText12);
        etPhone = findViewById(R.id.editTextText13);
        etPassword = findViewById(R.id.editTextText14);

        rgGender = findViewById(R.id.radiogroup);
        cbTerms = findViewById(R.id.checkBox);
        btnCreateAccount = findViewById(R.id.button);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prikaziPogovornoOkno();
            }
        });





    }

    private void prikaziPogovornoOkno() {
        // Branje besedila iz polj EditText z getText().toString()
        String username = etUsername.getText().toString();
        String fullName = etFullName.getText().toString();
        String country = etCountry.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        String password = etPassword.getText().toString();

        String gender = "Ni izbrano";
        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        if (selectedGenderId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedGenderId);
            gender = selectedRadioButton.getText().toString(); // Preberemo besedilo TUKAJ
        }
        // Preverjanje potrditvenega polja z isChecked()
        boolean isTermsAccepted = cbTerms.isChecked();
        String termsText = isTermsAccepted ? "Yes" : "No";

        // Sestavljanje večvrstičnega sporočila za dialog
        String message = "Username: " + username + "\n" +
                "Name: " + fullName + "\n" +
                "Country: " + country + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "Password: " + password + "\n" +
                "Gender: " + gender + "\n" +
                "Terms Accepted: " + termsText;

        // Ustvarjanje in prikaz AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Registration Details");
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}