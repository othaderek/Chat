package com.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerMain {
    public static void main(String[] args) {
        // First we have to create a network server
        // In order to create one we need to create a server socket and a port
        // This needs exception handling as well

        int port = 8818;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            // The accept method creates the connection between the server and the client
            // This also must continually accept connections from the client

            while (true){
                System.out.println("About to accept connection");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                ServerWorker worker = new ServerWorker(clientSocket);
                worker.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
