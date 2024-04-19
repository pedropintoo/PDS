/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-19
 */

package ContactManager;

public interface ContactsInterface { 
    public void openAndLoad(ContactsStorageInterface store);  
    public void saveAndClose();  
    public void saveAndClose(ContactsStorageInterface store);  
    public boolean exist(Contact contact); 
    public Contact getByName(String name); 
    public boolean add(Contact contact); 
    public boolean remove(Contact contact); 
}