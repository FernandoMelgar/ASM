package com.asm.entities;

import com.asm.entities.worker.Address;
import com.asm.entities.worker.SalaryInfo;
import com.asm.entities.worker.salaries.SalaryIteration;
import com.asm.entities.worker.salaries.SalaryType;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    public static List<Automobile> createMockAutomobileList() {
        List<Automobile> automobiles = new ArrayList<>();
        Automobile a1 = new Automobile();
        a1.setId("ID8387172");
        a1.setManufacture("Audi");
        a1.setModel("R8");
        a1.setCurrentKilometers(1000L);
        a1.setYear(2016);
        a1.setSerialNumber("SRN3456");
        a1.setLicencePlate("LPC-111");

        Automobile a2 = new Automobile();
        a2.setId("ID7873931");
        a2.setManufacture("Toyota");
        a2.setModel("Yaris");
        a2.setCurrentKilometers(500L);
        a2.setYear(2019);
        a2.setSerialNumber("SRN8976");
        a2.setLicencePlate("LPC-222");
        automobiles.add(a1);
        automobiles.add(a2);

        return automobiles;


    }

    public static Address createFakeAddress() {
       return new Address("Estado","Ciudad","Calle","7788");
    }

    public static SalaryInfo createFakePaysheet() {
        return new SalaryInfo(5000, SalaryType.COMMISSIONED, SalaryIteration.Diario,12356);
    }
}
