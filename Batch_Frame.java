/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USindhFrame;

import USindhBeans.*;
import USindhDatabaseManager.DatabaseManager;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author MUKHTIARALICHANDIO
 */
public class Batch_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Batch_Frame
     */
    public Batch_Frame() {
        initComponents();
        getFaculty();
        siftComboBox.addItem("Morning");
        siftComboBox.addItem("Evening");
     
        groupdescComboBox.addItem("Engineering");
        groupdescComboBox.addItem("Medical");
        groupdescComboBox.addItem("ComputerScience");
        groupdescComboBox.addItem("General");
        groupdescComboBox.addItem("Commerce");
        
        
    }
            
    private void getFaculty(){
        
        try{
            Vector v=DatabaseManager.getFaculty();
            FacultyComboBox.removeAllItems();
            for(int i=0; i<v.size(); i++)
            FacultyComboBox.addItem(v.elementAt(i));    
        }catch(Exception e){
            e.printStackTrace();
        }
        
     }// end of getFaculty method.
    
    
     private void getDepartment(){
         
         FacultyBean bean=(FacultyBean)FacultyComboBox.getSelectedItem();
         if(bean==null)return;
         try{
            Vector v=DatabaseManager.getDepartment(bean.getFacId());
            departComboBox.removeAllItems();
            for(int i=0; i<v.size(); i++)
           departComboBox.addItem(v.elementAt(i));    
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }// end of getDepartment method.
    
     private void getProgram(){
         
         DepartmentBean bean=(DepartmentBean)departComboBox.getSelectedItem();
         if(bean==null)return;
         try{
            Vector v=DatabaseManager.getProgram(bean.getDeptId());
            ProgramsComboBox.removeAllItems();
            for(int i=0; i<v.size(); i++)
           ProgramsComboBox.addItem(v.elementAt(i));    
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }// end of getDepartment method.
     
     
    
       
     private void getDepartmentTextFields(){
        
        BatchBean bean=(BatchBean)batchYearsList.getSelectedValue();
        if(bean==null)return;
        this.batchIdTextField.setText(""+bean.getBatchId());
        this.batchyearTextField.setText(bean.getBatchYear());
        this.remarksTextArea.setText(bean.getRemarks());
        this.siftComboBox.setSelectedItem(bean.getShift());
        this.groupdescComboBox.setSelectedItem(bean.getGroupDesc());
        
    }// end of */
   
       private void getBatch(){
         
          ProgramBean bean=(ProgramBean)ProgramsComboBox.getSelectedItem();
          if(bean==null)return;
          try{
            Vector v=DatabaseManager.getBatch(bean.getProgId());
            this.batchYearsList.setListData(v);  
         }catch(Exception e){
            e.printStackTrace();
        }
         
     }// end of getBatch method.
    
    private void addBatch(){
        
       ProgramBean bean=(ProgramBean)ProgramsComboBox.getSelectedItem();
       if(bean==null)return;
       
       String batch=batchyearTextField.getText();
       String remarks=remarksTextArea.getText();
       try{
            int rows=DatabaseManager.addBatch(bean.getProgId(),batch,remarks);
           
           if(rows>=1){
                JOptionPane.showMessageDialog(this,rows+"Record Saved");
                getBatch();
             
               
            }
       }catch(Exception e){
           
       }
       
     
    }// end of addBatch method.
    
     private void updateBatch(){
     
          
        BatchBean bean=(BatchBean)batchYearsList.getSelectedValue();
        if(bean==null)return;
        String batch=batchyearTextField.getText();
        String remarks=remarksTextArea.getText();
        try{
            int rows=DatabaseManager.updateBatch(bean.getBatchId(), batch, remarks); 
            if(rows>=1){
            JOptionPane.showMessageDialog(this,rows+" Record Update");
            getBatch();
            
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        
    
         
         
    }// end of updateBatch method.
    
    
    private void deleteBatch(){
        
        BatchBean bean=(BatchBean)batchYearsList.getSelectedValue();
        if(bean==null)return;
        try{
            
            int rows=DatabaseManager.deleteBatch(bean.getBatchId()); 
            if(rows>=1){
            JOptionPane.showMessageDialog(this,rows+" Record Remove");
            getBatch();
           
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        
    
        
        
    }// end of deleteBatch method.
    

    
    
    
    private void clear(){
        this.batchIdTextField.setText("");
        this.batchyearTextField.setText("");
        this.remarksTextArea.setText("");
        
    }

     
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BatchLabel = new javax.swing.JLabel();
        facultyLabel = new javax.swing.JLabel();
        FacultyComboBox = new javax.swing.JComboBox();
        DepartmentLabel = new javax.swing.JLabel();
        departComboBox = new javax.swing.JComboBox();
        programLabel = new javax.swing.JLabel();
        ProgramsComboBox = new javax.swing.JComboBox();
        BatchIdLabel = new javax.swing.JLabel();
        batchIdTextField = new javax.swing.JTextField();
        BatchYearLabel = new javax.swing.JLabel();
        batchyearTextField = new javax.swing.JTextField();
        ShiftLabel = new javax.swing.JLabel();
        siftComboBox = new javax.swing.JComboBox<String>();
        GroupDescLabel = new javax.swing.JLabel();
        groupdescComboBox = new javax.swing.JComboBox<String>();
        RemarksLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        BackButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        batchYearsList = new javax.swing.JList<BatchBean>();
        BatchyearsLabel = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BatchLabel.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        BatchLabel.setText("Batch");

        facultyLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        facultyLabel.setText("FACULTY");

        FacultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultyComboBoxActionPerformed(evt);
            }
        });

        DepartmentLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DepartmentLabel.setText("DEPARTMENT ");

        departComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departComboBoxActionPerformed(evt);
            }
        });

        programLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        programLabel.setText("PROGRAM");

        ProgramsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgramsComboBoxActionPerformed(evt);
            }
        });

        BatchIdLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BatchIdLabel.setText("BATCH ID");

        batchIdTextField.setEnabled(false);

        BatchYearLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BatchYearLabel.setText("BATCH YEAR");

        ShiftLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ShiftLabel.setText("SHIFT");

        siftComboBox.setActionCommand("");

        GroupDescLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        GroupDescLabel.setText("GROUP_DESC");

        RemarksLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RemarksLabel.setText("REMARKS");

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        BackButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BackButton.setText("BACK");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        AddButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        UpdateButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        ClearButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ClearButton.setText("CLEAR");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        batchYearsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                batchYearsListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(batchYearsList);

        BatchyearsLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BatchyearsLabel.setText("BATCH YEARS");

        DeleteButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DeleteButton.setText("DELETE");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\MUKHTIAR ALI CHANDIO\\Documents\\NetBeansProjects\\usindhAdmissionSystem\\Images For Project\\4.BatchFrame\\stdpic1.jfif")); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\MUKHTIAR ALI CHANDIO\\Documents\\NetBeansProjects\\usindhAdmissionSystem\\Images For Project\\4.BatchFrame\\stdpic2.jpeg")); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\MUKHTIAR ALI CHANDIO\\Documents\\NetBeansProjects\\usindhAdmissionSystem\\Images For Project\\4.BatchFrame\\stdpic3.jpeg")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DepartmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(programLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BatchIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BatchYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShiftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RemarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(BatchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(FacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(departComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ProgramsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batchIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batchyearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(siftComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(GroupDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(groupdescComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(BatchyearsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(facultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(DepartmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(programLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(BatchIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(BatchYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ShiftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(RemarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(BatchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(FacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(departComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(ProgramsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(batchIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(batchyearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(siftComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GroupDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupdescComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(BatchyearsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        
        clear();
        
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void FacultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultyComboBoxActionPerformed
        
        getDepartment();
        
    }//GEN-LAST:event_FacultyComboBoxActionPerformed

    private void departComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departComboBoxActionPerformed
        
       getProgram();
        
    }//GEN-LAST:event_departComboBoxActionPerformed

    private void batchYearsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_batchYearsListValueChanged
     
      getDepartmentTextFields();
      
              
    }//GEN-LAST:event_batchYearsListValueChanged

    private void ProgramsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgramsComboBoxActionPerformed
        
        getBatch();
        
    }//GEN-LAST:event_ProgramsComboBoxActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
       addBatch();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
       
        updateBatch();
       
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
      
        deleteBatch();
        
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        hide();
    }//GEN-LAST:event_BackButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Batch_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Batch_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Batch_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Batch_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Batch_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel BatchIdLabel;
    private javax.swing.JLabel BatchLabel;
    private javax.swing.JLabel BatchYearLabel;
    private javax.swing.JLabel BatchyearsLabel;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel DepartmentLabel;
    private javax.swing.JComboBox FacultyComboBox;
    private javax.swing.JLabel GroupDescLabel;
    private javax.swing.JComboBox ProgramsComboBox;
    private javax.swing.JLabel RemarksLabel;
    private javax.swing.JLabel ShiftLabel;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JTextField batchIdTextField;
    private javax.swing.JList<BatchBean> batchYearsList;
    private javax.swing.JTextField batchyearTextField;
    private javax.swing.JComboBox departComboBox;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JComboBox<String> groupdescComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel programLabel;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JComboBox<String> siftComboBox;
    // End of variables declaration//GEN-END:variables
}
