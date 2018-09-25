package MAIN;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idB;
    private String bName;

    @OneToMany
    private Set<Customer> customergroup;

    public Set<Customer> getCustomergroup() {
        return customergroup;
    }

    public void setCustomergroup(Set<Customer> customergroup) {
        this.customergroup = customergroup;
    }

    @OneToMany
    private Set<Employee> employeegroup;

    public Set<Employee> getEmployeegroup() {
        return employeegroup;
    }

    public void setEmployeegroup(Set<Employee> employeegroup) {
        this.employeegroup = employeegroup;
    }

    public Bank(){};
    public Bank(String bName){
        this.bName=bName;
    }


    public String getbName() {

        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }
}
