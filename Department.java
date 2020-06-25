public enum Department {
    ComputerScience("資訊科學系"),
    Chemistry("化學系"),
    Physics("物理系"),
    Mathematics("數學系"),
    ALL("共同選修");
    private Department(String dString) {
        this.departmentStr = dString;
    }
    private String departmentStr;
    public String getDepartment() {
        return departmentStr;
    }
}