package testrunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import controller.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.*;
import org.apache.commons.configuration.ConfigurationException;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRunner extends Setup {

    @Test(priority = 1, description = "Doctor SignIn")
    public void doSignIn() throws ConfigurationException {
        SignIn signIn = new SignIn(prop);
        SignInModel signInModel = new SignInModel();
        signInModel.setUserType("DOCTOR");
        signInModel.setDoctorType("MEDICAL");
        signInModel.setUsername("test1999");
        signInModel.setPassword("ek911");

        Response res = signIn.signIn(signInModel);

        String authId = res.getHeader("authId");
        System.out.println(authId);

        Utils.setEnvVar("authId", authId);

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200

    }

    @Test(priority = 2, description = "Get authInfo")
    public void authInfo() throws ConfigurationException {
        AuthInfo authInfo = new AuthInfo(prop);

        Response res = authInfo.authInfo();

        JsonPath jsonPath = res.jsonPath();

        //Extracting doctorId and orgIds in one step
        int docId = jsonPath.getInt("data.doctorId");

        //Get list from a Json response{Json Object[ArrayList{json object - particular one (key, value pair -> orgId}]}
        // -> actually return as an Array list
        List<Integer> orgIds = jsonPath.getList("data.orgInfoList.orgId");

        List<String> orgNames = jsonPath.getList("data.orgInfoList.orgName");

        //Get list from a Json response{Json Object[ArrayList]}
        List<Map<String, Object>> orgInfoList = jsonPath.getList("data.orgInfoList");

        System.out.println("Doctor ID: " + docId);
        System.out.println("Organization IDs: " + orgIds);
        System.out.println("Organization Names: " + orgNames);

        System.out.println("Org Info: " + orgInfoList);

        Utils.setEnvVar("docId", String.valueOf(docId));
        Utils.setEnvVar("orgId", String.valueOf(orgIds.get(0)));

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200

        //int orgIdsSize = orgIds.size();


//        //Creating and populating the JSON object
//        JSONObject result = new JSONObject();
//        result.put("doctorId", doctorId);
//        result.put("orgIds", orgIdsArray);
//
//        //System.out.println(res.asString());
//        System.out.println(result);
//
//        //Calling utils function to save data in json file
//        Utils.saveIntoJsonFile(result);
    }

    @Test(priority = 3, description = "Select Organization")
    public void orgSelection() {
        OrgSelection orgSelection = new OrgSelection(prop);
        Response res = orgSelection.orgSelection();

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 4, description = "Get Patient List")
    public void patientList() throws IOException {
        PatientList patientList = new PatientList(prop);

        File filepath = new File("./src/test/resources/patientList.json");
        ObjectMapper objectMapper = new ObjectMapper();

        PatientListModel patientListModel = objectMapper.readValue(filepath, PatientListModel.class);

        Response res = patientList.patientList(patientListModel);
        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 5, description = "Create New Patient")
    public void patientCreate() throws IOException {
        PatientCreate patientCreate = new PatientCreate(prop);

        File filepath = new File("./src/test/resources/patientCreate.json");
        ObjectMapper objectMapper = new ObjectMapper();

        PatientCreateModel patientCreateModel = objectMapper.readValue(filepath, PatientCreateModel.class);

        Response res = patientCreate.patientCreate(patientCreateModel);
        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 6, description = "Get Chamber Appointment Configuration Information")
    public void appointmentConfig() throws IOException {
        AppointmentConfig appointmentConfig = new AppointmentConfig(prop);
        Response res = appointmentConfig.appointmentConfig();

        System.out.println(res.asString());


        String jsonString = res.asString();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("./src/test/resources/appointmentConfig.json");
        objectMapper.writeValue(file, objectMapper.readTree(jsonString));

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 7, description = "Edit Chamber Appointment Configuration Information")
    public void editAppointmentConfig() throws IOException {
        EditAppointmentConfig editAppointmentConfig = new EditAppointmentConfig(prop);

        File filepath = new File("./src/test/resources/editAppointmentConfig.json");
        ObjectMapper objectMapper = new ObjectMapper();

        EditAppointmentConfigModel editAppointmentConfigModel = objectMapper.readValue(filepath, EditAppointmentConfigModel.class);

        Response res = editAppointmentConfig.editAppointmentConfig(editAppointmentConfigModel);
        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 9, description = "Add Schedule")
    public void addSchedule() throws IOException, ConfigurationException{
        AddSchedule addSchedule = new AddSchedule(prop);

        File filePath = new File("./src/test/resources/addSchedule.json");
        ObjectMapper objectMapper = new ObjectMapper();

        AddScheduleModel addScheduleModel = objectMapper.readValue(filePath, AddScheduleModel.class);

        Response res = addSchedule.addSchedule(addScheduleModel);

        JsonPath jsonPath = res.jsonPath();
        int scheduleId = jsonPath.getInt("data.id");
        Utils.setEnvVar("scheduleId", String.valueOf(scheduleId));

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 8, description = "Delete Schedule")
    public void delSchedule() throws IOException {
        DelSchedule delSchedule = new DelSchedule(prop);

        Response res = delSchedule.delSchedule();

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 10, description = "Add Leave")
    public void addLeave() throws IOException, ConfigurationException {
        AddLeave addLeave = new AddLeave(prop);

        File filePath = new File("./src/test/resources/addLeave.json");
        ObjectMapper objectMapper = new ObjectMapper();

        AddLeaveModel addLeaveModel = objectMapper.readValue(filePath, AddLeaveModel.class);

        Response res = addLeave.addLeave(addLeaveModel);

        JsonPath jsonPath = res.jsonPath();
        int leaveId = jsonPath.getInt("data.id");
        Utils.setEnvVar("leaveId", String.valueOf(leaveId));

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 11, description = "Delete Leave")
    public void delLeave() throws IOException {
        DelLeave delLeave = new DelLeave(prop);

        Response res = delLeave.delLeave();

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 12, description = "Check Schedule")
    public void checkSchedule() {
        CheckSchedule checkSchedule = new CheckSchedule(prop);

        Response res = checkSchedule.checkSchedule();

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 13, description = "Book Appointment")
    public void bookAppointment() throws ConfigurationException {
        BookAppointment bookAppointment = new BookAppointment(prop);
        BookAppointmentModel bookAppointmentModel = new BookAppointmentModel();
        bookAppointmentModel.setType("NEW");
        bookAppointmentModel.setDateOfBirth("13/03/2000");

        int docId = Integer.parseInt(prop.getProperty("docId"));
        bookAppointmentModel.setDoctor(new BookAppointmentModel.Doctor(docId));

        //bookAppointmentModel.getDoctor().setId(docId);

        bookAppointmentModel.setFollowUpId(null);
        bookAppointmentModel.setGender("Female");
        bookAppointmentModel.setName("Fariha Test");
        bookAppointmentModel.setPatientProfileId("P-2JNBPLBG8");
        bookAppointmentModel.setPhoneNumber("01883766247");
        bookAppointmentModel.setOrgComments(null);
        bookAppointmentModel.setSerial(1);

        String dateFormat = Utils.MondayDateFormat();
        bookAppointmentModel.setDate(dateFormat);

        bookAppointmentModel.setTime("05:42 PM");

        int date = Integer.parseInt(Utils.nextMondayDate());
        bookAppointmentModel.setAppointmentDateInt(date);

        int scheduleId = Integer.parseInt(prop.getProperty("scheduleId"));
        bookAppointmentModel.setScheduleId(scheduleId);

        bookAppointmentModel.setStatus("Pending");

        int orgId = Integer.parseInt(prop.getProperty("orgId"));
        bookAppointmentModel.setOrgId(orgId);

        bookAppointmentModel.setBloodGroup(null);

        Response res = bookAppointment.bookAppointment(bookAppointmentModel);

        JsonPath jsonPath = res.jsonPath();
        int appointmentId = jsonPath.getInt("data.id");
        Utils.setEnvVar("appointmentId", String.valueOf(appointmentId));

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 14, description = "Confirm Appointment")
    public void confirmAppointment() {
        ConfirmAppointment confirmAppointment = new ConfirmAppointment(prop);

        Response res = confirmAppointment.confirmAppointment();

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 15, description = "Cancel Appointment")
    public void cancelAppointment() {
        CancelAppointment cancelAppointment = new CancelAppointment(prop);

        Response res = cancelAppointment.cancelAppointment();

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 16, description = "Get Rx Number")
    public void getRxNumber() throws ConfigurationException {
        GetRxNumber getRxNumber = new GetRxNumber(prop);

        Response res = getRxNumber.getRxNumber();

        String rxNumber = res.asString();
        Utils.setEnvVar("rxNumber", rxNumber);

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 17, description = "Save Rx")
    public void saveRx() throws IOException {
        SaveRx saveRx = new SaveRx(prop);

        File filepath = new File("./src/test/resources/saveRx.json");
        ObjectMapper objectMapper = new ObjectMapper();

        SaveRxModel saveRxModel = objectMapper.readValue(filepath, SaveRxModel.class);
        saveRxModel.getPrescription().setRxNumber(prop.getProperty("rxNumber"));

        String nextNextMondayDate = Utils.NextNextMondayDateFormat();
        saveRxModel.getPrescription().setFollowUpDate(nextNextMondayDate);

        Response res = saveRx.saveRx(saveRxModel);

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 18, description = "Get Follow-up")
    public void getFollowUp() throws IOException {
        GetFollowUp getFollowUp = new GetFollowUp(prop);

        Response res = getFollowUp.getFollowUp();

        System.out.println(res.asString());

        String jsonString = res.asString();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("./src/test/resources/followUpInfo.json");
        objectMapper.writeValue(file, objectMapper.readTree(jsonString));

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 19, description = "Save Template")
    public void saveTemplate() throws IOException, ConfigurationException {
        SaveTemplate saveTemplate = new SaveTemplate(prop);

        /*This Part is to change response Json file of Get Follow-up to Request Body of Save Template
        * because this two json file is very similar*/
        String followUpFile = "./src/test/resources/followUpInfo.json";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> existingJson = objectMapper.readValue(new File(followUpFile), Map.class);

        Map<String, Object> transformedJson = new HashMap<>();
        transformedJson.put("prescription", existingJson); // Embed the original JSON under "prescription"
        transformedJson.put("priority", 3);
        Faker faker = new Faker();
        String templateName = faker.file().fileName();
        transformedJson.put("name", templateName);
        transformedJson.put("id", 0);

        File transformedFile = new File("./src/test/resources/saveTemplate.json");
        objectMapper.writeValue(transformedFile, transformedJson);
        /* End of Change code */

        Response res = saveTemplate.saveTemplate(transformedFile);

        JsonPath jsonPath = res.jsonPath();
        int templateId = jsonPath.getInt("id");
        Utils.setEnvVar("templateId", String.valueOf(templateId));

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 20, description = "Delete Template")
    public void delTemplate() throws IOException {
        DelTemplate delTemplate = new DelTemplate(prop);

        Response res = delTemplate.delTemplate();

        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }

    @Test(priority = 21, description = "Get Old Rx List")
    public void oldRxList() throws IOException {
        OldRxList oldRxList = new OldRxList(prop);

        File filepath = new File("./src/test/resources/oldRxList.json");
        ObjectMapper objectMapper = new ObjectMapper();

        OldRxListModel oldRxListModel = objectMapper.readValue(filepath, OldRxListModel.class);

        Response res = oldRxList.oldRxList(oldRxListModel);
        System.out.println(res.asString());

        int actualStatusCode = res.statusCode();
        System.out.println(actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);// expected status code 200
    }
}