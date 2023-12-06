package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String deptName = sc.next();
        System.out.print("Dia do pagamento: ");
        int payDay = sc.nextInt();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Telefone: ");
        String phone = sc.next();
        Department department = new Department(deptName, payDay, new Address(email, phone));

        System.out.print("Quantos funcionários tem o departamento? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do funcionário " + i + ":");
            System.out.print("Nome: ");
            String empName = sc.nextLine();
            System.out.print("Salário: ");
            double empSalary = sc.nextDouble();
            sc.nextLine();
            department.addEmployee(new Employee(empName, empSalary));
        }

        showReport(department);
        sc.close();

    }

    public static void showReport(Department dept) {
        System.out.println("FOLHA DE PAGAMENTO:");
        System.out.println("Departamento " + dept.getName() + " = R$ " + String.format("%.2f", dept.payroll()));
        System.out.println("Pagamento realizado no dia " + dept.getPayDay());

        System.out.println("Funcionários: ");
        for (Employee e : dept.getEmployees()) {
            System.out.println(e.getName());
        }
        System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
    }
}
