package com.asm.interactors;

import com.asm.entities.worker.Employee;
import sun.management.snmp.jvmmib.EnumJvmMemPoolCollectThreshdSupport;

import java.io.IOException;
import java.util.List;

public interface EmployeePersistence {


 /*   void save(Employee c);
    List<Employee> readAll();
    void save(Employee employee) throws IOException;
    Employee read(String id) throws IOException;
    void update(Employee c) throws IOException;
   void delete(String id) throws IOException;
*/
    void save(Employee e);
    List<Employee> readAll() throws IOException;
}

