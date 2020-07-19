package com.example.contact_swatirathour_c0772098;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.contact_swatirathour_c0772098.Room.Contact;
import com.example.contact_swatirathour_c0772098.Room.ContactRepository;

public class UpdateContact extends AppCompatActivity {

    private Contact contact;
    EditText fname, lname, email, phn,address;
    private ContactRepository mContactRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_contact);
        if(getIntent().hasExtra("contact")) {
            contact = (Contact) getIntent().getSerializableExtra("contact");
        }

        mContactRepository = new ContactRepository(this.getApplication());
        setupViews();
        showValues();
    }

    private void showValues() {
        System.out.println(fname);
        fname.setText(contact.getFirst_name());
        lname.setText(contact.getLast_name());
        email.setText(contact.getEmail());
        phn.setText(contact.getPhone_number());
        address.setText(contact.getPostal_address());
    }

    private void setupViews() {
        fname = findViewById(R.id.first_name_ET);
        lname = findViewById(R.id.last_name_ET);
        email = findViewById(R.id.EmailAddress_ET);
        phn = findViewById(R.id.Phone_ET);
        address = findViewById(R.id.TextPostalAddressET);
    }
    public  void saveBtnClicked(View view){
        String fst_name = fname.getText().toString();
        String lst_name = lname.getText().toString();
        String emaill = email.getText().toString();
        String phoneNum = phn.getText().toString();
        String adress = address.getText().toString();
        if (fst_name != null && lst_name !=null && emaill != null && phoneNum != null && adress != null )
        {
            contact.setFirst_name(fst_name);
            contact.setLast_name(lst_name);
            contact.setEmail(emaill);
            contact.setPhone_number(phoneNum);
            contact.setPostal_address(adress);
        }
        mContactRepository.updateContact(contact);
        finish();
    }
    public  void deleteBtnClicked(View view){
        mContactRepository.deleteContact(contact);
        finish();
    }
}