package no.nith.rmi.connection;

import no.nith.rmi.models.Message;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Remote interface for a session.
 */
public interface Session extends Remote, Serializable
{
    /**
     * Sends a message to the users subscribed to one of the message's keywords.
     * 
     * @param message
     *            the message to send.
     */
    String sendMessage(Message message) throws RemoteException;

    /**
     * Closes the session.
     */
    void close() throws RemoteException;

    /**
     * Gets the keywords the user is subscribed to.
     * 
     * @return the keywords.
     */
    List<String> getKeywords() throws RemoteException;

    /**
     * Sets the keywords the user is subscribed to.
     * 
     * @param keywords
     *            the new set of keywords.
     */
    void setKeywords(List<String> keywords) throws RemoteException;
}
