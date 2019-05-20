package com.asm.entities.worker;


import com.asm.entities.worker.salaries.SalaryIteration;
import com.asm.entities.worker.salaries.SalaryType;

public class SalaryInfo {


    private int salary;
    private SalaryType salaryType;
    private SalaryIteration payMode;
    private int socialSecurity;




    public SalaryInfo(int salary, SalaryType salaryType, SalaryIteration payMode, int socialSecurity) {
        this.salary = salary;
        this.salaryType = salaryType;
        this.payMode = payMode;
        this.socialSecurity = socialSecurity;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(int socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public SalaryType getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(SalaryType salaryType) {
        this.salaryType = salaryType;
    }

    public SalaryIteration getPayMode() {
        return payMode;
    }

    public void setPayMode(SalaryIteration payMode) {
        this.payMode = payMode;
    }
}
