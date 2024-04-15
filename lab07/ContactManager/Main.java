package ContactManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Contact> contacts = new ArrayList<>(
            List.of(
                new Contact("Pedro", 312130),
                new Contact("Joao", 312130),
                new Contact("Maria", 312130),
                new Contact("Jose", 312130),
                new Contact("Ana", 312130)));

        ContactsStorageInterface bin = new ContactsBin("binFile");
        ContactsStorageInterface txt = new ContactsTxt("txtFile");
        ContactsStorageInterface cvs = new ContactsCvs("cvsFile");

        ContactsInterface cm = new ContactsManager(txt);

        for (Contact c : contacts) {
            cm.add(c);
        }
        
        cm.saveAndClose();

        cm.saveAndClose(cvs);

        System.out.println(cm.getByName("Pedro"));
        
    }
}
