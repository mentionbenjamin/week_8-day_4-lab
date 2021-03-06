package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "managers")
public class Manager extends Employee {

    private double budget;
    private Department department;
    private List<Administrator> administrators;

    public Manager(){}

    public Manager(String name, int niNumber, double salary, double budget){
        super(name, niNumber, salary);
        this.budget = budget;
        this.administrators = new ArrayList<Administrator>();
    }


    @Column(name = "budget")
    public double getBudget() {
        return budget;
    }


    @OneToOne(mappedBy = "manager", fetch = FetchType.LAZY)
    public Department getDepartment() {
        return department;
    }


    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }

    public void addAdmins(Administrator administrator){
        this.administrators.add(administrator);
    }
}
