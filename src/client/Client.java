package client;

import java.io.*;
import java.rmi.RemoteException;

import org.datacontract.schemas._2004._07.ShopServerLibrary.Product;
import org.tempuri.IShopServiceProxy;

public class Client {
	static int id;
	static boolean shopping = false;
	static boolean loggedIn = false;
	
	public static void main(String[] args) throws RemoteException, IOException{
		IShopServiceProxy proxy = new IShopServiceProxy();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(Product p : proxy.getAllProducts()){
			System.out.println(p.getName());
		}
		System.out.println("--------------------------------------------------");
		
		shopping = true;
		
		//menu for users that are not loggedin
		while(shopping && !loggedIn){
			System.out.println("Welcome to our shop guest.\n"
					+ "Press 1 to register.\n"
					+ "Press 2 to log in.\n"
					+ "Press 0 to quit.");
			
			String input = br.readLine();
			
			if(input.equals("1")){
				System.out.println("U are going to register yourself\n");
				String rUsername = br.readLine();
				//TODO use rUsername to register user
				System.out.println("Your password: ");
				
			}
			else if(input.equals("2")){
				
				System.out.println("U are now logging in.\n"
						+ "Type your username: ");
				
				String username = br.readLine();
				System.out.println("Type your password: ");
				
				String password = br.readLine();
				
				System.out.println("\nChecking your credentials...\n");
				//call login service
				//set id on customer id
				//set loggedin on true
				System.out.println("You succesfully logged in.\n");
				loggedIn = true;
				
				while(loggedIn && shopping){
					System.out.println("Welcome :)\n" /*name of user*/
							+ "Press 1 to see all products currently in stock.\n"
							+ "Press 2 to see all your products.\n"
							+ "Press 3 to see your balance.\n"
							//TODO add option to buy a product
							+ "Press 4 to log out. :(\n");
					String input1 = br.readLine();
					if(input1.equals("1")){
						System.out.println("All of our products\n");
						//TODO add getAllProducts
					}
					else if(input1.equals("2")){
						System.out.println("All your products\n");
						//TODO add getBoughtProducts
					}
					else if(input1.equals("3")){
						System.out.println("All of your moneys\n");
						//TODO add getBalance
					}
					else if(input1.equals("4")){
						System.out.println("You logged out :(\n");
						loggedIn = false;
					}
				}
			}
			else if(input.equals("0")){
				System.out.println("You left us. :(");
				shopping = false;
			}
		}
	}
}
