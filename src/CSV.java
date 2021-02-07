import java.io.*;
import java.util.ArrayList;

public class CSV {
    public static void main(String[] args) throws IOException {

        // Reader to get filter list
        BufferedReader csvReader = new BufferedReader(new FileReader("src/filter_list.csv"));
        String row = csvReader.readLine();
        ArrayList<String> filter = new ArrayList<>();

        // Sets all filter lists in an array list
        while(row != null){
            String[] data = row.split(",");
            filter.add(data[0]);
            row = csvReader.readLine();
        }

        System.out.println(filter);

        // Reader to read contacts
        csvReader = new BufferedReader(new FileReader("src/contacts.csv"));
        row = csvReader.readLine();

        // Writer to write new CSV file
        FileWriter csvWriter = new FileWriter("src/new.csv");

        // Reads contacts and checks against filter list
        // Adds contacts to new file if not in filter list
        while(row != null) {
            String[] data = row.split(",");
            if(filter.contains(data[0])){
                System.out.println("Found a match: " + data[0]);
            }
            else{
                csvWriter.append(row);
                csvWriter.append("\n");
            }
            row = csvReader.readLine();

        }

        csvWriter.flush();
        csvWriter.close();
    }
}