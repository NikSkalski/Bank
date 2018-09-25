package MAIN;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;
    private String cName;
    private String cFamilyName;
    private int Money;

    public Customer(){};

    public Customer(String cName,String cFamilyName,int Money){
        this.cFamilyName=cFamilyName;
        this.cName=cName;
        this.Money=Money;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    @ManyToOne
    private Bank mainBank;

    public Bank getMainBank() {
        return mainBank;
    }

    public void setMainBank(Bank mainBank) {
        this.mainBank = mainBank;
    }

    @ManyToOne
    private Employee recruiter;//check spelling,man

    public Employee getRecruiter() {

        return recruiter;
    }

    public void setRecruiter(Employee recruiter) {
        this.recruiter = recruiter;
    }

    public String getcFamilyName() {

        return cFamilyName;
    }

    public void setcFamilyName(String cFamilyName) {
        this.cFamilyName = cFamilyName;
    }

    public String getcName() {

        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

}
