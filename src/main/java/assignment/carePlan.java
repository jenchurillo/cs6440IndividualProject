package assignment;

import javax.servlet.RequestDispatcher;
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







@WebServlet(name = "carePlan")
public class carePlan extends HttpServlet {

    private String serverBase ="http://hapi.fhir.org/baseDstu3";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        out.print("username" + request.getParameter("username") + " password" + request.getParameter("password"));

        checkLogin userObject = new checkLogin();
        MiniProject3 project3 = new MiniProject3(serverBase);

        if (userObject.isValidUserLogin(request.getParameter("username"), request.getParameter("password")))
        {

            project3.getPatientName(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
            project3.getPatientDOB(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
            project3.getPatientGender(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
            project3.getPatientAddress(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
            project3.getPatientPhone(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
            project3.getCondition(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));



                String name = project3.getPatientName(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
                Enumerations.AdministrativeGender gender = project3.getPatientGender(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
                Date dateOfBirth = project3.getPatientDOB(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
                String address = project3.getPatientAddress(userObject.getPatientId(request.getParameter("username"), request.getParameter("password"))).replace("[","").replace("]","");
                String phone = project3.getPatientPhone(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
                String condition = project3.getCondition(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
                String conditionId = project3.getConditionId(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
                String carePlan = project3.getCarePlan(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")),conditionId).replace(" ","\n");
                String urlString = "";
                String progressIdentifier = request.getParameter("password");

            if(condition.equals("Osteoarthritis of knee")){

                urlString="knee";

            }//Osteoarthritis of knee
            else if(condition.equals("Rheumatoid arthritis")){

                urlString="rheumatoid";

            }//Rheumatoid arthritis
            else if(condition.equals("Fracture subluxation of wrist")){

                urlString="wrist";

            }//Fracture subluxation of wrist
            else{

            }


                //String condition = project3.getPatientData(userObject.getPatientId(request.getParameter("username"), request.getParameter("password")));
                //String carePlan = project3.getCarePlan("1899027","1899030");

//                request.setAttribute("patientName",name);
//                request.setAttribute("patientGender",gender);
//                request.setAttribute("patientDateOfBirth",dateOfBirth);
//                request.setAttribute("patientAddress", address);
//                request.setAttribute("patientPhone", phone);
//                request.setAttribute("patientCondition", condition);
//                request.setAttribute("patientCarePlan", carePlan);
//                request.setAttribute("conditionId", conditionId);

                request.getSession().setAttribute("patientName",name);
                request.getSession().setAttribute("patientGender",gender);
                request.getSession().setAttribute("patientDateOfBirth",dateOfBirth);
                request.getSession().setAttribute("patientAddress", address);
                request.getSession().setAttribute("patientPhone", phone);
                request.getSession().setAttribute("patientCondition", condition);
                request.getSession().setAttribute("patientCarePlan", carePlan);
                request.getSession().setAttribute("conditionId", conditionId);
                request.getSession().setAttribute("urlString", urlString);
                request.getSession().setAttribute("progressIdentifier", progressIdentifier);



//                this.getServletConfig().getServletContext().setAttribute("patientName",name);
//                this.getServletConfig().getServletContext().setAttribute("patientGender",gender);
//                this.getServletConfig().getServletContext().setAttribute("patientDateOfBirth",dateOfBirth);
//                this.getServletConfig().getServletContext().setAttribute("patientAddress", address);
//                this.getServletConfig().getServletContext().setAttribute("patientPhone", phone);
//                this.getServletConfig().getServletContext().setAttribute("patientCondition", condition);
//                this.getServletConfig().getServletContext().setAttribute("patientCarePlan", carePlan);
//                this.getServletConfig().getServletContext().setAttribute("conditionId", conditionId);

                //request.setAttribute("patientCondition",condition);

                request.getRequestDispatcher("/portal.jsp").forward(request,response);
                request.getRequestDispatcher("/knee.jsp").forward(request,response);
                request.getRequestDispatcher("/wrist.jsp").forward(request,response);
                request.getRequestDispatcher("/rheumatoid.jsp").forward(request,response);
                request.getRequestDispatcher("/hamstringStretch.jsp").forward(request,response);
                request.getRequestDispatcher("/food.jsp").forward(request,response);
                request.getRequestDispatcher("/wrist.jsp").forward(request,response);
                request.getRequestDispatcher("/progress.jsp").forward(request,response);
        }
        else {
            request.setAttribute("errorMessage","Invalid username or password. Please try again.");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//    PrintWriter out = response.getWriter();
//    out.print("Detailed Care Plan Page?");

    }


}
