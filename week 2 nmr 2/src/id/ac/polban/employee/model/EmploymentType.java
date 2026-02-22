package id.ac.polban.employee.model;

public class EmploymentType {
    private String typeName;

    public EmploymentType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
