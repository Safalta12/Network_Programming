package Lab;

import javax.net.ssl.*;
import java.io.*;

public class SecureClient_Safalta {
    public static void main(String[] args) {
        try {
            // Create SSL socket factory
            SSLSocketFactory factory =
                    (SSLSocketFactory) SSLSocketFactory.getDefault();

            // Create secure client socket
            SSLSocket socket =
                    (SSLSocket) factory.createSocket("localhost", 8443);

            // Read data from secure server socket
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message = reader.readLine();
            System.out.println("Message from secure server: " + message);

            // Close resources
            reader.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
