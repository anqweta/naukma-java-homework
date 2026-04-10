package task3and4and5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import task1.Ticket;
import task1.TicketStatus;
import task2.StorageException;
import task2.TicketNotFoundException;
import task2.TicketStateException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketService {

    private final Map<Long, Ticket> ticketStorage = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(TicketService.class);

    public void createTicket(long id, String userEmail, String title){
        Ticket ticket = new Ticket(id, userEmail, title, TicketStatus.NEW);
        log.info("Create new ticket with id {} and userEmail {} and title {}", id, userEmail, title);
        ticketStorage.put(ticket.id(),  ticket);
        System.out.println("Додано новий квиток!");
    }

    public Ticket findById(long id) {
        if (ticketStorage.containsKey(id)) {
            return ticketStorage.get(id);
        } else {
            log.warn("Спроба отримати не існуючий квиток ID: {}", id);
            throw new TicketNotFoundException("Не знайдено квиток за вашим запитом!");
        }
    }

    public void assignTicket(long id) {
        Ticket ticket = findById(id);
        if (ticket.status().equals(TicketStatus.NEW)) {
            ticket = ticket.withStatus(TicketStatus.IN_PROGRESS);
            ticketStorage.put(id, ticket);
            log.info("Квиток {} успішно переведено в статус IN_PROGRESS", id);
        } else {
            log.warn("Неможливий перехід статусу для квитка {}. Поточний статус: {}", id, ticket.status());
            throw new TicketStateException("Не можливий перехід!");
        }
    }

    public void resolveTicket(long id) {
        Ticket ticket = findById(id);
        if (ticket.status().equals(TicketStatus.IN_PROGRESS)) {
            ticket = ticket.withStatus(TicketStatus.RESOLVED);
            ticketStorage.put(id, ticket);
        } else {
            throw new TicketStateException("Не можливий перехід!");
        }
    }

    public void exportOpenTicket(Path path) throws StorageException {
        List<Ticket> sortTicket = new ArrayList<>();
        for (Map.Entry<Long, Ticket> entry : ticketStorage.entrySet()) {
            if (entry.getValue().status().equals(TicketStatus.NEW) || entry.getValue().status().equals(TicketStatus.RESOLVED)) {
                sortTicket.add(entry.getValue());
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Ticket ticket : sortTicket) {
                writer.write(ticket.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("Критична помилка під час експорту квитків у файл: {}", path.toAbsolutePath(), e);
            throw new StorageException("Помилка під час запису квитків!");
        }
    }



}
