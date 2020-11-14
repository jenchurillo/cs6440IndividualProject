package assignment;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.util.BundleUtil;
import org.hl7.fhir.dstu3.model.*;
import org.hl7.fhir.dstu3.model.Bundle;

import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.instance.model.api.IBaseBundle;
import org.hl7.fhir.instance.model.api.IBaseResource;

import javax.servlet.http.HttpServlet;

public class patientList {

    private IGenericClient client = null;

    public patientList(String baseUrl) {
        FhirContext ctx = FhirContext.forDstu3();
        client = ctx.newRestfulGenericClient(baseUrl);
    }


    static public <T extends IBaseResource> ArrayList<T> getCompleteBundleAsList(Bundle bundle, IGenericClient client, Class<T> resourceClass) {
        // Create List to hold our resources.
        ArrayList<T> list = new ArrayList<T>();

        // The bundle starts on page 1, so before moving forward add all of those Resources to the list.
        list.addAll(BundleUtil.toListOfResourcesOfType(client.getFhirContext(), bundle, resourceClass));

        // Loop through the Bundle based on the presence of a link element with a relation of next.
        while (bundle.getLink(IBaseBundle.LINK_NEXT) != null) {
            // Load the next page.
            bundle = client.loadPage().next(bundle).execute();
            // Add those resources to the list.
            list.addAll(BundleUtil.toListOfResourcesOfType(client.getFhirContext(), bundle, resourceClass));
        }
        return list;
    }

    //set correct code for Osteoporosis
    //knee = "239873007"
    //elbow = "239866002"
    //wrist = "239867006"
    //rheumatoid arthritis = "69896004"
    ////osteoporosis = "64859006"
    //Fracture subluxation of wrist = "263102004"
    String snomedCode = "263102004";


    //method to get bundle of Osteoporosis Conditions
    public void getPatientBundle() {
        Bundle bundle = client.search().forResource(Condition.class)
                .where(Condition.CODE.exactly().systemAndCode("http://snomed.info/sct", snomedCode))
                .include(Condition.INCLUDE_SUBJECT.asRecursive())
                .returnBundle(Bundle.class).execute();


        //get completed bundle as list
        ArrayList<Condition> conditionList = getCompleteBundleAsList(bundle, client, Condition.class);

        //create empty set for patients
        ArrayList<String> patientArray = new ArrayList<String>();
        //creat empty set for patient name
        ArrayList<String> nameArray = new ArrayList<String>();

        //look up condition and add patientId to patientArray and conditionId to conditionArray
        for(int j = 0; j<conditionList.size(); j++){
            //System.out.println("Patient: " + conditionList.get(j).getSubject().getReferenceElement().getIdPart() + " Condition: " + conditionList.get(j).getIdElement().getIdPart());

            //Add patient id arrays
            patientArray.add(conditionList.get(j).getSubject().getReferenceElement().getIdPart());

            //get patient name based on patient id
            Patient patient = client.read()
                    .resource(Patient.class)
                    .withId(conditionList.get(j).getSubject().getReferenceElement().getIdPart())
                    .execute();

            String patientName = patient.getNameFirstRep().getNameAsSingleString();
            nameArray.add(patientName);

            System.out.println(patientArray.get(j));
            System.out.println(nameArray.get(j));


        }


    }

}
