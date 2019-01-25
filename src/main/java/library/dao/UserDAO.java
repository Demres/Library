package library.dao;

import library.HibernateUtil;
import library.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {
    public List<User> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<User> users = null;
        try {
            transaction = session.beginTransaction();
            users = session.createQuery("from PUBLISHER").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return users;
        }
    }

    public void create(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
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

    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(user);
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

    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(user);
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

    public User getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        User user = null;
        try {
            transaction = session.beginTransaction();
            user = (User) session.load(User.class, id);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return user;
        }
    }

    public User getByLogin(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        User user = null;
        try {
            transaction = session.beginTransaction();
            user = (User) session.createQuery("select u from User u where upper(u.login) LIKE upper(:login)")
                    .setParameter("login", login)
                    .uniqueResult();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return user;
        }
    }

    public List<Book> getBooks(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Book> books = null;
        try {
            transaction = session.beginTransaction();
            books = session.createQuery("select b from Book b where b.id IN (select b1.bookCopies.id from Borrow b1)")
                    .setParameter("user_id", user.getId())
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

    public List<Borrow> getBorrows(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Borrow> borrows = null;
        try {
            transaction = session.beginTransaction();
            borrows = session.createQuery("select b from Borrow b where b.user_id like :user_id")
                    .setParameter("user_id", user.getId())
                    .list();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return borrows;
        }
    }

    public List<Reservation> getReservations(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Reservation> reservations = null;
        try {
            transaction = session.beginTransaction();
            reservations = session.createQuery("select r from Reservation r where r.user_id like :user_id")
                    .setParameter("user_id", user.getId())
                    .list();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return reservations;
        }
    }

    public List<Penalty> getPenalties(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Penalty> penalties = null;
        try {
            transaction = session.beginTransaction();
            penalties = session.createQuery("select p from Penalty p where p.user_id like :user_id")
                    .setParameter("user_id", user.getId())
                    .list();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return penalties;
        }
    }

    public List<Permission> getPermissions(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Permission> permissions = null;
        try {
            transaction = session.beginTransaction();
            permissions = session.createQuery("select p from Permission p where p.user_id like :user_id")
                    .setParameter("user_id", user.getId())
                    .list();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            return permissions;
        }
    }
}
