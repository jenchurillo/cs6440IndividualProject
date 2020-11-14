package assignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.util.BundleUtil;
import org.hl7.fhir.dstu3.model.*;
import org.hl7.fhir.dstu3.model.Bundle;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.instance.model.api.IBaseBundle;
import org.hl7.fhir.instance.model.api.IBaseResource;

import javax.servlet.http.HttpServlet;


/**
 * This class contains methods for reading resoruces from the FHIR server.
 */

public class MiniProject3 extends HttpServlet {

    private IGenericClient client = null;

    public MiniProject3(String baseUrl) {
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

    /**
     * Find all conditions with the given SNOMED code (64859006 - Osteoporosis
     *
     */

    //set correct code for Osteoporosis of knee
    String snomedCode = "239873007";

    //method to get bundle of Osteoporosis Conditions
//    public void getOsteoarthritisBundle() {
//        Bundle bundle = client.search().forResource(Condition.class)
//                .where(Condition.CODE.exactly().systemAndCode("http://snomed.info/sct", snomedCode))
//                .include(Condition.INCLUDE_SUBJECT.asRecursive())
//                .returnBundle(Bundle.class).execute();
//
//
//        //get completed bundle as list
//        ArrayList<Condition> conditionList = getCompleteBundleAsList(bundle, client, Condition.class);
//
//
//        //create empty set for patients
//        ArrayList<String> patientArray = new ArrayList<String>();
//        //create empty set for encounter
//        ArrayList<String> conditionArray = new ArrayList<String>();
//        //creat empty set for patient name
//        ArrayList<String> nameArray = new ArrayList<String>();
//
//
//        //look up condition and add patientId to patientArray and conditionId to conditionArray
//        for(int j = 0; j<conditionList.size(); j++){
//            //System.out.println("Patient: " + conditionList.get(j).getSubject().getReferenceElement().getIdPart() + " Condition: " + conditionList.get(j).getIdElement().getIdPart());
//
//            //Add patient id and condition id to their accompanying arrays
//            patientArray.add(conditionList.get(j).getSubject().getReferenceElement().getIdPart());
//            conditionArray.add(conditionList.get(j).getIdElement().getIdPart());
//
//        }
//
//
//
//    }

//    //Get care plan for specific patient and observation
//    public String getCarePlan(String patientId, String conditionId){
//        //Look up CarePlan based on patientId and conditionId
//        Bundle bundle = client.search().forResource(CarePlan.class)
//                .where(CarePlan.SUBJECT.hasId(patientId))
//                .and(CarePlan.CONDITION.hasId(conditionId))
////                .where(Condition.CODE.exactly().systemAndCode("http://snomed.info/sct", snomedCode))
////                .include(Condition.INCLUDE_SUBJECT.asRecursive())
//                .returnBundle(Bundle.class).execute();
//
//
//        //System.out.println(bundle);
//          //      System.out.println(bundle.getEntry());
//        // System.out.println(bundle.getEntryFirstRep().getResource());
//
//
//        //get completed bundle as list
//        ArrayList<Resource> carePlanList = new ArrayList<Resource>();
//        carePlanList.add(bundle.getEntryFirstRep().getResource());
//                // getCompleteBundleAsList(bundle, client, CarePlan.class);
//                // = new ArrayList<CarePlan>();
//
//        //create empty array for care plan
//        //ArrayList<String> activities = new ArrayList<String>();
//
//
//        //System.out.println(carePlanList.size());
//        //String conditionIdentifier = carePlanList.get(k).getAddresses();
//
//
//        //get Care Plan activities
//
//        String fullCarePlan = "";
//
//        for(int k=0; k<carePlanList.size();k++){
//
//
//
//                //System.out.println(carePlanList.get(k).getActivity());
//                //System.out.println(((CarePlan) carePlanList.get(k)).getActivity());
//
//                List<CarePlan.CarePlanActivityComponent> activities = ((CarePlan) carePlanList.get(k)).getActivity();
//
//
//            for(int i=0;i<activities.size();i++){
//                //System.out.println(activities.get(i).getDetail().getCode().getCoding());
//                List<Coding> carePlanCoding = activities.get(i).getDetail().getCode().getCoding();
//
//                //System.out.println(i);
//                //System.out.println(activities.get(i));
//                //System.out.println(activities.get(i).getDetail().getCode().getCoding());
//
//                HashSet<String> display = new HashSet<String>();
//
//                for(int j=0; j<carePlanCoding.size();j++){
//
//                    display.add(carePlanCoding.get(j).getDisplay());
//                    for (String s : display) {
//                        System.out.println(s);
//                    }
//                    //System.out.println(carePlanCoding.get(j));
//                    //System.out.println(carePlanCoding.get(j).getDisplay());
//                }
//
//                String heatTherapyInstructions = "Apply heat 2 or 3 times a day for 20 to 30 minutes each time. \nYou can use a heating pad, hot pack, or hot shower.";
//                String heatRecommendations = "\nAfter treatment, try some gentle massage for relaxation and pain relief.\n";
//                String heatTherapyWarning =  "\nIf using an electric heating pad, make sure you do not fall asleep." + '\n' + "Only use the low or medium settings. Never use high!";
//                String jointMobilityInstructions = "Try the following exercises:" + '\n' + "Hamstring Stretch" + '\n' + "Calf Stretch" + '\n' + "Straight Leg Raise" + '\n' + "Seated Hip March" + '\n' + "Pillow Squeeze" + '\n' + "Heel Raises" + '\n' + "Side Leg Raises" + '\n' + "Sit to Stand" + '\n' + "Step Ups";
//
//                if(display.contains("Heat therapy")){
//                   // System.out.println(heatTherapyInstructions);
//                   // System.out.println(heatTherapyWarning);
//                    fullCarePlan += "\n\nHEAT THERAPY\n" + heatTherapyInstructions + " " + heatRecommendations + " " + heatTherapyWarning + "\n";
//                }
//
//                if(display.contains("Joint mobility exercises")){
//                   // System.out.println(jointMobilityInstructions);
//                    fullCarePlan += "\nJOINT MOBILITY\n" + jointMobilityInstructions + "\n";
//                }
//
//
//            }
//
//
//            //System.out.println(carePlanList.get(k).getAddresses());
//
//            //System.out.println(carePlanList.get(k).getActivity().toArray());
//
//        }//end of for loop
//
//        return fullCarePlan;
//
//    }




    public String getPatientName(String id){
                Patient patient = client.read()
                .resource(Patient.class)
                .withId(id)
                .execute();
        String patientName = patient.getNameFirstRep().getNameAsSingleString();
        return patientName;
    }

    public Date getPatientDOB(String id){
        Patient patient = client.read()
                .resource(Patient.class)
                .withId(id)
                .execute();
        Date patientBirthDate = patient.getBirthDate();
        return patientBirthDate;
    }

    public Enumerations.AdministrativeGender getPatientGender(String id){
        Patient patient = client.read()
                .resource(Patient.class)
                .withId(id)
                .execute();
        Enumerations.AdministrativeGender patientGender = patient.getGender();
        return patientGender;
    }


    public String getPatientAddress(String id){
        Patient patient = client.read()
                .resource(Patient.class)
                .withId(id)
                .execute();
        String patientAddress = patient.getAddressFirstRep().getLine().toString();
        return patientAddress;
    }

    public String getPatientPhone(String id){
        Patient patient = client.read()
                .resource(Patient.class)
                .withId(id)
                .execute();
        String patientPhone = patient.getTelecomFirstRep().getValue();
        return patientPhone;
    }




    //get Condition for specific patient
    public String getCondition(String id) {
        Bundle bundle = client.search().forResource(Condition.class)
                .where(Condition.SUBJECT.hasId(id))
                .returnBundle(Bundle.class).execute();

        //get completed bundle as list
        ArrayList<Condition> conditionList = getCompleteBundleAsList(bundle, client, Condition.class);

        String conditionDescription = "";


        for(int i=0;i<conditionList.size();i++){

            String conditionCode = conditionList.get(i).getCode().getCodingFirstRep().getCode();
            //System.out.println(conditionList.get(i).getCode().getCodingFirstRep().getCode());

            if((conditionCode.equals("239873007"))||(conditionCode.equals("69896004"))||(conditionCode.equals("263102004"))){
                conditionDescription += conditionList.get(i).getCode().getCodingFirstRep().getDisplay();
                //System.out.println(conditionList.get(i).getCode().getCodingFirstRep().getDisplay());

            }
            else{

            }

        }

        return conditionDescription;

    }

    public String getConditionId(String id){
        Bundle bundle = client.search().forResource(Condition.class)
                .where(Condition.SUBJECT.hasId(id))
                .returnBundle(Bundle.class).execute();

        //get completed bundle as list
        ArrayList<Condition> conditionList = getCompleteBundleAsList(bundle, client, Condition.class);

        String conditionId = "";

        for(int i=0;i<conditionList.size();i++){

            String conditionCode = conditionList.get(i).getCode().getCodingFirstRep().getCode();
            //System.out.println(conditionList.get(i).getCode().getCodingFirstRep().getCode());

            if((conditionCode.equals("239873007"))||(conditionCode.equals("69896004"))||(conditionCode.equals("263102004"))){
                conditionId += conditionList.get(i).getIdElement().getIdPart();
                //System.out.println(conditionList.get(i).getCode().getCodingFirstRep().getDisplay());

            }
            else{

            }

        }

        return conditionId;

    }

    public String getCarePlan(String patientId, String conditionId){
                Bundle bundle = client.search().forResource(CarePlan.class)
                .where(CarePlan.SUBJECT.hasId(patientId))
                .and(CarePlan.CONDITION.hasId(conditionId))
                .returnBundle(Bundle.class).execute();

                //get completed bundle as list
                ArrayList<CarePlan> carePlanList = getCompleteBundleAsList(bundle, client, CarePlan.class);

                String fullCarePlan = "";
                for(int k=0;k<carePlanList.size();k++){




                    //System.out.println(carePlanList.get(k).getActivity());
                    //System.out.println(((CarePlan) carePlanList.get(k)).getActivity());

                    List<CarePlan.CarePlanActivityComponent> activities = ((CarePlan) carePlanList.get(k)).getActivity();


                    for(int i=0;i<activities.size();i++){
                        //System.out.println(activities.get(i).getDetail().getCode().getCoding());
                        List<Coding> carePlanCoding = activities.get(i).getDetail().getCode().getCoding();

                        //System.out.println(i);
                        //System.out.println(activities.get(i));
                        //System.out.println(activities.get(i).getDetail().getCode().getCoding());

                        HashSet<String> display = new HashSet<String>();

                        for(int j=0; j<carePlanCoding.size();j++){

                            display.add(carePlanCoding.get(j).getDisplay());
                            for (String s : display) {
                                //System.out.println(s);
                                fullCarePlan += "\n" + s;
                            }
                            //System.out.println(carePlanCoding.get(j));
                            //System.out.println(carePlanCoding.get(j).getDisplay());
                        }



                    }

                    //System.out.println(carePlanList.get(k).getAddresses());

                    //System.out.println(carePlanList.get(k).getActivity().toArray());
                }

               //System.out.print(fullCarePlan);

                return fullCarePlan;
    }



}

