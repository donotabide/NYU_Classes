
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


// CashAbstract
// 	theBook: ArrayList<Account>
//	theClients: ArrayList<Client>

// Extending from superclass CashAbstract
public class Cash extends CashAbstract{
	
	// Keep in mind:
		// Error messages
		
	
	// Method to read from file
	// Open file
	
	// Check line by line
	// if Account type == 1
	//		
	// if Account type == 2
	
	// directory for theClients.txt address
	private String directory = "/Users/ricardodossantosalmei/Desktop/NYU/Fall16/DataStructure/hw2_Nunes/src/";
	
	
    
	void initClients(){ 
		try{
		// To open file
        	File file = new File(directory+"theClients.txt");
    		Scanner clientLines = new Scanner(file);
    		   // To read from file
    		String currentLine;
    		int i = 0; // Control
        	do{
        		
        		// Storing line in String variable
        		currentLine = clientLines.nextLine();
        		String [] clientLineSplit = currentLine.split(" ");           
        		
        		// Creates Account Object
        		//System.out.println(clientLineSplit[1]);
        		Client oldClient = new Client(clientLineSplit[1]);
        		
        		super.theClients.add(oldClient);
        		
        		//System.out.println("OldClient: "+oldClient.name); // Control
	        	System.out.println("Name: "+super.theClients.get(i).name); // Control
            	System.out.println("Name: "+super.theClients.get(i).clientNo); // Control
        		
        		// Change Balance for previosly stored accounts
        		//oldAccount.Deposit(Double.parseDouble(accountLineSplit[2]));
        		
        		// Add Object to ArrayList
        		//oldAccounts.add(oldAccount);
        		
        		i++; // Control
            }while(clientLines.hasNextLine());
            
        
        	clientLines.close();
        	
        } catch (IOException ex){
        	ex.printStackTrace();
        } catch (NoSuchElementException ex){
        } catch (ArrayIndexOutOfBoundsException ex){}
        
	}; // read from src/theClients.txt
    
    
    void initAccounts(){
    
    	try{
			File file = new File(directory+"theBook.txt");
			Scanner accountsLines = new Scanner(file);
			   // To read from file
			String currentLine;
			//int i = 0; // Control
			
			int now = Integer.parseInt(accountsLines.nextLine().split(" ")[1]);
			int i=0;
			int accountType = 0;
			
			super.theBook.add(new PlusAccount(now));
			super.theBook.add(new SavingAccount(now));
			
			while(accountsLines.hasNextLine()){
			
				// Storing line in String variable
				currentLine = accountsLines.nextLine();
				String [] accountLineSplit = currentLine.split(" ");           
			
				// Creates Account Object
				/*System.out.println(accountLineSplit[0]+" "
									+accountLineSplit[1]+" "
									+accountLineSplit[2]+" "
									+accountLineSplit[3]);
				*/
				
				double balance = Double.parseDouble(accountLineSplit[1]);
				int accountNo = Integer.parseInt(accountLineSplit[2]);
				accountType = Integer.parseInt(accountLineSplit[3]);
										
				Account oldAccount = new Account();
				
				oldAccount.deposit(balance);
				oldAccount.type = accountType;
						
				System.out.println("AccountNoOB: "+accountNo); // Control
				System.out.println("Account TypeOB: "+accountType);
				System.out.println("BalanceOB: "+balance);		
						
				//super.theBook.add(new PlusAccount(now));
				//super.theBook.add(new SavingAccount(now));
				
				//System.out.println("OldClient: "+oldAccount.accountNo); // Control
				try{	
					System.out.println("AccountNo: "+super.theBook.get(i).accountNo); // Control
					System.out.println("Account Type: "+super.theBook.get(i).type);
					System.out.println("Balance: "+super.theBook.get(i).balance);
				} catch (IndexOutOfBoundsException ex){}
				
				
				
				i++;
			}
			accountsLines.close();
			
			
			for(i=0; i < super.theBook.size(); i++){
				if ( super.theBook.get(i).type == 1 ){
					PlusAccount oldAccount;
					oldAccount = new PlusAccount(now);
					super.theBook.add(oldAccount);
					
				}
				else {
					SavingAccount oldAccount;
					oldAccount = new SavingAccount(now);
					super.theBook.add(oldAccount);
				}
				
				try{	
					System.out.println("AccountNoOut: "+super.theBook.get(i).accountNo); // Control
					System.out.println("Account TypeOut: "+super.theBook.get(i).type);
					System.out.println("BalanceOut: "+super.theBook.get(i).balance);
				} catch (IndexOutOfBoundsException ex){}

			}
				
        } catch (IOException ex){
        	ex.printStackTrace();
        } catch (NoSuchElementException ex){
        } catch (ArrayIndexOutOfBoundsException ex){}	
    	
    
    }; // read from src/theBook.txt
    
    boolean processCommand(String[] currLine){
    	
    	
    	
    	return false;
    
    }; // returns false only for Terminate command
    
    
    void saveData(){ 
    
    
    }; // Saving theBook, theClients and currentTime:

	
	/*
	theBook.get(0).getClass().getName().equals("PlusAccount);
	if(theBook.get(0) instanceof PlusAccount){
		((PlusAccount) theBook.get(0)).updateBal(currentTime);
	}*/
}
