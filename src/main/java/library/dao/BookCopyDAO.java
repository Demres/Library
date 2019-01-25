package library.dao;

import library.HibernateUtil;
import library.model.Book;
import library.model.BookCopy;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookCopyDAO {
    public List<BookCopy> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<BookCopy> copies = null;
        try {
            transaction = session.beginTransaction();
            copies = session.createQuery("from BOOK_COPY").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return copies;
        }
    }

    public List<BookCopy> getCopies(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<BookCopy> copies = null;
        try {
            transaction = session.beginTransaction();
            copies = session.createQuery("select b from BookCopy b where b.book_ISBN = :book_ISBN")
                    .setParameter("book_ISBN", book.getISBN())
                    .list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return copies;
        }
    }

    public void create(BookCopy copy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(copy);
            transaction = session.beginTransaction();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void update(BookCopy copy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(copy);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(BookCopy copy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(copy);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public BookCopy getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        BookCopy copy = null;
        try {
            transaction = session.beginTransaction();
            copy = (BookCopy) session.load(BookCopy.class, id);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return copy;
        }
    }
}
