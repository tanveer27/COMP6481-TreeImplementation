import java.util.Scanner;

/**
 * Main class to demonstrate the functionality of the Directory and DirectoryDriver classes.
 * Provides a menu-driven interface for performing various operations on a simulated file system.
 * Assignment 3, Question 2
 * Date: 30-Nov-2024
 * @author: Tanveer Reza
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an instance of DirectoryDriver with "root" as the root directory name
        DirectoryDriver directoryDriver = new DirectoryDriver("root");

        initializeDirectoryStructure(directoryDriver);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add File");
            System.out.println("2. Add Subdirectory");
            System.out.println("3. Print Directory Structure");
            System.out.println("4. Calculate Total Size");
            System.out.println("5. Search for a File");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter the path to the directory (e.g., root/documents): ");
                    String filePath = scanner.nextLine();
                    System.out.print("Enter the file name: ");
                    String fileName = scanner.nextLine();
                    directoryDriver.addFile(filePath, fileName);
                    break;

                case 2:
                    System.out.print("Enter the path to the directory (e.g., root/documents): ");
                    String dirPath = scanner.nextLine();
                    System.out.print("Enter the subdirectory name: ");
                    String dirName = scanner.nextLine();
                    directoryDriver.addDirectory(dirPath, dirName);
                    break;

                case 3:
                    System.out.println("\nDirectory Structure:");
                    directoryDriver.printDirectoryStructure();
                    break;

                case 4:
                    System.out.println("\nTotal size of the directory: " + directoryDriver.getTotalSize() + " files");
                    break;

                case 5:
                    System.out.print("Enter the file name to search: ");
                    String searchFile = scanner.nextLine();
                    String fullPath = directoryDriver.findFile(searchFile);
                    if (fullPath != null) {
                        System.out.println("File found at: " + fullPath);
                    } else {
                        System.out.println("File not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Initializes the directory structure with predefined directories and files.
     * @param directoryDriver the DirectoryDriver instance to initialize
     * @author: Tanveer Reza
     */
    public static void initializeDirectoryStructure(DirectoryDriver directoryDriver) {
        // Add subdirectories to the root
        directoryDriver.addDirectory("root", "documents");
        directoryDriver.addDirectory("root", "music");
        directoryDriver.addDirectory("root", "downloads");
        directoryDriver.addDirectory("root", "images");

        // Add subdirectories to documents
        directoryDriver.addDirectory("root/documents", "work");
        directoryDriver.addDirectory("root/documents", "personal");

        // Add files to work
        directoryDriver.addFile("root/documents/work", "report.docx");
        directoryDriver.addFile("root/documents/work", "presentation.pptx");

        // Add files to personal
        directoryDriver.addFile("root/documents/personal", "resume.pdf");

        // Add subdirectories to music
        directoryDriver.addDirectory("root/music", "rock");
        directoryDriver.addDirectory("root/music", "pop");

        // Add subdirectories and files to rock
        directoryDriver.addDirectory("root/music/rock", "album1");
        directoryDriver.addFile("root/music/rock/album1", "song1.mp3");
        directoryDriver.addFile("root/music/rock/album1", "song2.mp3");

        // Add subdirectories and files to pop
        directoryDriver.addDirectory("root/music/pop", "album2");
        directoryDriver.addFile("root/music/pop/album2", "song3.mp3");

        // Add subdirectories to downloads
        directoryDriver.addDirectory("root/downloads", "software");

        // Add files to software
        directoryDriver.addFile("root/downloads/software", "program1.exe");
        directoryDriver.addFile("root/downloads/software", "program2.exe");

        // Add files to images
        directoryDriver.addFile("root/images", "image1.jpg");
        directoryDriver.addFile("root/images", "image2.png");

        // Add file to root
        directoryDriver.addFile("root", "readme.txt");
    }
}