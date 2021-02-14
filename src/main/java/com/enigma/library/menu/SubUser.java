package com.enigma.library.menu;

import com.enigma.library.HibernateUtil;
import com.enigma.library.entities.*;
import com.enigma.library.repositories.*;
import com.enigma.library.service.*;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubUser {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final EntityManager em = sessionFactory.createEntityManager();


    private static final CategoryRepository categoryRepository = new CategoryRepository(em);
    private static final CategoryService categoryService = new CategoryService(em, categoryRepository);
    public static Category category = new Category();



    public static User user = new User();







    private static final BukuKitaRepository bukuKitaRepository = new BukuKitaRepository(em);
    private static final BukuKitaService bukuKitaService = new BukuKitaService(em, bukuKitaRepository);


    public static Scanner input = new Scanner(System.in);

    public static String padding(String column, int length) {
        return String.format("%1$-" + length + "s", column);
    }

    public static void userSeeAllbook() {
        List<BukuKita> values = bukuKitaService.findAll();
        values = values.stream().filter(BukuKita::isStatus).collect(Collectors.toList());
        System.out.println();
        System.out.print("\n"
                + padding("Id", 3)
                + padding("Title", 35)
                + padding("Author", 20)
                + padding("Publisher", 20)
                + padding("Shelf", 20)
                + padding("Category", 20)
                + "\n");

        for (BukuKita value : values) {
            System.out.println(padding(value.getId().toString(), 3)
                    + padding(value.getTitle(), 35)
                    + padding(value.getAuthor(), 20)
                    + padding(value.getPublisher(), 20)
                    + padding(value.getShelf(), 20)
                    + padding(value.getCategory().getName_cat(), 20));
        }

    }

    public static void userSeeAllCategory() {
        List<Category> values = categoryService.findAll();
        System.out.println(" ");
        System.out.print("\n"
                + padding("Id", 3)
                + padding("Name Category", 20)
                + padding("Price", 20)
                + padding("Duration", 10)
                + "\n");

        for (Category value : values) {
            System.out.println(padding(value.getId().toString(), 3)
                    + padding(value.getName_cat(), 20)
                    + padding(value.getRent_price().toString(), 20)
                    + padding(value.getRent_duration().toString(), 10));
        }

    }

    public static void userSearchBook() {
        String userInput;
        boolean isContinue = true;
        while (isContinue) {
            System.out.println(" ");
            System.out.println("###########################################");
            System.out.println("Search book");
            System.out.println("1.By title");
            System.out.println("2.By category");
            System.out.println("3.EXIT");
            userInput = input.next();

            switch (userInput) {
                case "1":
                    viewSearch(searchByName());
                    isContinue = false;
                    break;
                case "2":
                    viewSearch(searchByCategory());
                    isContinue = false;
                    break;
                case "3":
                    isContinue = false;
                    break;
                default:
                    System.out.println("Please choose between 1-3");
            }
        }

    }

    public static List<BukuKita> searchByName() {
        input.nextLine();
        System.out.println("Insert book title = ");
        String title = input.nextLine();

        List<BukuKita> bukuKitas = bukuKitaService.findAll();
        List<BukuKita> bukuKitaList = new ArrayList<>();
        for (BukuKita bukuKita : bukuKitas) {
            if (bukuKita.getTitle().toLowerCase().contains(title.toLowerCase())) {
                bukuKitaList.add(bukuKita);
            }
        }
        return bukuKitaList;
    }

    public static List<BukuKita> searchByCategory() {
        input.nextLine();
        System.out.println("Insert book category = ");
        String category = input.nextLine();

        List<BukuKita> bukuKitas = bukuKitaService.findAll();
        List<BukuKita> bukuKitaList = new ArrayList<>();
        for (BukuKita bukuKita : bukuKitas) {
            if (bukuKita.getCategory().getName_cat().toLowerCase().contains(category.toLowerCase())) {
                bukuKitaList.add(bukuKita);
            }
        }
        return bukuKitaList;
    }

    public static void viewSearch(List<BukuKita> bukuKitas) {
        if (bukuKitas.isEmpty()) {
            System.out.println("There is no transaction on this date");
        } else {
            System.out.print("\n"
                    + padding("Id", 3)
                    + padding("Title", 35)
                    + padding("Author", 20)
                    + padding("Publisher", 20)
                    + padding("Bookself", 20)
                    + padding("Category", 20)
                    + "\n");

            for (BukuKita bukukita : bukuKitas) {
                System.out.println(padding(bukukita.getId().toString(), 3)
                        + padding(bukukita.getTitle(), 35)
                        + padding(bukukita.getAuthor(), 20)
                        + padding(bukukita.getPublisher(), 20)
                        + padding(bukukita.getShelf(), 20)
                        + padding(bukukita.getCategory().getName_cat(), 20));
            }
        }
    }
}
