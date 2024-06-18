package gr.aueb.cf.ch9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Reads data from a file that contains locations and their latitude/longitude
 * and writes them in another file using a different formation. Example:
 * source formation -> Athens,37.9838,23.7275 - destination formation ->
 * { location: 'Athens', latitude: 37.9838, longitude: 23.7275 }
 */
public class LocationsApp {

    public static void main(String[] args) {
        String line = "";
        String header1 = "";
        String header2 = "";
        String header3 = "";
        boolean isHeadersLine = true;

        try (BufferedReader bf = new BufferedReader(new FileReader("C:/Users/IT/jtmp/locations.txt"));
             PrintWriter pw = new PrintWriter("C:/Users/IT/jtmp/locations-out.txt")) {

            while ((line = bf.readLine()) != null) {
                String[] tokens = line.split(",");
                if (isHeadersLine) {
                    header1 = tokens[0].toLowerCase();
                    header2 = tokens[1].toLowerCase();
                    header3 = tokens[2].toLowerCase();
                    isHeadersLine = false;
                } else {
                    pw.printf("{ %s: '%s', %s: %s, %s: %s },%n", header1, tokens[0], header2, tokens[1], header3, tokens[2]);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
