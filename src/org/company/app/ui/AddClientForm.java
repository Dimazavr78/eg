package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.entity.ClientEntity;
import org.company.app.data.manager.ClientEntityManager;
import org.company.app.util.BaseSubForm;
import org.company.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddClientForm extends BaseSubForm<ClientTableForm>
{
    private final ClientEntityManager clientEntityManager = new ClientEntityManager(Application.getInstance().getDatabase());
    private final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    private JPanel mainPanel;
    private JTextField firstnameField;
    private JTextField surnameField;
    private JTextField patronymicField;
    private JTextField birthdayField;
    private JTextField emailField;
    private JTextField phoneField;
    private JButton backButton;
    private JButton saveButton;
    private JComboBox pricep;
    private JComboBox opasngrus;

    public AddClientForm(ClientTableForm mainForm)
    {
        super(mainForm);
        setContentPane(mainPanel);

        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initBoxes()
    {
        pricep.addItem("Да");
        pricep.addItem("Нет");
        opasngrus.addItem("Да");
        opasngrus.addItem("Нет");
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            closeSubForm();
        });

        saveButton.addActionListener(e -> {
            Date newDate = null;
            try {
                newDate = format.parse(birthdayField.getText());
            } catch (ParseException parseException) {
                parseException.printStackTrace();
                DialogUtil.showError(this, "Неверный формат даты");
                return;
            }

            try {

                ClientEntity newClient = new ClientEntity(
                        firstnameField.getText(),
                        surnameField.getText(),
                        patronymicField.getText(),
                        newDate,
                        emailField.getText(),
                        phoneField.getText(),
                        ((String) pricep.getSelectedItem()).toLowerCase().charAt(0),
                        ((String) opasngrus.getSelectedItem()).toLowerCase().charAt(0)

                );

                clientEntityManager.addCar(newClient);
//                mainForm.getModel().getValues().add(newClient);
                mainForm.getModel().fireTableDataChanged();

                closeSubForm();

            } catch (SQLException ex) {
                ex.printStackTrace();
                DialogUtil.showError(AddClientForm.this, "Не удалось добавить клиента");
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
