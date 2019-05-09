package com.asm.entities.worker.salaries;


import com.asm.entities.worker.Salary;

import java.util.Date;

public class FixedSalary implements Salary {

    private final SalaryType type;
    private final SalaryIteration iteration;

    public FixedSalary(){
        this.type = SalaryType.FIXED;
        this.iteration = SalaryIteration.BIWEEKLY;
    }

    @Override
    public boolean isPayDay() {
        return false;
    }

    @Override
    public Date getPayDayDate() {
        return null;
    }

    @Override
    public void addBonus(double bonus) {
    }

    @Override
    public SalaryType getType() {
        return this.type;
    }

    @Override
    public SalaryIteration getIteration() {
        return this.iteration;
    }
}