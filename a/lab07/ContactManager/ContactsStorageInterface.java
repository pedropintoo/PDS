/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-19
 */

package ContactManager;
import java.util.List;

public interface ContactsStorageInterface { 
    public List<Contact> loadContacts(); 
    public boolean saveContacts(List<Contact> list); 
}