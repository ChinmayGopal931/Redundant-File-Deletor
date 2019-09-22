import java.io.File;
import java.util.Scanner;
public class Deletor{
	public static void main(String[] args) {
		
		System.out.println("Enter the path containing redundant files");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		File dir;
		if(input==null ) {
			
			System.out.println("Default folder Downloads will be used");
			dir = new File("C:\\Users\\chinm\\Downloads");
		}else {
			dir = new File(input);
		}

		File[] directoryListing = dir.listFiles();
		
		if (directoryListing != null) {
			
			for (int i = 0; i < directoryListing.length; i++) {
				
				if (directoryListing[i].getName().contains("(1)")) {

					System.out.println(directoryListing[i].getName());
					if (directoryListing[i].delete())
						System.out.println("File deleted successfully");
					else
						System.out.println("Failed to delete the file");

					int temp = 2;
					while (directoryListing[++i].getName().contains("(" + (temp++) + ")")) {
						System.out.println(directoryListing[i].getName());
						if (directoryListing[i].delete())
							System.out.println("File deleted successfully");
						else
							System.out.println("Failed to delete the file");
					}

				}
			}

		}
	}
}