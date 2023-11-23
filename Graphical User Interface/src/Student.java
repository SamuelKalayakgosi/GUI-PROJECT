

public class Student {
    private int ID;
    private String name;
    private String email;
    private int phone;
    private String gender;
    private String standard;

    public Student(int ID,String name, String email, int phone, String gender, String standard) {
        this.ID=ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.standard = standard;
    }
     //this method returns the ID of a student
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", gender='" + gender + '\'' +
                ", standard='" + standard + '\'' +
                '}';
    }
}

