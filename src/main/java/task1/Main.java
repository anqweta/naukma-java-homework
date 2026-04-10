package task1;

import task2.StorageException;
import task3and4and5.TicketService;

import java.nio.file.Path;

public class Main {
    static void main() {
        TicketService ticketService = new TicketService();
        ticketService.createTicket(1, "test1@gmail.com", "якась проблема1");
        ticketService.createTicket(2, "test2@gmail.com", "якась проблема2");
        ticketService.createTicket(3, "test3@gmail.com", "якась проблема3");

        ticketService.assignTicket(2);
        ticketService.assignTicket(1);

        Path exportPath = Path.of("open_tickets.csv");

        try {
            System.out.println("Починаємо експорт квитків...");
            ticketService.exportOpenTicket(exportPath);
            System.out.println("Експорт завершено! Файл збережено: " + exportPath.toAbsolutePath());

        } catch (StorageException e) {
            System.err.println("Помилка під час експорту: " + e.getMessage());
        }

        //ticketService.resolveTicket(3); //exception

    }
}
