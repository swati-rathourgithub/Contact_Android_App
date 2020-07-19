package com.example.contact_swatirathour_c0772098.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ContactDao {
    @Insert
    void insertContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Update
    void updateContact(Contact contact);

    @Query("SELECT * FROM contact")
    List<Contact> getAllContacts();
}


//
//    @Query("UPDATE employee SET name = :name, department = :department, salary = :salary WHERE id = :id")
//    int updateEmployee(int id, String name, String department, double salary);
//
//    @Query("SELECT * FROM employee ORDER BY name")
//    List<Employee> getAllEmployees();