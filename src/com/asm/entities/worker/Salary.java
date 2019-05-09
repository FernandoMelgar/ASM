package com.asm.entities.worker;


import com.asm.entities.worker.salaries.SalaryIteration;
import com.asm.entities.worker.salaries.SalaryType;

import java.util.Date;

public interface Salary {

    boolean isPayDay();
    Date getPayDayDate();
    void addBonus(double bonus);
    public SalaryType getType();
    public SalaryIteration getIteration();

}
