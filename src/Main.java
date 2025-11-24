import java.util.ArrayList;

abstract  class Employee{

    private String name;
    private  int id;

    public Employee(String name,int id){  // constructor
        this.name = name;
        this.id = id;
    }  //constructor close


    public String getName(){
        return  name;
    }

    public int getId(){
        return id;
    }

    public abstract  double calculateSalary();  // method

    @Override
    public String toString(){
        return "Employee [name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }
} //class Employee close

class FullTimeEmployee extends Employee{
    private  double monthlySalary;

    public  FullTimeEmployee(String name, int id, double monthlySalary){  //constructor

        super(name, id);
        this.monthlySalary = monthlySalary;

    } // constructor close

    @Override

    public double calculateSalary(){
        return monthlySalary;

    }
} // FullTimeEmployee class close

class PartTimeEmployee extends Employee{
    private  int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){  //constructor
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;

    } //constructor close
    @Override
    public  double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
} // class PartTime close

class PayrollSystem{
    private ArrayList<Employee> employeesList;

    public PayrollSystem(){
        employeesList = new ArrayList<>();//constructor

    } //constructor close

   public void addEmployee(Employee employee){    //method
        employeesList.add(employee);
   } //method close

    public void removeEmployee(int id){
        Employee employeeToRemove = null;

        for(Employee employee : employeesList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeesList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for (Employee employee: employeesList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
      PayrollSystem payrollSystem = new PayrollSystem();
      FullTimeEmployee emp1 = new FullTimeEmployee("Deepanshu", 1, 80000.0);
      PartTimeEmployee emp2 = new PartTimeEmployee("Jex", 2, 40,100);

      payrollSystem.addEmployee(emp1);
      payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employees");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployees();
    }
}