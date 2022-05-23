package T06DifiningClasses.Lab.P03BankAccount;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> map = new LinkedHashMap<>();

        String[] array = scanner.nextLine().split("\\s+");

        String command = array[0];
        while (!command.equals("End")) {
            String printResult = "";

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    map.put(bankAccount.getId(), bankAccount);
                    printResult = String.format("Account ID%d created", BankAccount.getAcoountCounter());
                    break;

                case "Deposit":
                    int accountId = Integer.parseInt(array[1]);
                    double money = Double.parseDouble(array[2]);

                    if (map.containsKey(accountId)) {
                        BankAccount bankAccountFromMap = map.get(accountId);
                        bankAccountFromMap.deposit(money);
                        map.put(accountId, bankAccountFromMap);

                        printResult = String.format("Deposited %.0f to ID%d", money, accountId);
                    } else {
                        printResult = "Account does not exist";
                    }
                    break;

                case "SetInterest":
                    double newInterestRate = Double.parseDouble(array[1]);
                    BankAccount.setInterestRate(newInterestRate);
                    break;

                case "GetInterest":
                    int accId = Integer.parseInt(array[1]);
                    int years = Integer.parseInt(array[2]);

                    if (map.containsKey(accId)) {
                        BankAccount newBankAccount = map.get(accId);
                        double totalInterest = newBankAccount.getInterestRate(years);
                        printResult = String.format("%.2f", totalInterest);
                    } else {
                        printResult = "Account does not exist";
                    }

                    break;
            }

            if (printResult != "") {
                System.out.println(printResult);
            }

            array = scanner.nextLine().split("\\s+");
            command = array[0];
        }

    }
}
