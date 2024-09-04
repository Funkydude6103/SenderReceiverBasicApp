package com.example.senderreceiverbasicapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class SenderForm extends AppCompatActivity {
    private EditText etEmail, etFullName, etContact, etCountry, etAddress;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_form);
        etEmail = findViewById(R.id.etsemail);
        etFullName = findViewById(R.id.etsfullname);
        etContact = findViewById(R.id.etscontact);
        etCountry = findViewById(R.id.etscountry);
        etAddress = findViewById(R.id.etsaddress);
        btnNext = findViewById(R.id.btnnext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String fullName = etFullName.getText().toString().trim();
                String contact = etContact.getText().toString().trim();
                String country = etCountry.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                // Check for empty fields
                if (email.isEmpty() || fullName.isEmpty() || contact.isEmpty() || country.isEmpty() || address.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill out all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validate email
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid email address.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validate contact number (optional, example for phone numbers)
                if (!contact.matches("\\d{11}")) { // Assuming 10-digit phone number
                    Toast.makeText(getApplicationContext(), "Please enter a valid contact number.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // All validations passed
                // Proceed to next step
                // Intent or other actions
                Toast.makeText(getApplicationContext(), "All fields are valid. Proceeding...", Toast.LENGTH_SHORT).show();


                // Create Sender object
                Sender sender = new Sender(email, fullName, contact, country, address);

                // Send Sender object to the next activity
                Intent intent = new Intent(SenderForm.this, ReceiverForm.class);
                intent.putExtra("sender", sender);
                finish();
                startActivity(intent);
            }
        });
    }

}
