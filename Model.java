import java.io.*;
import java.util.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Model {
    public static void main(String[] args) {
        try {
            String replacementText = "!.txt";
            String sourceDirectory = "C:\\SCAN FOR ME\\TIFFANY 26697-330 e Priscilla too\\Emails";
            String targetDirectory = "C:\\SCAN FOR ME\\TIFFANY 26697-330 e Priscilla too\\Emails\\cake";

            // Get a text file to replace all the names
            List<String> readFile = Files.readAllLines(Paths.get(replacementText));
            // Make sure the names equals the number of files to be renamed
            String[] allString = new String[readFile.size()];
            // Convert the list into an array
            allString = readFile.toArray(allString);

            // Get the directory source of the files you want to change
            File oldDirectory = new File(sourceDirectory);
            // Put the files in an array of Files
            File[] listFile = oldDirectory.listFiles();

            // Counter variable for counting allString seperately,
            // since we're looping forEach File in listFile[]
            int count = 0;

            // Iterate for each File object in listFile[]
            for (File oldFile : listFile) {
                // Check if the file is not a folder
                if (oldFile.isFile()) {
                    // Get the new name from allString[], and remove the file extention
                    String newSentence = allString[count].substring(0, allString[count].lastIndexOf("."));

                    // Pick a location for the new file, and combine it with the new name,
                    // and add the extention back
                    File newFile = new File(targetDirectory + "\\" + newSentence + "." + "pdf");

                    // Copy the old file to the new location
                    Files.copy(oldFile.toPath(), newFile.toPath());

                    // Rename the copied file to the new File name
                    newFile.renameTo(newFile);

                    // Increase counter
                    count += 1;
                    System.out.println(newFile.toString());
                }
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

    }
}