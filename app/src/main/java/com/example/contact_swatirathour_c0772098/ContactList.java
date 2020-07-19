package com.example.contact_swatirathour_c0772098;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.contact_swatirathour_c0772098.Room.Contact;
import com.example.contact_swatirathour_c0772098.Room.ContactRepository;

import java.util.ArrayList;
import java.util.List;

public class ContactList extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private ContactRepository contactRepository;
    private List<Contact> contacts = new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView contactsCount;
    private ContactAdapter mContactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        ((SearchView) findViewById(R.id.search_view)).setOnQueryTextListener(this);
    }

    private void setupData() {
        contactRepository = new ContactRepository(this.getApplication());
        contacts = contactRepository.fetchAllContacts();
        contactsCount = findViewById(R.id.count_contacts_tv);
        contactsCount.setText(contacts.size()+"  contacts");
        for(Contact contact: contacts)
        {
            System.out.println(contact.getFirst_name());
        }
    }


    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        mContactAdapter = new ContactAdapter(this, contacts);
        recyclerView.setAdapter(mContactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void addContactClicked(View view){
        Intent intent = new Intent(ContactList.this,MainActivity.class);
        this.startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupData();
        setupRecyclerView();
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        List<Contact> contacts = new ArrayList<>();
        for(Contact contact: this.contacts)
        {
            if(contact.getFirst_name().contains(s) || contact.getLast_name().contains(s))
            {
                contacts.add(contact);
            }
        }
        contactsCount.setText(contacts.size()+"  contacts");
        mContactAdapter.setContacts(contacts);
        return true;
    }
}
