package com.enigma.library.menu;

import javax.persistence.EntityManager;
import com.enigma.library.HibernateUtil;
import com.enigma.library.entities.Borrow;
import com.enigma.library.entities.BukuKita;
import com.enigma.library.entities.Category;
import com.enigma.library.entities.SendBack;
import com.enigma.library.repositories.BorrowRepository;
import com.enigma.library.repositories.BukuKitaRepository;
import com.enigma.library.repositories.CategoryRepository;
import com.enigma.library.repositories.SendBackRepository;
import com.enigma.library.service.BorrowService;
import com.enigma.library.service.BukuKitaService;
import com.enigma.library.service.CategoryService;
import com.enigma.library.service.SendBackService;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubAdmin {


    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final EntityManager em = sessionFactory.createEntityManager();


    private static final BorrowRepository borrowRepository = new BorrowRepository(em);
    private static final BorrowService borrowService = new BorrowService(em, borrowRepository);


    private static final CategoryRepository categoryRepository = new CategoryRepository(em);
    private static final CategoryService categoryService = new CategoryService(em, categoryRepository);
    public static Category category = new Category();

    private static final SendBackRepository sendBackRepository = new SendBackRepository(em);
    private static final SendBackService sendBackService = new SendBackService(em, sendBackRepository);


    private static final BukuKitaRepository bukuKitaRepository = new BukuKitaRepository(em);
    private static final BukuKitaService bukuKitaService = new BukuKitaService(em, bukuKitaRepository);
    private static BukuKita bukuKita = new BukuKita();

    private static Scanner input = new Scanner(System.in);


    public static void adminAddBook() {

        System.out.println("Book Title = ");
        bukuKita.setTitle(input.nextLine());
        System.out.println("Author = ");
        bukuKita.setAuthor(input.nextLine());
        System.out.println("Insert book shelf ");
        bukuKita.setShelf(input.nextLine());
        System.out.println("Publisher = ");
        bukuKita.setPublisher(input.nextLine());
        System.out.println("Choose Category Id = ");
        List<Category> values1 = categoryService.findAll();
        System.out.println(" ");
        System.out.print("\n"
                + padding("Id", 3)
                + padding("Name Category", 20)
                + padding("Price", 20)
                + padding("Duration", 10)
                + "\n");

        for (Category value : values1) {
            System.out.println(padding(value.getId().toString(), 3)
                    + padding(value.getName_cat(), 20)
                    + padding(value.getRent_price().toString(), 20)
                    + padding(value.getRent_duration().toString(), 10));
        }
        int tempCategoryId = input.nextInt();
        category = categoryRepository.findById(tempCategoryId);
        bukuKita.setCategory(category);
        int tempPrice = category.getRent_price();
        int tempTax = (int) Math.round(0.1 * tempPrice);
        bukuKita.setTax(tempTax);
        input.nextLine();
        BukuKita savedBukukita = bukuKitaService.save(bukuKita);
        System.out.println("Book " + savedBukukita + "succesfully added");

    }

    public static void adminAddCategory() {

        System.out.print("Category Name = ");
        category.setName_cat(input.nextLine());
        System.out.print("Rent Price(IDR) = ");
        category.setRent_price(input.nextInt());
        System.out.print("Rent Duration(Day) = ");
        category.setRent_duration(input.nextInt());
        input.nextLine();
        Category savedCategory = categoryService.save(category);
        System.out.println("Category " + savedCategory + "succesfully added");

    }

    public static void adminEditCategory() {
        List<Category> values2 = categoryService.findAll();
        System.out.println(" ");
        System.out.print("\n"
                + padding("Id", 3)
                + padding("Name Category", 20)
                + padding("Price", 20)
                + padding("Duration", 10)
                + "\n");

        for (Category value : values2) {
            System.out.println(padding(value.getId().toString(), 3)
                    + padding(value.getName_cat(), 20)
                    + padding(value.getRent_price().toString(), 20)
                    + padding(value.getRent_duration().toString(), 10));
        }
        System.out.print("Please input Id category to Edit = ");
        category = categoryRepository.findById(input.nextInt());

        System.out.println("This is current data by id = " + category.getId());
        System.out.println("Name category : " + category.getName_cat());
        System.out.println("Price : " + category.getRent_price());
        System.out.println("Rent Duration : " + category.getRent_duration());
        System.out.println(" ");
        System.out.println("Please input NEW data ");
        System.out.print("Name category = ");
        input.nextLine();
        category.setName_cat(input.nextLine());
        System.out.print("Price = ");
        category.setRent_price(input.nextInt());
        System.out.print("Rent Duration = ");
        category.setRent_duration(input.nextInt());
        Category saveEdit = categoryService.save(category);
        System.out.println("Data " + saveEdit + " successfully Edit");

    }

    public static void adminSeeTransactionReport() {

        String userInput;
        boolean isContinue = true;
        while (isContinue) {
            System.out.println(" ");
            System.out.println("###########################################");
            System.out.println("See Transaction Report");
            System.out.println("1.Based on date");
            System.out.println("2.Based on month");
            System.out.println("3.EXIT");
            userInput = input.next();

            switch (userInput) {
                case "1":
                    report(adminSeeBasedOnDate());
                    isContinue = false;
                    break;
                case "2":
                    report(adminSeeBasedOnMonth());
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

    public static void adminSeeMonthlyTax() {

        System.out.println("Example Input : 2021-01");
        System.out.println("Date = ");
        String date = input.nextLine();

        List<SendBack> sendBacks = sendBackService.findAll();
        int totalTax = 0;
        for (SendBack sendBack : sendBacks) {
            String tgl = sendBack.getCreateDate().toString().substring(0, 7);
            if (tgl.equals(date)) {
                totalTax += sendBack.getTax();
            } else {
                System.out.println("there is no data in this month");
            }
        }
        if (totalTax == 0) {
            System.out.println("There is no tax report for this month");
        } else {
            System.out.println("total tax : "+totalTax);
        }
    }

    public static List<Borrow> adminSeeBasedOnDate() {

        input.nextLine();
        System.out.println("Examaple input : 2021-01-02");
        System.out.println("Date = ");
        String date = input.nextLine();

        List<Borrow> borrows = borrowService.findAll();
        List<Borrow> borrowList = new ArrayList<>();
        for (Borrow borrow : borrows) {
            String tgl = borrow.getCreateDate().toString().substring(0, 10);
            if (tgl.equals(date)) {
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }

    public static List<Borrow> adminSeeBasedOnMonth() {

        input.nextLine();
        System.out.println("Example Input : 2021-01");
        System.out.println("Date = ");
        String date = input.nextLine();

        List<Borrow> borrows = borrowService.findAll();
        List<Borrow> borrowList = new ArrayList<>();
        for (Borrow borrow : borrows) {
            String tgl = borrow.getCreateDate().toString().substring(0, 7);
            if (tgl.equals(date)) {
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }

    public static void report(List<Borrow> borrows) {
        if (borrows.isEmpty()) {
            System.out.println("There is no transaction on that date");
        } else {
            System.out.print("\n"
                    + padding("Id Borrow", 10)
                    + padding("Title", 35)
                    + padding("Author", 20)
                    + padding("Category", 20)
                    + padding("Date", 20)
                    + "\n");

            for (Borrow borrow : borrows) {
                System.out.println(padding(borrow.getId().toString(), 10)
                        + padding(borrow.getBukuKita().getTitle(), 35)
                        + padding(borrow.getBukuKita().getAuthor(), 20)
                        + padding(borrow.getBukuKita().getCategory().getName_cat(), 20)
                        + padding(borrow.getCreateDate().getMonth().toString(), 20));

            }
        }
    }

    public static String padding(String column, int length) {
        return String.format("%1$-" + length + "s", column);
    }

}
