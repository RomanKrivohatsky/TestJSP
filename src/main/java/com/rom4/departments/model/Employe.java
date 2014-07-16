package com.rom4.departments.model;



import com.rom4.departments.validation.Email;
import net.sf.oval.constraint.*;
import net.sf.oval.guard.Guarded;

import javax.persistence.*;
import javax.persistence.IdClass;
import java.util.*;

/**
 * Created by rom4 on 02.07.14.
 */


@Entity
@Table(name="employes")
@Guarded
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeID;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    Department department;

    private String firstName = null;
    private String lastName = null;

    @Email
    private String email = null;
    private float salary = 0.0F;
    private Date birthday = null;
    private Integer departmentID = 0;

    public Employe() {
    }

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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "employeID=" + employeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", departmentID=" + departmentID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;

        Employe employe = (Employe) o;

        if (employeID != employe.employeID) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return employeID;
    }

    public static void main (String args[]) {
        /*Employe e = new Employe();

        e.setEmployeID(0);
        //e.setEmail("email");
        e.setFirstName("Ivan");

        //throw new ConstraintsViolatedException();

        Validator validator = new net.sf.oval.Validator();
        java.util.List<ConstraintViolation> violations = validator.validate(e);
        if (!violations.isEmpty()) {

            System.out.println(violations.get(0).getMessage());
            System.out.println("1123");
        }*/

    }

    private class checkFirstName implements CheckWithCheck.SimpleCheck {
        @Override
        public boolean isSatisfied(Object o, Object o2) {

            return true;
        }
    }
}
