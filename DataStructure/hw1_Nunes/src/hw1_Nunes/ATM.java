package hw1_Nunes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ATM {

	public static void main(String[] args) throws IOException{
		
		ArrayList<Account> theBook = new ArrayList<Account>();
		
		// banksAccount.txt address
		String directory = "/Users/ricardodossantosalmei/Documents/workspace/CH1/Classes/Ch1/hw1_Nunes/src/hw1_Nunes/bankAccounts.txt";
    	
		// Open file with old accounts and load it into theBook
		loadExistentAccounts(directory, theBook);
		
    	// Message to client
    	System.out.println("ATM at your service!");
    	
    	// Scan input in method and returns as option
    	Scanner input = new Scanner(System.in);
    	
    	char option = 't';
    	// ATM options loop
    	do{
    		
    		optionsATM(input, option, directory, theBook);
    		
    	} while(option != 't');
    	
    	input.close();
    	
    	// Rewrites accounts into file with modifications
    	loadToBankAccounts(directory, theBook);
    	
	}
	
	
	// This method searches for previously created Accounts in bankAccounts.txt
	//			 and  create the Account objects for each loading the balance
	public static void loadExistentAccounts(String directory, ArrayList<Account> oldAccounts){
		
		
		try {
        	
			// To open file
        	File file = new File(directory);
    		Scanner accountLines = new Scanner(file);
    		   // To read from file
    		String currentLine;
    		
        	do{
        		
        		// Storing line in String variable
        		currentLine = accountLines.nextLine();
        		String [] accountLineSplit = currentLine.split(" ");           
        		
        		// Creates Account Object
        		Account oldAccount = new Account(accountLineSplit[1]);
        		// Change Balance for previosly stored accounts
        		oldAccount.Deposit(Double.parseDouble(accountLineSplit[2]));
        		
        		// Add Object to ArrayList
        		oldAccounts.add(oldAccount);
        		
        		
            }while(accountLines.hasNext());
            
        	accountLines.close();
        	
        } catch (IOException ex){
        	ex.printStackTrace();
        } catch (NoSuchElementException ex){}
	
	}

	
	public static void optionsATM(Scanner input, char option, String directory, ArrayList<Account> accounts){

		char optionLogin = 'q';

		do{		
			// Get the option for ATM (o, l or t)
			String clientInput = input.nextLine();
			String[ ] splitInput = clientInput.split(" ");
			
			
			try{
				option = Character.toLowerCase(splitInput[0].charAt(0));
			} catch (StringIndexOutOfBoundsException ex){
				option = 'e';
			}
			
			switch(option){
			
				// Opening an account 
					// splitInput[0] = 'o' 
					// splitInput[1] = String
				case 'o':
				{
					// To get client name
					String owner = splitInput[1];
			
					// Creating new Account object for new account
					Account newAccount = new Account(owner);
					
					// Adding new account to ArrayList
					accounts.add(newAccount);
					
					// Rewriting all to txt file for every account opened
					loadToBankAccounts(directory, accounts);
				
					System.out.println("# "+newAccount.getAccountNo());
			
					break;
				}
		
				
				case 'l':
				{	
					
					// To get account from String input
					try{
						int accountNo = Integer.parseInt(splitInput[1]);
					
						// Find account in theBook 
						int index = 0;
						for(index=0; index<accounts.size() && accounts.get(index).getAccountNo()!=accountNo; index++);
						
						try{
							// Continue from here
							do{
								loginOptions(input, optionLogin, option, directory, accountNo, accounts.get(index), accounts);
						
							}while(optionLogin!='q' && option != 't');	
						} catch (IndexOutOfBoundsException ex){
							System.out.println("ERROR, account does not exist.");
						}
						
						if (option == 't')
							continue;
					} catch (NumberFormatException ex){
						System.out.println("ERROR, incorrect input for Account No");
					}
					break;	
				}
				
				case 't':
					continue;
				
				default:
				{	
					System.out.println("ERROR");
					break;
				}
			}		
		} while	(option != 't');

		System.out.println("ATM SHUTTING DOWN");	
	
	}
	
	public static void loginOptions(Scanner input, char optionLogin, char optionATM, String directory, int accountNo, Account client, ArrayList<Account> accounts){
		
		System.out.println("Hello " + client.owner + "!");
		
		do
		{
		
			double valueOrAccount = 0.0;
			// Getting user's input	
			String [] splitInputLogin = input.nextLine().split(" ");
			try{
				optionLogin = Character.toLowerCase(splitInputLogin[0].charAt(0));
				valueOrAccount = Double.parseDouble(splitInputLogin[1]);
			} catch (NoSuchElementException ex){	
				optionLogin = Character.toLowerCase(splitInputLogin[0].charAt(0));
			} catch (ArrayIndexOutOfBoundsException ex){
				optionLogin = Character.toLowerCase(splitInputLogin[0].charAt(0));
			} catch (StringIndexOutOfBoundsException ex){
				optionLogin = 'e';
			}
			
			switch(optionLogin)
			{
				// Balance
				case 'b':
				{
					System.out.println("= "+client.getBalance());
					break;
				}
				// Deposit
				case 'd':
				{
					client.Deposit(valueOrAccount);
					System.out.println("+ "+valueOrAccount);
					break;
				}
				// Withdraw
				case 'w':
				{
					client.Withdraw(valueOrAccount);
					System.out.println("- "+valueOrAccount);
					break;
				}
				case 'l':
				{
					System.out.print("Goodbye "+ client.owner + "!");
					
					int otherAccountNo = (int)valueOrAccount;
					
					int index = 0;
					for(index=0; index<accounts.size() && accounts.get(index).getAccountNo()!=otherAccountNo; index++);
				
					client = accounts.get(index);
					
					System.out.println("Hello "+ client.owner + "!");
					
					break;
				}
				case 'q':
				{
					System.out.println("Goodbye "+ client.owner + "!");
					break;
				}
				case 't':
				{
					optionLogin = 't';
					optionATM = 't';
					//break;
					continue;
				}
				default:
				{	
					System.out.println("ERROR");
					break;
				}
			}
		} while (optionLogin !='q' && optionATM != 't');

	}
	
	
	public static String readAccountFile(String directory, int accountNo){	
		
		String lineReturn = "";
        
		try {
        	
        	File file = new File(directory);
            
        	int accountNoSplit = 0;
        	
        	Scanner scanner = new Scanner(file);
            // This will reference one line at a time
            //tring line = null;
        	
        	do{
        		
        		lineReturn = scanner.nextLine();
        		String [] accountLineSplit = lineReturn.split(" ");           
        		
        		accountNoSplit = Integer.parseInt(accountLineSplit[0]);
        		
            }while(scanner.hasNext() && accountNo != accountNoSplit);
        
        	scanner.close();
        	
        } catch (IOException ex){
        	ex.printStackTrace();
        }
        
        return lineReturn;
	}
	
	// Comment this
	public static void addAccountToFile(String directory, String expression){

	    	try {
	    		// To add 
	    		FileWriter fileWriter = new FileWriter(directory, false);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	            
	            bufferedWriter.write(expression);
	            bufferedWriter.newLine();

	            bufferedWriter.close();
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }     	

	    }

	// Rewrites theBook into file for every change in the accounts
	public static void loadToBankAccounts(String directory, ArrayList<Account> theBook){
		
		String accountsToString = "";
		for (int i = 0; i < theBook.size(); i++)
		{
			accountsToString += theBook.get(i).getAccountNo() + " "
					+ theBook.get(i).owner + " " 
					+ theBook.get(i).getBalance() +"\n";
		}
		
		addAccountToFile(directory, accountsToString);
	}
	
}
