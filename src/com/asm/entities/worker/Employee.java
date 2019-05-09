package com.asm.entities.worker;


import com.asm.entities.worker.salaries.DefaultSalary;
import com.asm.entities.worker.skills.Skill;
import com.asm.entities.worker.workhistory.WorkHistory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Employee {

    private long id;
    private String nss;

    private String name;
    private String lastName;
    private String surname;

    private String position;
    Salary salaryInfo;

    private List<Skill> skills;

    private List<WorkHistory> workHistory;
    private double punctuation;

    public Employee() {
        this.nss = "";
        this.name = "";
        this.lastName = "";
        this.surname = "";
        this.position = "";
        this.skills = new ArrayList<>();
        this.workHistory = new ArrayList<>();
        this.punctuation = 0.0;
        this.salaryInfo = new DefaultSalary();
    }

    public String getFullName() {
        if (this.name.equals("") && this.lastName.equals("")) return "No name Found";
        return String.format("%s %s %s",this.name, this.lastName, this.surname);
    }

    public void setFullNameInformation(String name, String lastName, String motherLastName){
        this.name = name;
        this.lastName = lastName;
        this.surname = motherLastName;
    }

    public void setFullNameInformation(String fullName){
        String[] ss = fullName.split(" ");
        this.name = ss[0];
        this.lastName = ss[1];
        this.surname = ss[2];
    }

    public void addSkill(Skill labourSkill) {
        this.skills.add(labourSkill);
    }

    public void removeSkill(String name){
        int i;
        for (i = 0; i < skills.size(); i ++){
            if (skills.get(i).getName().equals(name)) break;
        }
        skills.remove(i);
    }

    public void addToHistory(WorkHistory wk) {
        this.workHistory.add(wk);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Salary getSalaryInfo() {
        return salaryInfo;
    }

    public void setSalaryInfo(Salary salaryInfo) {
        this.salaryInfo = salaryInfo;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<WorkHistory> getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(List<WorkHistory> workHistory) {
        this.workHistory = workHistory;
    }

    public double getPunctuation(){
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.parseDouble(df.format(this.punctuation));
    }

    public void setPunctuation(double punctuation) {
        this.punctuation = punctuation;
    }
}
