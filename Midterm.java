package Midterm;

public class Midterm {

	public static void main(String[] args) {
		Employee[] emp = {
				new FullTimeEmployee("Frank", 101, 5000),
				new PartTimeEmployee("Lisa", 102, 20, 80),
				new Intern("Gomez", 103, 1000)
		};
		for (int i = 0; i < emp.length; ++i) {
			System.out.println(emp[i]);
			System.out.println();
		}
		System.out.println("Total number of employees: " + Employee.getNumEmp());
		}
		}

	abstract class Employee{
		//properties
		String name;
		int id;
		static int numEmp;
		Employee(){
			numEmp++;
		}
		Employee(String name, int id){
			this.name = name;
			this.id = id;
			numEmp++;
		}
		
		public static int getNumEmp() {
			return numEmp;
		}
		public static void setNumEmp(int numEmp) {
			Employee.numEmp = numEmp;
		}
		abstract double calculateSalary();
		
		@Override
		public String toString() {
			return "Name: " + name + ", ID: " + id;
		}
	} // end Employee
	class FullTimeEmployee extends Employee{
		double monthlySalary;
		FullTimeEmployee(){
			super();
			}
		FullTimeEmployee(String name, int id, double monthlySalary){
			super(name, id);
			this.monthlySalary = monthlySalary;
		}
		double calculateSalary(){
			return monthlySalary;
		}
		@Override
		public String toString() {
			return super.toString() + " Monthly Salary: " + monthlySalary;
		}
	} // end FullTime
	class PartTimeEmployee extends Employee{
		double hourlyRate;
		int hoursWorked;
		PartTimeEmployee(){
			super();
		}
		PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked){
			super(name, id);
			this.hourlyRate = hourlyRate;
			this.hoursWorked = hoursWorked;
		}
		double calculateSalary() {
			return hourlyRate * hoursWorked;
		}
		@Override
		public String toString() {
			return super.toString() + " Salary: " + calculateSalary();
		}
	} // end PartTime
	class Intern extends Employee{
		double stipend;
		Intern(){
			super();
		}
		Intern(String name, int id, double stipend){
			super(name, id);
			this.stipend = stipend;
		}
		double calculateSalary() {
			return stipend;
		}
		@Override
		public String toString() {
			return super.toString() + " Stipend: " + stipend;
		}
	}
