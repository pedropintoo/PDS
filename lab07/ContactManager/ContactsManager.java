package ContactManager;

import java.util.ArrayList;
import java.util.List;

public class ContactsManager implements ContactsInterface {

    private List<Contact> contactList = new ArrayList<>();
    private ContactsStorageInterface contactStorage;

    public ContactsManager(ContactsStorageInterface contactStorage) {
        this.contactStorage = contactStorage;
    }

    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        contactList = new ArrayList<>(store.loadContacts());
    }

    @Override
    public void saveAndClose() {
        if (!contactStorage.saveContacts(contactList)) {
            System.err.println("Error saving contacts");
        }
        
    }

    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        if (!store.saveContacts(contactList)) {
            System.err.println("Error saving contacts");
        }
    }

    @Override
    public boolean exist(Contact contact) {
        return contactList.contains(contact);
    }

    @Override
    public Contact getByName(String name) {
        for (Contact c : contactList) {
            if (c.getName().equals(name)) {
                return c;
            }
        }

        return null;
    }

    @Override
    public boolean add(Contact contact) {
        return !exist(contact) && contactList.add(contact);
    }

    @Override
    public boolean remove(Contact contact) {
        return contactList.remove(contact);
    }
    
}
