package com.dbs.springmvcapp.controller;

import com.dbs.springmvcapp.model.Address;
import com.dbs.springmvcapp.model.BankAccount;
import com.dbs.springmvcapp.model.Dependent;
import com.dbs.springmvcapp.model.Employee;
import com.dbs.springmvcapp.service.EmployeeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;


@Controller
@RequestMapping("/users")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/login")
    public String login(Model model){
        System.out.println("Came inside the login method ");
        List<Employee> listOfAllEmployees  = employeeService.listAll();
        listOfAllEmployees.forEach(employee ->  System.out.println(employee));
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam("username")String username,
            @RequestParam("password") String password,
            Model model){
        System.out.println("Inside the POST method of login user");
        System.out.println("Username is "+username + " password is "+ password);
        if(username.equalsIgnoreCase(password)){
            model.addAttribute("user", username);
            return "success";
        }
        return "login";
    }
    @GetMapping("/register")
    public String registerId(Model model){
        System.out.println("Came inside the login method ");
        return "register";
    }
    @PostMapping("/register")
    public String registerUser( @Valid @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult) throws IOException {
    	
    	System.out.println(employee);
        Address address = new Address();
        address.setStreet("18th Main");
        address.setCity("Bangalore");
        address.setState("Karnataka");
        address.setZip("577142");

        BankAccount account1 = new BankAccount();
        account1.setPan("AOY45G88M");
        account1.setAccountBalance(5_000);
        BankAccount account2 = new BankAccount();
        account2.setPan("AOY45GG88M");
        account2.setAccountBalance(15_000);

        Dependent dependent1 = new Dependent("Krishna", 63);
        employee.addDependent(dependent1);
       Dependent dependent2 = new Dependent("Radha", 55);
        Dependent dependent3 = new Dependent("Sahitya", 24);
        
        employee.addBankAccount(account1);
        employee.addBankAccount(account2);
        employee.addDependent(dependent1);
        employee.addDependent(dependent2);
        employee.addDependent(dependent3);

       // employee.addDependent(dependent2);
        //employee.setAddress(address);
        //address.setEmployee(employee);
       
        this.employeeService.saveEmployee(employee);
        return "dashboard";
    }


    @GetMapping("/listAll")
    public String listAllEmployees(Model model){
        List<Employee> employees = this.employeeService.listAll();
        model.addAttribute("employees", employees);
        return "list";
    }
    @ExceptionHandler(IOException.class)
    public String handleException(HttpServletRequest request, Exception ex){
        return "error";
    }
}