package chapter5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class PostData {
 public static void main(String[] args) {
	 try {
		 URL url=new URL("https://example.com");
		 HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		 connection.setRequestMethod("POST");
		 connection.setDoOutput(true);
		 String data="name=" + URLEncoder.encode("Swastik","UTF-8") + "&Program=" + URLEncoder.encode("BCA","UTF-8");
		 try(OutputStream os= connection.getOutputStream()){
			 os.write(data.getBytes(StandardCharsets.UTF_8));
			 os.flush();
		 }
		 try(BufferedReader reader=new BufferedReader(
				 new InputStreamReader(connection.getInputStream()))){
			 String line;
			 while((line=reader.readLine())!=null) {
				 System.out.println(line);
			 }
		 }
		 connection.disconnect();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
 }
}
