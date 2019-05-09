package com.asm.entities.worker.salaries;


import com.asm.entities.worker.Salary;

import java.util.Date;

public class DefaultSalary implements Salary {

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
        return SalaryType.NOTSET;
    }

    @Override
    public SalaryIteration getIteration() {
        return SalaryIteration.NOTSET;
    }
}
