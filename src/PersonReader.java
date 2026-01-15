import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class PersonReader {
    static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(System.getProperty("user.dir")));

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Path file = chooser.getSelectedFile().toPath();
            ArrayList<String> lines = new ArrayList<>();

            try (InputStream in = new BufferedInputStream(Files.newInputStream(file));
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

                while (reader.ready()) {
                    lines.add(reader.readLine());
                }

                System.out.printf("%-8s %-15s %-15s %-6s %-5s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println("==============================================================")
                ;


                for (String line : lines) {
                    String[] f = line.split(",");
                    if (f.length == 5) {
                    System.out.printf("%-8s %-15s %-15s %-6s %-5s%n"
                            , f[0].trim(), f[1].trim(), f[2].trim(), f[3].trim(), f[4].trim());
                } else {
                    System.out.println("Error record: " + line); } }

                    } catch (Exception e)
                        { e.printStackTrace(); }

                } else {
            System.out.println("No file selected");

            }
        }
    }

