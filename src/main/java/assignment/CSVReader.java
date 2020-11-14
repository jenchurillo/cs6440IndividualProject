package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args){

        String path = "/Users/jenchurillo/Desktop/IndividualProject_Username&PasswordData - Sheet1.csv";
        String line = "";
        String[] patientId = new String[54];
        String[] patientName = new String[54];
        String[] patientPassword = new String[54];
        String[] patientUsername = new String[54];
        String[] values = new String[54];





            //read in CSV file and store values in an array
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));



                    int i = 0;
                    while ((line = br.readLine()) != null) {

                        values[i] = line;
                        i++;

                    }



            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        //create array of patientIds
        for(int j=0; j<values.length; j++){
            patientId[j] = values[j].split(",")[0];

        }

        //create array of patientName
        for(int k=0; k<values.length; k++){
            patientName[k] = values[k].split(",")[1];

        }

        //create array of patientUsername
        for(int l=0; l<values.length; l++){
            patientUsername[l] = values[l].split(",")[2];

        }

        //create array of patientPassword
        for(int m=0; m<values.length; m++){
            patientPassword[m] = values[m].split(",")[3];

        }


        //create method that searches for username and password




    }
}
