package com.example.contact_swatirathour_c0772098;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.contact_swatirathour_c0772098.Room.Contact;
import com.example.contact_swatirathour_c0772098.Room.ContactRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText firstName, lastName, email, phone_num, address;
    ContactRepository mContactRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.first_name_ET);
        lastName = findViewById(R.id.last_name_ET);
        email = findViewById(R.id.EmailAddress_ET);
        phone_num = findViewById(R.id.Phone_ET);
        address = findViewById(R.id.TextPostalAddressET);

        findViewById(R.id.AddContactBtn).setOnClickListener(this);

        mContactRepository = new ContactRepository(this.getApplication());

    }

    @Override
    public void onClick(View view) {
        addContact();
    }

    private void addContact() {
        String fname = firstName.getText().toString();
        String lname = lastName.getText().toString();
        String semail = email.getText().toString();
        String pnum = phone_num.getText().toString();
        String saddress = address.getText().toString();
        Contact contact = new Contact(fname, lname, semail, pnum, saddress);
        mContactRepository.insertContact(contact);
        finish();
    }
}