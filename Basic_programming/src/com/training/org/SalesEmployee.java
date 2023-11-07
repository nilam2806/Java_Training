package com.training.org;

import java.util.Scanner;

public class SalesEmployee extends Employee{
	private int sales;
	private double commission;
	private double netSalary;
	private double basicsalary;
	
	public SalesEmployee() {
		System.out.println("Default constructor of SalesEmployee is called");
		this.sales=0;
		this.commission=0;
		this.netSalary=0;
	}

	public SalesEmployee(int empId,String empName,double salary,int sales) {
		super(empId,empName,salary);
		System.out.println("Parameterized constructor of SalesEmployee is called");
		this.sales = sales;
		this.commission = 0;
		this.netSalary = 0;
		
	}
	
	public String toString() {
		return super.toString()+ "Sales "+this.sales+" Commission "+this.commission+" Net Salary"+this.netSalary;
	}
	
	public void CalculateSal() {
	
		if(sales<5000) {
			commission=super.getSalary()*0.05;
	}
		else if(sales>-5000 && sales<10000) {
			commission=super.getSalary()*0.07;
			}
		else if(sales>10000 && sales<15000) {
			commission=super.getSalary()*0.15;
			}
		else {
			System.out.println("commision not allowed");
		}
		netSalary=super.getSalary()+commission;
		}

}

class Salesemployee implements EmpstkInterface{
	private SalesEmployee stk[ ];
    private int top;
    private int sales;
	
	private int empId;
	private String empName;
	private double salary;
	
    Salesemployee()
    {
    	System.out.println("default constructor of sales employee is called");
        stk=new SalesEmployee[0];
        top=0;
}
    public Salesemployee(int empId,String empName,double salary,int sales) {
		
		System.out.println("Parameterized constructor of SalesEmployee is called");
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		
	}
    
    public Salesemployee(int size) {
    	System.out.println("parameterized ");
    	stk=new SalesEmployee[size];
        top=0;
    }
	@Override
	public void push(SalesEmployee se1) {
		if(top==stk.length-1)
        {
                System.out.println("Stack Overflows");
                
        }
        else
                stk[++top]=se1;
		
	}

	@Override
	public SalesEmployee pop() {
		if(top<0) {
			System.out.println("stack underflow");
		return null;
		}
		else 
			return stk[top--];
	}
}
	


