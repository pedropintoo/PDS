/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-19
 */

package ContactManager;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ContactsBin implements ContactsStorageInterface {
    private String filename;

    public ContactsBin (String filename) {
        this.filename = filename + ".bin";
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> listContacts = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            while (true) {
                try {
                    Contact c = (Contact) ois.readObject();
                    listContacts.add(c);
                } catch (EOFException e) {
                    break; // End of file reached, stop reading
                }
            }
            return listContacts;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try (FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            for (Contact c : list) {
                oos.writeObject(c);
            }
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
   