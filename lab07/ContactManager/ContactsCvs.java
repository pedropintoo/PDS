package ContactManager;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsCvs implements ContactsStorageInterface {
    private String filename;

    public ContactsCvs (String filename) {
        this.filename = filename + ".csv";
    }

    @Override
    public List<Contact> loadContacts() {
        try {
            Scanner f = new Scanner(new FileReader(filename));
            List<Contact> listContacts = new ArrayList<>();

            while (f.hasNext()) {
                String line = f.nextLine();
                String[] param = line.split("-");

                listContacts.add(new Contact(param[0], Integer.parseInt(param[1])));
            }
            f.close();
            return listContacts;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try {
            FileWriter f = new FileWriter(filename);
            for (Contact c: list) {
                f.write(c + "\n");
            }   
            f.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
