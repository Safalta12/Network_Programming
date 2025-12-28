package Lab;


import java.io.*;
import java.net.*;
import java.util.*;
public class HeaderView_Safalta {
		    public static void main(String[] args) {

		        String urlString="https://example.com";
		            try {
		                URL u = new URL(urlString);  // FIXED
		                URLConnection uc = u.openConnection();

		                System.out.println("URL: " + u);
		                System.out.println("Content-type: " + uc.getContentType());
		                System.out.println("Content-length: " + uc.getContentLength());

		                if (uc.getLastModified() != 0) {
		                    System.out.println("Last modified: " + new Date(uc.getLastModified()));
		                }

		               
		            } catch (MalformedURLException ex) {
		                System.err.println(urlString + " is not a valid URL");
		            } catch (IOException ex) {
		                System.err.println(ex);
		            }

		            System.out.println();
		        }
		    }
		

