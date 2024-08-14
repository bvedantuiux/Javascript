import java.util.Scanner;

class UserDefined extends Exception {
    public UserDefined(String s) {
        super(s);
    }
}

class User {
    private int age;
    private double income;
    private String city;
    private boolean vehicle;

    public void getData() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter age:");
            age = sc.nextInt();

            System.out.println("Enter Income:");
            income = sc.nextDouble();

            System.out.println("Enter City:");
            city = sc.next();

            System.out.println("Does user have four-wheeler? (true/false):");
            vehicle = sc.nextBoolean();
        }
    }

    public void validate() throws UserDefined {
        try {
            if (age < 18 || age > 55) {
                throw new UserDefined("Age must be between 18 to 55");
            }

            if (income < 50000 || income > 100000) {
                throw new UserDefined("Income must be between Rs.50,000 to Rs.1,00,000.");
            }

            if (!(city.equals("Pune") || city.equals("Mumbai") || city.equals("Bangalore") || city.equals("Chennai"))) {
                throw new UserDefined("City must be Pune, Mumbai, Bangalore, or Chennai");
            }

            if (!vehicle) {
                throw new UserDefined("User must have a Four-Wheeler.");
            }
        } catch (UserDefined e) {
            System.out.println(e.getMessage());
        }
    }

    public void showData() {
        System.out.println("User Details:");
        System.out.println("Age: " + age);
        System.out.println("Income: Rs." + income);
        System.out.println("City: " + city);
        System.out.println("Has Four-Wheeler: " + (vehicle ? "Yes" : "No"));
    }
}

public class assi9 {
    public static void main(String args[]) {
        User u1 = new User();
        u1.getData();
        try {
            u1.validate();
            u1.showData();
        } catch (UserDefined e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}