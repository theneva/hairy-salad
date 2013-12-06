package no.nith.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
public class ServerStarter
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            Server object = new PipServer();
            Server stub = (Server) UnicastRemoteObject.exportObject(object, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("PipServer", stub);

            System.err.println("PipServer ready!");

            // Keep the console alive.
            new Scanner(System.in).nextLine();

            // TODO does this work?
//            Naming.rebind("Pip", new PipServer());
//            System.err.println("PipServer ready!");
        }
        catch (RemoteException e)
        {
            System.err.printf("PipServer exception: %s%n", e.toString());
            e.printStackTrace();
        }
    }
}
