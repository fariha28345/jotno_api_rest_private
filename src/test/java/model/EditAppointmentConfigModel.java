package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditAppointmentConfigModel {
    private String appointmentMethod;
    private int timePerPatient;
    private String appointmentRequestType;
    private boolean waitingListEnabled;
    private int waitingListSize;
    private String phoneNumber;
    private String extension;
    private String instruction;
    private String status;
    private boolean visibleInApp;

    public EditAppointmentConfigModel(String appointmentMethod, int timePerPatient, String appointmentRequestType, boolean waitingListEnabled,
    int waitingListSize, String phoneNumber, String extension, String instruction, String status, boolean visibleInApp) {
        this.appointmentMethod = appointmentMethod;
        this.timePerPatient = timePerPatient;
        this.appointmentRequestType = appointmentRequestType;
        this.waitingListEnabled = waitingListEnabled;
        this.waitingListSize = waitingListSize;
        this.phoneNumber = phoneNumber;
        this.extension = extension;
        this.instruction = instruction;
        this.status = status;
        this.visibleInApp = visibleInApp;
    }

    public EditAppointmentConfigModel() {

    }
}
