import java.util.*;

public class OptionHandler {
    private String question;
    private List<String> options;

    public OptionHandler(String question, List<String> options) {
        this.question = question;
        this.options = options;
    }

    public int handleOptions() {
        Scanner scanner = new Scanner(System.in);
        Boolean notResolved = true;
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
                notResolved = false;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input, not a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return optionInt;
    }
}
