package T06DifiningClasses.Lab.P03BankAccount;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int currentId = 0;
        Map<Integer, BankAccount> accountsById = new HashMap<>();

        // 2. While cycle algorithm:
        while (!line.equals("End")) {
            String[] array = line.split(" ");
            String command = array[0];

            // 3.  Commands implementation
            switch (command) {
                // 3.1. Account creating:
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    currentId++;
                    bankAccount.setId(currentId);
                    accountsById.put(currentId, bankAccount);
                    System.out.printf("Account ID" + currentId + " created\n");
                    break;

                // 3.2. Deposit adding in case of correct id:
                case "Deposit":
                    int idDep = Integer.parseInt(array[1]);
                    BankAccount acc = accountsById.get(idDep);
                    if (acc == null) {
                        System.out.println("Account does not exist");
                        line = scanner.nextLine();
                        continue;
                    }

                    int depositSum = Integer.parseInt(array[2]);
                    acc.deposit(depositSum);
                    System.out.printf("Deposited %d to ID%d\n", depositSum, idDep);
                    accountsById.put(idDep, acc);
                    break;

                // 3.3. Setting the new interest rate
                case "SetInterest":
                    double idSetInt = Double.parseDouble(array[1]);
                    BankAccount.setInterestRate(idSetInt);
                    break;

                // 3.4. Interest calculation in case of correct id:
                case "GetInterest":
                    int id = Integer.parseInt(array[1]);
                    if (!accountsById.containsKey(id)) {
                        System.out.println("Account does not exist");
                        line = scanner.nextLine();
                        continue;
                    }

                    int years = Integer.parseInt(array[2]);
                    BankAccount bankAcc = accountsById.get(id);
                    double addedSum = bankAcc.getInterest(years);
                    System.out.printf("%.2f\n", addedSum);
                    break;
            }

            line = scanner.nextLine();
        }
    }
}

/*

class BankAccount

1. int id;
2. double balance;
3. double interestRate

Map<Integer, BankAccount> map

Input 1:

Create                 ->                                                                         account1 = {id = 1, balance = 0, interestRate = 0.02}
Deposit 1 20           ->   acc1Balance = 0 + 20 = 20                                              account1 = {id = 1, balance = 20, interestRate = 0.02}
GetInterest 1 10       ->   double addedSum =  amount * interestRate  * years
                            double addedSum =   20    *   0.02        *   10   = 4.00    account1 - {id = 1, balance = 24, interestRate = 0.02}

Input 2:

Create                 ->                                               account1 = {id = 1, balance = 0,  interestRate = 0.02}
Create                 ->                                               account1 = {id = 1, balance = 0,  interestRate = 0.02}, account2 = {id = 2, balance = 0, interestRate = 0.02}
Deposit 1 20           ->   acc1Balance = 0 + 20 = 20                   account1 = {id = 1, balance = 20, interestRate = 0.02}, account2 = {id = 2, balance = 0, interestRate = 0.02}
Deposit 3 20           ->   Wrong Account
Deposit 2 10           ->   acc2Balance = 0 + 20 = 20                   account1 = {id = 1, balance = 20, interestRate = 0.02}, account2 = {id = 2, balance = 20, interestRate = 0.02}
SetInterest 1.5        ->   The interest of all balances becomes 1.5    account1 = {id = 1, balance = 20, interestRate = 1.5}, account2  = {id = 2, balance = 20, interestRate = 1.5}
GetInterest 1 1        ->   AddedSum1 = (0.15 * 20) * 1 = 3             account1 = {id = 1, balance = 23, interestRate = 1.5}, account2  = {id = 2, balance = 20, interestRate = 1.5}
GetInterest 2 1        ->   AddedSum2 = (0.15 * 20) * 1 = 3             account1 = {id = 1, balance = 23, interestRate = 1.5}, account2  = {id = 2, balance = 23, interestRate = 1.5}
GetInterest 3 1        ->   Wrong Account

 */
