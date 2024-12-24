package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientListModel {
    private int start;
    private int length;
    private List<Column> columns;
    private List<Object> order;
    private Search search;

    public PatientListModel(int start, int length, List<Column> columns, List<Object> order, Search search) {
        this.start = start;
        this.length = length;
        this.columns = columns;
        this.order = order;
        this.search = search;
    }

    public PatientListModel() {

    }

    @Getter
    @Setter
    public static class Column {
        private String name;
        private Search search;

        public Column(String name, Search search) {
            this.name = name;
            this.search = search;
        }

        public Column() {

        }
    }

    @Getter
    @Setter
    public static class Search {
        private String value;
        private boolean regex;

        public Search(String value, boolean regex) {
            this.value = value;
            this.regex = regex;
        }

        public Search() {

        }
    }
}
