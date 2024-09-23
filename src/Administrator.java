import java.util.List;

public class Administrator extends User {
    public Administrator(String name) {
        super(name, RoleNames.ADMINISTRATOR);
    }

    // Add a user to the system
    public void addUser(List<User> users, String name, String role) {
        // Check if user with the same name already exists
        for (User existingUser : users) {
            if (existingUser.getName().equalsIgnoreCase(name)) {
                System.out.println("User with the name '" + name + "' already exists.");
                return;
            }
        }

        User newUser;
        if (role.equalsIgnoreCase("Programmer")) {
            newUser = new Programmer(name);
        } else if (role.equalsIgnoreCase("Manager")) {
            newUser = new Manager(name);
        } else {
            System.out.println("Invalid role. User not added.");
            return;
        }

        users.add(newUser);
        System.out.println("User '" + name + "' added as " + role + ".");
    }

    // Remove a user from the system by name
    public void removeUser(List<User> users, String name) {
        User userToRemove = findUserByName(users, name);
        if (userToRemove != null) {
            users.remove(userToRemove);
            System.out.println("User '" + name + "' removed.");
        } else {
            System.out.println("User '" + name + "' not found.");
        }
    }

    // List all users in the system
    public void listUsers(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            for (User user : users) {
                System.out.println(user.getName() + " - " + user.getRole());
            }
        }
    }

    // Find a user by name
    public User findUserByName(List<User> users, String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null; // Return null if not found
    }

    @Override
    public void displayRolePermissions() {
        System.out.println("Administrator Permissions: Manage users.");
    }
}







