package com.enigma.library.menu;

import com.enigma.library.HibernateUtil;
import com.enigma.library.entities.*;
import com.enigma.library.repositories.*;
import com.enigma.library.service.*;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RunUser {


    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static final EntityManager em = sessionFactory.createEntityManager();

    private static final BukuKitaRepository bukuKitaRepository = new BukuKitaRepository(em);
    private static final BukuKitaService bukuKitaService = new BukuKitaService(em, bukuKitaRepository);
    private static BukuKita bukuKita = new BukuKita();

    public static Category category = new Category();

    private static final BorrowRepository borrowRepository = new BorrowRepository(em);
    private static final BorrowService borrowService = new BorrowService(em, borrowRepository);
    public static Borrow borrow = new Borrow();

    private static final SendBackRepository sendBackRepository = new SendBackRepository(em);
    private static final SendBackService sendBackService = new SendBackService(em, sendBackRepository);
    public static SendBack sendBack = new SendBack();

    private static final UserRepository userRepository = new UserRepository(em);
    private static final UserService userService = new UserService(em, userRepository);
    public static User user = new User();
    public static String userInput;

    private static Scanner input = new Scanner(System.in);

    public static void userStart() {

        boolean isContinue = true;

        while (isContinue) {
            System.out.println("Welcome, please choose");
            System.out.println("1.Login insert id");
            System.out.println("2.Dont have id? Sign up as member now");
            System.out.println("3.EXIT");
            userInput = input.next();
            switch (userInput) {
                case "1":
                    System.out.println("Insert your member id = ");
                    user = userRepository.findById(input.nextInt());
                    profilMember();
                    isContinue = false;
                    break;
                case "2":
                    daftarMember();
                    isContinue = false;
                    break;
                case "3":
                    isContinue = false;
                    break;
                default:
                    System.out.println("Wrong input, please choose 1-3");
                    break;

            }
        }
    }

    public static void profilMember() {

        System.out.println("This is profil member by id = " + user.getId());
        System.out.println("Name    : " + user.getName());
        System.out.println("Gender  : " + user.getGender());
        System.out.println("Address : " + user.getAddress());
        System.out.println("Phone No: " + user.getPhone_num());

        userStartReal();
    }

    public static void daftarMember() {
        System.out.print("Name = ");
        input.nextLine();
        user.setName(input.nextLine());
        System.out.print("Gender = ");
        user.setGender(input.nextLine());
        System.out.print("Address = ");
        user.setAddress(input.nextLine());
        System.out.print("Phone Number = ");
        user.setPhone_num(input.nextLine());
        User savedUser = userService.save(user);
        System.out.println("User " + savedUser + "succesfully added");
        profilMember();

    }

    public static void userStartReal() {

        boolean isContinue = true;
        while (isContinue) {
            System.out.println(" ");
            System.out.println("###########################################");
            System.out.println("Welcome " + user.getName() + ", please choose");
            System.out.println("1.Show all book");
            System.out.println("2.Show all book category");
            System.out.println("3.Rent book");
            System.out.println("4.Return book");
            System.out.println("5.Transaction report");
            System.out.println("6.See book currenty on loan");
            System.out.println("7.Search books");
            System.out.println("8.EXIT");
            System.out.print("Choose your option = ");
            userInput = input.next();
            switch (userInput) {
                case "1":
                    SubUser.userSeeAllbook();
                    isContinue = false;
                    break;
                case "2":
                    SubUser.userSeeAllCategory();
                    isContinue = false;
                    break;
                case "3":
                    boolean temploan = user.isStatus_loan();
                    if (temploan) {
                        userLoanBook();
                    } else {
                        System.out.println("You need to return book before loan again");
                    }
                    isContinue = false;
                    break;
                case "4":
                    boolean tempReturn = user.isStatus_loan();
                    if (!tempReturn) {
                        userReturnBook();
                    } else {
                        System.out.println("There's nothing to return");
                    }
                    isContinue = false;
                    break;
                case "5":
                    userSeeTransactionReport();
                    isContinue = false;
                    break;
                case "6":
                    seeBookCurrentlyLoan();
                    isContinue = false;
                    break;
                case "7":
                    SubUser.userSearchBook();
                    isContinue = false;
                    break;
                case "8":
                    isContinue = false;
                    break;
                default:
                    System.out.println("Input Wrong, Please choose number 1-8");
            }
        }

    }

    public static void userLoanBook() {

        List<BukuKita> values = bukuKitaService.findAll();
        values = values.stream().filter(BukuKita::isStatus).collect(Collectors.toList());
        if (values.isEmpty()) {
            System.out.println("can't borrow book, All book currently on loan");
            System.exit(0);
        } else {
            System.out.println(" ");
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

        System.out.println("Pilih id buku yang ingin di pinjem : ");
        int tempIdBuku = input.nextInt();
        bukuKita = bukuKitaRepository.findById(tempIdBuku);
        borrow.setBukuKita(bukuKita);
        if (!bukuKita.isStatus()) {
            System.out.println("Book by id " + bukuKita.getId() + " currently not available");
        } else {
            category = bukuKita.getCategory();
            int tempPrice = category.getRent_price();
            int tempTax = bukuKita.getTax();
            borrow.setFee(tempPrice + tempTax);

            int tempIdUser = user.getId();
            user = userRepository.findById(tempIdUser);
            borrow.setUser(user);
            borrowService.save(borrow);

            borrow = borrowRepository.findById(borrow.getId());
            int tempDuration = category.getRent_duration();
            LocalDate tempDate = borrow.getCreateDate().plusDays(tempDuration);
            borrow.setSendbackdate(tempDate);

            borrowService.save(borrow);
            System.out.println("Rent prosses complete, now you need to pay rent price(with tax) = " + borrow.getFee());
            user.setStatus_loan(false);
            userService.save(user);
            bukuKita.setStatus(false);
            bukuKitaService.save(bukuKita);
        }
    }

    public static void userReturnBook() {
        int tempIdUser = user.getId();

        user = userRepository.findById(tempIdUser);
        List<Borrow> values = borrowService.findAll();

        values = values.stream().filter(value -> value.getUser().getId().equals(user.getId())
                && !value.getBukuKita().isStatus() && value.isStatus_active())
                .collect(Collectors.toList());
        System.out.println(" ");
        System.out.print("\n"
                + padding("Id Borrow", 10)
                + padding("Title", 35)
                + padding("Author", 20)
                + padding("Category", 20)
                + "\n");

        for (Borrow value : values) {
            System.out.println(padding(value.getId().toString(), 10)
                    + padding(value.getBukuKita().getTitle(), 35)
                    + padding(value.getBukuKita().getAuthor(), 20)
                    + padding(value.getBukuKita().getCategory().getName_cat(), 20));
        }

        System.out.println(" ");
        System.out.println("Insert id borrow = ");
        int tempIdBorrow = input.nextInt();
        borrow = borrowRepository.findById(tempIdBorrow);
        sendBack.setBorrow(borrow);
        sendBackService.save(sendBack);
        sendBack = sendBackRepository.findById(sendBack.getId());
        LocalDate temptCreate = sendBack.getCreateDate();
        LocalDate temptEndDate = borrow.getSendbackdate();
        long exceedDuration = ChronoUnit.DAYS.between(temptEndDate, temptCreate);
        if (exceedDuration > 0) {
            sendBack.setExceed_dur((int) (exceedDuration));
            double tempFine = 5 * exceedDuration;
            sendBack.setFine((int) tempFine);
        } else {
            sendBack.setFine(0);
        }
        bukuKita = borrow.getBukuKita();
        int tempPrice = borrow.getFee();
        int tempFineAgain = sendBack.getFine();
        int tempFinePay = (tempFineAgain * tempPrice) / 100;
        sendBack.setFineNeedPay(tempFinePay);
        sendBack.setTax(bukuKita.getTax());
        if (sendBack.getFineNeedPay() == 0) {
            System.out.println("Proses return book complete");
        } else {
            System.out.println("Proses return book complete,but you need to pay fine Rp. " + sendBack.getFineNeedPay() +
                    " because of exceed duration during rent periode");
        }
        sendBackService.save(sendBack);
        borrow.setStatus_active(false);
        borrowService.save(borrow);
        user.setStatus_loan(true);
        userService.save(user);
        bukuKita.setStatus(true);
        bukuKitaService.save(bukuKita);

    }

    public static void seeBookCurrentlyLoan() {
        int tempIdUser = user.getId();
//        System.out.println(user);
        user = userRepository.findById(tempIdUser);
        List<Borrow> values = borrowService.findAll();

        values = values.stream().filter(value -> value.getUser().getId().equals(user.getId())
                && !value.getBukuKita().isStatus() && value.isStatus_active())
                .collect(Collectors.toList());
        if (values.isEmpty()) {
            System.out.println("You dont rent any book");
            System.exit(0);
        } else {
            System.out.print("\n"
                    + padding("Id Borrow", 10)
                    + padding("Title", 35)
                    + padding("Author", 20)
                    + padding("Category", 20)
                    + padding("Rent By", 20)
                    + "\n");

            for (Borrow value : values) {
                System.out.println(padding(value.getId().toString(), 10)
                        + padding(value.getBukuKita().getTitle(), 35)
                        + padding(value.getBukuKita().getAuthor(), 20)
                        + padding(value.getBukuKita().getCategory().getName_cat(), 20)
                        + padding(value.getUser().getName(), 20));

            }
        }
    }

    public static void userSeeTransactionReport() {

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
                    report(basedOnDate());
                    isContinue = false;
                    break;
                case "2":
                    report(basedOnMonth());
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


    public static List<Borrow> basedOnDate() {

        input.nextLine();
        System.out.println("Examaple input : 2021-01-02");
        System.out.println("Date = ");
        String date = input.nextLine();

        List<Borrow> borrows = borrowService.findAll();
        List<Borrow> borrowList = new ArrayList<>();
        for (Borrow borrow : borrows) {
            String tgl = borrow.getCreateDate().toString().substring(0, 10);
            if (tgl.equals(date) && borrow.getUser().getId().equals(user.getId())) {
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }

    public static List<Borrow> basedOnMonth() {

        input.nextLine();
        System.out.println("Example Input : 2021-01");
        System.out.println("Date = ");
        String date = input.nextLine();

        List<Borrow> borrows = borrowService.findAll();
        List<Borrow> borrowList = new ArrayList<>();
        for (Borrow borrow : borrows) {
            String tgl = borrow.getCreateDate().toString().substring(0, 7);
            if (tgl.equals(date) && borrow.getUser().getId().equals(user.getId())) {
                borrowList.add(borrow);
            }
        }
        return borrowList;
    }


    public static void report(List<Borrow> borrows) {
        if (borrows.isEmpty()) {
            System.out.println("There is no transaction on this date");
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
