package assignment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.hl7.fhir.dstu3.model.Bundle;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.util.BundleUtil;
import org.hl7.fhir.dstu3.model.*;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.instance.model.api.IBaseBundle;
import org.hl7.fhir.instance.model.api.IBaseResource;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IClientInterceptor;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.gclient.IClientExecutable;
import assignment.MiniProject3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class checkLogin {


    private String serverBase ="http://hapi.fhir.org/baseDstu3";
    String path = "/Users/jenchurillo/Desktop/IndividualProject_Username&PasswordData - Sheet1.csv";
    String line = "";
    String[] patientId = new String[54];
    String[] patientName = new String[54];
    String[] patientPassword = new String[54];
    String[] patientUsername = new String[54];
    String[] values = new String[54];




    public  boolean isValidUserLogin(String username, String userPassword) {

        MiniProject3 project3 = new MiniProject3(serverBase);
        String Id;
        String correctPassword;
        String correctUsername;

        //read in CSV file and store values in an array
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(path));
//
//
//            int i = 0;
//            while ((line = br.readLine()) != null) {
//
//                values[i] = line;
//                i++;
//
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //create array of patientIds
            //        for (int j = 0; j < values.length; j++) {
            //            patientId[j] = values[j].split(",")[0];
            //
            //        }
        patientId[0]="1899027";
        patientId[1]="1908120";
        patientId[2]="1911777";
        patientId[3]="1914777";
        patientId[4]="1919692";
        patientId[5]="1201232";
        patientId[6]="1265949";
        patientId[7]="1298813";
        patientId[8]="1297641";
        patientId[9]="1302326";
        patientId[10]="1322641";
        patientId[11]="1316800";
        patientId[12]="1329987";
        patientId[13]="1340449";
        patientId[14]="1348481";
        patientId[15]="2529199";
        patientId[16]="2529636";
        patientId[17]="2529824";
        patientId[18]="2529986";
        patientId[19]="2530159";
        patientId[20]="2530178";
        patientId[21]="2530112";
        patientId[22]="2532717";
        patientId[23]="2532719";
        patientId[24]="2533298";
        patientId[25]="2536306";
        patientId[26]="2536318";
        patientId[27]="2536380";
        patientId[28]="2539457";
        patientId[29]="2543694";
        patientId[30]="2558345";
        patientId[31]="2567292";
        patientId[32]="2735047";
        patientId[33]="1250273";
        patientId[34]="2543648";
        patientId[35]="1198142";
        patientId[36]="2735047";
        patientId[37]="1906842";
        patientId[38]="1922305";
        patientId[39]="1933001";
        patientId[40]="1933955";
        patientId[41]="1938245";
        patientId[42]="1999893";
        patientId[43]="2000372";
        patientId[44]="2008843";
        patientId[45]="1264668";
        patientId[46]="2533540";
        patientId[47]="2533543";
        patientId[48]="2533542";
        patientId[49]="2536328";
        patientId[50]="2558330";
        patientId[51]="2558432";
        patientId[52]="2567283";

        //create array of patientName
                //        for (int k = 0; k < values.length; k++) {
                //            patientName[k] = values[k].split(",")[1];
                //
                //        }
        patientName[0]="Mr. Lemuel917 Murray968";
        patientName[1]="Mrs. Laveta530 Parker609";
        patientName[2]="Mrs. Dinorah800 Jones139";
        patientName[3]="Mrs. Annemarie626 Kohler405";
        patientName[4]="Ms. Chi949 Tremblay982";
        patientName[5]="Ms. Athena83 Wilderman619";
        patientName[6]="Mrs. Rachele486 Bode78";
        patientName[7]="Mrs. Kelli207 Daugherty69";
        patientName[8]="Mr. Keenan632 Paucek755";
        patientName[9]="Mr. Keenan632 Paucek755";
        patientName[10]="Mr. Keenan632 Paucek755";
        patientName[11]="Mr. Keenan632 Paucek755";
        patientName[12]="Mr. Keenan632 Paucek755";
        patientName[13]="Mr. Keenan632 Paucek755";
        patientName[14]="Mr. Keenan632 Paucek755";
        patientName[15]="Bà. Ái Linh Bùi";
        patientName[16]="Bà. Ái Linh Bùi";
        patientName[17]="Bà. Ái Linh Bùi";
        patientName[18]="Ông. Nhật Hồng Nguyễn";
        patientName[19]="Bà. Hà Tiên Lý";
        patientName[20]="Bà. Ngọc Lan Đỗ";
        patientName[21]="Bà. Phương Hoa Phan";
        patientName[22]="Ông. Tùng Anh Lê";
        patientName[23]="Ông. Tùng Anh Lê";
        patientName[24]="Ông. Huy Hà Bùi";
        patientName[25]="Bà. Hương Giang Lý";
        patientName[26]="Bà. Hương Giang Lý";
        patientName[27]="Bà. Ngọc Khuê Phan";
        patientName[28]="Bà. Hương Giang Lý";
        patientName[29]="Bà. Ngọc Liên Phan";
        patientName[30]="Bà. Hồng Lâm Ngô";
        patientName[31]="Ông. Gia Minh Nguyễn";
        patientName[32]="Mrs. Vivan792 Fisher759";
        patientName[33]="Mr. Morgan564 Hilpert278";
        patientName[34]="Bà. Thủy Minh Lý";
        patientName[35]="Mrs. Albertine688 Schmidt332";
        patientName[36]="Mrs. Vivan792 Fisher759";
        patientName[37]="Ms. Nicola64 Boyle354";
        patientName[38]="Mr. Norberto545 Nicolas997";
        patientName[39]="Mrs. Maurine738 Bauch455";
        patientName[40]="Piedad84 Ortiz382";
        patientName[41]="Mrs. Tamisha760 Welch858";
        patientName[42]="Mr. David908 Fay398";
        patientName[43]="Mr. Dudley365 Larkin917";
        patientName[44]="Mrs. Cherilyn114 Schinner682";
        patientName[45]="Alvin56 Hilpert278";
        patientName[46]="Chị. Tâm Như Lê";
        patientName[47]="Chị. Tâm Như Lê";
        patientName[48]="Chị. Tâm Như Lê";
        patientName[49]="Anh. Quốc Trường Lý";
        patientName[50]="Hữu Châu Hoàng";
        patientName[51]="Bà. Thiên Lam Lê";
        patientName[52]="Ông. Thiên Lương Hồ";

        //create array of patientUsername
                //        for (int l = 0; l < values.length; l++) {
                //            patientUsername[l] = values[l].split(",")[2];
                //
                //        }
        patientUsername[0]="HeLLO1899027";
        patientUsername[1]="HeLLO1908120";
        patientUsername[2]="HeLLO1911777";
        patientUsername[3]="HeLLO1914777";
        patientUsername[4]="HeLLO1919692";
        patientUsername[5]="HeLLO1201232";
        patientUsername[6]="HeLLO1265949";
        patientUsername[7]="HeLLO1298813";
        patientUsername[8]="HeLLO1297641";
        patientUsername[9]="HeLLO1302326";
        patientUsername[10]="HeLLO1322641";
        patientUsername[11]="HeLLO1316800";
        patientUsername[12]="HeLLO1329987";
        patientUsername[13]="HeLLO1340449";
        patientUsername[14]="HeLLO1348481";
        patientUsername[15]="HeLLO2529199";
        patientUsername[16]="HeLLO2529636";
        patientUsername[17]="HeLLO2529824";
        patientUsername[18]="HeLLO2529986";
        patientUsername[19]="HeLLO2530159";
        patientUsername[20]="HeLLO2530178";
        patientUsername[21]="HeLLO2530112";
        patientUsername[22]="HeLLO2532717";
        patientUsername[23]="HeLLO2532719";
        patientUsername[24]="HeLLO2533298";
        patientUsername[25]="HeLLO2536306";
        patientUsername[26]="HeLLO2536318";
        patientUsername[27]="HeLLO2536380";
        patientUsername[28]="HeLLO2539457";
        patientUsername[29]="HeLLO2543694";
        patientUsername[30]="HeLLO2558345";
        patientUsername[31]="HeLLO2567292";
        patientUsername[32]="HeLLO2735047";
        patientUsername[33]="HeLLO1250273";
        patientUsername[34]="HeLLO2543648";
        patientUsername[35]="HeLLO1198142";
        patientUsername[36]="HeLLO2735047";
        patientUsername[37]="HeLLO1906842";
        patientUsername[38]="HeLLO1922305";
        patientUsername[39]="HeLLO1933001";
        patientUsername[40]="HeLLO1933955";
        patientUsername[41]="HeLLO1938245";
        patientUsername[42]="HeLLO1999893";
        patientUsername[43]="HeLLO2000372";
        patientUsername[44]="HeLLO2008843";
        patientUsername[45]="HeLLO1264668";
        patientUsername[46]="HeLLO2533540";
        patientUsername[47]="HeLLO2533543";
        patientUsername[48]="HeLLO2533542";
        patientUsername[49]="HeLLO2536328";
        patientUsername[50]="HeLLO2558330";
        patientUsername[51]="HeLLO2558432";
        patientUsername[52]="HeLLO2567283";

        //create array of patientPassword
                //        for (int m = 0; m < values.length; m++) {
                //            patientPassword[m] = values[m].split(",")[3];
                //
                //        }
        patientPassword[0]="1899027";
        patientPassword[1]="1908120";
        patientPassword[2]="1911777";
        patientPassword[3]="1914777";
        patientPassword[4]="1919692";
        patientPassword[5]="1201232";
        patientPassword[6]="1265949";
        patientPassword[7]="1298813";
        patientPassword[8]="1297641";
        patientPassword[9]="1302326";
        patientPassword[10]="1322641";
        patientPassword[11]="1316800";
        patientPassword[12]="1329987";
        patientPassword[13]="1340449";
        patientPassword[14]="1348481";
        patientPassword[15]="2529199";
        patientPassword[16]="2529636";
        patientPassword[17]="2529824";
        patientPassword[18]="2529986";
        patientPassword[19]="2530159";
        patientPassword[20]="2530178";
        patientPassword[21]="2530112";
        patientPassword[22]="2532717";
        patientPassword[23]="2532719";
        patientPassword[24]="2533298";
        patientPassword[25]="2536306";
        patientPassword[26]="2536318";
        patientPassword[27]="2536380";
        patientPassword[28]="2539457";
        patientPassword[29]="2543694";
        patientPassword[30]="2558345";
        patientPassword[31]="2567292";
        patientPassword[32]="2735047";
        patientPassword[33]="1250273";
        patientPassword[34]="2543648";
        patientPassword[35]="1198142";
        patientPassword[36]="2735047";
        patientPassword[37]="1906842";
        patientPassword[38]="1922305";
        patientPassword[39]="1933001";
        patientPassword[40]="1933955";
        patientPassword[41]="1938245";
        patientPassword[42]="1999893";
        patientPassword[43]="2000372";
        patientPassword[44]="2008843";
        patientPassword[45]="1264668";
        patientPassword[46]="2533540";
        patientPassword[47]="2533543";
        patientPassword[48]="2533542";
        patientPassword[49]="2536328";
        patientPassword[50]="2558330";
        patientPassword[51]="2558432";
        patientPassword[52]="2567283";


//            System.out.println(patientUsername[1]);
//            System.out.println(username);

        //if no username is entered return false
        if(username.length()!=0)
        {

        //search through username array and see if entered username (username) matches
        int w = -1;

        for (int p = 0; p < patientUsername.length; p++) {
            if (username.equals(patientUsername[p])) {
                w = p;
                break;
            }
        }

        System.out.println("w = " + w);

        //if username was found, set correct username, password, and patientId
        if (w != -1) {
            Id = patientId[w];
            correctPassword = patientPassword[w];
            correctUsername = patientUsername[w];
            //System.out.println(Id + " " + correctPassword + " " + correctUsername);
        } else {
            Id = "";
            correctUsername = "";
            correctPassword = "";
        }


        if (username.equals(correctUsername) && userPassword.equals(correctPassword)) {
            return true;
        }

        return false;
    }
        else{
            return false;
        }

    }

    public String getPatientId(String username, String userPassword){
        MiniProject3 project3 = new MiniProject3(serverBase);
        String Id;
        String correctPassword;
        String correctUsername;

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


//            System.out.println(patientUsername[1]);
//            System.out.println(username);


        //search through username array and see if entered username (username) matches
        int w = -1;

        for(int p=0; p<patientUsername.length; p++){
            if(username.equals(patientUsername[p])){
                w = p;
                break;
            }
        }

        System.out.println("w = " + w);

        //if username was found, set correct username, password, and patientId
        if(w != -1){
            Id = patientId[w];
            correctPassword = patientPassword[w];
            correctUsername = patientUsername[w];
            //System.out.println(Id + " " + correctPassword + " " + correctUsername);
        }
        else{
            Id = "";
            correctUsername = "";
            correctPassword = "";
        }

        return Id;

    }

}
