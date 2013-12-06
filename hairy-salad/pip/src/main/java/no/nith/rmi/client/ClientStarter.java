package no.nith.rmi.client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * A starter for the client. Connects to the local host.
 */
public class ClientStarter
{
    public static void main(String[] args) throws InterruptedException, RemoteException, NotBoundException,
            MalformedURLException
    {
        final String host = null; // local host
        new UserClient(host);
    }
}
