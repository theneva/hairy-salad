package no.nith.rmi.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import no.nith.rmi.client.UserClient;
import no.nith.rmi.connection.PipSession;
import no.nith.rmi.connection.Session;

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
    public Session registerSession(UserClient client, String username, List<String> keywords) throws RemoteException
    {
        return new PipSession(client, username, keywords);
    }
}
