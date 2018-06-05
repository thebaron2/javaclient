package client;

import java.io.*;
import java.rmi.RemoteException;
import java.util.*;

import org.datacontract.schemas._2004._07.ShopServerLibrary.*;
import org.tempuri.IShopServiceProxy;

public class Client {
	static int id;
	static boolean shopping = false;
	static boolean loggedIn = false;
	
	public static void main(String[] args) throws RemoteException, IOException{
		IShopServiceProxy proxy = new IShopServiceProxy();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		shopping = true;
		
		//menu for users that are not loggedin
		while(shopping && !loggedIn){
			System.out.println("Welcome to our shop guest.\n"
					+ "Press 1 to register.\n"
					+ "Press 2 to log in.\n"
					+ "Press 0 to quit.");
			
			String input = br.readLine();
			
			if(input.equals("1")){
				System.out.println("U are going to register yourself.\n"
						+ "Type your desired username:");
				String rUsername = br.readLine();
				String register = proxy.register(rUsername);
				
				System.out.println(register + "\n");				
			}
			else if(input.equals("2")){
				
				System.out.println("U are now logging in.\n"
						+ "Type your username: ");
				String username = br.readLine();
				
				System.out.println("Type your password: ");
				String password = br.readLine();
				
				System.out.println("\nChecking your credentials...\n");
				int login = proxy.login(username, password);
				if (login != 0){
					id = login;
					System.out.println("You succesfully logged in.\n");
					loggedIn = true;
					
					while(loggedIn && shopping){
						System.out.println("\nWelcome :)\n" /*name of user*/
								+ "Press 1 to see all products currently in stock.\n"
								+ "Press 2 to buy a product.\n"
								+ "Press 3 to see all your products.\n"
								+ "Press 4 to see your balance.\n"
								+ "Press 5 to log out. :(\n");
						String input1 = br.readLine();
						
						if(input1.equals("1")){
							System.out.println("All of our products\n");
							Product[] pArray = proxy.getAllProducts();
							for(Product p : pArray){
								System.out.println("Product id: "+ p.getId() + " name: " + p.getName() + " for: " 
										+ p.getPrice() + " | amount left: " + p.getAmount());
							}
						}
						else if(input1.equals("2")){
							System.out.println("Buy a product.\n"
									+ "Type the ID of the product you wish to buy:");
							String pId = br.readLine();
							int pID = Integer.parseInt(pId);
							String msg = proxy.buyProduct(id, pID, 1);
							System.out.println(msg);
						}
						else if(input1.equals("3")){
							System.out.println("All your products.\n");
							Product[] uPArray = proxy.getBoughtProducts(id);
							for(Product p : uPArray){
								System.out.println("Product: " + p.getName() + " aantal: " + p.getAmount());
							}
						}
						else if(input1.equals("4")){
							System.out.println("All of your moneys.\n");
							User u = proxy.findUser(id);
							double uBalance = u.getBalance();
							System.out.println("Your Balance: €" + uBalance);
						}
						else if(input1.equals("5")){
							System.out.println("You logged out :(\n");
							loggedIn = false;
						}
					}
				}else{
					System.out.println("Your credentials were incorrect.");
					loggedIn = false;
				}
				
			}
			else if(input.equals("0")){
				System.out.println("You left us. :(");
				shopping = false;
			}
		}
	}
}
