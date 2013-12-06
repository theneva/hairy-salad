package no.nith.rmi.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import no.nith.rmi.client.Client;
import no.nith.rmi.connection.Session;
import no.nith.rmi.connection.UserSession;
import no.nith.rmi.server.util.ClientContainer;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
public class PipServer implements Server, Serializable
{
    /**
     * Default constructor.
     */
    PipServer()
    {
    }

    @Override
    public Session registerSession(Client client, String username, List<String> keywords) throws RemoteException
    {
        ClientContainer.getInstance().getClients().add(client);
        return new UserSession(username, keywords);
    }
}
