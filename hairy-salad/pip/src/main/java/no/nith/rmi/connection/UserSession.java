package no.nith.rmi.connection;

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import no.nith.rmi.client.Client;
import no.nith.rmi.models.Message;
import no.nith.rmi.server.util.ClientContainer;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
public class UserSession extends UnicastRemoteObject implements Session
{
    /** The username for the session. */
    private String username;

    /** The keywords the user is following. */
    private List<String> keywords;

    public UserSession(String username, List<String> keywords) throws RemoteException
    {
        this.username = username;
        this.setKeywords(keywords);
    }

    @Override
    public String sendMessage(Message message) throws RemoteException {
        String finalMessage = new StringBuilder(this.username).append(": ").append(message.getText()).toString();

        // Send the message to anyone who subscribed to >= 1 of the keywords.
        List<Client> clients = ClientContainer.getInstance().getClients();

        for (Client client : clients)
        {
            List<String> clientSubscription = client.getSession().getKeywords();

            final List<String> messageKeywords = message.getKeywords();
            for (String messageKeyword : messageKeywords)
            {
                // Is the user subscribed to the current word?
                // TODO ignore case
                if (clientSubscription.contains(messageKeyword))
                {
                    client.receiveMessage(finalMessage);
                    break; // No need to keep looking.
                }
            }
        }

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

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public List<String> getKeywords()
    {
        return keywords;
    }

    @Override
    public void setKeywords(List<String> keywords) throws RemoteException
    {
        this.keywords = keywords;
    }
}
