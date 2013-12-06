package no.nith.rmi.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface for the clients.
 */
public interface Client extends Remote
{
    /**
     * Receives a message from the server. Used for callbacks.
     * @param message the message to receive.
     */
    void receiveMessage(String message) throws RemoteException;
}
