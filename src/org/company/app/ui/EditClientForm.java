package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.entity.ClientEntity;
import org.company.app.data.entity.DTPEntity;
import org.company.app.data.manager.ClientEntityManager;
import org.company.app.data.manager.DtpEntityManager;
import org.company.app.util.BaseSubForm;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class EditClientForm extends BaseSubForm<ClientTableForm>
{
    private final DtpEntityManager dtpEntityManager = new DtpEntityManager(Application.getInstance().getDatabase());
    private final SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    private DTPEntity clientEntity;
    private int rowIndex;

    private JPanel mainPanel;
    private JTextField idField;
    private JTextField kordFild;
    private JTextField radiusFild;
    private JTextField timeDtpFild;
    private JTextField coloFild;
    private JTextField phoneField;
    private JTextField SituationFild;
    private JComboBox servis;
    private JButton cancelButton;
    private JButton saveButton;

    public EditClientForm(ClientTableForm mainForm, DTPEntity clientEntity, int rowIndex)
    {
        super(mainForm);
        this.clientEntity = clientEntity;
        this.rowIndex = rowIndex;

        setContentPane(mainPanel);

        initFields();
        initButtons();

        setVisible(true);
    }

    private void initFields()
    {
        idField.setEditable(false);
        idField.setText(String.valueOf(clientEntity.getId()));
        kordFild.setText(clientEntity.getArea());
        radiusFild.setText(clientEntity.getArea_radius());
        timeDtpFild.setText(format.format(clientEntity.getTime_of_detect()));
        SituationFild.setText(clientEntity.getSituations_weathercol());
        phoneField.setText(clientEntity.getRoad_quality());
        coloFild.setText(clientEntity.getKordFild());

        servis.addItem("Да");
        servis.addItem("Нет");
        if(clientEntity.status() == 'д') {
            servis.setSelectedIndex(0);
        } else if(clientEntity.status() == 'н') {
            servis.setSelectedIndex(1);
        }
    }

    private void initButtons()
    {
        cancelButton.addActionListener(e -> closeSubForm());

        saveButton.addActionListener(e -> {
            //тут нужно делать проверки на корректность полей
            try {
                clientEntity.setArea(kordFild.getText());
                clientEntity.setArea_radius(radiusFild.getText());
                clientEntity.setSituations_weathercol(SituationFild.getText());
                clientEntity.setTime_of_detect(format.parse(timeDtpFild.getText()));
                clientEntity.setRoad_quality(phoneField.getText());
                clientEntity.setKordFild(coloFild.getText());
                clientEntity.setStatus(((String) servis.getSelectedItem()).toLowerCase().charAt(0));

                dtpEntityManager.update(clientEntity);
                mainForm.getModel().getValues().set(rowIndex, clientEntity);
                mainForm.getModel().fireTableDataChanged();
                closeSubForm();
            } catch (Exception ex) {
                ex.printStackTrace();
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
