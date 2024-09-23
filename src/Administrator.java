import java.util.List;

public class Administrator extends User {

    public Administrator(String name) {
        super(name, RoleNames.ADMINISTRATOR);
    }

    // Método para agregar un nuevo usuario
    public void addUser(List<User> users, String name, String role) {
        if (role.equalsIgnoreCase(RoleNames.PROGRAMMER)) {
            users.add(new Programmer(name));
            System.out.println("Programmer " + name + " added successfully.");
        } else if (role.equalsIgnoreCase(RoleNames.MANAGER)) {
            users.add(new Manager(name));
            System.out.println("Manager " + name + " added successfully.");
        } else {
            System.out.println("Invalid role. No user added.");
        }
    }

    // Nuevo método para eliminar un usuario
    public void removeUser(List<User> users, String name) {
        User userToRemove = null;
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                userToRemove = user;
                break;
            }
        }
        if (userToRemove != null && !(userToRemove instanceof Administrator)) {
            users.remove(userToRemove);
            System.out.println("User " + name + " removed successfully.");
        } else if (userToRemove instanceof Administrator) {
            System.out.println("Cannot remove an Administrator.");
        } else {
            System.out.println("User not found.");
        }
    }

    @Override
    public void displayRolePermissions() {
        System.out.println("Administrator Permissions: Manage users, view all data.");
    }
}




