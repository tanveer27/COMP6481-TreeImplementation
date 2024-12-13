/**
 * Demonstrates the functionality of the Directory class by performing various operations on a simulated file system.
 * Assignment 3, Question 2, Task 4
 * Date: 30-Nov-2024
 * @author: Tanveer Reza
 */
public class DirectoryDriver {
    private Directory root;

    /**
     * Constructs a DirectoryDriver object with the specified root directory name.
     * @param rootName the name of the root directory
     * @author: Tanveer Reza
     */
    public DirectoryDriver(String rootName) {
        this.root = new Directory(rootName, false);
    }

    /**
     * Adds a file to a specific directory.
     * @param path     the path to the directory
     * @param fileName the name of the file to add
     * @author: Tanveer Reza
     */
    public void addFile(String path, String fileName) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.addFile(fileName);
            System.out.println("File added successfully.");
        } else {
            System.out.println("Directory not found. Please check the path.");
        }
    }

    /**
     * Adds a subdirectory to a specific directory.
     * @param path    the path to the directory
     * @param dirName the name of the subdirectory to add
     * @author: Tanveer Reza
     */
    public void addDirectory(String path, String dirName) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.addDirectory(dirName);
            System.out.println("Subdirectory added successfully.");
        } else {
            System.out.println("Directory not found. Please check the path.");
        }
    }

    /**
     * Finds a directory by path.
     * @param path the path to the directory
     * @return the directory if found, null otherwise
     * @author: Tanveer Reza
     */
    public Directory findDirectory(String path) {
        String[] parts = path.split("/");
        Directory current = root;
        for (String part : parts) {
            if (!part.equalsIgnoreCase(root.getName())) {
                current = current.getChild(part);
                if (current == null) {
                    return null; // Directory not found
                }
            }
        }
        return current;
    }

    /**
     * Prints the entire directory structure.
     * @author: Tanveer Reza
     */
    public void printDirectoryStructure() {
        root.printDirectoryStructure("");
    }

    /**
     * Calculates the total size of the root directory.
     * @return the total size of the root directory
     * @author: Tanveer Reza
     */
    public int getTotalSize() {
        return root.getSize();
    }

    /**
     * Searches for a file in the entire directory structure.
     * @param fileName the name of the file to search for
     * @return the full path to the file if found, null otherwise
     * @author: Tanveer Reza
     */
    public String findFile(String fileName) {
        return root.findFile(fileName);
    }
}