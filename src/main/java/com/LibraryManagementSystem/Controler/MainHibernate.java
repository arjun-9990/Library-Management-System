package com.LibraryManagementSystem.Controler;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.LibraryManagementSystem.Entity.Author;
import com.LibraryManagementSystem.Entity.Book;

public class MainHibernate {

	SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Author.class).addAnnotatedClass(Book.class)
			.configure().buildSessionFactory();

	Session session = null;

	Transaction transaction = null;

	private boolean flag = false;

	public void addOtherAndBook(Author author) {
		session = sessionFactory.openSession();

		transaction = session.beginTransaction();

		try {

			session.persist(author);
			flag = true;

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (flag)
				transaction.commit();
			else
				transaction.rollback();

			session.close();
		}

		sessionFactory.close();

	}

	public void getAllBookOFAuthor(String authorName) {

		session = sessionFactory.openSession();

		Iterator<Author> iterator = session.createQuery("SELECT books FROM Author WHERE name = :name", Author.class)
				.setParameter("name", authorName).list().iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void updateBookDetails(String isbn, String title, String price) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			int data = session.createMutationQuery("UPDATE Book SET title = :title, price = :price WHERE isbn = :isbn")
					.setParameter("title", title).setParameter("price", price).setParameter("isbn", isbn)
					.executeUpdate();

			if (data > 0) {
				System.out.println("Updated Successfully");
			} else {
				System.out.println("Something went wrong");
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteAuthor(String name) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Author author = session.createQuery("FROM Author WHERE name = :name", Author.class)
					.setParameter("name", name).uniqueResult();

			if (author != null) {
				session.remove(author);
				System.out.println("Author and associated books deleted successfully");
			} else {
				System.out.println("Author not found");
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
