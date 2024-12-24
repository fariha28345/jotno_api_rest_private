package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaveRxModel {
    private Prescription prescription;

    public SaveRxModel(Prescription prescription) {
        this.prescription = prescription;
    }
    public SaveRxModel() {

    }

    @Getter
    @Setter
    public static class Prescription {
        private String rxNumber;
        private List<Complaint> complaints;
        private List<Medicine> medicines;
        private List<Diagnose> diagnoses;
        private List<Investigation> investigations;
        private List<Examination> examinations;
        private List<Advice> advices;
        private Allergy allergy;
        private SocialHabit socialHabit;
        private List<Object> followUps;
        private List<Object> referrals;
        private Patient patient;
        private VitalSign vitalSign;
        private GynecologyFindings gynecologyFindings;
        private List<Object> investigationOrderReferences;
        private boolean investigationReferenceEnabled;
        private EyeGlass eyeGlass;
        private Preference preference;
        private String visitType;
        private String profileId;
        private String followUpDate;

        public Prescription(String rxNumber, List<Complaint> complaints, List<Medicine> medicines, List<Diagnose> diagnoses, List<Investigation> investigations,
        List<Examination> examinations, List<Advice> advices, Allergy allergy, SocialHabit socialHabit, List<Object> followUps, List<Object> referrals,
        Patient patient, VitalSign vitalSign, GynecologyFindings gynecologyFindings, List<Object> investigationOrderReferences, boolean investigationReferenceEnabled,
        EyeGlass eyeGlass, Preference preference, String visitType, String profileId, String followUpDate) {
            this.rxNumber = rxNumber;
            this.complaints = complaints;
            this.medicines = medicines;
            this.diagnoses = diagnoses;
            this.investigations = investigations;
            this.examinations = examinations;
            this.advices = advices;
            this.allergy = allergy;
            this.socialHabit = socialHabit;
            this.followUps = followUps;
            this.referrals = referrals;
            this.patient = patient;
            this.vitalSign = vitalSign;
            this.gynecologyFindings = gynecologyFindings;
            this.investigationOrderReferences = investigationOrderReferences;
            this.investigationReferenceEnabled = investigationReferenceEnabled;
            this.eyeGlass = eyeGlass;
            this.preference = preference;
            this.visitType = visitType;
            this.profileId = profileId;
            this.followUpDate = followUpDate;
        }
        public Prescription() {

        }

        @Getter
        @Setter
        public static class Complaint {
            private String unit;
            private int suggestionId;
            private int originalSuggestionId;
            private String name;
            private String originalName;
            private List<Object> values;

            public Complaint(String unit, int suggestionId, int originalSuggestionId, String name, String originalName, List<Object> values) {
                this.unit = unit;
                this.suggestionId = suggestionId;
                this.originalSuggestionId = originalSuggestionId;
                this.name = name;
                this.originalName = originalName;
                this.values = values;
            }
            public Complaint() {

            }
        }

        @Getter
        @Setter
        public static class Medicine {
            private List<MedicineDose> medicineDoses;
            private int drugId;
            private String name;
            private String brandName;
            private String formation;
            private String strength;
            private String vendor;
            private String generic;
            private String count;

            public Medicine(List<MedicineDose> medicineDoses, int drugId, String name, String brandName, String formation, String strength,
                            String vendor, String generic, String count) {
                this.medicineDoses = medicineDoses;
                this.drugId = drugId;
                this.name = name;
                this.brandName = brandName;
                this.formation = formation;
                this.strength = strength;
                this.vendor = vendor;
                this.generic = generic;
                this.count = count;
            }
            public Medicine() {

            }

            @Getter
            @Setter
            public static class MedicineDose {
                private String schedules;
                private boolean continued;
                private String duration;
                private String durationUnit;
                private String remarks;
                private String unit;
                private int schedule;

                public MedicineDose(String schedules, boolean continued, String duration, String durationUnit, String remarks, String unit,
                                    int schedule) {
                    this.schedules = schedules;
                    this.continued = continued;
                    this.duration = duration;
                    this.durationUnit = durationUnit;
                    this.remarks = remarks;
                    this.unit = unit;
                    this.schedule = schedule;
                }
                public MedicineDose() {

                }
            }
        }

        @Getter
        @Setter
        public static class Diagnose {
            private int suggestionId;
            private int originalSuggestionId;
            private String name;
            private String originalName;
            private List<Object> teeth;
            private List<Object> values;
            private String  valueJSON;
            private String value;

            public Diagnose(int suggestionId, int originalSuggestionId, String name, String originalName, List<Object> teeth, List<Object> values,
                            String valueJSON, String value) {
                this.suggestionId = suggestionId;
                this.originalSuggestionId = originalSuggestionId;
                this.name = name;
                this.originalName = originalName;
                this.teeth = teeth;
                this.values = values;
                this.valueJSON = valueJSON;
                this.value = value;
            }
            public Diagnose() {

            }
        }

        @Getter
        @Setter
        public static class Investigation {
            private int investigationId;
            private String name;
            private String note;
            private int count;
            private String indexDbNote;
            private String date;
            private List<Object> teeth;
            private List<Object> values;
            private String valueJSON;
            private String value;

            public Investigation(int investigationId, String name, String note, int count, String indexDbNote, String date, List<Object> teeth,
                                 List<Object> values, String valueJSON, String value) {
                this.investigationId = investigationId;
                this.name = name;
                this.note = note;
                this.count = count;
                this.indexDbNote = indexDbNote;
                this.date = date;
                this.teeth = teeth;
                this.values= values;
                this.valueJSON = valueJSON;
                this.value = value;
            }
            public Investigation() {

            }
        }

        @Getter
        @Setter
        public static class Examination {
            private GynecologyFindings gynecologyFindings;
            private int suggestionId;
            private int originalSuggestionId;
            private String name;
            private String originalName;
            private List<Object> values;

            public Examination(GynecologyFindings gynecologyFindings, int suggestionId, int originalSuggestionId, String name, String originalName,
                               List<Object> values) {
                this.gynecologyFindings = gynecologyFindings;
                this.suggestionId = suggestionId;
                this.originalSuggestionId = originalSuggestionId;
                this.name = name;
                this.originalName = originalName;
                this.values = values;
            }
            public Examination() {

            }

            @Getter
            @Setter
            public static class GynecologyFindings {
                private MenstrualHistory menstrualHistory;
                private ObstetricsHistory obstetricsHistory;
                private PerAbdominalGyne perAbdominalGyne;
                private PerAbdominalPregnency perAbdominalPregnency;
                private PerVaginalGyne perVaginalGyne;
                private PerVaginalPregnency perVaginalPregnency;

                public GynecologyFindings(MenstrualHistory menstrualHistory, ObstetricsHistory obstetricsHistory, PerAbdominalGyne perAbdominalGyne,
                                          PerAbdominalPregnency perAbdominalPregnency, PerVaginalGyne perVaginalGyne,
                                          PerVaginalPregnency perVaginalPregnency) {
                    this.menstrualHistory = menstrualHistory;
                    this.obstetricsHistory = obstetricsHistory;
                    this.perAbdominalGyne = perAbdominalGyne;
                    this.perAbdominalPregnency = perAbdominalPregnency;
                    this.perVaginalGyne = perVaginalGyne;
                    this.perVaginalPregnency = perVaginalPregnency;
                }
                public GynecologyFindings() {

                }

                @JsonInclude(JsonInclude.Include.NON_EMPTY)
                public static class MenstrualHistory {

                }

                @Getter
                @Setter
                public static class ObstetricsHistory {
                    private String marriedUnit;
                    private String para;

                    public ObstetricsHistory(String marriedUnit, String para) {
                        this.marriedUnit = marriedUnit;
                        this.para = para;
                    }
                    public ObstetricsHistory() {

                    }
                }

                @Getter
                @Setter
                public static class PerAbdominalGyne {
                    private boolean nad;

                    public PerAbdominalGyne(boolean nad) {
                        this.nad = nad;
                    }
                    public PerAbdominalGyne() {

                    }
                }

                @Getter
                @Setter
                public static class PerAbdominalPregnency {
                    private String fundalHeightUnit;

                    public PerAbdominalPregnency(String fundalHeightUnit) {
                        this.fundalHeightUnit = fundalHeightUnit;
                    }
                    public PerAbdominalPregnency() {

                    }
                }

                @Getter
                @Setter
                public static class PerVaginalGyne {
                    private String utSizeUnitPV;

                    public PerVaginalGyne(String utSizeUnitPV) {
                        this.utSizeUnitPV = utSizeUnitPV;
                    }
                    public PerVaginalGyne() {

                    }
                }

                @JsonInclude(JsonInclude.Include.NON_EMPTY)
                public static class PerVaginalPregnency {

                }
            }
        }

        @Getter
        @Setter
        public static class Advice {
            private int suggestionId;
            private int originalSuggestionId;
            private String name;
            private String originalName;
            private String note;
            private int count;
            private String indexDbNote;
            private List<Object> teeth;
            private List<Object> values;
            private String valueJSON;
            private String value;

            public Advice(int suggestionId, int originalSuggestionId, String name, String originalName, String note, int count, String indexDbNote,
                          List<Object> teeth, List<Object> values, String valueJSON, String value) {
                this.suggestionId = suggestionId;
                this.originalSuggestionId = originalSuggestionId;
                this.name = name;
                this.originalName = originalName;
                this.note = note;
                this.count = count;
                this.indexDbNote = indexDbNote;
                this.teeth = teeth;
                this.values = values;
                this.valueJSON = valueJSON;
                this.value = value;
            }
            public Advice() {

            }
        }

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public static class Allergy {

        }

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        public static class SocialHabit {

        }

        @Getter
        @Setter
        public static class Patient {
            private Age age;
            private String name;
            private String gender;
            private String phoneNumber;
            private String bloodGroup;
            private String fatherName;
            private String motherName;
            private String address;
            private String dateOfBirth;

            public Patient(Age age, String name, String gender, String phoneNumber, String bloodGroup, String fatherName, String motherName,
                           String address, String dateOfBirth) {
                this.age = age;
                this.name = name;
                this.gender = gender;
                this.phoneNumber = phoneNumber;
                this.bloodGroup = bloodGroup;
                this.fatherName = fatherName;
                this.motherName = motherName;
                this.address = address;
                this.dateOfBirth = dateOfBirth;
            }
            public Patient() {

            }

            @Getter
            @Setter
            public static class Age {
                private int year;
                private int month;
                private int day;

                public Age(int year, int month, int day) {
                    this.year = year;
                    this.month = month;
                    this.day = day;
                }
                public Age() {

                }
            }
        }

        @Getter
        @Setter
        public static class VitalSign {
            private List<Object> lungsType;
            private String pulseUnit;
            private String temperatureUnit;
            private String heightUnit;
            private String weightUnit;
            private String peakFlowRateUnit;
            private String ofcUnit;

            public VitalSign(List<Object> lungsType, String pulseUnit, String temperatureUnit, String heightUnit, String weightUnit,
                             String peakFlowRateUnit, String ofcUnit) {
                this.lungsType = lungsType;
                this.pulseUnit = pulseUnit;
                this.temperatureUnit = temperatureUnit;
                this.heightUnit = heightUnit;
                this.weightUnit = weightUnit;
                this.peakFlowRateUnit = peakFlowRateUnit;
                this.ofcUnit = ofcUnit;
            }
            public VitalSign() {

            }
        }

        @Getter
        @Setter
        public static class GynecologyFindings {
            private Examination.GynecologyFindings.MenstrualHistory menstrualHistory;
            private Examination.GynecologyFindings.ObstetricsHistory obstetricsHistory;
            private Examination.GynecologyFindings.PerAbdominalGyne perAbdominalGyne;
            private Examination.GynecologyFindings.PerAbdominalPregnency perAbdominalPregnency;
            private Examination.GynecologyFindings.PerVaginalGyne perVaginalGyne;
            private Examination.GynecologyFindings.PerVaginalPregnency perVaginalPregnency;

            public GynecologyFindings(Examination.GynecologyFindings.MenstrualHistory menstrualHistory, Examination.GynecologyFindings.ObstetricsHistory obstetricsHistory, Examination.GynecologyFindings.PerAbdominalGyne perAbdominalGyne,
                                      Examination.GynecologyFindings.PerAbdominalPregnency perAbdominalPregnency, Examination.GynecologyFindings.PerVaginalGyne perVaginalGyne,
                                      Examination.GynecologyFindings.PerVaginalPregnency perVaginalPregnency) {
                this.menstrualHistory = menstrualHistory;
                this.obstetricsHistory = obstetricsHistory;
                this.perAbdominalGyne = perAbdominalGyne;
                this.perAbdominalPregnency = perAbdominalPregnency;
                this.perVaginalGyne = perVaginalGyne;
                this.perVaginalPregnency = perVaginalPregnency;
            }
            public GynecologyFindings() {

            }

            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            public static class MenstrualHistory {

            }

            @Getter
            @Setter
            public static class ObstetricsHistory {
                private String marriedUnit;
                private String para;

                public ObstetricsHistory(String marriedUnit, String para) {
                    this.marriedUnit = marriedUnit;
                    this.para = para;
                }
                public ObstetricsHistory() {

                }
            }

            @Getter
            @Setter
            public static class PerAbdominalGyne {
                private boolean nad;

                public PerAbdominalGyne(boolean nad) {
                    this.nad = nad;
                }
                public PerAbdominalGyne() {

                }
            }

            @Getter
            @Setter
            public static class PerAbdominalPregnency {
                private String fundalHeightUnit;

                public PerAbdominalPregnency(String fundalHeightUnit) {
                    this.fundalHeightUnit = fundalHeightUnit;
                }
                public PerAbdominalPregnency() {

                }
            }

            @Getter
            @Setter
            public static class PerVaginalGyne {
                private String utSizeUnitPV;

                public PerVaginalGyne(String utSizeUnitPV) {
                    this.utSizeUnitPV = utSizeUnitPV;
                }
                public PerVaginalGyne() {

                }
            }

            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            public static class PerVaginalPregnency {

            }
        }

        @Getter
        @Setter
        public static class EyeGlass {
            private String reCylinder;
            private String leCylinder;

            public EyeGlass(String reCylinder, String leCylinder) {
                this.reCylinder = reCylinder;
                this.leCylinder = leCylinder;
            }
            public EyeGlass() {

            }
        }

        @Getter
        @Setter
        public static class Preference {
            private String medicationPreference;
            private String language;

            public Preference(String medicationPreference, String language) {
                this.medicationPreference = medicationPreference;
                this.language = language;
            }
            public Preference() {

            }
        }
    }
}