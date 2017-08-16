package RS3.RS3Fisher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

public class GUI2 extends JFrame {
    public GUI2() {
        initComponents();
    }

    private void locationItemStateChanged(ItemEvent e) {
        String item = e.getItem().toString();
        if (item.contains("Lumbridge")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Shrimps & Anchovies",
                    "Sardines & Herrings"
            }));
        }
        else if (item.contains("Draynor village")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Shrimps & Anchovies",
                    "Sardines & Herrings"
            }));
        }
        else if (item.contains("Karamja")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Lobster",
                    "Tuna & Swordfish"
            }));
        }
    }

    private void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        location = new JComboBox();
        fish = new JComboBox();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        setTitle("Shachar's AIO Fisher");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== tabbedPane1 ========
                {

                    //======== panel1 ========
                    {

                        //======== panel2 ========
                        {
                            panel2.setBorder(new TitledBorder(null, "Location & Fish", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

                            //---- label1 ----
                            label1.setText("Location:");

                            //---- label2 ----
                            label2.setText("Fish:");

                            //---- location ----
                            location.setModel(new DefaultComboBoxModel(new String[] {
                                    "Lumbridge",
                                    "Draynor village",
                                    "Karamja"
                            }));
                            location.addItemListener(new ItemListener() {
                                @Override
                                public void itemStateChanged(ItemEvent e) {
                                    locationItemStateChanged(e);
                                }
                            });

                            //---- fish ----
                            fish.setModel(new DefaultComboBoxModel(new String[] {
                                    "Shrimps & Anchovies",
                                    "Sardines & Herrnigs"
                            }));

                            GroupLayout panel2Layout = new GroupLayout(panel2);
                            panel2.setLayout(panel2Layout);
                            panel2Layout.setHorizontalGroup(
                                    panel2Layout.createParallelGroup()
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addGroup(panel2Layout.createParallelGroup()
                                                            .addComponent(label1)
                                                            .addComponent(label2))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(fish, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(location))
                                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            panel2Layout.setVerticalGroup(
                                    panel2Layout.createParallelGroup()
                                            .addGroup(panel2Layout.createSequentialGroup()
                                                    .addGroup(panel2Layout.createParallelGroup()
                                                            .addGroup(panel2Layout.createSequentialGroup()
                                                                    .addComponent(label1)
                                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                            .addComponent(location))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(panel2Layout.createParallelGroup()
                                                            .addComponent(label2)
                                                            .addComponent(fish, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                        }

                        GroupLayout panel1Layout = new GroupLayout(panel1);
                        panel1.setLayout(panel1Layout);
                        panel1Layout.setHorizontalGroup(
                                panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(139, Short.MAX_VALUE))
                        );
                        panel1Layout.setVerticalGroup(
                                panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(111, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane1.addTab("General", panel1);
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .addComponent(tabbedPane1)
                                        .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                buttonBar.add(okButton, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JComboBox location;
    private JComboBox fish;
    private JPanel buttonBar;
    private JButton okButton;
}
