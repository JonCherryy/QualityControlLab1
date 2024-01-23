import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) {
		ArrayList<ReportCard> Reportcards = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		boolean choice = true;
		
		while(choice) {
			addReportCard(Reportcards, scanner);
			System.out.println("Would you like to go again? (type no to stop): ");
			String s = scanner.nextLine();
			if(s.equals("no")) {
				choice = false;
			}
		}
		scanner.close();
		writeFile(Reportcards, "reportcards.txt");
	}
	
	static void addReportCard(ArrayList<ReportCard> Reportcards, Scanner scanner) {
		
		//bunch of inputs
		System.out.println("First name: \n");
		String FirstName = scanner.nextLine();
		
		System.out.println("Last name: \n");
		String LastName = scanner.nextLine();
		
		System.out.println("TUid: \n");
		int TUid = scanner.nextInt();
		scanner.nextLine(); //apparently needed because of the "integer buffer"???
		
		System.out.println("Email address: \n");
		String Email = scanner.nextLine();
		
		System.out.println("Phone Number: \n");
		String PhoneNum = scanner.nextLine();
		
		System.out.println("Major: \n");
		String Major = scanner.nextLine();
		
		System.out.println("Expected Graduation Date: \n");
		int ExpGrad = scanner.nextInt();
		scanner.nextLine(); 
		
		System.out.println("Graduation Status: \n");
		String GradStatus = scanner.nextLine();
		
		ReportCard reportcard = new ReportCard(FirstName, LastName, TUid, Email, PhoneNum, Major, ExpGrad, GradStatus);
		Reportcards.add(reportcard);
	}
	
	static void writeFile(ArrayList<ReportCard> Reportcards, String filename) {
		
		//I had a lot of trouble looking for how to write files in java,
		try(PrintWriter writer = new PrintWriter(new FileWriter(filename))){
			for(ReportCard CardNum : Reportcards) { // for each value in the arraylist
				writer.println("First Name: " + CardNum.getFirstName());
				writer.println("Last Name: " + CardNum.getLastName());
				writer.println("TUid: " + CardNum.getTUid());
				writer.println("Email: " + CardNum.getEmail());
				writer.println("Phone Number: " + CardNum.getPhoneNum());
				writer.println("Major: " + CardNum.getMajor());
				writer.println("Expected Graduation Year: " + CardNum.getExpGrad());
				writer.println("Grad degree: " + CardNum.getGrad());
				writer.println();
				writer.println();
			}
		}catch(IOException IO) {
			System.err.println("An error occured while writing the file");  //error writing file message
		}
	}
}

