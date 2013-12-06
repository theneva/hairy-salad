package no.nith.rmi.connection;

import java.io.Serializable;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import no.nith.rmi.client.UserClient;
import no.nith.rmi.models.Message;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
public class PipSession extends UnicastRemoteObject implements Session
{
    /** The client, for pushing messages. */
    private UserClient client;

    /** The username for the session. */
    private String username;

    /** The keywords the user is following. */
    private List<String> keywords;

    public PipSession(UserClient client, String username, List<String> keywords) throws RemoteException
    {
        this.client = client;
        this.username = username;
        this.setKeywords(keywords);
    }

    @Override
    public String sendMessage(Message message)
    {
        String finalMessage = new StringBuilder(this.username).append(": ").append(message.getText()).toString();

        // Print and return the message.
        System.out.println(finalMessage);

        // Make sure the sender of the message sees it regardless of subscriptions.
        return finalMessage;
    }

    @Override
    public void close()
    {
        try
        {
            UnicastRemoteObject.unexportObject(this, true);
        }
        catch (NoSuchObjectException e)
        {
            // This isn't really ever going to happen.
            e.printStackTrace();
        }
    }

    @Override
    public void setKeywords(List<String> keywords) throws RemoteException
    {
        this.keywords = keywords;
    }
}
