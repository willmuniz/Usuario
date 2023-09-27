
package usuario;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<User> invitedUsers;
    private User parent;

    public User(String name) {
        this.name = name;
        this.invitedUsers = new ArrayList<>();
        this.parent = null;
    }

    public User(String name, User parent) {
        this(name);
        this.parent = parent;
    }

    public void invite(User newUser) {
        if (!invitedUsers.contains(newUser)) {
            invitedUsers.add(newUser);
        }
    }

    public void listInvitedUsers() {
        for (User invitedUser : invitedUsers) {
            System.out.println(name + " convidou " + invitedUser.getName());
        }
    }

    public void showParent() {
        if (parent != null) {
            System.out.println("O convidado de " + name + " é " + parent.getName());
        } else {
            System.out.println(name + " não tem um convidado.");
        }
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        User firstUser = new User("João");
        User secondUser = new User("Maria", firstUser);
        User thirdUser = new User("Pedro", firstUser);

        firstUser.invite(new User("Ana"));
        firstUser.invite(new User("Carlos"));
        secondUser.invite(new User("Alice"));

        firstUser.listInvitedUsers();
        secondUser.listInvitedUsers();
        thirdUser.listInvitedUsers();

        firstUser.showParent();
        secondUser.showParent();
        thirdUser.showParent();
    }
}
