import java.util.*;

public class OptionHandler {
    private String question;
    private List<String> options;

    public OptionHandler(String question, List<String> options) {
        this.question = question;
        this.options = options;
    }

    public int handleOptions(Scanner scanner) {

        boolean notResolved = true;
        int optionInt = 0;
        while(notResolved) {
            try {
                //Get Input
                System.out.println(this.question);
                for (String option : this.options) {
                    System.out.println(option);
                }
                optionInt = scanner.nextInt();
                if (optionInt < 1 || optionInt > options.size()) {
                    throw new IllegalArgumentException("Invalid input, number must be between 1 and " + options.size());
                }
                System.out.println("You selected: " + options.get(optionInt-1));
                scanner.nextLine();
                notResolved = false;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input, not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return optionInt;
    }

    public void handleConfirmation(Scanner scanner) {
        boolean notConfirmed = true;
        while (notConfirmed) {
            try {
                //Get Input
                System.out.println("Enter c to continue!");

                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("c")) {
                    System.out.println("\n**********************************************");
                    notConfirmed = false;
                } else {
                    throw new IllegalArgumentException("Invalid input, enter c to continue!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
