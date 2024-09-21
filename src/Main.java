import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista global de usuarios
        List<User> users = new ArrayList<>();

        // Lista global de proyectos
        List<Project> projects = new ArrayList<>();

        // 1. Crear un administrador inicial
        Administrator admin = new Administrator("John");
        users.add(admin); // Agregar el administrador a la lista de usuarios

        // Añadir algunos usuarios iniciales (Programmers y Managers)
        users.add(new Programmer("Bob"));
        users.add(new Programmer("Charlie"));
        users.add(new Manager("Alice"));
        users.add(new Manager("David"));

        // Ciclo para permitir inicio de sesión de diferentes usuarios
        boolean running = true;
        while (running) {
            // 2. Solicitar nombre de usuario para iniciar sesión
            System.out.println("\nWelcome to the Project Management System!");
            System.out.print("Please enter your username (or type 'exit' to quit): ");
            String username = scanner.nextLine();

            // Verificar si el usuario desea salir del programa
            if (username.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the system... Goodbye!");
                break;
            }

            // 3. Buscar el usuario en la lista global
            User user = findUserByName(users, username);
            if (user == null) {
                System.out.println("User not found. Try again.");
                continue; // Volver a pedir el nombre de usuario
            }

            // 4. Verificar el rol del usuario y mostrar el menú correspondiente
            switch (user.getRole()) {
                case RoleNames.ADMINISTRATOR:
                    System.out.println("Welcome, Administrator " + user.getName() + "!");
                    adminMenu(scanner, (Administrator) user, users);
                    break;

                case RoleNames.PROGRAMMER:
                    System.out.println("Welcome, Programmer " + user.getName() + "!");
                    programmerMenu(scanner, (Programmer) user);
                    break;

                case RoleNames.MANAGER:
                    System.out.println("Welcome, Manager " + user.getName() + "!");
                    managerMenu(scanner, (Manager) user, users, projects);
                    break;

                default:
                    System.out.println("Unknown role detected.");
                    break;
            }
        }

        scanner.close();
    }

    // Método para buscar un usuario por su nombre
    public static User findUserByName(List<User> users, String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null; // Devolver null si no se encuentra el usuario
    }

    // Menú para el Administrador
    public static void adminMenu(Scanner scanner, Administrator admin, List<User> users) {
        boolean running = true;
        while (running) {
            System.out.println("\nAdministrator Menu:");
            System.out.println("1. Add User");
            System.out.println("2. List Users");
            System.out.println("3. Log Out");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (option) {
                case 1:
                    System.out.print("Enter the new user's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the new user's role (Programmer/Manager): ");
                    String role = scanner.nextLine();

                    admin.addUser(users, name, role); // Pasar la lista global de usuarios
                    break;

                case 2:
                    // Listar todos los usuarios
                    for (User user : users) {
                        System.out.println(user.getName() + " - " + user.getRole());
                    }
                    break;

                case 3:
                    running = false; // Cerrar sesión
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Menú para el Programador
    public static void programmerMenu(Scanner scanner, Programmer programmer) {
        boolean running = true;
        while (running) {
            System.out.println("\nProgrammer Menu:");
            System.out.println("1. View Assigned Projects");
            System.out.println("2. View Assigned Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Log Out");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (option) {
                case 1:
                    programmer.listAssignedProjects();
                    break;

                case 2:
                    programmer.listAssignedTasks();
                    break;

                case 3:
                    System.out.print("Enter the task description to mark as completed: ");
                    String taskDesc = scanner.nextLine();
                    programmer.markTaskAsCompleted(taskDesc);
                    break;

                case 4:
                    running = false; // Cerrar sesión
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Menú para el Manager
    public static void managerMenu(Scanner scanner, Manager manager, List<User> users, List<Project> projects) {
        boolean running = true;
        while (running) {
            System.out.println("\nManager Menu:");
            System.out.println("1. Create Project");
            System.out.println("2. List Projects");
            System.out.println("3. Assign Programmer to Project");
            System.out.println("4. Create Task in Project");
            System.out.println("5. Log Out");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (option) {
                case 1:
                    System.out.print("Enter the project name: ");
                    String projectName = scanner.nextLine();
                    Project newProject = new Project(projectName, manager);
                    projects.add(newProject);
                    System.out.println("Project created successfully.");
                    break;

                case 2:
                    // Listar proyectos
                    for (Project project : projects) {
                        System.out.println("Project: " + project.getName());
                    }
                    break;

                case 3:
                    System.out.print("Enter the project name: ");
                    String projName = scanner.nextLine();
                    Project project = findProjectByName(projects, projName);
                    if (project != null) {
                        System.out.print("Enter the programmer's name: ");
                        String progName = scanner.nextLine();
                        Programmer programmer = (Programmer) findUserByName(users, progName);
                        if (programmer != null) {
                            manager.assignProgrammerToProject(project, programmer);
                        } else {
                            System.out.println("Programmer not found.");
                        }
                    } else {
                        System.out.println("Project not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the project name: ");
                    String projectForTask = scanner.nextLine();
                    Project taskProject = findProjectByName(projects, projectForTask);
                    if (taskProject != null) {
                        System.out.print("Enter the task description: ");
                        String taskDesc = scanner.nextLine();
                        System.out.print("Enter the programmer's name to assign: ");
                        String progName = scanner.nextLine();
                        Programmer taskProgrammer = (Programmer) findUserByName(users, progName);
                        if (taskProgrammer != null) {
                            manager.createTaskInProject(taskProject, taskDesc, taskProgrammer);
                        } else {
                            System.out.println("Programmer not found.");
                        }
                    } else {
                        System.out.println("Project not found.");
                    }
                    break;

                case 5:
                    running = false; // Cerrar sesión
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Método para buscar un proyecto por su nombre
    public static Project findProjectByName(List<Project> projects, String name) {
        for (Project project : projects) {
            if (project.getName().equalsIgnoreCase(name)) {
                return project;
            }
        }
        return null; // Devolver null si no se encuentra el proyecto
    }
}


