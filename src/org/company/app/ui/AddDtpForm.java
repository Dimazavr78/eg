package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.entity.ClientEntity;
import org.company.app.data.entity.DTPEntity;
import org.company.app.data.manager.ClientEntityManager;
import org.company.app.data.manager.DtpEntityManager;
import org.company.app.util.BaseSubForm;
import org.company.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddDtpForm extends BaseSubForm<ClientTableForm> {

    private final DtpEntityManager dtpEntityManager = new DtpEntityManager(Application.getInstance().getDatabase());
    private final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    private JPanel mainPanel;
    private JTextField kordFild;
    private JTextField radiusFild;
    private JTextField timeDtpFild;
    private JTextField birthdayField;
    private JTextField SituationFild;
    private JTextField phoneField;
    private JButton backButton;
    private JButton saveButton;
    private JComboBox servis;
    private JComboBox opasngrus;
    private JTextField coloFild;

    public AddDtpForm(ClientTableForm mainForm) {
        super(mainForm);
        setContentPane(mainPanel);

        initBoxes();
        initButtons();

        setVisible(true);

        setVisible(true);
    }
    private void initBoxes()
    {
        servis.addItem("Да");
        servis.addItem("Нет");
        opasngrus.addItem("Шоссе");
        opasngrus.addItem("Улица");
        opasngrus.addItem("Просёлочная дорога");
        opasngrus.addItem("Горол");
        opasngrus.addItem("Загород");
    }

    private void initButtons() {
        backButton.addActionListener(e -> {
            closeSubForm();
        });

        saveButton.addActionListener(e -> {
            Date newDate = null;
            try {
                newDate = format.parse(timeDtpFild.getText());
            } catch (ParseException parseException) {
                parseException.printStackTrace();
                DialogUtil.showError(this, "Неверный формат даты");
                return;
            }

            try {

                DTPEntity newDtp = new DTPEntity(
                        ((String) servis.getSelectedItem()).toLowerCase().charAt(0),
                        ((String) opasngrus.getSelectedItem()).toLowerCase().charAt(0),
                        kordFild.getText(),
                        radiusFild.getText(),
                        newDate,
                        SituationFild.getText(),
                        phoneField.getText(),
                        coloFild.getText()

                );

                dtpEntityManager.addDtp(newDtp);
//                mainForm.getModel().getValues().add(newDtp);
                mainForm.getModel().fireTableDataChanged();

                closeSubForm();

            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(AddDtpForm.this, "Не удалось добавить клиента");
            }
        });
    }


    @Override
    public int getFormWidth() {
        return 400;
    }

    @Override
    public int getFormHeight() {
        return 500;
    }
}
