package com.example.contact_swatirathour_c0772098.Room;

import android.app.Application;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ContactRepository {

    private ContactDao contactDao;


    public ContactRepository(Application application) {
        ContactRoomDb contactRoomDb = ContactRoomDb.getInstance(application);
        contactDao = contactRoomDb.contactDao();
    }

    public void updateContact(Contact contact) {
        if(contact != null) {
            new ContactRepository.UpdateContactAsync(contactDao).execute(contact);
        }
    }

    public void deleteContact(Contact contact) {
        if(contact != null) {
            new ContactRepository.DeleteContactAsync(contactDao).execute(contact);
        }
    }

    public void insertContact(Contact contact) {
        if(contact != null) {
            new ContactRepository.InsertContactAsync(contactDao).execute(contact);
        }
    }

    public List<Contact> fetchAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        try {
            contacts = new FetchAllContacts(contactDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    private class InsertContactAsync extends AsyncTask<Contact, Void, Void> {
        private ContactDao contactDao;

        private InsertContactAsync(ContactDao contactDao) {
            this.contactDao = contactDao;
        }


        @Override
        protected Void doInBackground(Contact... contacts) {
            contactDao.insertContact(contacts[0]);
            return null;
        }
    }
    private class UpdateContactAsync extends AsyncTask<Contact, Void, Void> {
        private ContactDao contactDao;

        private UpdateContactAsync(ContactDao contactDao) {
            this.contactDao = contactDao;
        }


        @Override
        protected Void doInBackground(Contact... contacts) {
            contactDao.updateContact(contacts[0]);
            return null;
        }
    }

    private class DeleteContactAsync extends AsyncTask<Contact, Void, Void> {
        private ContactDao contactDao;

        private DeleteContactAsync(ContactDao contactDao) {
            this.contactDao = contactDao;
        }


        @Override
        protected Void doInBackground(Contact... contacts) {
            contactDao.deleteContact(contacts[0]);
            return null;
        }
    }

    private class FetchAllContacts extends AsyncTask<Void, Void, List<Contact>> {
        private ContactDao contactDao;

        private FetchAllContacts(ContactDao contactDao) {
            this.contactDao = contactDao;
        }


        @Override
        protected List<Contact> doInBackground(Void... voids) {
            return contactDao.getAllContacts();
        }
    }

}
