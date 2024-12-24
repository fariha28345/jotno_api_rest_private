package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Properties;

@Getter
@Setter
public class PatientCreateModel {
    private PatientBasicInfo patientBasicInfo;
    private LatestVitalSign latestVitalSign;
    private List<Object> emergencyContactList;
    private PresentAddress presentAddress;

    public PatientCreateModel(PatientBasicInfo patientBasicInfo, LatestVitalSign latestVitalSign, List<Object> emergencyContactList, PresentAddress presentAddress) {
        this.patientBasicInfo = patientBasicInfo;
        this.latestVitalSign = latestVitalSign;
        this.emergencyContactList = emergencyContactList;
        this.presentAddress = presentAddress;
    }

    public PatientCreateModel() {

    }

    @Getter
    @Setter
    public static class PatientBasicInfo {
        private String gender;
        private String name;
        private String phoneNumber;
        private int occupationId;
        private String dateOfBirth;
        private String bloodGroup;
        private String demography;
        private String email;
        private String fatherName;
        private String motherName;
        private String spouseName;
        private String doctorGivenPatientId;

        public PatientBasicInfo(String gender, String name, String phoneNumber, int occupationId, String dateOfBirth, String bloodGroup,
                                String demography, String email, String fatherName, String motherName, String spouseName, String doctorGivenPatientId) {
            this.gender = gender;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.occupationId = occupationId;
            this.dateOfBirth = dateOfBirth;
            this.bloodGroup = bloodGroup;
            this.demography = demography;
            this.email = email;
            this.fatherName = fatherName;
            this.motherName = motherName;
            this.spouseName = spouseName;
            this.doctorGivenPatientId = doctorGivenPatientId;
        }

        public PatientBasicInfo() {

        }
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public static class LatestVitalSign {

    }

    @Getter
    @Setter
    public static class PresentAddress {
        private String address;

        public PresentAddress(String address) {
            this.address = address;
        }

        public PresentAddress() {

        }
    }

}
