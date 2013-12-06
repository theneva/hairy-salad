package no.nith.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import no.nith.rmi.connection.Session;
import no.nith.rmi.models.Message;
import no.nith.rmi.server.Server;
import no.nith.rmi.util.InputHandler;

/**
 * GLHFDDDFU! Don't forget to commit!
 */
public class UserClient extends UnicastRemoteObject implements Client
{
    /** The command which the user types in to exit the program. */
    public static final transient String LOGOUT_COMMAND = "/logout";

    /** The session. */
    private Session session;

    public UserClient(final String host) throws RemoteException, NotBoundException
    {
        // TODO the client starter could do this.
        this.connect(host);

        // Start asking for messages.
        this.start();
    }

    private void start()
    {
        final String keywordPrompt = "& some keywords, separated by spaces: ";

        // Request new messages until the user wants to leave.
        for (;;)
        {
            String text = this.getMessage();

            if (text.equals(LOGOUT_COMMAND))
            {
                this.disconnect();
            }

            List<String> keywords = this.getKeywords(keywordPrompt);

            Message message = new Message(text, keywords);
            String sentText = null;

            try
            {
                sentText = session.sendMessage(message);
            }
            catch (RemoteException e)
            {
                // This should never happen.
                e.printStackTrace();
            }

            // Display the message to the sender regardless of subscription.
            // TODO the message is displayed twice if the sender is subscribed to >= 1 of the keywords
            System.out.println(sentText);
        }
    }

    @Override
    public void receiveMessage(String message) throws RemoteException
    {
        JOptionPane.showMessageDialog(null, "receiveMessage was called!");
        System.out.println(message);
    }

    @Override
    public Session getSession()
    {
        return this.session;
    }

    private void connect(final String host) throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry(host);

        Server server = (Server) registry.lookup("PipServer");

        System.err.println("Connected to server!");

        this.session = this.obtainSession(server);

        System.err.println("Obtained session: " + this.session);
    }

    private Session obtainSession(Server server) throws RemoteException
    {
        // Obtain a username and a list of keywords.
        System.out.print("Hello, there! What will your username be? ");
        String username = InputHandler.next();

        final String greeting = "Welcome, "
                + username
                + "! Please list the keywords you would like to subscribe to, separated by spaces.\nEnd your line with a return.\n";

        List<String> keywordsSubscription = this.getKeywords(greeting);

        return server.registerSession(this, username, keywordsSubscription);
    }

    private List<String> getKeywords(String prompt)
    {
        System.out.print(prompt);
        String keywords[] = InputHandler.nextLine().split("\\s");

        return Arrays.asList(keywords);
    }

    private String getMessage()
    {
        System.out.println("Write a message, or " + LOGOUT_COMMAND + " to disconnect.");
        System.out.print("Type away: ");
        return InputHandler.nextLine();
    }

    private void disconnect()
    {
        System.out.println("Goodbye!");

        try
        {
            this.session.close();
        }
        catch (RemoteException e)
        {
            // This is hopefully never going to happen.
            e.printStackTrace();
        }

        System.exit(0);
    }
}
