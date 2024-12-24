package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddLeaveModel {
    private String fromDate;
    private String toDate;
    private String status;
    private String comments;

    public AddLeaveModel(String fromDate, String toDate, String status, String comments) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = status;
        this.comments = comments;
    }

    public AddLeaveModel() {

    }
}
