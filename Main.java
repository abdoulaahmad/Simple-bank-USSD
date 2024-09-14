import java.util.*;
 //Sample Bank USSD Service
public class Main { // Class name should start with a capital letter

    public static void main(String[] args) {
        System.out.println("WELCOME TO ASUFAK BANK USSD");
        System.out.println("1. Enter 1 to Register An Account");
        System.out.println("2. Enter 2 to Know About Us");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt(); // Use a more descriptive variable name

        String firstName, lastName, phone;
        double balance = 1000.0; // Initialize account balance with a starting amount (optional)

        switch (choice) {
            case 1:
                System.out.println("Enter Your First Name");
                firstName = input.next();
                System.out.println("Enter Your Last Name");
                lastName = input.next();
                System.out.println("Enter Your Date Of Birth(E.g 01012001)");
                int dob = input.nextInt(); // Use int for date of birth

                System.out.println("Enter Your Phone Number");
                phone = input.next();

                // Validate phone number length (optional)
                if (phone.length() != 11) {
                    System.out.println("Invalid Input: Phone number must be 11 digits.");
                } else {
                    // Last 10 digits of the phone number
                    String accountNumber = phone.substring(1);

                    System.out.println("Congratulations! You have successfully created an account with us.");
                    System.out.println("New User Bonus Is Deposited In Your Account (#1000)");
                    System.out.println("Your Account Number Is: " + accountNumber);

                    //  Transaction PIN
                    System.out.println("Create your 4-digit PIN: ");
                    int pin = input.nextInt();

                    // Method for the Main Menu
                    showMenu(balance, pin); // Call a method to display the menu And To Create the PIN
                }
                break;

            case 2:
                System.out.println("Asufak Bank We Are Dedicated to providing Exceptional Banking " +
                        "Services To Our Customers");
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void showMenu(double balance, int pin) {
        Scanner input = new Scanner(System.in);

        int option;
        do {

            System.out.println("\nMain Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer"); // Indicate simulation
            //System.out.println("4. Buy Airtime");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Your current balance is: #" + balance);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    balance += depositAmount;
                    System.out.println("Deposit successful. New balance: #" + balance);
                    break;
                case 3:
                    System.out.println("Transfer");
                    System.out.print("Enter recipient account number: ");
                    String recipientAccount = input.next(); // Simulate getting recipient info
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = input.nextDouble();
                    System.out.print("Enter Your Pin ");
                    int enteredPin = input.nextInt();

                    if (enteredPin != pin) {
                        System.out.println("Wrong Pin");
                    } else if (balance >= transferAmount) {
                        balance -= transferAmount;
                        System.out.println("You Have successful Transfer #" + transferAmount + " To " + recipientAccount+ " New balance Is: #" + balance);
                    } else {
                        System.out.println("Insufficient funds for transfer.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using Asufak Bank USSD.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (option != 4); // Keep looping until user exits
    }
}
