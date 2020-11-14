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

@WebServlet(name = "detailedPlan")
public class knee extends HttpServlet {

    private String serverBase ="http://hapi.fhir.org/baseDstu3";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String conditionIdentifier = (String) request.getSession().getAttribute("conditionId");
        String jointMobilityInstructions = "Choose 5 of the following 10 exercises and perform 2X a day";
        String jointMobilityExercise1 = "Hamstring Stretch";
        String jointMobilityExercise2 = "Calf Stretch";
        String jointMobilityExercise3 = "Straight Leg Raise";
        String jointMobilityExercise4 = "Quad Set";
        String jointMobilityExercise5 = "Seated Hip March";
        String jointMobilityExercise6 = "Pillow Squeeze";
        String jointMobilityExercise7 = "Heel Raise";
        String jointMobilityExercise8 = "Side Leg Raise";
        String jointMobilityExercise9 = "Sit to Stand";
        String jointMobilityExercise10 = "One Leg Balance";

        String heatTherapy = "";
        String physicalExercise = "";
        String iceTherapy = "Ice the affected area";
        String healthyDiet = "";
        String rest = "";
        String lightExercise = "";





        if(conditionIdentifier.equals("1899030")){
            heatTherapy = "";
            physicalExercise = "";
            iceTherapy = "";
            healthyDiet = "";
            rest = "";
            lightExercise = "";



        }//Osteoarthritis of knee
        else if(conditionIdentifier.equals("1250334")){
            heatTherapy = "";
            physicalExercise = "";
            rest = "";
            lightExercise = "";
            jointMobilityInstructions = "";
            jointMobilityExercise1 = "";
            jointMobilityExercise2 = "";
            jointMobilityExercise3 = "";
            jointMobilityExercise4 = "";
            jointMobilityExercise5 = "";
            jointMobilityExercise6 = "";
            jointMobilityExercise7 = "";
            jointMobilityExercise8 = "";
            jointMobilityExercise9 = "";
            jointMobilityExercise10 = "";




        }//Rheumatoid arthritis
        else if(conditionIdentifier.equals("1922413")){
            heatTherapy = "";
            physicalExercise = "";
            heatTherapy = "";
            physicalExercise = "";
            iceTherapy = "";
            healthyDiet = "";
            rest = "";
            lightExercise = "";
            jointMobilityInstructions = "";
            jointMobilityExercise1 = "";
            jointMobilityExercise2 = "";
            jointMobilityExercise3 = "";
            jointMobilityExercise4 = "";
            jointMobilityExercise5 = "";
            jointMobilityExercise6 = "";
            jointMobilityExercise7 = "";
            jointMobilityExercise8 = "";
            jointMobilityExercise9 = "";
            jointMobilityExercise10 = "";

        }//Fracture subluxation of wrist
        else{

        }

        request.getSession().setAttribute("jointMobilityInstructions",jointMobilityInstructions);
        request.getSession().setAttribute("jointMobilityExercise1",jointMobilityExercise1);
        request.getSession().setAttribute("jointMobilityExercise2",jointMobilityExercise2);
        request.getSession().setAttribute("jointMobilityExercise3",jointMobilityExercise3);
        request.getSession().setAttribute("jointMobilityExercise4",jointMobilityExercise4);
        request.getSession().setAttribute("jointMobilityExercise5",jointMobilityExercise5);
        request.getSession().setAttribute("jointMobilityExercise6",jointMobilityExercise6);
        request.getSession().setAttribute("jointMobilityExercise7",jointMobilityExercise7);
        request.getSession().setAttribute("jointMobilityExercise8",jointMobilityExercise8);
        request.getSession().setAttribute("jointMobilityExercise9",jointMobilityExercise9);
        request.getSession().setAttribute("jointMobilityExercise10",jointMobilityExercise10);
        request.getSession().setAttribute("iceTherapy",iceTherapy);
        request.getSession().setAttribute("conditionIdentifier",conditionIdentifier);

        // request.getSession().setAttribute("patientGender",gender);
        request.getRequestDispatcher("/knee.jsp").forward(request,response);

//        PrintWriter out = response.getWriter();
//        out.print("Condition Id is: "+conditionIdentifier);
    }
}
