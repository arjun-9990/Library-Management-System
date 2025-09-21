package com.LibraryManagementSystem.View;

import java.util.Scanner;

import com.LibraryManagementSystem.Controler.MainHibernate;
import com.LibraryManagementSystem.DAT.SettingData;
import com.LibraryManagementSystem.Entity.Author;

public class View {

	public static void main(String[] args) {

		boolean isRunning = true;

		Scanner sc = new Scanner(System.in);

		while (isRunning) {

			System.out.println("1) :- Add Author with Books");
			System.out.println("2) :- View Books of an Author");
			System.out.println("3) :- Update Book Details");
			System.out.println("4) :- Delete Author (Cascade Books)");
			System.out.println("5) :- Exit");

			System.out.println("Enter the option");

			int no = sc.nextInt();

			switch (no) {
			case 1:
				Author author = new SettingData().addBookAndAuthor();
				new MainHibernate().addOtherAndBook(author);
				break;
			case 2:
				String authorName = new SettingData().getData();
				new MainHibernate().getAllBookOFAuthor(authorName);
				break;
			case 3:
				new SettingData().updateBookDetails();
				break;
			case 4:
				new SettingData().deleteAuthor();
				break;
			case 5:
				isRunning = false;
				break;
			default:
				System.out.println("Wrong number");
			}

		}

	}

}
