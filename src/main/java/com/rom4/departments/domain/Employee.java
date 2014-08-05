package com.rom4.departments.domain;

import net.sf.oval.constraint.*;
import javax.persistence.*;
import java.util.*;



/**
 * Created by rom4 on 02.07.14.
 */


@Entity
@Table(name="employes")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employe_id")
    private Integer employeID;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="department_id")
    private Department department;

    @Column(name = "first_name")
    private String firstName = null;
    @Column(name = "last_name")
    private String lastName = null;
    @Column(name = "email")
    private String email = null;
    @Column(name = "salary")
    private Float salary = 0.0F;
    @Column(name = "birthday")
    private Date birthday = null;


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEmployeID() {
        return employeID;
    }

    public void setEmployeID( Integer employeID) {
        this.employeID = employeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeID=" + employeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return  employeID == employee.getEmployeID();

    }

    @Override
    public int hashCode() {
        return employeID;
    }

    private class checkFirstName implements CheckWithCheck.SimpleCheck {
        @Override
        public boolean isSatisfied(Object o, Object o2) {

            return true;
        }
    }
}

