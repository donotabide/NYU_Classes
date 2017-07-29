import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Fred Fung on 9/8/2016.
 */
public class ATM {
    private static ArrayList<Account> theBook;

    public static void main(String[] args) throws IOException {

        Scanner stdInScanner = new Scanner(System.in);
	if (args.length>0)
	    stdInScanner = new Scanner(new File(args[0]));	// I am
	//	assuming that args[0] is "Input.txt".   Should probably check!
	//	my current Makefile will cause severe error if not fixed.

	System.out.printf("ATM at your service!\n");

        File bankAccountsFile = new File("/Users/ricardodossantosalmei/Desktop/NYU/Fall16/DataStructure/hw1_Solution/src/bankAccounts.txt");
        bankAccountsFile.createNewFile();
        Scanner scanner = new Scanner(bankAccountsFile);
        theBook = new ArrayList<Account>();
        Account loggedinAccount = null;


        while (scanner.hasNextLine()) {
            Account temp = parseAccounts(scanner.nextLine());
            if (temp != null) {
                theBook.add(temp);
            }
        }
        Boolean loopFlag = true;
        while (loopFlag) {
            try {
                String[] input = stdInScanner.nextLine().split(" ");
                switch (Character.toLowerCase(input[0].charAt(0))) {
                    case 't':
                        System.out.println("ATM shutting down!");
                        loopFlag = false;
                        break;
                    case 'o':
                        Account newAccount = new Account(input[1]);
                        theBook.add(newAccount);
                        System.out.println( "#" + newAccount.getAccountNo());
                        break;
                    case 'l':
                        if (loggedinAccount != null) {
                            System.out.printf("Goodbye %s! ", loggedinAccount.owner);
                            loggedinAccount = null;
                        }
                        for(Account tempAccount : theBook){
                            if(tempAccount.getAccountNo() == Integer.parseInt(input[1])){
                                loggedinAccount = tempAccount;
                            }
                        }
                        if (loggedinAccount != null) {
                            System.out.printf("Hello %s!\n", loggedinAccount.owner);
                        } else {
                            System.out.println("ERROR!");
                        }
                        break;
                    case 'd':
                        if (loggedinAccount != null) {
                            double amount = Double.parseDouble(input[1]);
                            loggedinAccount.Deposit(amount);
                            System.out.println("+" + amount);
                        } else {
                            System.out.println("ERROR!");
                        }
                        break;
                    case 'w':
                        if (loggedinAccount != null) {
                            double amount = Double.parseDouble(input[1]);
                            loggedinAccount.Withdraw(amount);
                            System.out.println("-" + amount);
                        } else {
                            System.out.println("ERROR!");
                        }
                        break;
                    case 'b':
                        if (loggedinAccount != null) {
                            System.out.println("=" + loggedinAccount.getBalance());
                        } else {
                            System.out.println("ERROR!");
                        }
                        break;
                    case 'q':
                        if (loggedinAccount != null) {
                            System.out.printf("Goodbye %s!\n", loggedinAccount.owner);
                            loggedinAccount = null;
                        } else {
                            System.out.println("ERROR!");
                        }
                        break;
                    default:
                        System.out.println("ERROR!");
                }
            } catch (Exception ex){
                System.out.println("ERROR!");
            }
        }
        saveTheBook(bankAccountsFile);
    }

    private static Account parseAccounts(String line) {
        String[] temp = line.split(" ");
        if (temp.length != 3) {
            Account.NextAcctNo = Integer.parseInt(line);
            return null;
        }
        Account tempAccount = new Account(temp[0]);
        tempAccount.balance = Double.parseDouble(temp[1]);
        tempAccount.accountNo = Integer.parseInt(temp[2]);
        return tempAccount;
    }

    private static void saveTheBook(File file) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        for (Account tempAccount : theBook) {
            printWriter.printf("%s %s %s\n", tempAccount.owner, tempAccount.getBalance(), tempAccount.getAccountNo());
        }
        printWriter.println(Account.NextAcctNo);
        printWriter.close();
    }
}
