package employement.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    JButton delete, back;

    Choice choiceEMPID;

    RemoveEmployee(){

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,45,100,30);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        add(choiceEMPID);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEMPID.add(resultSet.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,100,100,30);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,100,30);
        add(textName);

        // phone
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        labelphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelphone);

        JLabel textphone = new JLabel();
        textphone.setBounds(200,150,100,30);
        add(textphone);

        //
        JLabel labelemail = new JLabel("email");
        labelemail.setBounds(50,200,100,30);
        labelemail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(labelemail);

        JLabel textemail = new JLabel();
        textemail.setBounds(200,200,100,30);
        add(textemail);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'");
            while(resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textphone.setText(resultSet.getString("phone"));
                textemail.setText(resultSet.getString("email"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where empId = '"+choiceEMPID.getSelectedItem()+"'");
                    while(resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textphone.setText(resultSet.getString("phone"));
                        textemail.setText(resultSet.getString("email"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("delete");
        delete.setBounds(50,270,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("back");
        back.setBounds(200,270,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i12 = i11.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel image = new JLabel(i13);
        image.setBounds(0,0,1120,630);
        add(image);

        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == delete){
            try{
                conn c = new conn();
                String query = "delete from employee where empId = '"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"employee details deleted successfully");
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
        new RemoveEmployee();
    }
}
