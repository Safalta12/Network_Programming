package Lab;

import java.net.*;

public class TestReachability_Safalta {

		public static void main(String[] args) {
			try {
				boolean isGoogleReachable= InetAddress.getByName("www.google.com").isReachable(2000);
				System.out.println("Is Google reachable? " + isGoogleReachable);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		}


