package Factorial;

import java.io.*;
import java.net.*;
import java.util.*;
public class Client_Safalta {
	    public static void main(String[] args) {
	        try {
	            // Connect to server at localhost:6000
	            Socket socket = new Socket("localhost", 6000);

	            // Read integer from user
	            Scanner scanner = new Scanner(System.in);
	            System.out.print("Enter an integer: ");
	            int num = scanner.nextInt();

	            // Send number to server
	            PrintWriter out = new PrintWriter(
	                    socket.getOutputStream(), true);
	            out.println(num);

	            // Read factorial from server
	            BufferedReader in = new BufferedReader(
	                    new InputStreamReader(socket.getInputStream()));
	            String result = in.readLine();

	            System.out.println("Factorial of " + num + " is " + result);

	            // Close resources
	            scanner.close();
	            in.close();
	            out.close();
	            socket.close();

	        } catch (IOException e) {
	            System.out.println("Client error: " + e.getMessage());
	        }
	    }
	}
