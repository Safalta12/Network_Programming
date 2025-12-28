package Lab;

import java.net.*;
import java.util.List;
public class ProxySelector_Safalta {
	    public static void main(String[] args) {
	        try {
	            // Create a URI
	            URI uri = new URI("http://www.example.com");

	            // Get the default ProxySelector
	            ProxySelector proxySelector = ProxySelector.getDefault();

	            // Select proxies for the given URI
	            List<Proxy> proxies = proxySelector.select(uri);

	            // Display proxy details
	            for (Proxy proxy : proxies) {
	                System.out.println("Proxy Type: " + proxy.type());
	                System.out.println("Proxy Address: " + proxy.address());
	           
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

