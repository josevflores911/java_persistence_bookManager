package net.codejava;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BooksManager {
	
	static EntityManagerFactory factory;
	static EntityManager entityManager;

	public static void main(String[] args) {
		
		begin();
		
		    //create();
			//update();
			find();
			
			
			//query();
			
			/*remove();*/
			end();

		}

		
		private static void remove() {
			Integer primaryKey = 3;
			Book reference = entityManager.getReference(Book.class, primaryKey);
			entityManager.remove(reference);		
		}
		private static void query() {
			String jpql = "Select b From Book b Where b.price < 30";
			Query query = entityManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<Book> listBooks = query.getResultList();
			
			for (Book aBook : listBooks) {
				System.out.println(aBook.getTitle() + ", "+aBook.getAuthor() + ", "+aBook.getPrice() + ", ");
			}
		}
		
		
		private static void update() {
			Book existBook = new Book();
			existBook.setBookId(1);
			existBook.setTitle("Thinking in Java. 2edit");
			existBook.setAuthor("joshua Eckel");
			existBook.setPrice(19);
			
			entityManager.merge(existBook);
		}
		
		private static void find() {
			Integer primaryKey = 2;
			Book book = entityManager.find(Book.class, primaryKey);
			
			System.out.println(book.getTitle());
			System.out.println(book.getAuthor());
			System.out.println(book.getPrice());
			
		}
		
		
		private static void end() {
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
		}
		
		private static void begin() {
			factory = Persistence.createEntityManagerFactory("BookUnit");
			entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();
		}

		private static void create() {
			Book newBook = new Book();
			
			newBook.setTitle("Thinking in Java");
			newBook.setAuthor("Bruce Eckel");
			newBook.setPrice(45);
			
			entityManager.persist(newBook);
			
		}

	}
