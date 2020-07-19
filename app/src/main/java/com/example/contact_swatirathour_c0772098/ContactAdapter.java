package com.example.contact_swatirathour_c0772098;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contact_swatirathour_c0772098.Room.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactListHolder> implements Filterable {
    Context context;
    List<Contact> contactList;



    @Override
    public Filter getFilter() {
        return null;
    }

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;

    }

    @NonNull
    @Override
    public ContactListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
      View view =  inflater.inflate(R.layout.list_cell_layout,parent,false);
        return new ContactListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListHolder holder, final int position) {
        final String full_name = contactList.get(position).getFirst_name() + " " + contactList.get(position).getLast_name();
        holder.name.setText(full_name);
        holder.phone.setText(contactList.get(position).getPhone_number());
        holder.cellLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateContact.class);
                intent.putExtra("contact", contactList.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }


    public class ContactListHolder extends RecyclerView.ViewHolder {
        TextView name,phone;
        ConstraintLayout cellLayout;


        public ContactListHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.contact_name_tv);
            phone = itemView.findViewById(R.id.phone_tv);
            cellLayout = itemView.findViewById(R.id.cellLayout);

        }
    }

    public void setContacts(List<Contact> contacts)
    {
        this.contactList = contacts;
        this.notifyDataSetChanged();
    }
}
