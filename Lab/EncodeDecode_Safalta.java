package Lab;

import java.net.URLEncoder;
import java.net.URLDecoder;
public class EncodeDecode_Safalta {

	   public static void main(String[] args) {
	      try {
	         String url = "This string has space";
	         String encodedUrl = URLEncoder.encode(url, "UTF-8");
	         System.out.println(encodedUrl); 
	         String decodedUrl = URLDecoder.decode(encodedUrl, "UTF-8");
	         System.out.println(decodedUrl); 
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	}