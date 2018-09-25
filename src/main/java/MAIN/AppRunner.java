package MAIN;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class AppRunner {
    private static SessionFactory sessionFactory = null;
    public static void main(String[] args) {
        Employee employee=new Employee("Markowski Damian","Ochroniarz");
        Employee employee2=new Employee("Machowski Tomasz","Przedstawiciel");
        Customer customer=new Customer("Piotr","Wabik",20000);
        Bank bank = new Bank("Lehman Brothers");
        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Set<Employee> newEmployeeGroup = new HashSet<Employee>();
        Set<Customer> newCustomerGroup=new HashSet<Customer>();
        Set<Customer> newRecruitedCustomers=new HashSet<Customer>();
        newRecruitedCustomers.add(customer);
        newEmployeeGroup.add(employee);
        newEmployeeGroup.add(employee2);
        newCustomerGroup.add(customer);
        bank.setEmployeegroup(newEmployeeGroup);
        bank.setCustomergroup(newCustomerGroup);
        customer.setMainBank(bank);
        customer.setRecruiter(employee2);
        employee2.setRecruitedCustomers(newRecruitedCustomers);
        employee.seteBank(bank);
        employee2.seteBank(bank);
        session.save(employee);
        session.save(bank);
        session.save(employee2);
        session.save(customer);
        tx.commit();
        session.close();

    }
    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
