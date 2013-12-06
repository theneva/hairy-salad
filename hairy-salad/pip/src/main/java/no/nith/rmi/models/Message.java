package no.nith.rmi.models;

import java.io.Serializable;
import java.util.List;

/**
 * A simple Message containing a text body
 * and a set of keywords for sending to the server.
 */
public class Message implements Serializable
{
    private String message;
    private List<String> keywords;

    public Message(String message, List<String> keywords)
    {
        this.setMessage(message);
        this.setKeywords(keywords);
    }

    public String getText()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public List<String> getKeywords()
    {
        return keywords;
    }

    public void setKeywords(List<String> keywords)
    {
        this.keywords = keywords;
    }
}
