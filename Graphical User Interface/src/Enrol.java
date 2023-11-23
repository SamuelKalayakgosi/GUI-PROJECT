public class Enrol {
    private int StudentID;
    private int classCode;

    public Enrol(int studentID, int classCode) {
        StudentID = studentID;
        this.classCode = classCode;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public int getClassCode() {
        return classCode;
    }

    public void setClassCode(int classCode) {
        this.classCode = classCode;
    }
}
