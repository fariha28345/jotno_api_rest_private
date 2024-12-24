package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookAppointmentModel {
    private String type;
    private String dateOfBirth;
    private Doctor doctor;
    private String followUpId;
    private String gender;
    private String name;
    private String patientProfileId;
    private String phoneNumber;
    private String orgComments;
    private int serial;
    private String date;
    private String time;
    private int appointmentDateInt;
    private int scheduleId;
    private String status;
    private int orgId;
    private String bloodGroup;

    public BookAppointmentModel(String type, String dateOfBirth, Doctor doctor, String followUpId, String gender, String name,
                       String patientProfileId, String phoneNumber, String orgComments, int serial, String date,
                       String time, int appointmentDateInt, int scheduleId, String status, int orgId, String bloodGroup) {
        this.type = type;
        this.dateOfBirth = dateOfBirth;
        this.doctor = doctor;
        this.followUpId = followUpId;
        this.gender = gender;
        this.name = name;
        this.patientProfileId = patientProfileId;
        this.phoneNumber = phoneNumber;
        this.orgComments = orgComments;
        this.serial = serial;
        this.date = date;
        this.time = time;
        this.appointmentDateInt = appointmentDateInt;
        this.scheduleId = scheduleId;
        this.status = status;
        this.orgId = orgId;
        this.bloodGroup = bloodGroup;
    }

    public BookAppointmentModel() {

    }

    @Getter
    @Setter
    public static class Doctor {
        private int id;

        public Doctor(int id) {
            this.id = id;
        }

        public Doctor() {

        }
    }
}
