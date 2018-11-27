package Server;

import java.util.ArrayList;

public class BookShelf
{
	private ArrayList<Book> bookArrayList;

	public void addBook(Book book)
	{
		bookArrayList.add(book);
	}

	public Book getBook(String bookName)
	{
		if (bookArrayList.contains(bookName))
			return bookArrayList.get(bookArrayList.indexOf(bookName));
		else
			return null;
	}

	public void removeBooks(Book... books)
	{
		for (Book book :
				books)
			bookArrayList.remove(book);
	}
}
