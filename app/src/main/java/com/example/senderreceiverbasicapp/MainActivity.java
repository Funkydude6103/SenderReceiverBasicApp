package com.example.senderreceiverbasicapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                delete("receiver.txt");
                delete("sender.txt");
                Intent i = new Intent(MainActivity.this, SenderForm.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }
    public void delete(String name)
    {
        File file = new File(getFilesDir(),name);
        // Check if the file exists
        if (file.exists()) {
            // Attempt to delete the file
            if (file.delete()) {
                System.out.println("File deleted successfully: " + file.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File not found.");
        }
    }
}
