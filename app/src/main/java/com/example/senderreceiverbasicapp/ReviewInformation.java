package com.example.senderreceiverbasicapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.view.View;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.android.material.imageview.*;

import static androidx.core.util.TypedValueCompat.dpToPx;

public class ReviewInformation extends AppCompatActivity {
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_information);
        ImageView fabAdd= findViewById(R.id.fabAdd);

// Set an onClickListener to handle the click event
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to start another activity
                Intent intent = new Intent(ReviewInformation.this, SenderForm.class);
                startActivity(intent);
            }
        });

        tableLayout = findViewById(R.id.tableLayout);
        List<Reciever> recieverList=getAllReceiver();
        List<Sender> senderList=getAllSender();
        for(int i=0;i<recieverList.size();i++)
        {
            TableRow tableRow = new TableRow(this);


            // Name
            TextView name = new TextView(this);
            name.setText(senderList.get(i).getFullName());
            name.setPadding(20, 8, 8, 8);
            TableRow.LayoutParams nameParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            name.setLayoutParams(nameParams);
            tableRow.addView(name);

            // Country
            TextView country = new TextView(this);
            country.setText(senderList.get(i).getCountry());
            country.setPadding(8, 8, 8, 8);
            TableRow.LayoutParams countryParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            country.setLayoutParams(countryParams);
            tableRow.addView(country);

            // Address
            TextView address = new TextView(this);
            address.setText(senderList.get(i).getAddress());
            address.setPadding(8, 8, 8, 8);
            TableRow.LayoutParams addressParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            address.setLayoutParams(addressParams);
            tableRow.addView(address);

            // Contact
            TextView contact = new TextView(this);
            contact.setText(senderList.get(i).getContact());
            contact.setPadding(8, 8, 8, 8);
            TableRow.LayoutParams contactParams = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            contact.setLayoutParams(contactParams);
            tableRow.addView(contact);

            tableLayout.addView(tableRow);

            TableRow tableRow1 = new TableRow(this);
            ImageView imageView=new ImageView(this);
            // Set the layout parameters for width and height
            int widthInPx = (int) dpToPx(77,this.getResources().getDisplayMetrics()); // Convert 77dp to pixels
            int heightInPx = (int) dpToPx(77,this.getResources().getDisplayMetrics()); // Convert 76dp to pixels

//            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(widthInPx, heightInPx);
//            imageView.setLayoutParams(layoutParams);
            imageView.setMinimumHeight(200);
            imageView.setMinimumWidth(200);
            imageView.setImageResource(R.drawable.baseline_compare_arrows_24);
            imageView.setRotation(90f);
            tableRow1.addView(imageView);
            tableLayout.addView(tableRow1);

            TableRow tableRow2 = new TableRow(this);


            // Name
            name = new TextView(this);
            name.setText(recieverList.get(i).getFullName());
            name.setPadding(20, 8, 8, 8);
            name.setLayoutParams(nameParams);
            tableRow2.addView(name);

            // Country
            country = new TextView(this);
            country.setText(recieverList.get(i).getCountry());
            country.setPadding(8, 8, 8, 8);
            country.setLayoutParams(countryParams);
            tableRow2.addView(country);

            // Address
            address = new TextView(this);
            address.setText(recieverList.get(i).getAddress());
            address.setPadding(8, 8, 8, 8);
            address.setLayoutParams(addressParams);
            tableRow2.addView(address);

            // Contact
            contact = new TextView(this);
            contact.setText(recieverList.get(i).getContact());
            contact.setPadding(8, 8, 8, 8);
            contact.setLayoutParams(contactParams);
            tableRow2.addView(contact);


            tableLayout.addView(tableRow2);

        }
    }
    // Convert dp to pixels


    public List<Reciever> getAllReceiver()
    {
        File file = new File(getFilesDir(), "receiver.txt");
        List<Reciever> receiverList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(", ");
                if (details.length == 4) {
                    Reciever receiver = new Reciever(details[0], details[1], details[2], details[3]);
                    receiverList.add(receiver);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receiverList;
    }
    public List<Sender> getAllSender()
    {
        File file = new File(getFilesDir(), "sender.txt");
        List<Sender> receiverList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(", ");
                if (details.length == 4) {
                    Sender receiver = new Sender(details[0], details[1], details[2], details[3]);
                    receiverList.add(receiver);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return receiverList;
    }
}