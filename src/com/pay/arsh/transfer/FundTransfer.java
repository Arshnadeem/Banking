package com.pay.arsh.transfer;



import java.util.Scanner;

import com.pay.arsh.bean.User;
import com.pay.arsh.bean.utils.Utils;
import com.pay.arsh.validate.Validate;
import com.pay.arsh.services.UserService;
public class FundTransfer implements UserService {
/** summary, while objects in Java are allocated memory on the heap and can store data
* in their fields, the objects themselves do not control memory allocation directly.
* Memory management, including allocation and deallocation, 
* is handled by the Java Virtual Machine (JVM) and its garbage collector.
*/	
	User user1, user2;
	int user, activeAcc;
	Scanner scanner = new Scanner(System.in);
	private String accType;

	{
		user1 = new User();
		user2 = new User();
	}

	public static void main(String[] args) {

		FundTransfer fundTransfer = new FundTransfer();
		fundTransfer.mainMenu();

	}

	private void mainMenu() {

		System.out.println("");

		if (activeAcc != 0) {
			System.out.println("1. Logout");
			System.out.println("2. My Account Detail");
			System.out.println("3. Account Activity");
			System.out.println("4. Fund Transfer");
			System.out.println("5. Withdraw");
			System.out.println("6. Change Pin");

		} else {
			System.out.println("1. Login");
			System.out.println("2. Create Account");
		}

		System.out.println("");

		int menuChoice = scanner.nextInt();
		/**
		 *  System.out.println("1. Logout");
		 */
		if (menuChoice == 1) {
			if (activeAcc == 1) {
				Logout(user1);
			} else if (activeAcc == 2) {
				Logout(user2);
			} else {
				this.login();
			}
		}

		/**
		 * System.out.println("2. My Account Detail");
		 */
		else if (menuChoice == 2) {
			if (activeAcc != 0) {
				if (activeAcc == 1) {
					accountInfo(user1);

				} else if (activeAcc == 2) {

					accountInfo(user2);
				}

			} else {
				createAccount();
			}

		}
		/**
		 * System.out.println("3. Account Activity");
		 */

		else if (menuChoice == 3) {
			if (activeAcc == 1) {
				print(user1.getHistory());
			} else {
				print(user2.getHistory());
			}
			mainMenu();
		}
		/**
		 * System.out.println("4. Fund Transfer");
		 */

		else if (menuChoice == 4) {
			if (activeAcc == 1) {
				this.checkAccount(user1,user2);
			}
			else
			{
			this.checkAccount(user2,user1);
					
			}
				
		}
		/**
		 * System.out.println("5. Withdraw");
		 */

		else if (menuChoice == 5) {
			if (activeAcc == 1) {
				 this.withdraw(user1);			
				 }
			else
			{
				 this.withdraw(user2);			
					
			}
		}
		/**
		 * 	System.out.println("6. Change Pin");
		 */
		
		else if (menuChoice == 6) {
			if (activeAcc == 1) {
				 this.ChangePin(user1);
			}
			else
			{
				this.ChangePin(user2);
			}
		}
	}

	@Override
	public void login() {
		System.out.println("Welcome to bank");
		System.out.println("Eneter Your bank Account Number");
		String accNumber = scanner.next();
      
		//is account no. entered equal to created one for first user?
		if (accNumber.equalsIgnoreCase(user1.getAcccountNumber())) {
			System.out.println("Eneter 6 digit Pin !!!");
			int pin = scanner.nextInt();
			if (Validate.verifyPin(pin, user1)) {
				activeAcc = 1;
				System.out.println("!! Login Successfull   !!");
				createLog(user1, "Account Login");
				mainMenu();
			} else {
				System.out.println("!! Wrong Pin Try Again !!");
				login();
			}
		}
	
		//is account no. entered equal to created one for second user?
		else if (accNumber.equalsIgnoreCase(user2.getAcccountNumber())) {

			System.out.println("Eneter 6 digit Pin !!!");
			int pin = scanner.nextInt();
			if (Validate.verifyPin(pin, user2)) {
				activeAcc = 2;
				System.out.println("!! Login Successfull   !!");
				createLog(user2, "Account Login");
				mainMenu();
			} else {
				System.out.println("!! Wrong Pin Try Again !!");
				login();
			}
		}
	
	else
	{
		System.out.println("!! Your Account Does not Exist !!");
		mainMenu();
	}


	}

	@Override
	public void createAccount() {

		if (user1.getUserName() == null) {
			user = 1;
		} else if (user2.getUserName() == null) {
			user = 2;

		} else {
			System.out.println("!! OOps Only 2 user Can be created...");
		}

		System.out.println("--------Fill Detail to Continue---------");
		System.out.println("====|  Enter Bank Name  |====");
		String bankName = scanner.next();

		if (!Validate.checkLength(3, bankName, false)) {
			print("[!! Bank Name is Not Valid or Empty !! ]");
			createAccount();
		}
		Scanner scanner1 = new Scanner(System.in);

		System.out.println("====|  Full Name  |====");
		String name = scanner1.nextLine();

		if (!Validate.checkLength(2, name, false)) {
			print("[!! Name is Not Valid or Empty !! ]");
			createAccount();
		}
		System.out.println("");

		System.out.println("====|  Email  |====");
		String email = scanner.next();

		if (!Validate.checkLength(10, email, false) && !Validate.validateEmail(email)) {
			print("[!! Email is Not Valid or Empty !! ]");
			createAccount();
		}

		System.out.println("====|  Mobile Number  |====");
		String mobile = scanner.next();

		if (Validate.validateMaxMobile(mobile) || Validate.validateMinMobile(mobile)) {
			print("[!! Mobile Number Must be 10 digit !! ]");
			createAccount();
		}

		System.out.println("====|  Create IFSC Code  |====");
		String ifsc = scanner.next();

		if (!Validate.checkLength(11, ifsc, true)) {
			print("[!! ifsc is Not Valid or Empty !! ]");
			createAccount();
		}

		System.out.println("====|  Select Account Type    |====");
		System.out.println("1.Saving ");
		System.out.println("2.Current");
		int accountType = scanner.nextInt();
		if (accountType != 0 && accountType <= 2) {
			if (accountType == 1)
				accType = "Saving";
			else
				accType = "Current";
		} else {
			print("[!! Account Type is Not Valid !! ]");
		}

		System.out.println("====|    Enter Amount You want to Save   |====");
		int amount = scanner.nextInt();
		if (amount < 0) {
			print("[!! Sorry You Can Not Open an Account With 0(Zero) !! ]");
		}

		System.out.println("====|  Create 6 Digit Pin    |====");
		int pin = scanner.nextInt();
		if (!Validate.checkLength(6, String.valueOf(pin), true)) {
			print("[!! Pin Must Be 6 Digit !! ]");
			createAccount();
		}

		System.out.println("====|   Generating 11 Digit Account Number    |====");
		String acNum = Utils.generateAcNum();
		if (user == 1) {
			user1.setAcccountNumber(acNum);
			user1.setUserName(name);
			user1.setAccountBalance(amount);
			user1.setBankName(bankName);
			user1.setAccountPin(pin);
			user1.setEmail(email);
			user1.setType(accType);
			user1.setAcccountNumber(acNum);
			user1.setHistory(Utils.getTimestamp());
			user1.setIfscCode(ifsc);
			user1.setMobile(mobile);
			this.createLog(user1, " Account Created ");
			this.accountInfo(user1);
		} else {
			user2.setAcccountNumber(acNum);
			user2.setUserName(name);
			user2.setAccountBalance(amount);
			user2.setBankName(bankName);
			user2.setAccountPin(pin);
			user2.setEmail(email);
			user2.setType(accType);
			user2.setAcccountNumber(acNum);
			user2.setHistory(Utils.getTimestamp());
			user2.setIfscCode(ifsc);
			user2.setMobile(mobile);
			this.createLog(user2, " Account Created ");
			this.accountInfo(user2);

		}
	}

	private void accountInfo(User user) {
		System.out.println("-----------*******-------------");
		System.out.println("-----------***[ Account Created Successfully ]***-------------");
		System.out.println("!! Account Detail !!");
		System.out.println("!!~ Bank Name => " + user.getBankName());
		System.out.println("!!~ Account Name => " + user.getUserName());
		System.out.println("!!~ Account Email => " + user.getEmail());
		System.out.println("!!~ Mobile Number => " + user.getMobile());
		System.out.println("!!~ Account Number => " + user.getAcccountNumber());
		System.out.println("!!~ Account Balance => " + user.getAccountBalance());
		System.out.println("!!~ Account Type => " + user.getType());
		System.out.println("!!~ IFSC Code => " + user.getIfscCode());
		System.out.println("!!~ Account Pin => " + user.getAccountPin());
		print("-----------*******-------------");
		this.mainMenu();

	}

	private void print(String string) {
		System.out.println(string);

	}

	@Override
	public void Logout(User user) {
		 activeAcc=0;
		 System.out.println("!!Logout Successfully !!!");
		 createLog(user, "Account Logout ");
		  mainMenu();

	}

	@Override
	public void MyAccountDetail() {
		// TODO Auto-generated method stub

	}

	@Override
	public void AccountActivity() {
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * deducting the amount from the user that is sending 
	 * and adding the amount in the account of receiver
	 */
	public void FundTransfer(int amount, int pin, User fromUser, User toUser) {
		
			if (amount <= fromUser.getAccountBalance()) {
				toUser.setAccountBalance(toUser.getAccountBalance() + amount);
				fromUser.setAccountBalance(fromUser.getAccountBalance() - amount);
				print("---------***[Fund Transfer Succesfully]*****----------");
				System.out.println("!! ~ Available Balance =: " + fromUser.getAccountBalance());
				createLog(fromUser, amount + " Transfer to " + toUser.getUserName());
				createLog(toUser, amount + "Recevied from " + fromUser.getUserName());
				mainMenu();

			} else {
				System.out.println("!!~Not Enough Balalnce in Account ");
				System.out.println("----------------------------------");
				mainMenu();
			}
		} 
	
	

	

	@Override
	public void withdraw(User user) {
		System.out.println("!!~ Enter Amount");
		int amount = scanner.nextInt();

		System.out.println("!!~ Enter 6 Digit Pin");
		int pin = scanner.nextInt();
		if (Validate.verifyPin(pin, user)) {
			if (amount <= user.getAccountBalance()) {

				user.setAccountBalance(user.getAccountBalance() - amount);
				print("---------***[withdraw Succesfully]*****----------");
				System.out.println("!! ~ Available Balance =: " + user.getAccountBalance());
				createLog(user, amount + "withdraw");
				mainMenu();
			} else {
				System.out.println("!!~Not Enough Balalnce in Account ");
				System.out.println("----------------------------------");
				mainMenu();

			}

		}

		else {
			System.out.println("[!!Pin is Not Valid !!]");
			mainMenu();
		}

	}

	@Override
	public void ChangePin(User user) {
		 print("!!~ Eneter Your Old Pin");
		 int oldPin=scanner.nextInt();
		 if(oldPin==user.getAccountPin())
		 {
			 print("!!~ Eneter Your New Pin");
			 int newPin=scanner.nextInt();
			 user.setAccountPin(newPin);
			 print("*********Your Pin has updated successfully************");
			 mainMenu();
			 
			 
		 }
		 else
		 {
			 print("!!~ You have Entered Wrong  Pin "); 
			 mainMenu();
			 
		 }

	}

	@Override
	public void createLog(User user, String msg) {

		String history = null;
		if (user.getHistory() == null) {
			history = "";
		} else {
			history = user.getHistory();

		}
		user.setHistory(msg + " on " + Utils.getTimestamp() + "\n" + history);
	}

	@Override
	public void checkAccount(User fromUser, User toUser) {
		 
		System.out.println("!!~ Enter Receiver Account no . You want to send Money");
		String accountNo=scanner.next();
		
		if(accountNo.equalsIgnoreCase(fromUser.getAcccountNumber()))
		{
			System.out.println("!!~ You can not send Money to Own Account");
			mainMenu();
		}
		//if accno. is equal to to that no. then money can be transfered
		else if(accountNo.equalsIgnoreCase(toUser.getAcccountNumber()))
				{
			    print("!! ~ You are Sending Money to "+ toUser.getUserName());
			    print("!! ~ Enter Amount");
			     int  amount=scanner.nextInt();
			     print("!! ~ Enter 6 Digit Pin");
			     int  pin=scanner.nextInt();
			    if(!Validate.verifyPin(pin, fromUser))
			    {
			    	print("!!~ In-Correct Pin");
			    	mainMenu();
			    }
			    //transfer of money for 1st user
		  if(activeAcc==1)
		  {
			  
			  FundTransfer(amount, pin, fromUser, toUser);
		  }
		//transfer of money for 2nd user
		  else
		  {

			  FundTransfer(amount, pin, toUser, fromUser);
			  
		  }
			    
				}
		
		else
		{
			System.out.println("!! This Account number Does not Exist... ");
			mainMenu(); 
			
			
		}
		
	}

}
