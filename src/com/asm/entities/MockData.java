package com.asm.entities;

import com.asm.entities.client.Client;
import com.asm.entities.order.Order;
import com.asm.entities.order.Service;
import com.asm.entities.worker.Address;
import com.asm.entities.worker.Employee;
import com.asm.entities.worker.Genre;
import com.asm.entities.worker.SalaryInfo;
import com.asm.entities.worker.salaries.SalaryIteration;
import com.asm.entities.worker.salaries.SalaryType;

import java.util.ArrayList;
import java.util.Date;
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

    private static Employee createFakeEmployee() {
        Employee e = new Employee();
        e.setName("Gabriel");
        e.setSurnames("Hernandez Fonseca");
        e.setPosition("Gerente");
        e.setEmail("gabrielhdz@gmail.com");
        e.setActive("True");
        e.setAddress(MockData.createFakeAddress());
        e.setRfc("GHF003828");
        e.setGenre(Genre.Hombre);
        e.setBirthDate("1987-03-15");
        e.setId("EMPL2537");
        e.setPaysheet(MockData.createFakePaysheet());
        e.setPhone("557679");
        e.setQualification(4);
        e.setSpecialities(MockData.createFakeSpecialtyList());
        return e;
    }

    public static List<Employee> createFakeEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            employees.add(createFakeEmployee());
        }

        return employees;
    }

    private static List<String> createFakeSpecialtyList() {
        List<String> l = new ArrayList<>();
        l.add("Manufactura");
        l.add("Remolque");
        return l;
    }

    public static List<Order> createMockOrders() {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Order o = new Order(new Service("Mantenimiento", 600.0, 40),
                    new Client("Fernando","Melgar"),
                    new Automobile("Audi", "R8", 2000));
            o.setPrice(4000);
            o.setStartDate(new Date());
            o.setMechanic(MockData.createFakeEmployee());
            orders.add(o);
        }

        return orders;
    }
}
