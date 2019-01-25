package library.dao;

import library.HibernateUtil;
import library.model.Book;
import library.model.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDAO {
    public List<Category> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Category> categories = null;
        try {
            transaction = session.beginTransaction();
            categories = session.createQuery("from CATEGORY").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return categories;
        }
    }

    public void create(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            if(!exists(category)) {
                transaction = session.beginTransaction();
                session.save(category);
                transaction.commit();
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public boolean exists(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean exists = false;
        try {
            transaction = session.beginTransaction();
            List<Category>  categories = session.createQuery("select c from Category c where upper(c.name) like upper(:name)")
                    .setParameter("name", category.getName())
                    .list();
            if(categories.size() != 0)
                exists = true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return exists;
        }
    }

    public void update(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(category);
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

    public void delete(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(category);
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

    public Category getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Category category = null;
        try {
            transaction = session.beginTransaction();
            category = (Category) session.load(Category.class, id);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return category;
        }
    }

    public List<Book> getBooks(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Book> books = null;
        try {
            transaction = session.beginTransaction();
            books = session.createQuery("select b from Book b where b.category_id like :category_id")
                    .setParameter("category_id", category.getId())
                    .list();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return books;
        }
    }
}
