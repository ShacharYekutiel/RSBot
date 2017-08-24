/*
 * Created by JFormDesigner on Wed Aug 16 21:23:54 IDT 2017
 */

package OSRS.FIsher;

import OSRS.FIsher.Utils.Variables;
import com.sun.deploy.util.ArrayUtil;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;

/**
 * @author shachar yekutiel
 */
class GUI extends JFrame {
    public GUI() {
        initComponents();
    }

    private void locationItemStateChanged(ItemEvent e) {
        String item = e.getItem().toString();
        if (item.contains("Lumbridge Swamp")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Shrimps & Anchovies",
                    "Sardines & Herrnigs",
            }));
        }
        else if (item.contains("Draynor village")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Shrimps & Anchovies",
                    "Sardines & Herrnigs"
            }));
        }
        else if (item.contains("Al-Kharid")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Shrimps & Anchovies",
                    "Sardines & Herrnigs"
            }));
        }
        else if (item.contains("Catherby")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Shrimps & Anchovies",
                    "Sardines & Herrnigs",
                    "Lobsters",
                    "Tunas & Swordfishes",
                    "Mackerels, Cods & Brass",
                    "Sharks"
            }));
        }
        else if (item.contains("Karamja")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Lobsters",
                    "Tunas & Swordfishes",
            }));
        }
        else if (item.contains("Fishing Guild")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Trouts & Salmons",
                    "Rainbow fishes",
                    "Pikes",
                    "Angler fishes",
                    "Lobsters",
                    "Tunas & Swordfishes",
                    "Mackerels, Cods & Brass",
                    "Sharks"
            }));
        }
        else if (item.contains("Barbarian village")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Trouts & Salmons",
                    "Rainbow fishes",
                    "Pikes",
                    "Angler fishes"
            }));
        }
        else if (item.contains("Shilo village")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Trouts & Salmons",
                    "Rainbow fishes",
                    "Pikes",
                    "Angler fishes"
            }));
        }
        if (item.contains("Entrana")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Shrimps & Anchovies",
                    "Sardines & Herrnigs",
                    "Trout & Salmons",
                    "Rainbow fishes",
                    "Pikes",
                    "Angler fishes"
            }));
        }
        if (item.contains("Picatoris Fishing Colony")) {
            fish.setModel(new DefaultComboBoxModel(new String[] {
                    "Tunas & Swordfishes",
                    "Monkfishes"
            }));
        }

    }

    private void startActionPerformed(ActionEvent e) {
        Variables.powerFishing = powerfishing.isSelected();
        if (location.getSelectedItem() == "Lumbridge Swamp") {
            Variables.setLocation(Variables.Lumbridge_Swamp, Variables.Lumbridge_Castle, Variables.Lumbridge_Swamp_To_Castle);
            Variables.setSpot(Variables.Lumbridge_Spot, Variables.Small_Net_ID);
            if (fish.getSelectedItem() == "Shrimps & Anchovies") {
                Variables.addFish(Variables.Shrimp_ID);
                Variables.addFish(Variables.Anchovie_ID);
            }
            else if (fish.getSelectedItem() == "Sardines & Herrnigs") {
                Variables.addFish(Variables.Sardine_ID);
                Variables.addFish(Variables.Herring_ID);
            }
        }
        else if (location.getSelectedItem() == "Draynor village") {
            Variables.setLocation(Variables.Draynor, Variables.Draynor_Village, Variables.Draynor_To_Bank);
            Variables.setSpot(Variables.Draynor_Spot, Variables.Small_Net_ID);
            if (fish.getSelectedItem() == "Shrimps & Anchovies") {
                Variables.addFish(Variables.Shrimp_ID);
                Variables.addFish(Variables.Anchovie_ID);
            }
            else if (fish.getSelectedItem() == "Sardines & Herrnigs") {
                Variables.addFish(Variables.Sardine_ID);
                Variables.addFish(Variables.Herring_ID);
            }
        }
        else if (location.getSelectedItem() == "Al-Kharid") {
            if (fish.getSelectedItem() == "Shrimps & Anchovies") {
                Variables.addFish(Variables.Shrimp_ID);
                Variables.addFish(Variables.Anchovie_ID);
            }
            else if (fish.getSelectedItem() == "Sardines & Herrnigs") {
                Variables.addFish(Variables.Sardine_ID);
                Variables.addFish(Variables.Herring_ID);
            }
        }
        else if (location.getSelectedItem() == "Entrana") {
            if (fish.getSelectedItem() == "Shrimps & Anchovies") {
                Variables.addFish(Variables.Shrimp_ID);
                Variables.addFish(Variables.Anchovie_ID);
            }
            else if (fish.getSelectedItem() == "Sardines & Herrnigs") {
                Variables.addFish(Variables.Sardine_ID);
                Variables.addFish(Variables.Herring_ID);
            }

        }
        else if (location.getSelectedItem() == "Catherby") {
            if (fish.getSelectedItem() == "Shrimps & Anchovies") {
                Variables.addFish(Variables.Shrimp_ID);
                Variables.addFish(Variables.Anchovie_ID);
            }
            else if (fish.getSelectedItem() == "Sardines & Herrnigs") {
                Variables.addFish(Variables.Sardine_ID);
                Variables.addFish(Variables.Herring_ID);
            }
        }
        else if (location.getSelectedItem() == "Barbarian village")
        {
            Variables.setLocation(Variables.BarbarianVillage, Variables.Edge_Bank, Variables.BarbarianVillage_To_EdgeBank);
            if (fish.getSelectedItem() == "Trouts & Salmons") {
                Variables.addFish(Variables.Trout_ID);
                Variables.addFish(Variables.Salmon_ID);
                Variables.setSpot(Variables.BarbarianVillage_Spot, Variables.Fly_Fishing_Rod);
            }
            else if (fish.getSelectedItem() == "Pikes") {
                Variables.addFish(Variables.Pike_ID);
                Variables.setSpot(Variables.BarbarianVillage_Spot, Variables.Fishing_Rod_ID);
            }
        }
            setVisible(false);
        Fisher.guiWait = false;
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
        panel3 = new JPanel();
        banking = new JRadioButton();
        powerfishing = new JRadioButton();
        buttonBar = new JPanel();
        start = new JButton();

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
                                    "Lumbridge Swamp",
                                    "Draynor village",
                                    "Al-Kharid",
                                    "Catherby",
                                    "Brimheaven",
                                    "Karamja",
                                    "Fishing Guild",
                                    "Barbarian village",
                                    "Shilo village",
                                    "Mudkeeper point",
                                    "Entrana",
                                    "Picatoris Fishing Colony"
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
                                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(panel2Layout.createSequentialGroup()
                                                                    .addComponent(label1)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(location, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(panel2Layout.createSequentialGroup()
                                                                    .addComponent(label2)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(fish, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
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

                        //======== panel3 ========
                        {
                            panel3.setBorder(new TitledBorder(null, "Fishing Method", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

                            //---- banking ----
                            banking.setText("Banking");
                            banking.setSelected(true);

                            //---- radioButton2 ----
                            powerfishing.setText("Powerfishing");

                            GroupLayout panel3Layout = new GroupLayout(panel3);
                            panel3.setLayout(panel3Layout);
                            panel3Layout.setHorizontalGroup(
                                    panel3Layout.createParallelGroup()
                                            .addGroup(panel3Layout.createSequentialGroup()
                                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(banking, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(powerfishing, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(14, 14, 14))
                            );
                            panel3Layout.setVerticalGroup(
                                    panel3Layout.createParallelGroup()
                                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(powerfishing)
                                                    .addComponent(banking))
                            );
                        }

                        GroupLayout panel1Layout = new GroupLayout(panel1);
                        panel1.setLayout(panel1Layout);
                        panel1Layout.setHorizontalGroup(
                                panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(panel1Layout.createParallelGroup()
                                                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(9, Short.MAX_VALUE))
                        );
                        panel1Layout.setVerticalGroup(
                                panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane1.addTab("General", panel1);
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 3, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
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

                //---- start ----
                start.setText("OK");
                start.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startActionPerformed(e);
                    }
                });
                buttonBar.add(start, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(banking);
        buttonGroup1.add(powerfishing);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - shachar yekutiel
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JComboBox location;
    private JComboBox fish;
    private JPanel panel3;
    private JRadioButton banking;
    private JRadioButton powerfishing;
    private JPanel buttonBar;
    private JButton start;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
