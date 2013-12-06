package no.nith.rmi.server.util;

import no.nith.rmi.client.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton container for clients currently connected to the server.
 */
public class ClientContainer
{
    /** The instance. */
    private static ClientContainer instance;

    /** The clients currently connected to the server. */
    private List<Client> clients;

    private ClientContainer()
    {
        this.clients = new ArrayList<>();
    }

    public static ClientContainer getInstance()
    {
        return instance == null ? (instance = new ClientContainer()) : instance;
    }

    public List<Client> getClients()
    {
        return this.clients;
    }
}
