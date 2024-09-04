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
import java.io.FileWriter;
import java.io.IOException;

public class ReceiverForm extends AppCompatActivity {
    private EditText etEmail, etFullName, etContact, etCountry, etAddress;
    private Button btnNext;
    private Sender sender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_form);
        // Retrieve Sender object from intent
        sender = (Sender) getIntent().getSerializableExtra("sender");

        etEmail = findViewById(R.id.etremail);
        etFullName = findViewById(R.id.etrfullname);
        etContact = findViewById(R.id.etrcontact);
        etCountry = findViewById(R.id.etrcountry);
        etAddress = findViewById(R.id.etraddress);
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


                // Create Receiver object
                Reciever receiver = new Reciever(email, fullName, contact, country, address);
                writeToFile("sender.txt", sender.toString());
                writeToFile("receiver.txt", receiver.toString());


                // Send Receiver and Sender objects to the next activity
                Intent intent = new Intent(ReceiverForm.this, ReviewInformation.class);
                intent.putExtra("receiver", receiver);
                intent.putExtra("sender", sender);
                finish();
                startActivity(intent);
            }
        });

    }
    private void writeToFile(String fileName, String content) {
        File file = new File(getFilesDir(), fileName);
        System.out.println(file.getAbsolutePath());
        try (FileWriter writer = new FileWriter(file, true)) { // true to append to file
            writer.write(content + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }
}