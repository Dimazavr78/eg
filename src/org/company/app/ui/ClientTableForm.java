package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.entity.DTPEntity;
import org.company.app.data.manager.DtpEntityManager;
import org.company.app.util.BaseForm;
import org.company.app.util.CustomTableModel;
import org.company.app.util.DialogUtil;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class ClientTableForm extends BaseForm
{
    private final DtpEntityManager dtpEntityManager = new DtpEntityManager(Application.getInstance().getDatabase());

    private CustomTableModel<DTPEntity> model;

    private boolean idSort = true;
    private boolean birthdaySort = false;

    private JPanel mainPanel;
    private JTable table;
    private JButton addClientButton;
    private JButton idSortButton;
    private JButton birthdaySortButton;
    private JComboBox genderSortBox;
    private JComboBox firstCharSortBox;
    private JButton DTp_button;

    public ClientTableForm()
    {
        setContentPane(mainPanel);

        initTable();
        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        try {
            model = new CustomTableModel<>(
                DTPEntity.class,
                new String[]{
                        "ID", "status", "tip", "area", "area_radius", "time_of_detect", "Situations_weathercol", "road_quality","kordFild"
                },
                    dtpEntityManager.getAll()
            );
            table.setModel(model);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int row = table.getSelectedRow();
                if(e.getKeyCode() == KeyEvent.VK_DELETE && row != -1) {
                    if(DialogUtil.showConfirm(ClientTableForm.this, "Вы точно хотите удалить данную запись?"))
                    {
                        try {
                            dtpEntityManager.delete(model.getValues().get(row));
                            model.getValues().remove(row);
                            model.fireTableDataChanged();

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if(e.getClickCount() == 2 && row != -1) {
                    new EditClientForm(ClientTableForm.this, model.getValues().get(row), row);
                }
            }
        });
    }

    private void initButtons()
    {
        addClientButton.addActionListener(e -> {
            new AddClientForm(ClientTableForm.this);
        });
        DTp_button.addActionListener(e -> {
                new AddDtpForm(ClientTableForm.this);});

     /*   idSortButton.addActionListener(e -> {
            Collections.sort(model.getValues(), new Comparator<ClientEntity>() {
                @Override
                public int compare(ClientEntity o1, ClientEntity o2) {
                    if(idSort) {
                        return Integer.compare(o2.getId(), o1.getId());
                    } else {
                        return Integer.compare(o1.getId(), o2.getId());
                    }
                }
            });
            idSort = !idSort;
            birthdaySort = false;
            model.fireTableDataChanged();
        });*/

      /*  birthdaySortButton.addActionListener(e -> {
            Collections.sort(model.getValues(), new Comparator<ClientEntity>() {
                @Override
                public int compare(ClientEntity o1, ClientEntity o2) {
                    if(birthdaySort) {
                        return o2.getBirthday().compareTo(o1.getBirthday());
                    } else {
                        return o1.getBirthday().compareTo(o2.getBirthday());
                    }
                }
            });
            birthdaySort = !birthdaySort;
            idSort = false;
            model.fireTableDataChanged();
        });*/
    }

    private void initBoxes()
    {
        genderSortBox.addItem("Все");
        genderSortBox.addItem("Мужкой");
        genderSortBox.addItem("Женский");

        genderSortBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                updateBoxSort();
            }
        });

        firstCharSortBox.addItem("Все");
        for(int i=(int)'а'; i<=(int)'я'; i++) {
            firstCharSortBox.addItem((char)i);
        }

        firstCharSortBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                updateBoxSort();
            }
        });
    }

    private void updateBoxSort()
    {
        try {
            List<DTPEntity> allClients = dtpEntityManager.getAll();

           /* if(genderSortBox.getSelectedIndex() == 1) {
                allClients.removeIf(clientEntity -> clientEntity.getGenderCode() == 'ж');
            } else if(genderSortBox.getSelectedIndex() == 2) {
                allClients.removeIf(clientEntity -> clientEntity.getGenderCode() == 'м');
            }

            if(firstCharSortBox.getSelectedIndex() != 0) {
                char c = (char)firstCharSortBox.getSelectedItem();
                allClients.removeIf(clientEntity -> clientEntity.getFirstname().toLowerCase().charAt(0) != c);
            }*/

//            model.setValues(allClients);
            model.fireTableDataChanged();
            idSort = true;
            birthdaySort = false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int getFormWidth() {
        return 1000;
    }

    @Override
    public int getFormHeight() {
        return 600;
    }

    public CustomTableModel<DTPEntity> getModel() {
        return model;
    }
}
