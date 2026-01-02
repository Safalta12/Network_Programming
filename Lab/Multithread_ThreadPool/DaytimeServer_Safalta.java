package Multithread_ThreadPool;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.concurrent.*;
public class DaytimeServer_Safalta {
	    public static void main(String[] args) {
	        int port = 1313;
	        int poolSize = 50;

	        ExecutorService pool = Executors.newFixedThreadPool(poolSize);

	        try (ServerSocket server = new ServerSocket(port)) {
	            System.out.println("Multithreaded Daytime Server Started on port " + port);

	            while (true) {
	                Socket connection = server.accept();

	                pool.submit(() -> {
	                    try {
	                        System.out.println("Client connected: " +
	                            connection.getInetAddress().getHostAddress());

	                        Writer out = new OutputStreamWriter(connection.getOutputStream());
	                        Date now = new Date();
	                        out.write(now.toString() + "\n");
	                        out.flush();

	                        connection.close();
	                        System.out.println("Connection closed.");
	                    } catch (IOException e) {
	                        System.err.println("Error: " + e.getMessage());
	                    }
	                });
	            }
	        } catch (IOException ex) {
	            System.err.println(ex);
	        }
	    }
	}
