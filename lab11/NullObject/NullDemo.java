/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package NullObject;
   
abstract class Employee { 
    protected String name; 
    public abstract String getName(); 
} 
 
class Programmer extends Employee { 
    public Programmer(String name) { 
    this.name = name; 
    } 
    @Override 
    public String getName() { 
    return name; 
    } 
} 

class NullEmployee extends Employee {
    @Override
    public String getName() {
        return "Not Available";
    }
}
 
class EmployeeFactory { 
    public static final String[] names = { "Mac", "Linux", "Win" }; 
    
    public static Employee getEmployee(String name) { 
        for (int i = 0; i < names.length; i++) { 
            if (names[i].equalsIgnoreCase(name)) { 
                return new Programmer(name); 
            } 
        } 
        return new NullEmployee(); 
    } 
} 
 
public class NullDemo { 
    public static void main(String[] args) { 
    
        Employee emp = EmployeeFactory.getEmployee("Mac"); 
        Employee emp2 = EmployeeFactory.getEmployee("Janela"); 
        Employee emp3 = EmployeeFactory.getEmployee("Linux"); 
        Employee emp4 = EmployeeFactory.getEmployee("Mack"); 
        
        System.out.println(emp.getName()); 
        System.out.println(emp2.getName()); 
        System.out.println(emp3.getName()); 
        System.out.println(emp4.getName()); 
    } 
}