package com.example.contact_swatirathour_c0772098.Room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "contact")
public class Contact implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "first_name")
    private String first_name;

    @NonNull
    @ColumnInfo(name = "last_name")
    private String last_name;

    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    @NonNull
    @ColumnInfo(name = "phone_number")
    private String phone_number;

    @NonNull
    @ColumnInfo(name = "postal_address")
    private String postal_address;

    public Contact( @NonNull String first_name, @NonNull String last_name, @NonNull String email, @NonNull String phone_number, @NonNull String postal_address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.postal_address = postal_address;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getFirst_name() {
        return first_name;
    }

    @NonNull
    public String getLast_name() {
        return last_name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    @NonNull
    public String getPhone_number() {
        return phone_number;
    }

    @NonNull
    public String getPostal_address() {
        return postal_address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(@NonNull String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(@NonNull String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public void setPhone_number(@NonNull String phone_number) {
        this.phone_number = phone_number;
    }

    public void setPostal_address(@NonNull String postal_address) {
        this.postal_address = postal_address;
    }
}
