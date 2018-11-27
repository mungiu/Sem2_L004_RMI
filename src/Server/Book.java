package Server;

public class Book
{
	private String title;
	private String topic;

	public Book(String title, String topic)
	{
		this.title = title;
		this.topic = topic;
	}

	public String getTitle()
	{
		return title;
	}

	public String getTopic()
	{
		return topic;
	}
}
