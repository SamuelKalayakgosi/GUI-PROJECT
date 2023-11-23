import javax.swing.*;
import java.sql.*;

public class Main {
    /**Database variables hold data that you pass or retrieve from database tables **/
    private Connection connection;
    PreparedStatement pstm;

    public Main(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
            JOptionPane.showMessageDialog(null,"Database connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Method that registers a student via
     * */
    public int registerUser(Student student){
        int i = -1;
        try{

            pstm=connection.prepareStatement("insert into student(ID, name, email, phone, gender, standard) values(?,?,?,?,?,?)");
            pstm.setInt(1,student.getID());
            pstm.setString(2,student.getName());
            pstm.setString(3,student.getEmail());
            pstm.setInt(4,student.getPhone());
            pstm.setString(5,student.getGender());
            pstm.setString(6,student.getStandard());
            i= pstm.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        finally {
            return i;
        }
    }

    public String listStudent(int classCode)
    {  String list = new String();
        try{
            pstm=connection.prepareStatement("select * from classenrollment,student where classenrollment.studentID=student.ID and classenrollment.classCode = ?");
            pstm.setInt(1,classCode);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                Student student = new Student(rs.getInt("ID"),rs.getString("name"), rs.getString("email"),
                        rs.getInt("phone"),rs.getString("gender"), rs.getString("standard"));
                list = list +student.toString()+"\n";
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        finally{
            return list;
        }

    }
    public int Enrol(Enrol enrol){
        int I= -1;
        try{
            pstm=connection.prepareStatement("insert into classenrollment(studentID, classCode) values(?,?)");
            pstm.setInt(1,enrol.getStudentID());
            pstm.setInt(2,enrol.getClassCode());
            I=pstm.executeUpdate();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        finally {
            return I;
        }

    }
    }



