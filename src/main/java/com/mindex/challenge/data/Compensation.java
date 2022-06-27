package com.mindex.challenge.data;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Compensation {
    private float salary;
    private Employee employee;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date effectiveDate;
    private String employeeId;
    public Compensation() {
    }


    public String getEmployeeId() {return employeeId;}
    public void setEmployeeId(String employeeId) {
       this.employeeId = employeeId;
    }


    public Employee getEmployee() {
        return this.employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public void setSalary(float salary) {
        this.salary = salary;
    }
    public float getSalary() {
        return this.salary;
    }


    public void setEffectiveDate(Date date) {
        this.effectiveDate = date;
    }
    public Date getEffectiveDate() {
        return this.effectiveDate;
    }



}
