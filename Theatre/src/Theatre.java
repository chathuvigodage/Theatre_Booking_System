import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Theatre {

    static int[]row1={0,0,0,0,0,0,0,0,0,0,0,0};
    static int[]row2={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};          //create arrays for each row
    static int[]row3={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    static ArrayList<Ticket> tickets = new ArrayList<Ticket>(); //create arraylist called tickets


    public static void main(String[] args){

        System.out.println("!Welcome to the New Theatre!");
        System.out.println("------------------------------------------------------------------------------------");
        boolean running=true;
        while(running==true){
        System.out.println("Select an option: ");
        System.out.println("1) Buy a ticket");
        System.out.println("2) Print seating area ");
        System.out.println("3) Cancel ticket ");
        System.out.println("4) List available seats");
        System.out.println("5) Save to file");
        System.out.println("6) Load from file ");
        System.out.println("7) Print ticket information and total price");
        System.out.println("8) Sort tickets by price ");
        System.out.println("     0) Quit ");
        System.out.println("------------------------------------------------------------------------------------");


            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter an option: ");
                int no = input.nextInt();
                int option = no;
                switch (option) {
                    case 1:
                        buy_ticket();    // execute the buy ticket method
                        break;
                    case 2:
                        print_seating_area();   //execute the print_seating_area method
                        break;
                    case 3:
                        cancel_ticket();       //execute the cancel_ticket method
                        break;
                    case 4:
                        show_available();      //execute the show_available method
                        break;
                    case 5:
                        save();                //execute the save method
                        break;
                    case 6:
                        load();                //execute the load method
                        break;
                    case 7:
                        show_tickets_info();   //execute the show_tickets_info method
                        break;
                    case 8:
                        sort_tickets();        //execute the sort_tickets method
                        break;
                    case 0:
                        System.out.println("Thank you!");    //exit from the program
                        running=false;
                        break;
                    default:
                        System.out.println("Invalid option!");  // other than that print Invalid option
                        break;
                }
            }catch (InputMismatchException e){
                     System.out.println("Invalid option!");
            }

        }
    }

    public static void buy_ticket(){
            Scanner input1 = new Scanner(System.in);         //use Scanner to read user inputs
            System.out.println("Enter the name: ");
            String name = input1.next();
            System.out.println("Enter the surname: ");
            String surname = input1.next();
            System.out.println("Enter the email: ");
            String email = input1.next();
            Person person = new Person(name, surname, email);
            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter row no: ");
                int rowno = input.nextInt();
                if (rowno == 1 || rowno == 2 || rowno == 3) {
                    while (true) {
                        System.out.println("Enter seat no: ");
                        int seatno = input.nextInt();
                        if (rowno == 1 && seatno < 13) {
                            if ((row1[seatno - 1] == 0)) {         //check if seat is available
                                System.out.println("booked");
                                System.out.println("------------------------------------------------------------");
                                row1[seatno - 1] = 1;     //then seat mark as occupied
                                int price=0;
                                switch (rowno){
                                    case 1:
                                        price=40;         //if rowno=1 mark price as 40
                                        break;
                                    case 2:
                                        price=30;          //if rowno=2 mark price as 30
                                        break;
                                    case 3:
                                        price=20;           //if rowno=3 mark price as 20
                                        break;
                                }
                                Ticket ticket = new Ticket(rowno, seatno, price, person);
                                //create a object call Ticket
                                tickets.add(ticket);
                                //Add ticket to the tickets array

                            } else {
                                System.out.println("already booked");
                            }
                        } else if (rowno == 2 && seatno < 17) {
                            if ((row2[seatno - 1] == 0)) {       //check if seat is available
                                System.out.println("booked");
                                row2[seatno - 1] = 1;       //then seat mark as occupied
                                int price=0;
                                switch (rowno){
                                    case 1:
                                        price=40;          //if rowno=1 mark price as 40
                                        break;
                                    case 2:
                                        price=30;          //if rowno=2 mark price as 30
                                        break;
                                    case 3:
                                        price=20;           //if rowno=3 mark price as 20
                                        break;
                                }
                                Ticket ticket = new Ticket(rowno, seatno, price, person);
                                tickets.add(ticket);
                                //Add ticket to the tickets array
                            } else {
                                System.out.println("already booked");
                            }
                        } else if (rowno == 3 && seatno < 21) {
                            if ((row3[seatno - 1] == 0)) {       //check if seat is available
                                System.out.println("booked");
                                row3[seatno - 1] = 1;       //then seat mark as occupied
                                int price=0;
                                switch (rowno){
                                    case 1:
                                        price=40;      //if rowno=1 mark price as 40
                                        break;
                                    case 2:
                                        price=30;       //if rowno=2 mark price as 30
                                        break;
                                    case 3:
                                        price=20;        //if rowno=3 mark price as 20
                                        break;
                                }
                                Ticket ticket = new Ticket(rowno, seatno, price, person);
                                tickets.add(ticket);
                                //Add ticket to the tickets array
                            } else {
                                System.out.println("already booked");
                            }
                        } else {
                            System.out.println("seat no not valid");
                            continue;
                        }
                        break;
                    }

                } else {
                    System.out.println("Invalid row no");
                    continue;
                }
                break;
            }
    }

    public static void print_seating_area(){
        System.out.println("    ***********      ");
        System.out.println("    *  STAGE  *      ");    // Prints out the header of the stage
        System.out.println("    ***********      ");
        // Prints out the first row of the stage
        System.out.print("    ");
        for (int i = 0; i < row1.length; i++) {
            if(i==6){                           // Adds a space in the middle of the row
                System.out.print(" ");
            }
            // Prints out an "X" if there is a 1 in the array, and "0" otherwise
            if(row1[i]==1){
                System.out.print("X");

            }else{
                System.out.print("0");
            }

        }
        System.out.println("");
        // Prints out the first row of the stage
        System.out.print("  ");
        for (int i = 0; i < row2.length; i++){
            if(i==8){                                  // Adds a space in the middle of the row
                System.out.print(" ");
            }
            // Prints out an "X" if there is a 1 in the array, and "0" otherwise
            if(row2[i]==1){
                System.out.print("X");

            }else{
                System.out.print("0");
            }

        }

        System.out.println("");
        // Prints out the first row of the stage
        for (int i = 0; i < row3.length; i++) {
            if(i==10){                                 // Adds a space in the middle of the row
                System.out.print(" ");
            }
            // Prints out an "X" if there is a 1 in the array, and "0" otherwise
            if(row3[i]==1){
                System.out.print("X");

            }else{
                System.out.print("0");
            }

        }

        System.out.println("");
    }
    public static void cancel_ticket(){
        while(true){
            Scanner input=new Scanner(System.in);
            System.out.println("Enter row no: ");
            int rowno=input.nextInt();
            if(rowno==1 || rowno==2 || rowno==3){
                while(true){
                    System.out.println("Enter seat no: ");
                    int seatno=input.nextInt();
                    if(rowno==1&&seatno<13){
                        if(row1[seatno-1]==1){
                            row1[seatno-1]=0;
                            System.out.println("cancel successfully");
                            for(int i=0; i< tickets.size();i++){
                                Ticket.ticket=tickets.get(i);
                                if(Ticket.ticket.getSeat()==seatno){
                                    tickets.remove(i);
                                }
                            }
                        }else{
                            System.out.println("already available");
                        }
                    }else if(rowno==2&&seatno<17){
                        if(row2[seatno-1]==1){
                            row2[seatno-1]=0;
                            System.out.println("cancel successfully");
                            for(int i=0; i< tickets.size();i++){
                                Ticket.ticket=tickets.get(i);
                                if(Ticket.ticket.getSeat()==seatno){
                                    tickets.remove(i);
                                }
                            }

                        }else{
                            System.out.println("already available");
                        }
                    }else if(rowno==3&&seatno<21){
                        if(row3[seatno-1]==1){
                            row3[seatno-1]=0;
                            System.out.println("cancel successfully");
                            for(int i=0; i< tickets.size();i++){
                                Ticket.ticket=tickets.get(i);
                                if(Ticket.ticket.getSeat()==seatno){
                                    tickets.remove(i);
                                }
                            }

                        }else{
                            System.out.println("already available");
                        }
                    }else{
                        System.out.println("seat is not valid");
                    }
                    break;
                }

            }else{
                System.out.println("Invalid no");
                continue;
            }

            break;
        }
    }

    public static void show_available(){
        System.out.print("seats available in row 1:");
        for (int i = 0; i < row1.length; i++) {
            if(row1[i]==0){                       // Check if the seat is available
                System.out.print(" "+(i+1));      // Display the seat number
            }
        }
        System.out.println("");
        System.out.print("seats available in row 2:");
        for (int j = 0; j < row2.length; j++) {
            if(row2[j]==0){                         // Check if the seat is available
                System.out.print(" "+(j+1));        // Display the seat number
            }
        }
        System.out.println("");
        System.out.print("seats available in row 3:");
        for (int k = 0; k < row3.length; k++) {
            if(row3[k]==0){                          // Check if the seat is available
                System.out.print(" "+(k+1));         // Display the seat number
            }
        }
        System.out.println("");
    }
    public static void save() {
        try{
            // Create a new file object with the name "cw2.txt"
            File file = new File("cw2.txt");
            // FileWriter is use to write to the file
            FileWriter fileWriter = new FileWriter(file);
            //Write the contents of the first array to the file
            for (int i = 0; i < row1.length; i++) {
                fileWriter.write(Integer.toString(row1[i]));
            }
            fileWriter.write("\n");
            //Write the contents of the second array to the file
            for (int i = 0; i < row2.length; i++) {
                fileWriter.write(Integer.toString(row2[i]));
            }
            fileWriter.write("\n");
            //Write the contents of the third array to the file
            for (int i = 0; i < row3.length; i++) {
                fileWriter.write(Integer.toString(row3[i]));
            }

            fileWriter.close();
            System.out.println("file saved successfully");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static void load() {
        try {
            File file = new File("cw2.txt");
            Scanner rf = new Scanner(file);     // Create a scanner object to read from the file
            String fileline;                    // Create a string to hold each line from the file
            int row=1;
            while (rf.hasNext()) {              // Loop through each line in the file
                fileline = rf.nextLine();       // Read the next line from the file
                for(int i=0; i<fileline.length(); i++){    // Loop through each character in the line
                    switch (row){
                        case 1 :
                            row1[i] = Character.getNumericValue(fileline.charAt(i));
                        case 2 :
                            row2[i] = Character.getNumericValue(fileline.charAt(i));
                        case 3 :
                            row3[i] = Character.getNumericValue(fileline.charAt(i));

                    }
                }
                row++;
            }
            rf.close();
            System.out.println("seating information was successfully loaded ");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static void show_tickets_info(){
        double total=0;
        for(Ticket ticket:tickets){
            // Iterate through each ticket in the tickets ArrayList
            ticket.print();
            //Print the information of the ticket
            total+= ticket.price;
            // Add the price of the ticket to the total variable.

        }
        System.out.println("Total price:"+total);
        // Print the total price of all the tickets.

    }
    public static void sort_tickets(){
        // Create a new ArrayList to hold the sorted tickets
        ArrayList<Ticket>sortedTickets = new ArrayList<>();
        // Loop until all tickets have been removed from the original list
        while(!tickets.isEmpty()) {
            // Set the minimum price to the first ticket in the list.
            Ticket minprice = tickets.get(0);
            // Loop through the remaining tickets in the list
            for (Ticket ticket : tickets) {
                if (ticket.price < minprice.price) {
                    minprice = ticket;
                }
            }
            // Remove the minimum price ticket from the original list and add it to the sorted list
            tickets.remove(minprice);
            sortedTickets.add(minprice);
        }
            // Loop through the sorted list and print each ticket.
            for(Ticket ticket:sortedTickets){
                ticket.print();
                System.out.println();
            }

    }

}