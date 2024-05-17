public class Ticket {

    public static Ticket ticket;
    public int row;
    public int seat;
    public double price;
    Person person;
    // Constructor with row, seat, price, and Person parameters
    public Ticket(int row,int seat,double price,Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    // Getters and setters for the attributes
    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public Person getPerson() {
        return person;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // Method to print ticket information
    public void print(){
        System.out.println("Person name:"+person.getName());
        System.out.println("Person surname:"+person.getSurname());
        System.out.println("Person email:"+person.getEmail());
        System.out.println("Row:"+row);
        System.out.println("Seat:"+seat);
        System.out.println("Price:"+price);



    }

}
