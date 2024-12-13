import java.util.ArrayList;
import java.util.List;
/**
 * Represents a directory or file in a file system.
 * Assignment 3, Question 2, Task 1
 * Date: 30-Nov-2024
 * @author: Tanveer Reza
 */
class Directory {
    private String name;
    private boolean isFile;
    private List<Directory> children;

    /**
     * Constructs a Directory object.
     *
     * @param name   the name of the directory or file
     * @param isFile true if this is a file, false if it is a directory
     * @author: Tanveer Reza
     */
    public Directory(String name, boolean isFile) {
        this.name = name;
        this.isFile = isFile;
        this.children = isFile ? null : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public List<Directory> getChildren() {
        return children;
    }

    public void setChildren(List<Directory> children) {
        this.children = children;
    }

    /**
     * Adds a file to the current directory.
     * @param fileName the name of the file to add
     * @author: Tanveer Reza
     * Assignment 3, Question 2, Task 2
     */
    public void addFile(String fileName) {
        if (this.isFile) {
            throw new UnsupportedOperationException("Cannot add files to a file.");
        }
        this.children.add(new Directory(fileName, true));
    }

    /**
     * Adds a subdirectory to the current directory.
     * @param dirName the name of the subdirectory to add
     * @author: Tanveer Reza
     * Assignment 3, Question 2, Task 2
     */
    public void addDirectory(String dirName) {
        if (this.isFile) {
            throw new UnsupportedOperationException("Cannot add directories to a file.");
        }
        this.children.add(new Directory(dirName, false));
    }

    /**
     * Prints the directory structure recursively.
     * @param indent the indentation to use for printing
     * @author: Tanveer Reza
     * Assignment 3, Question 2, Task 2
     */
    public void printDirectoryStructure(String indent) {
        System.out.println(indent + (isFile ? "- " : "+ ") + name);
        if (!isFile && children != null) {
            for (Directory child : children) {
                child.printDirectoryStructure(indent + "  ");
            }
        }
    }

    /**
     * Calculates the total size of the directory.
     * @return the total size of the directory
     * @author: Tanveer Reza
     * Assignment 3, Question 2, Task 3
     */
    public int getSize() {
        if (isFile) {
            return 1; // Each file has a size of 1
        }
        int totalSize = 0;
        for (Directory child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    /**
     * Finds a file recursively and returns the full path.
     *
     * @param fileName    the name of the file to find
     * @param currentPath the current path in the directory structure
     * @return the full path to the file if found, null otherwise
     * @author: Tanveer Reza
     * Assignment 3, Question 2, Task 3
     */
    public String findFile(String fileName, String currentPath) {
        if (isFile && name.equals(fileName)) {
            return currentPath + "/" + name;
        }
        if (!isFile && children != null) {
            for (Directory child : children) {
                String found = child.findFile(fileName, currentPath + "/" + name);
                if (found != null) {
                    return found;
                }
            }
        }
        return null; // File not found
    }

    /**
     * Gets a child directory or file by name.
     * @param childName the name of the child to get
     * @return the child directory or file if found, null otherwise
     * @author: Tanveer Reza
     */
    public Directory getChild(String childName) {
        if (this.isFile) {
            throw new UnsupportedOperationException("Files do not have children.");
        }
        for (Directory child : children) {
            if (child.getName().equalsIgnoreCase(childName)) {
                return child;
            }
        }
        return null; // Child not found
    }

    /**
     * Finds a file recursively and returns the full path.
     * @param fileName the name of the file to find
     * @return the full path to the file if found, null otherwise
     * @author: Tanveer Reza
     */
    public String findFile(String fileName) {
        return findFile(fileName, "");
    }
}