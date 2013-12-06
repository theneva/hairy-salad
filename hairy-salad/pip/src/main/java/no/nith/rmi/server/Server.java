package no.nith.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import no.nith.rmi.client.Client;
import no.nith.rmi.connection.Session;

/**
 * Remote interface for the server.
 */
public interface Server extends Remote
{
    /**
     * Registers and returns a new session.
     * 
     * @param username
     *            the username for the session.
     * @param keywords
     *            the keywords the user is subscribed to.
     * @return the session object.
     */
    Session registerSession(Client client, String username, List<String> keywords) throws RemoteException;
}
