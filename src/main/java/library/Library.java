package library;

import library.dao.AuthorDAO;
import library.model.Author;

public class Library {

    public static void main(String[] args) {

        AuthorDAO authorDAO = new AuthorDAO();
        Author author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Mickiewicz");
        authorDAO.create(author);
    }
}
