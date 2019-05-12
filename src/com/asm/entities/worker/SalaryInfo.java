package com.asm.entities.worker;


import com.asm.entities.worker.salaries.SalaryIteration;
import com.asm.entities.worker.salaries.SalaryType;

public class SalaryInfo {


    private String salary;
    private SalaryType salaryType;
    private SalaryIteration salaryIteration;


    public SalaryInfo(String salary, SalaryType salaryType, SalaryIteration salaryIteration) {
        this.salary = salary;
        this.salaryType = salaryType;
        this.salaryIteration = salaryIteration;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public SalaryType getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(SalaryType salaryType) {
        this.salaryType = salaryType;
    }

    public SalaryIteration getSalaryIteration() {
        return salaryIteration;
    }

    public void setSalaryIteration(SalaryIteration salaryIteration) {
        this.salaryIteration = salaryIteration;
    }
}
