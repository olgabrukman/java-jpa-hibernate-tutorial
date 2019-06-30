package main.java.com.javahelps.jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class Main {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY;

    public static void main(String[] args) {
        // Create an EntityManagerFactory when you start the application.
        ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JavaHelps");
        // Create two Students
        createStudent("Alice", 22); // Alice will get an id 1
        createStudent("Bob", 20); // Bob will get an id 2
        createStudent("Charlie", 25); // Charlie will get an id 3

        // Print all the Students
        List<Student> students = readAllStudents();
        if (students != null) {
            for (Student stu : students) {
                System.out.println(stu);
            }
        }


        createEmployee("a", "b", 100);
        createEmployee("c", "d", 200);
        createEmployee("e", "f", 300);
        createEmployee("g", "h", 400);

        List<Employee> employees = readAllEmployees();
        if (employees != null) {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }

        // NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
        ENTITY_MANAGER_FACTORY.close();
    }

    /**
     * Create a new Student.
     *
     * @param name
     * @param age
     */
    public static void createStudent(String name, int age) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
            Student stu = new Student();
            stu.setName(name);
            stu.setAge(age);

            // Save the student object
            manager.persist(stu);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }


    public static void createEmployee(String firstName, String lastName,  int salary) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Student object
            Employee e = new Employee();
          //  e.setId(id);
            e.setFirstName(firstName);
            e.setLastName(lastName);
            e.setSalary(salary);
            // Save the student object
            manager.persist(e);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    /**
     * Read all the Students.
     *
     * @return a List of Students
     */
    public static List readAllStudents() {

        List students = null;

        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Students
            students = manager.createQuery("from main.java.com.javahelps.jpa.Student",
                    Student.class).getResultList();

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return students;
    }


    public static List readAllEmployees() {

        List employees = null;

        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Employees
            employees = manager.createQuery("FROM main.java.com.javahelps.jpa.Employee",
                    Employee.class).getResultList();

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return employees;
    }




}