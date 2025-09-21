package com.LibraryManagementSystem.DAT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.LibraryManagementSystem.Controler.MainHibernate;
import com.LibraryManagementSystem.Entity.Author;
import com.LibraryManagementSystem.Entity.Book;

public class SettingData {

	Scanner sc = new Scanner(System.in);

	public Author addBookAndAuthor() {

		Author author1 = null;

		List<Book> bookList = new ArrayList<>();

		System.out.println("Enter Author Name");
		String name = sc.nextLine();

		System.out.println("Enter Author Email");
		String email = sc.nextLine();

		author1 = new Author(name, email, bookList);

		boolean isFalse = true;

		while (isFalse) {

			System.out.println("Enter Title Of book");
			String title = sc.nextLine();

			System.out.println("Enter Isbn No of book");
			String isbn = sc.nextLine();

			System.out.println("Enter Price of book");
			String price = sc.nextLine();

			Book book1 = new Book(title, isbn, price, author1);

			bookList.add(book1);
			author1.setBooks(bookList);

			System.out.println("Did you want To Store book by same author if yes press Y if no press N");

			char ch = sc.next().toLowerCase().charAt(0);
			sc.nextLine();

			isFalse = (ch == 'y');
		}
		return author1;
	}

	public String getData() {

		System.out.println("Enter Auther ID To see The Author Books");
		String name = sc.nextLine();

		return name;
	}

	public void updateBookDetails() {

		System.out.println("Update Book ID or ISBN no");
		String isbn = sc.nextLine();

		System.out.println("Enter Title To update");
		String title = sc.nextLine();

		System.out.println("Enter Price To Update");
		String price = sc.nextLine();
		
		new MainHibernate().updateBookDetails(isbn, title, price);
	}
	
	public void deleteAuthor() {
		
		System.out.println("Enter Auther Name ");
		String name = sc.nextLine();
		
		new MainHibernate().deleteAuthor(name);		
		
	}

}
