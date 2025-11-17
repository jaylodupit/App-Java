import java.util.Scanner;

class User {
    private String username;
    private String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role.toLowerCase(); 
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}

class Students extends User {
    public Students(String username) {
        super(username, "student");
    }
}

class Admin extends User {
    public Admin(String username) {
        super(username, "admin");
    }
}

class Teacher extends User {
    public Teacher(String username) {
        super(username, "teacher");
    }
}

class permission {
    public void checkAccess(User user) {
        switch (user.getRole()) {
            case "student":
                System.out.println(" Student: VIEW ONLY");
                break;
            case "admin":
                System.out.println(" Admin: FULL ACCESS");
                break;
            case "teacher":
                System.out.println("Teacher: VIEW + EDIT");
                break;
            default:
                System.out.println("Access denied.");
                break;
        }
    }
}

class security {

    public boolean CheckPassword(String password) {
        if (password.equals("bading")) {
            System.out.println("Password is correct.");
            return true;
        } else {
            System.out.println("Incorrect password.");
            return false;
        }
    }

    public boolean TwoFactorTruth(int code) {
        int correctCode = 23455;

        if (code == correctCode) {
            System.out.println("Two-factor authentication successful.");
            return true;
        } else {
            System.out.println("Two-factor authentication failed.");
            return false;
        }
    }

    public boolean DetectionofIntrusion(String action) {
        if (action.equalsIgnoreCase("delete")) {  
            System.out.println("Intrusion detected!");
            return false; 
        } else {
            System.out.println("No intrusion detected.");
            return true; 
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        security sec = new security();
        permission perm = new permission();

        System.out.println("Enter your username:");
        String username = sc.nextLine();

        System.out.println("Enter your role (student/admin/teacher):");
        String role = sc.nextLine();

        User user = new User(username, role);

        System.out.println("Enter your password:");
        String password = sc.nextLine();

        if (!sec.CheckPassword(password)) {
            return;
        }

        System.out.println("Enter the two-factor authentication code:");
        int code = sc.nextInt();
        sc.nextLine(); 

        if (!sec.TwoFactorTruth(code)) {
            return;
        }

        System.out.println("Enter an action to perform: view/edit/delete");
        String action = sc.nextLine();   

        if (!sec.DetectionofIntrusion(action)) {  
            System.out.println("Di katuohan! LOCKED!");
            return;
        }

        perm.checkAccess(user);
    }
}