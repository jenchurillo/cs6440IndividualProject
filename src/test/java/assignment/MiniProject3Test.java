package assignment;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IClientInterceptor;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.gclient.IClientExecutable;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hl7.fhir.instance.model.api.IBaseBundle;


/**
 * Unit test for simple Connection.
 */
public class MiniProject3Test extends TestCase {


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    // public SimpleReadTest(String testName) {
    //     super(testName);
    //}

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MiniProject3Test.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testMiniProject3() {
        String serverBase ="http://hapi.fhir.org/baseDstu3";
        MiniProject3 reader = new MiniProject3(serverBase);

        //reader.getOsteoarthritisBundle();
        //reader.getCondition("1899027");
        reader.getCarePlan("1899027","1899030");
        //reader.getConditionId("1899027");



        //do something with the reader to make sure it works...
        //String patientID = "1";//find a good patient
        //String expected_name = "";
        //String actual_name = reader.getNameByPatientID(patientID);
        //assertEquals(expected_name, actual_name);


//        List<String> list = reader.getIDByPatientName("");
//        for (String id : list){
//            System.out.println(id);
//        }
    }

//    public void testPatientList(){
//       String serverBase = "http://hapi.fhir.org/baseDstu3";
//       patientList reader = new patientList(serverBase);
//       reader.getPatientBundle();
//    }

//    public void testCheckLogin(){
//        String serverBase = "http://hapi.fhir.org/baseDstu3";
//        checkLogin reader = new checkLogin();
//        reader.isValidUserLogin("HeLLO1899027", "1899027");
//
//    }





}