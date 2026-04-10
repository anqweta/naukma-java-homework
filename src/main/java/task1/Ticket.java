package task1;

public record Ticket(long id, String userEmail, String title, TicketStatus status) {

    public Ticket {
        if (id < 0) {
            throw new IllegalArgumentException("ID не може бути відємним!");
        }
        if (!userEmail.contains("@") || !userEmail.contains(".")) {
            throw new IllegalArgumentException("Неправильний формат Email");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Введіть значення Title");
        }
    }

    public Ticket withStatus(TicketStatus newStatus) {
        return new Ticket(this.id, this.userEmail, this.title, newStatus);
    }

}
