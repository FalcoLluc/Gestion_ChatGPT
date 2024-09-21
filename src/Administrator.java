import java.util.List;

public class Administrator extends User {

    public Administrator(String name) {
        super(name, RoleNames.ADMINISTRATOR);
    }

    //Método para agregar un usuario a la lista global de usuarios
    public void addUser(List<User> users, String name, String role) {
        // Dependiendo del rol, se crea un objeto de tipo Programmer o Manager
        User newUser;
        if (role.equalsIgnoreCase(RoleNames.PROGRAMMER)) {
            newUser = new Programmer(name);
        } else if (role.equalsIgnoreCase(RoleNames.MANAGER)) {
            newUser = new Manager(name);
        } else {
            System.out.println("Invalid role. User not created.");
            return;
        }

        // Agregar el nuevo usuario a la lista global de usuarios
        users.add(newUser);
        System.out.println("User " + name + " with role " + role + " created successfully.");
    }

    // Método para mostrar los permisos del administrador
    @Override
    public void displayRolePermissions() {
        System.out.println("Administrator Permissions: Manage users, manage projects.");
    }
}



