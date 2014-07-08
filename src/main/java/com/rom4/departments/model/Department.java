package com.rom4.departments.model;

import java.io.Serializable;

/**
 * Created by rom4 on 02.07.14.
 * This is a department bean
 */
public class Department implements Serializable{
    private String name = null;
    private String city = null;
    private Integer departmentID;

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

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        if (!departmentID.equals(that.departmentID)) return false;

        return true;
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
