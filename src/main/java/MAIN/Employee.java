package MAIN;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idE;
    private String eName;
    private String eposition;
    @ManyToOne
    private Bank eBank;

    @OneToMany
    private Set<Customer> recruitedCustomers;

    public Set<Customer> getRecruitedCustomers() {
        return recruitedCustomers;
    }

    public void setRecruitedCustomers(Set<Customer> recruitedCustomers) {
        this.recruitedCustomers = recruitedCustomers;
    }

    public Bank geteBank() {
        return eBank;
    }

    public void seteBank(Bank eBank) {
        this.eBank = eBank;
    }

    public Employee(){}

    public Employee(String eName,String eposition){
    this.eName=eName;
    this.eposition=eposition;
    }
    public String getEposition() {
        return eposition;
    }

    public void setEposition(String eposition) {
        this.eposition = eposition;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }
}
