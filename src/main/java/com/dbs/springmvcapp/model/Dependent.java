package com.dbs.springmvcapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@ToString(exclude = "employee")
public class Dependent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;
    @Setter @Getter
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;
    

    public Dependent(String name, int age) {
        this.name = name;
        this.age = age;
    }


	public void setEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employee = employee;
		
	}
}