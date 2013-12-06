package no.nith.rmi.client;

import no.nith.rmi.connection.Session;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface for the clients.
 */
public interface Client extends Remote, Serializable
{
    /**
     * Receives a message from the server. Used for callbacks.
     * 
     * @param message
     *            the message to receive.
     */
    void receiveMessage(String message) throws RemoteException;

    /**
     * Returns the client's session.
     * 
     * @return the session.
     */
    Session getSession() throws RemoteException;
}
