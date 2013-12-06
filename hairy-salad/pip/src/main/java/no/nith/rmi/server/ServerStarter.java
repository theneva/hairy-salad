package no.nith.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * A starter program for the server.
 */
public class ServerStarter
{
    public static void main(String[] args) throws RemoteException, AlreadyBoundException
    {
        Server object = new PipServer();
        Server stub = (Server) UnicastRemoteObject.exportObject(object, 0);

        Registry registry = LocateRegistry.getRegistry();
        registry.bind("PipServer", stub);

        System.err.println("PipServer ready!");

        // Keep the console alive. TODO clean this mess up.
        new Scanner(System.in).nextLine();
    }
}
