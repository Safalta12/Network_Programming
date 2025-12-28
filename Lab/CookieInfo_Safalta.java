package Lab;

import java.io.*;
import java.net.*;
import java.util.*;
public class CookieInfo_Safalta {
	    public static void main(String[] args) {
	        try {
	            // URL of the website
	            URL url = new URL("http://www.google.com");  // Replace with the actual URL
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	            // Make the request
	            connection.setRequestMethod("GET");
	            connection.connect();

	            // Get all headers
	            Map<String, List<String>> headerFields = connection.getHeaderFields();

	            // Retrieve cookies from the "Set-Cookie" header
	            List<String> cookiesHeader = headerFields.get("Set-Cookie");

	            if (cookiesHeader != null) {
	                // Store cookies in a file
	                FileWriter fw = new FileWriter("cookies.txt");
	                BufferedWriter bw = new BufferedWriter(fw);

	                System.out.println("Cookies retrieved:");
	                for (String cookie : cookiesHeader) {
	                    System.out.println(cookie); // Print cookie
	                    bw.write(cookie);          // Write cookie to file
	                    bw.newLine();
	                }

	                bw.close();
	                System.out.println("\nCookies have been stored in cookies.txt");
	            } else {
	                System.out.println("No cookies found from the server.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
