package employement.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignamtion;
    JLabel tempid;
    JDateChooser tdob;

    JButton add;
    JButton back;
    JComboBox Boxeducation;

    AddEmployee(){

        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        //NAME
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,25);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150,150,30);
        tname.setBackground(new Color(127,252,197));
        add(tname);

        //FATHER NAME
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(430,150,150,30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150,150,30);
        tfname.setBackground(new Color(127,252,197));
        add(tfname);


        //DATE OF BIRTH
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,25);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);


        //SALARY
        JLabel salary = new JLabel("Salary");
        salary.setBounds(430,200,150,30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200,150,30);
        tsalary.setBackground(new Color(127,252,197));
        add(tsalary);


        //ADDRESS
        JLabel addr = new JLabel("Address");
        addr.setBounds(50,250,150,30);
        addr.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(addr);

        taddress = new JTextField();
        taddress.setBounds(200, 250,150,30);
        taddress.setBackground(new Color(127,252,197));
        add(taddress);


        //PHONE
        JLabel phone = new JLabel("Phone");
        phone.setBounds(430,250,150,30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250,150,30);
        tphone.setBackground(new Color(127,252,197));
        add(tphone);


        //EMAIL
        JLabel email = new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300,150,30);
        temail.setBackground(new Color(127,252,197));
        add(temail);

        //EDUCATION
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        String items[] = {" ","BBA", "B.Tech", "BCA", "BA",
                "B.COM", "MBA", "MA", "MTech", "MSC", "PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(600,300,150,30);
        add(Boxeducation);


        //AADHAR
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(430,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600, 350,150,30);
        taadhar.setBackground(new Color(127,252,197));
        add(taadhar);

        //EMPLOYEE ID
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel(""+number);
        tempid.setBounds(200, 400,150,30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        //DESIGNATION
        JLabel desig = new JLabel("Designation");
        desig.setBounds(50,350,150,30);
        desig.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(desig);

        tdesignamtion = new JTextField();
        tdesignamtion.setBounds(200, 350,150,30);
        tdesignamtion.setBackground(new Color(127,252,197));
        add(tdesignamtion);

        add = new JButton("ADD");
        add.setBounds(480,550, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(280, 550, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == add){
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignamtion.getText();
            String empID = tempid.getText();

            try{
                conn c= new conn();
                String query= "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empID+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main_class();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String... args){
        new AddEmployee();
    }
}
