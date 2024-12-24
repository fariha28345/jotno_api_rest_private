package model;

import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.Test;

import java.util.List;

@Getter
@Setter
public class OldRxListModel {
    private int start;
    private int length;
    private List<Object> columns;
    private List<Object> order;
    private Object search;

    public OldRxListModel(int start, int length, List<Object> columns, List<Object> order, Object search) {
        this.start = start;
        this.length = length;
        this.columns = columns;
        this.order = order;
        this.search = search;
    }

    public OldRxListModel() {

    }
}
