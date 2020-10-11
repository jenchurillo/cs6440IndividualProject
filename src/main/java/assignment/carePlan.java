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







@WebServlet(name = "carePlan")
public class carePlan extends HttpServlet {

    private String serverBase ="http://hapi.fhir.org/baseDstu3";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        MiniProject3 project3 = new MiniProject3(serverBase);
        project3.getPatientData("1899027");
        PrintWriter out = response.getWriter();
        out.print("PATIENT INFORMATION\n");
        out.print("\nPatient Name: " + project3.getPatientData("1899027").split("-")[0]);
        out.print("\nPatient Gender: " + project3.getPatientData("1899027").split("-")[1]);
        out.print("\nPatient Date of Birth: " + project3.getPatientData("1899027").split("-")[2]);
        out.print("\nPatient Condition: " + project3.getPatientData("1899027").split("-")[3]);

        out.print("\n\n\n\nCARE PLAN");
        out.print("\n" + project3.getCarePlan("1899027","1899030"));

    }
}
