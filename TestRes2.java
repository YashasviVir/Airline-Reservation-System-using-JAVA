import java.util.Scanner;
public class TestRes2 {
	static char[][] seats = { { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' },
			{ 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' } };
	static char[][] seats2 = { { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' },
			{ 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' } };
	public static boolean isFull() {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j] != '-') {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isFull2() {
		for (int i = 0; i < seats2.length; i++) {
			for (int j = 0; j < seats2[i].length; j++) {
				if (seats2[i][j] != '-') {
					return false;
				}
			}
		}
		return true;
	}
	public static void printSeats() {
		int row = 1;
		System.out.println("\nEconomy Seats");
		for (int i = 0; i < seats.length; i++) {
			if (row==5){
				System.out.println("First Class Seats");
			}
			System.out.print(row++ + " ");
			for (int k = 0; k < seats[i].length; k++) {
				System.out.printf(seats[i][k] + " ");
			}
			System.out.println();
		}
	}
	public static void printSeats2() {
		int row = 1;
		System.out.println("\nEconomy Seats");
		for (int i = 0; i < seats2.length; i++) {
			if(row==5){
				System.out.println("First Class Seats");
			}
			System.out.print(row++ + " ");
			for (int k = 0; k < seats2[i].length; k++) {
				System.out.printf(seats2[i][k] + " ");
			}
			System.out.println();
		}
	}
	public static int getIndex(char character) {
		switch (character) {
		case 'A':
			return 0;
		case 'B':
			return 1;
		case 'C':
			return 2;
		default:
			return 3;
		}
	}
	public static int getRow(int row2){
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter seat's row number:");
			boolean rowTaken = false;
			while (!rowTaken) {
				int checkRow = Character.getNumericValue(sc.nextLine().charAt(0));
					if (checkRow >= 1 && checkRow <= 7) {
					row2 = checkRow;
					rowTaken = true;
					}
				else{
					System.out.println("Wrong input, please enter a number between 1 and 7.");
				}
	}
	return row2;
	}
	public static char getChar(char column2){
		Scanner scans = new Scanner(System.in);
		System.out.println("Please enter a character represents the seat you wish to reserve: ");
		column2 = ' ';
		boolean columnTaken = false;
		while (!columnTaken) {
			char checkColumn = Character.toUpperCase(scans.nextLine().charAt(0));
			if (checkColumn >= 'A' && checkColumn <= 'D') {
				column2 = checkColumn;
				columnTaken = true;
			} else {
				System.out.println("Wrong input, please enter a seat between A and D.");
			}
		}
		return column2;
	}
	public static void main(String[] args) {
		int row2=0;
		char column2=' ';
		int row=0;
		char column = ' ';
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while (!isFull()) {
			System.out.println("\nWelcome to Airline Reservation \n");
			boolean depend = false;
			while(!depend){
			    System.out.println("Enter your choice \n1. Reservation \n2. Cancellation \n3. Exit");
			    int choice1 = scan.nextInt();
			    if(choice1 == 1)
			{
			System.out.println("Enter your first name - ");
            String extra = scan.nextLine();
			String fname = scan.nextLine();
			System.out.println("Enter your middle name - ");
			String mname = scan.nextLine();
			System.out.println("Enter your last name - ");
			String lname = scan.nextLine();
			System.out.println("\nThe following flights are available - ");
			System.out.println("1.One way - BDQ to BOM\n  Economy - 6000 Rupees\n  First Class - 8000 Rupees\n2.One way - BOM to BDQ\n  Economy - 5000 Rupees\n  First Class - 7000 Rupees\n3.Return - BDQ to BOM and BOM to BDQ\n Economy -  10000 Rupees\n  First Class - 13000 Rupees");
			boolean choose2 = false;
			while(!choose2){
				int choose = Character.getNumericValue(scan.nextLine().charAt(0));
				if(choose==1){
					printSeats();
					row = getRow(row2);
					column=getChar(column2);
					if (seats[row - 1][getIndex(column)] == '-') {
					System.out.println("Sorry, place is already taken, try to take another one.");
					} else {
						seats[row - 1][getIndex(column)] = '-';
                		System.out.println("\nFind your ticket below - \n");
						System.out.println("**************************************************************************");
						System.out.println("\n\t\t\tFrom - BDQ     To - BOM\n");
						   System.out.println("\t\t\tName - "+ fname +" "+ mname +" "+lname );
						if(row>4){
							System.out.println("\n\t\t\tClass - First Class");
						}
						else{
							System.out.println("\n\t\t\tClass - Economy");
						}
						System.out.println("\n\t\t\tSeat booked - " + row + column +"\n" );
						System.out.println("**************************************************************************");
						System.out.println("\nEnter any character to continue and 1 to exit");
						int so = Character.getNumericValue(scan.nextLine().charAt(0));
						if(so==1){
							System.out.println("Thanks for using Airline reservation system!");
							System.exit(0);
						}
					}
					choose2 = true;
				}
				else if (choose == 2){
				printSeats2();
				row = getRow(row2);
				column=getChar(column2);
				if (seats2[row - 1][getIndex(column)] == '-') {
					System.out.println("Sorry, place is already taken, try to take another one.");
				} else {
					seats2[row - 1][getIndex(column)] = '-';
					System.out.println("\nFind your ticket below - \n");
					System.out.println("**************************************************************************");
					System.out.println("\n\t\t\tFrom - BDQ     To - BOM\n");
					   System.out.println("\t\t\tName - "+ fname +" "+ mname +" "+lname );
					if(row>4){
						System.out.println("\n\t\t\tClass - First Class");
					}
					else{
						System.out.println("\n\t\t\tClass - Economy");
					}
					System.out.println("\n\t\t\tSeat booked - " + row + column +"\n" );
					System.out.println("**************************************************************************");
					System.out.println("Enter any character to continue and 1 to exit");
					int s = Character.getNumericValue(scan.nextLine().charAt(0));
					if(s==1){
						System.out.println("Thanks for using Airline reservation system!");
						System.exit(0);
					}
				}
					choose2 = true; 
				}
                else if(choose ==3){
                    System.out.println("Select your seat for the first flight - BDQ to BOM");
                    printSeats();
                    row = getRow(row2);
					column=getChar(column2);
					if (seats[row - 1][getIndex(column)] == '-') {
					System.out.println("Sorry, place is already taken, try to take another one.");
					} else {
						seats[row - 1][getIndex(column)] = '-';
						System.out.println("\nFind your ticket below - \n");
						System.out.println("**************************************************************************");
						System.out.println("\n\t\t\tFrom - BDQ     To - BOM\n");
					   System.out.println("\t\t\tName - "+ fname +" "+ mname +" "+lname );
					if(row>4){
						System.out.println("\n\t\t\tClass - First Class");
					}
					else{
						System.out.println("\n\t\t\tClass - Economy");
					}
					System.out.println("\n\t\t\tSeat booked - " + row + column +"\n" );
					System.out.println("**************************************************************************");
				}	
                    System.out.println("Select your seat for the second flight - BOM to BDQ");
                    printSeats2();
                    row = getRow(row2);
				column=getChar(column2);
				if (seats2[row - 1][getIndex(column)] == '-') {
					System.out.println("Sorry, place is already taken, try to take another one.");
				} else {
					seats2[row - 1][getIndex(column)] = '-';
                	System.out.println("\nFind your ticket below - \n");
					System.out.println("**************************************************************************");
					System.out.println("\n\t\t\tFrom - BDQ     To - BOM\n");
					   System.out.println("\t\t\tName - "+ fname +" "+ mname +" "+lname);
					if(row>4){
						System.out.println("\n\t\t\tClass - First Class");
					}
					else{
						System.out.println("\n\t\t\tClass - Economy");
					}
					System.out.println("\n\t\t\tSeat booked - " + row + column +" \n" );
					System.out.println("**************************************************************************");
                }
                    choose2 = true;
                }
				else{
					System.out.println("Wrong input, please enter 1,2 or 3");
				}
			}
		}
		else if(choice1 == 2){
            System.out.println("Enter your first name - ");
            String extra = scan.nextLine();
			String fname = scan.nextLine();
			System.out.println("Enter your middle name - ");
			String mname = scan.nextLine();
			System.out.println("Enter your last name - ");
			String lname = scan.nextLine();
            System.out.println("\nSelect the flight whose ticket is to be cancelled - ");
            System.out.println("1.One way - BDQ to BOM\n  Economy - 6000 Rupees\n  First Class - 8000 Rupees\n2.One way - BOM to BDQ\n  Economy - 5000 Rupees\n  First Class - 7000 Rupees\n3.Return - BDQ to BOM and BOM to BDQ\n Economy -  10000 Rupees\n  First Class - 13000 Rupees");
            boolean choose3 = false;
			while(!choose3){
				int choice3 = Character.getNumericValue(scan.nextLine().charAt(0));
				if(choice3==1){
					row = getRow(row2);
					column=getChar(column2);
					if (seats[row - 1][getIndex(column)] == '-') {
						seats[row - 1][getIndex(column)] = column;
						System.out.println("\nThe reservation has been cancelled.");
						System.out.println("\nThe details are - ");
						System.out.println("From - BDQ      To - BOM");
						System.out.println("Name - "+ fname +" "+ mname +" "+lname);
						if(row>4){
							System.out.println("Class - First Class");
							System.out.println("Your refund of 8000 Rupees will be deposited into your bank account shortly.\n");
						}
						else{
							System.out.println("Class - Economy");
							System.out.println("Your refund of 6000 Rupees will be deposited into your bank account shortly.\n");
						}
						       
					} else {
						System.out.println("\nThis seat is not reserved and hence cannot be cancelled\n");
                		System.out.println("Enter any character to continue and 1 to exit");
						int so1 = Character.getNumericValue(scan.nextLine().charAt(0));
						if(so1==1){
							System.out.println("Thanks for using Airline reservation system!");
							System.exit(0);
						}
					}
					choose3 = true;
				}
				else if (choice3 == 2){
					row = getRow(row2);
					column=getChar(column2);
					if (seats2[row - 1][getIndex(column)] == '-') {
						seats2[row - 1][getIndex(column)] = column;
						System.out.println("\nThe reservation has been cancelled.");
						System.out.println("\nThe details are - ");
						System.out.println("From - BOM      To - BDQ");
						System.out.println("Name - "+ fname +" "+ mname +" "+lname);
						if(row>4){
							System.out.println("Class - First Class");
							System.out.println("Your refund of 7000 Rupees will be deposited in your account shortly.\n");
						}
						else{
							System.out.println("Class - Economy");
							System.out.println("Your refund of 5000 Rupees will be deposited in your account shortly.\n");
						}
					} else {
						System.out.println("\nThis seat is not reserved and hence cannot be cancelled\n");
					}
					System.out.println("Enter any character to continue and 1 to exit");
					int s = Character.getNumericValue(scan.nextLine().charAt(0));
					if(s==1){
						System.out.println("Thanks for using Airline reservation system!");
						System.exit(0);
					}
				}
				else if(choice3==3){
					System.out.println("For cancellation of the return ticket first enter the details of the first flight - ");
					row=getRow(row2);
					column = getChar(column2);
					if (seats[row - 1][getIndex(column)] == '-') {
						seats[row - 1][getIndex(column)] = column;
						System.out.println("\nThe reservation has been cancelled.");
						System.out.println("\nThe details are - ");
						System.out.println("From - BDQ      To - BOM");
						System.out.println("Name - "+ fname +" "+ mname +" "+lname);
						if(row>4){
							System.out.println("Class - First Class");
							System.out.println("Your refund of 8000 Rupees will be deposited in your account shortly.\n");
						}
						else{
							System.out.println("Class - Economy");
							System.out.println("Your refund of 6000 Rupees will be deposited in your account shortly.\n");
						}
					} else {
						System.out.println("\nThis seat is not reserved and hence cannot be cancelled\n");
					}
					System.out.println("Please enter details of the second flight - ");
					row=getRow(row2);
					column = getChar(column2);
					if (seats2[row - 1][getIndex(column)] == '-') {
						seats2[row - 1][getIndex(column)] = column;
						System.out.println("\nThe reservation has been cancelled.");
						System.out.println("\nThe details are - ");
						System.out.println("From - BOM      To - BDQ");
						System.out.println("Name - "+ fname +" "+ mname +" "+lname);
						if(row>4){
							System.out.println("Class - First Class");
							System.out.println("Your refund of 7000 Rupees will be deposited in your account shortly\n.");
						}
						else{
							System.out.println("Class - Economy");
							System.out.println("Your refund of 5000 Rupees will be deposited in your account shortly.\n");
						}
					} else {
						System.out.println("\nThis seat is not reserved and hence cannot be cancelled\n");
					}

				}
                else{
                    System.out.println("Wrong input, please eneter 1,2 or 3");
                }
					choose3 = true; 
            }
		}
		else if(choice1 == 3){
			System.out.println("Thank you for using Airline Reservation System");
            depend = true;
			System.exit(0);
		}
		else{
			System.out.println("Wrong input, please enter numbers from 1 to 3");
		}
			}
			}
            System.out.println("Plane is Full.");
		    System.exit(0);
		}	
}