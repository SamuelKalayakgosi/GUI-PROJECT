import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registar {
    private JPanel panel1;
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextArea textArea1;
    private JButton registerButton;
    private JButton enrolButton;
    private JButton listStudentsButton;
    private JLabel label1;
    private JLabel lName;
    private JLabel lEmail;
    private JLabel lPhone;
    private JLabel lGender;
    private JLabel lStanfard;

    public registar(){
        JFrame frame = new JFrame("primary school");
        frame.setSize(500,500);
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(true);

        Main main= new Main();

        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int ID=Integer.parseInt(textField1.getText());
                String name= textField2.getText();
                String email= textField3.getText();
                int phone=Integer.parseInt(textField4.getText());
                String gender=textField5.getText();
                String standard= textField6.getText();

                Student student= new Student(ID,name,email,phone,gender,standard);

                int i = main.registerUser(student);
                if(i > 0) {
                    JOptionPane.showMessageDialog(null,"student registered successfully");

                } else {
                JOptionPane.showMessageDialog(null,"registration unsuccessful");
                }
            }
        });
        enrolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ID=Integer.parseInt(textField1.getText());
                int classCode=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter classCode"));
                Enrol enrol= new Enrol(ID,classCode);
                int I= main.Enrol(enrol);

                if(I>0) {
                    JOptionPane.showMessageDialog(null,"student enrolled successfully");

                }
                else {
                    JOptionPane.showMessageDialog(null,"Enrollment unsuccessful");
                }

            }
        });
        listStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int classCode=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter classCode to List students"));
                textArea1.setText(main.listStudent(classCode));
            }
        });

    }
}
