package ex2;

// Criei uma nova classe para perceber melhor o padrão
// Não era necessario poderia ser dentro do company
public class FacadeAdmitEmployee extends Company {
    
    public FacadeAdmitEmployee() {
        super();
    }

    @Override
    public void admitEmployee(Person person, double salary) {
        super.admitEmployee(person, salary);
        SocialSecurity.allow(person);
        Insurance.allow(person);
        EmployeeCard.createCard(person);
        Parking.allow(person);
    }

}
