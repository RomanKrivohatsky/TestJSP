package com.rom4.departments.model;

import com.rom4.departments.validation.DepartmentNameUnique;
import net.sf.oval.guard.Guarded;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by rom4 on 02.07.14.
 * This is a department bean
 */


@Entity
@Table(name="departments")
@Guarded
public class Department implements Serializable {

    @DepartmentNameUnique
    @Column (name="name")
    private String name = null;

    @Column (name="city")
    private String city = null;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentID;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY,  mappedBy = "department")
    private Collection<Employe> employes;

    public Collection<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(Collection<Employe> employes) {
        this.employes = employes;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (com.rom4.departments.model.Department) o;

        return departmentID.equals(that.getDepartmentID());
    }

    @Override
    public int hashCode() {
        return departmentID.hashCode();
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", departmentID=" + departmentID +
                '}';
    }
}
