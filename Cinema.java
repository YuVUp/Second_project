package cinema;

import java.util.Scanner;

public class Cinema {
    final static Scanner scanner = new Scanner(System.in); // Do not change this line

    static int row;
    static int seat;
    static String[][] cinema;
    //static float statistics;
    static int priceTicket;
    static int purchaseTickets;
    static int currentIncome;


    public static void main(String[] args) {

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        cinema = new String[rows + 1][seats + 1];

        boolean flag = true;
        while (flag) {

            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int enter = scanner.nextInt();

            switch (enter) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    //Zal(rows, seats, row, seat);
                    Zal1(rows, seats);
                    break;
                case 2:
                    TicketPrice(rows, seats);
                    break;
                case 3:
                    Statistics(rows, seats, priceTicket);
                    //purchaseTickets += purchaseTickets;
                    break;
            }
        }
    }

    public static void CinemaZal(int rows, int seats) {
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (cinema[i][j] != "B") {
                    cinema[i][j] = "S";
                }

            }
        }
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0) {
                    cinema[i][j] = String.valueOf(j);
                }
            }
        }

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (j == 0) {
                    cinema[i][j] = String.valueOf(i);
                }
            }
        }
        String b = "B";
        cinema[row][seat] = b;
        cinema[0][0] = " ";
    }

    private static void Zal1(int rows, int seats) {
        System.out.println("Cinema:");
        CinemaZal(rows, seats);
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void TicketPrice(int rows, int seats) {
        CinemaZal(rows, seats);

        System.out.println("Enter a row number:");
        int row1 = scanner.nextInt();
        row = row1;
        System.out.println("Enter a seat number in that row:");
        int seat1 = scanner.nextInt();
        seat = seat1;

        if (row > 9) {
            System.out.println("Wrong input!");
            System.out.println();
            System.out.println("Enter a row number:");
            int row4 = scanner.nextInt();
            row = row4;
            System.out.println("Enter a seat number in that row:");
            int seat4 = scanner.nextInt();
            seat = seat4;
        }

        if (seat > 9) {
            System.out.println("Wrong input!");
            System.out.println();
            System.out.println("Enter a row number:");
            int row4 = scanner.nextInt();
            row = row4;
            System.out.println("Enter a seat number in that row:");
            int seat4 = scanner.nextInt();
            seat = seat4;
        }

        if (row < 1) {
            System.out.println("Wrong input!");
            System.out.println();
            System.out.println("Enter a row number:");
            int row4 = scanner.nextInt();
            row = row4;
            System.out.println("Enter a seat number in that row:");
            int seat4 = scanner.nextInt();
            seat = seat4;
        }

        if (seat < 1) {
            System.out.println("Wrong input!");
            System.out.println();
            System.out.println("Enter a row number:");
            int row4 = scanner.nextInt();
            row = row4;
            System.out.println("Enter a seat number in that row:");
            int seat4 = scanner.nextInt();
            seat = seat4;
        }

        if (cinema[row][seat] == "B") {
            System.out.println("That ticket has already been purchased!");
            System.out.println();
            System.out.println("Enter a row number:");
            int row3 = scanner.nextInt();
            row = row3;
            System.out.println("Enter a seat number in that row:");
            int seat3 = scanner.nextInt();
            seat = seat3;
        }

        int total = rows * seats;
        int price1 = 10;
        int price2 = 8;
        int priceTicket = 0;
        int oneHalf = rows / 2;
        // int secondHalf = (rows + 1) / 2;
        if (total <= 60) {
            priceTicket = price1;
        } else if (total > 60 && row <= oneHalf) {
            priceTicket = price1;
        } else if (total > 60 && row > oneHalf) {
            priceTicket = price2;
        }

        System.out.println("Ticket price: " + "$" + priceTicket);
        System.out.println();
    }

    public static void Statistics(int rows, int seats, int priceTicket) {

// Считаем количество купленных билетов
        int pCount = 0;
        int purchaseTicketsStore = 0;
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                if (cinema[i][j] == "B") {
                    ++pCount;
                }
            }
        }
        if (pCount == 0) {
            purchaseTicketsStore = 0;
        } else {
            purchaseTicketsStore += pCount + 1;
        }
        //Запоминаем, сколько купили до и прибавляем билеты, купленные при следующем выборе меню

        purchaseTickets = purchaseTicketsStore;
        System.out.printf("Number of purchased tickets: %d%n", purchaseTickets);

        // Вычисляем процентное соотношение купленных билетов от общего количества мест в зале
        float percentage;
        percentage = (float) purchaseTickets * 100 / (rows * seats);
        System.out.printf("Percentage: %.2f%%%n", percentage);

        // Вычисляем общую стоимость купленных билетов

        int total = rows * seats;
        int price1 = 10;
        int price2 = 8;
        int oneHalf = rows / 2;
        int secondHalf = (rows + 1) / 2;

        int curCount1 = 0;
        int curCount2 = 0;
        int currentIncomeStore = 0;

        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                if (cinema[i][j] == "B" && total > 60 && i <= oneHalf) {
                    curCount1++;
                }
                if (cinema[i][j] == "B" && total > 60 && i >= secondHalf) {
                    curCount2++;
                }
            }
        }

        System.out.println(curCount1);
        System.out.println(curCount2);

        if (total > 60 && curCount1 > 0 && curCount2 == 0) {
            currentIncomeStore = ((curCount1 + 1) * price1); }
        else if (total > 60 && curCount2 > 0 && curCount1 == 0) {
            currentIncomeStore = ((curCount2 + 1) * price2); }
        else if (total > 60 && curCount1 > 0 && curCount2 > 0) {
            currentIncomeStore = ((curCount1) * price1 + (curCount2 + 1) * price2); }
        if (total > 60 && curCount1 == 0 && curCount2 == 0) {
            currentIncomeStore = 0;}
        if (total < 60) {
            currentIncomeStore = purchaseTickets * price1;
        }

        currentIncome = currentIncomeStore;
        System.out.printf("Current income: $%d%n", currentIncome);



        //Полная стоимость билетов за весь зал
        int totalIncome;
        if (total < 60) {
            totalIncome = total * price1;
        } else {
            totalIncome = price1 * oneHalf * seats + price2 * secondHalf * seats;
        }
        System.out.printf("Total income: $%d%n", totalIncome);
    }

}

