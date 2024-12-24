package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddScheduleModel {
    private String day;
    private String type;
    private int endTime;
    private int startTime;

    public AddScheduleModel(String day, String type, int endTime, int startTime) {
        this.day = day;
        this.type = type;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public AddScheduleModel() {

    }
}
