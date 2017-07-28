package View;

/**
 * Created by Игорь on 27.07.2017.
 */

import Control.Control;
import Model.Factory;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 * Created by Игорь on 24.07.2017.
 */
public class View {
    private Control control;
    Factory factory;
    private int id;

    public View() {
        control = new Control();
        factory = new Factory();

        try {
            control.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public class MyTableModel extends AbstractTableModel {

        public MyTableModel() {
        }

        @Override
        public int getRowCount() {
            return control.getRows();
        }

        @Override
        public int getColumnCount() {
            return 10;
        }


        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {

            String str = "";

            switch (columnIndex) {

                case 0:
                    str = control.getAllNumber(rowIndex);

                    break;
                case 1:
                    str = control.getAllNumberNote(rowIndex);
                    break;
                case 2:
                    str = control.getAllPC(rowIndex);
                    break;
                case 3:
                    str = control.getAllUser(rowIndex);
                    break;
                case 4:
                    str = control.getAllBuilding(rowIndex);
                    break;
                case 5:
                    str = control.getAllRoom(rowIndex);
                    break;
                case 6:
                    str = control.getAllSoftware(rowIndex);
                    break;
                case 7:
                    str = control.getAllStatus(rowIndex);
                    break;
                case 8:
                    str = control.getAllDate(rowIndex);
                    break;
                case 9:
                    str = control.getAllExecutor(rowIndex);
                    break;
                default:
                    str = "other";

            }
            return str;
        }
    }


    public void makeGUI() {

        JFrame jFrame = new JFrame("SoftwareList");
        jFrame.setSize(1000, 600);
        jFrame.setLayout(new FlowLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] strings = {"№", "№ служебной записки", "Имя компьютера", "Пользователь", "Корпус", "Комната", "Программный продукт", "Статус", "Дата", "Исполнитель"};

        JButton createButton = new JButton("Создание");
        JButton editButton = new JButton("Редактировать");
        JButton refreshButton = new JButton("Обновить");
        JButton saveButton = new JButton("Сохранить");


        MyTableModel myTableModel = new MyTableModel();
        JTable jTable = new JTable(myTableModel);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jTable.setPreferredScrollableViewportSize(new Dimension(250, 100));
        myTableModel.fireTableDataChanged();


        jFrame.add(createButton);
        jFrame.add(editButton);
        jFrame.add(refreshButton);
        jFrame.add(saveButton);
        jFrame.add(jTable);
        jFrame.getContentPane().add(jScrollPane);


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFrame();
                id++;
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editFrame(jTable.getSelectedRow());
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myTableModel.fireTableDataChanged();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.save();
            }
        });


        jFrame.setVisible(true);
    }

    public void createFrame() {

        String[] strings = {"Установлено", "Переустановлено", "Удалено"};
        JFrame createFrame = new JFrame("Создание");
        createFrame.setSize(400, 400);
        createFrame.setLayout(new GridLayout(15, 1));
        createFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JLabel numberNoteLabel = new JLabel("№ служебной записки");
        JTextField numberNoteTextField = new JTextField(15);


        JLabel namePCLabel = new JLabel("Имя компьютера");
        JTextField namePCTextField = new JTextField(20);

        JLabel userLabel = new JLabel("Имя пользователя");
        JTextField firstNameTextField = new JTextField(15);

        JLabel lastNameLabel = new JLabel("Фамилия пользователя");
        JTextField lastNameTextField = new JTextField(20);


        JLabel buildingLabel = new JLabel("Корпус");
        JTextField buildingTextField = new JTextField(28);

        JLabel roomLabel = new JLabel("Комната");
        JTextField roomTextField = new JTextField(20);


        JLabel nameSoftLabel = new JLabel("Программный продукт");
        JTextField nameSoftTextField = new JTextField(20);


        JLabel statusLabel = new JLabel("Статус");
        JComboBox box = new JComboBox(strings);


        JLabel dateLabel = new JLabel("Дата");
        JTextField dateTextField = new JTextField(25);


        JLabel executorLabel = new JLabel("Исполнитель");
        JTextField executorTextField = new JTextField(15);

        JButton jButton = new JButton("Создать");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pcText = namePCTextField.getText();
                String fisrtNameUser = firstNameTextField.getText();
                String lastNameUser = lastNameTextField.getText();
                String executorText = executorTextField.getText();
                String noteText = numberNoteTextField.getText();
                String buildingText = buildingTextField.getText();
                String roomText = roomTextField.getText();
                String softText = nameSoftTextField.getText();
                String statusText = (String) box.getSelectedItem();
                String date = dateTextField.getText();
                String number = "";


                control.addPC(pcText);
                control.addExecutor(executorText, noteText);
                control.addUser(fisrtNameUser, lastNameUser, number);
                control.addBuilding(buildingText);
                control.addRoom(roomText);
                control.addSoftware(softText, statusText, date);

            }
        });


        createFrame.add(numberNoteLabel);
        createFrame.add(numberNoteTextField);
        createFrame.add(namePCLabel);
        createFrame.add(namePCTextField);
        createFrame.add(userLabel);
        createFrame.add(firstNameTextField);
        createFrame.add(lastNameLabel);
        createFrame.add(lastNameTextField);
        createFrame.add(buildingLabel);
        createFrame.add(buildingTextField);
        createFrame.add(roomLabel);
        createFrame.add(roomTextField);
        createFrame.add(nameSoftLabel);
        createFrame.add(nameSoftTextField);
        createFrame.add(statusLabel);
        createFrame.add(box);
        createFrame.add(dateLabel);
        createFrame.add(dateTextField);
        createFrame.add(executorLabel);
        createFrame.add(executorTextField);
        createFrame.add(jButton);


        createFrame.setVisible(true);


    }


    public void editFrame(int count) {

        String[] strings = {"Установлено", "Переустановлено", "Удалено"};

        JFrame createFrame = new JFrame("Редактирование");
        createFrame.setSize(400, 400);
        createFrame.setLayout(new GridLayout(15, 1));
        createFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JLabel numberLabel = new JLabel("Порядковый номер");
        JTextField numberTextField = new JTextField(15);
        numberTextField.setText(control.getAllNumber(count));


        JLabel numberNoteLabel = new JLabel("№ служебной записки");
        JTextField numberNoteTextField = new JTextField(15);
        numberNoteTextField.setText(control.getAllNumberNote(count));

        JLabel namePCLabel = new JLabel("Имя компьютера");
        JTextField namePCTextField = new JTextField(20);
        namePCTextField.setText(control.getAllPC(count));

        JLabel userLabel = new JLabel("Имя пользователя");
        JTextField firstNameTextField = new JTextField(25);
        firstNameTextField.setText(control.getFirstNameUser(count));

        JLabel lastNameLabel = new JLabel("Фамилия пользователя");
        JTextField lastNameTextField = new JTextField(15);
        lastNameTextField.setText(control.getLastNameUser(count));


        JLabel buildingLabel = new JLabel("Корпус");
        JTextField buildingTextField = new JTextField(27);
        buildingTextField.setText(control.getAllBuilding(count));

        JLabel roomLabel = new JLabel("Комната");
        JTextField roomTextField = new JTextField(20);
        roomTextField.setText(control.getAllRoom(count));


        JLabel nameSoftLabel = new JLabel("Программный продукт");
        JTextField nameSoftTextField = new JTextField(20);
        nameSoftTextField.setText(control.getAllSoftware(count));


        JLabel statusLabel = new JLabel("Статус");
        JComboBox box = new JComboBox(strings);
        box.setActionCommand(control.getAllStatus(count));


        JLabel dateLabel = new JLabel("Дата");
        JTextField dateTextField = new JTextField(25);
        dateTextField.setText(control.getAllDate(count));


        JLabel executorLabel = new JLabel("Исполнитель");
        JTextField executorTextField = new JTextField(15);
        executorTextField.setText(control.getAllExecutor(count));

        JButton jButton = new JButton("Редактировать");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pcText = namePCTextField.getText();
                String fisrtNameUser = firstNameTextField.getText();
                String lastNameUser = lastNameTextField.getText();
                String executorText = executorTextField.getText();
                String noteText = numberNoteTextField.getText();
                String buildingText = buildingTextField.getText();
                String roomText = roomTextField.getText();
                String softText = nameSoftTextField.getText();
                String statusText = (String) box.getSelectedItem();
                String dateText = dateTextField.getText();
                String number = "";

                control.setPC(pcText, count);
                control.setExecutor(executorText, noteText, count);
                control.setUser(fisrtNameUser, lastNameUser, number, count);
                control.setBuilding(buildingText, count);
                control.setRoom(roomText, count);
                control.setSoftware(softText, statusText, dateText, count);

            }
        });


        createFrame.add(numberLabel);
        createFrame.add(numberTextField);
        createFrame.add(numberNoteLabel);
        createFrame.add(numberNoteTextField);
        createFrame.add(namePCLabel);
        createFrame.add(namePCTextField);
        createFrame.add(userLabel);
        createFrame.add(firstNameTextField);
        createFrame.add(lastNameLabel);
        createFrame.add(lastNameTextField);
        createFrame.add(buildingLabel);
        createFrame.add(buildingTextField);
        createFrame.add(roomLabel);
        createFrame.add(roomTextField);
        createFrame.add(nameSoftLabel);
        createFrame.add(nameSoftTextField);
        createFrame.add(statusLabel);
        createFrame.add(box);
        createFrame.add(dateLabel);
        createFrame.add(dateTextField);
        createFrame.add(executorLabel);
        createFrame.add(executorTextField);
        createFrame.add(jButton);


        createFrame.setVisible(true);


    }


}

