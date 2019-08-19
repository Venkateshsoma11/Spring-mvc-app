package com.dbs.springmvcapp.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

import com.dbs.springmvcapp.model.Address;
import com.dbs.springmvcapp.model.BankAccount;
import com.dbs.springmvcapp.model.Dependent;


@Data
@Entity
@Table
public class Employee {

    public Employee(){}

   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "emp_name")
    private String name;
    
    @Column(name = "department_name")
    private String department_name;
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

   // @NotBlank(message = "Name cannot be null")
    @Column(name = "emp_name")
    private String name;

    @Column(name = "department_name")
    private String department_name;
    
   // @Range(min = 18, max = 58, message = "Employee age should be between 18 and 58")
    private int age;

    private LocalDate dateOfBirth;

   // @Range(min = 25000, max = 75000)
    private double salary;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BankAccount> bankAccountSet = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Dependent> dependents = new HashSet<>();
    
    public Employee(long id, String name,int age){
        this.id = id;
        this.name = name;
        this.age=age;
       //this.department_name=department_name;
        
    }
    public void addBankAccount(BankAccount bankAccount) {
        this.bankAccountSet.add(bankAccount);
        bankAccount.setEmployee(this);
    }

    public void addDependent(Dependent dependent){
        this.dependents.add(dependent);
        dependent.setEmployee(this);
    }
    
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth =  LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
     }
     public String getDateOfBirth(){
         if(this.dateOfBirth != null) {
             return this.dateOfBirth.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
         }
         return "";
     }
}