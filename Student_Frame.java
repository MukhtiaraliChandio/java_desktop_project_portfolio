/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USindhFrame;

import USindhBeans.BatchBean;
import USindhBeans.DepartmentBean;
import USindhBeans.FacultyBean;
import USindhBeans.ProgramBean;
import USindhBeans.StudentBean;
import USindhDatabaseManager.DatabaseManager;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author MUKHTIARALICHANDIO
 */
public class Student_Frame extends javax.swing.JFrame {

    /**
     * Creates new form Student_Frame
     */
    public Student_Frame() {
        initComponents();
        getFaculty();
        
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
            programComboBox.removeAllItems();
            for(int i=0; i<v.size(); i++)
            programComboBox.addItem(v.elementAt(i));    
        }catch(Exception e){
            e.printStackTrace();
        }
         
     }// end of getProgram method.
    
     private void getBatch(){
         
          ProgramBean bean=(ProgramBean)programComboBox.getSelectedItem();
          if(bean==null)return;
          try{
            Vector v=DatabaseManager.getBatch(bean.getProgId());
          
             batchyearComboBox.removeAllItems();
            for(int i=0; i<v.size(); i++)
            batchyearComboBox.addItem(v.elementAt(i));
            
         }catch(Exception e){
            e.printStackTrace();
        }
         
     }// end of getProgram method.
    

     private void getrollNo(){
         
          BatchBean bean=(BatchBean)batchyearComboBox.getSelectedItem();
          if(bean==null)return;
          try{
            Vector v=DatabaseManager.getStudent(bean.getBatchId());
             this.rollNoList.setListData(v);
           
            
         }catch(Exception e){
            e.printStackTrace();
        }
     }
     
     private void getStudentSetTextField(){
     
         BatchBean bean=(BatchBean)batchyearComboBox.getSelectedItem();
         if(bean==null)return;
         this.BatchIdTextField.setText(""+bean.getBatchId());
         this.shiftTextField.setText(bean.getShift());
         this.groupdescTextField.setText(bean.getGroupDesc());
         
         
     }
     private void getStudentSetTextFieldone(){
         
          StudentBean bean=(StudentBean)rollNoList.getSelectedValue();
         if(bean==null)return;
         this.StudentNameTextField.setText(bean.getStudentName());
         this.fatherNameTextField.setText(bean.getFatherName());
         this.surnameTextField.setText(bean.getSurname());
         this.rollNoTextField.setText(bean.getRollNo());
         this.remarksTextArea.setText(bean.getRemarks());
         
         
         
     }// end of
     private void addStudent(){
         
       BatchBean bean=(BatchBean)batchyearComboBox.getSelectedItem();
       if(bean==null)return;
       
      
       String stdName=StudentNameTextField.getText();
       String fatherName=fatherNameTextField.getText();
       String surname=surnameTextField.getText();
       String rollNo=rollNoTextField.getText();
       String remarks=remarksTextArea.getText();
       
       try{
            int rows=DatabaseManager.addStudent(bean.getBatchId(), stdName,fatherName,surname, rollNo ,remarks);
           
           if(rows>=1){
                JOptionPane.showMessageDialog(this,rows+"Record Saved");
                 getrollNo();
                 clear();
            }
       }catch(Exception e){
           
       }
     }// end of addStudent method.
     
     private void updateStudent(){
         
         
        StudentBean bean=(StudentBean)rollNoList.getSelectedValue();
        String   stdName=StudentNameTextField.getText();
        String   fatherName=fatherNameTextField.getText();
        String   surname=surnameTextField.getText();
        String  rollNo=rollNoTextField.getText();
        String remarks=remarksTextArea.getText();
        
        if(bean==null)return;
        try{
            
            int rows=DatabaseManager.updateStudent(bean.getStdId(),stdName, fatherName, surname, rollNo, remarks); 
            if(rows>=1){
            JOptionPane.showMessageDialog(this,rows+" Record Update");
            getrollNo();
            clear();
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        
         
     }// end of updateStudent method.
     
     private void deleteStudent(){
          
        StudentBean bean=(StudentBean)rollNoList.getSelectedValue();
        if(bean==null)return;
        try{
            
            int rows=DatabaseManager.deleteStudent(bean.getStdId()); 
            if(rows>=1){
            JOptionPane.showMessageDialog(this,rows+" Record Remove");
             getrollNo();
             clear();
            }
        }catch(Exception e){
           e.printStackTrace();
        }
     }// end of deletestudent method.
     
     
     
     private void clear(){
         
         this.BatchIdTextField.setText("");
         this.shiftTextField.setText("");
         this.groupdescTextField.setText("");
         this.StudentNameTextField.setText("");
         this.fatherNameTextField.setText("");
         this.surnameTextField.setText("");
         this.rollNoTextField.setText("");
         this.remarksTextArea.setText("");
         
     }// end of clear method.
     
     
     
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StudentLabel = new javax.swing.JLabel();
        FacultyLabel = new javax.swing.JLabel();
        FacultyComboBox = new javax.swing.JComboBox();
        DepartmentLabel = new javax.swing.JLabel();
        departComboBox = new javax.swing.JComboBox();
        ProgramLabel = new javax.swing.JLabel();
        programComboBox = new javax.swing.JComboBox();
        batchIdLabel = new javax.swing.JLabel();
        BatchIdTextField = new javax.swing.JTextField();
        BatchYearLabel = new javax.swing.JLabel();
        batchyearComboBox = new javax.swing.JComboBox();
        ShiftLabel = new javax.swing.JLabel();
        shiftTextField = new javax.swing.JTextField();
        GroupDescisionLabel = new javax.swing.JLabel();
        groupdescTextField = new javax.swing.JTextField();
        StudentNameLabel = new javax.swing.JLabel();
        StudentNameTextField = new javax.swing.JTextField();
        FatherNameLabel = new javax.swing.JLabel();
        fatherNameTextField = new javax.swing.JTextField();
        SurnameLabel = new javax.swing.JLabel();
        surnameTextField = new javax.swing.JTextField();
        rollNoLabel = new javax.swing.JLabel();
        rollNoTextField = new javax.swing.JTextField();
        RemarksLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarksTextArea = new javax.swing.JTextArea();
        DeleteButton = new javax.swing.JButton();
        RollNosLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rollNoList = new javax.swing.JList();
        AddButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StudentLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        StudentLabel.setText(" STUDENT ");

        FacultyLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FacultyLabel.setText("FACULTY");

        FacultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultyComboBoxActionPerformed(evt);
            }
        });

        DepartmentLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DepartmentLabel.setText("DEPARTMENT");

        departComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departComboBoxActionPerformed(evt);
            }
        });

        ProgramLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ProgramLabel.setText("PROGRM");

        programComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programComboBoxActionPerformed(evt);
            }
        });

        batchIdLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        batchIdLabel.setText("BATCH ID");

        BatchIdTextField.setEnabled(false);
        BatchIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatchIdTextFieldActionPerformed(evt);
            }
        });

        BatchYearLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BatchYearLabel.setText("BATCH YEAR");

        batchyearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchyearComboBoxActionPerformed(evt);
            }
        });

        ShiftLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ShiftLabel.setText("SHIFT");

        GroupDescisionLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        GroupDescisionLabel.setText("GROUP DESCISION");

        StudentNameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        StudentNameLabel.setText("STUDENT NAME");

        FatherNameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FatherNameLabel.setText("FATHER NAME");

        SurnameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SurnameLabel.setText("SURNAME");

        rollNoLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rollNoLabel.setText("ROLL NO");

        RemarksLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RemarksLabel.setText("REMARKS");

        remarksTextArea.setColumns(20);
        remarksTextArea.setRows(5);
        jScrollPane1.setViewportView(remarksTextArea);

        DeleteButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        DeleteButton.setText("DELETE");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        RollNosLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        RollNosLabel.setText("ROLL NOS");

        rollNoList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                rollNoListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(rollNoList);

        AddButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        ClearButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ClearButton.setText("CLEAR");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        UpdateButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        BackButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BackButton.setText("BACK");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MUKHTIAR ALI CHANDIO\\Documents\\NetBeansProjects\\usindhAdmissionSystem\\Images For Project\\5.Student Frame Images\\student1.jpg")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(StudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(RollNosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(StudentNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(StudentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FatherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(fatherNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(FacultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(FacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(DepartmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(departComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ProgramLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addComponent(programComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(batchIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(BatchIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(BatchYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(batchyearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ShiftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(shiftTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(GroupDescisionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(groupdescTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SurnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rollNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(rollNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(RemarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(197, 197, 197)
                                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(RollNosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FacultyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FacultyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DepartmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(departComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProgramLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(programComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(batchIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BatchIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BatchYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(batchyearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(ShiftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(shiftTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GroupDescisionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(groupdescTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StudentNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StudentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FatherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fatherNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SurnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rollNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rollNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RemarksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FacultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultyComboBoxActionPerformed
        
        getDepartment();
        
    }//GEN-LAST:event_FacultyComboBoxActionPerformed

    private void BatchIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatchIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BatchIdTextFieldActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
       
        addStudent();
        
    }//GEN-LAST:event_AddButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        hide();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       
        deleteStudent();
        
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void departComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departComboBoxActionPerformed
      
        getProgram();
        
    }//GEN-LAST:event_departComboBoxActionPerformed

    private void programComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programComboBoxActionPerformed
       
        getBatch();
        
    }//GEN-LAST:event_programComboBoxActionPerformed

    private void batchyearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchyearComboBoxActionPerformed
        
        BatchBean bean = (BatchBean) this.batchyearComboBox.getSelectedItem();
        if(bean==null)return;
        this.shiftTextField.setText(bean.getShift());
        this.groupdescTextField.setText(bean.getGroupDesc());
        getrollNo();
        
        
    }//GEN-LAST:event_batchyearComboBoxActionPerformed

    private void rollNoListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_rollNoListValueChanged
       
        getStudentSetTextField();
        getStudentSetTextFieldone();
       
    }//GEN-LAST:event_rollNoListValueChanged

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        clear();
        
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
       
        updateStudent();
        
    }//GEN-LAST:event_UpdateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Student_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField BatchIdTextField;
    private javax.swing.JLabel BatchYearLabel;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JLabel DepartmentLabel;
    private javax.swing.JComboBox FacultyComboBox;
    private javax.swing.JLabel FacultyLabel;
    private javax.swing.JLabel FatherNameLabel;
    private javax.swing.JLabel GroupDescisionLabel;
    private javax.swing.JLabel ProgramLabel;
    private javax.swing.JLabel RemarksLabel;
    private javax.swing.JLabel RollNosLabel;
    private javax.swing.JLabel ShiftLabel;
    private javax.swing.JLabel StudentLabel;
    private javax.swing.JLabel StudentNameLabel;
    private javax.swing.JTextField StudentNameTextField;
    private javax.swing.JLabel SurnameLabel;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel batchIdLabel;
    private javax.swing.JComboBox batchyearComboBox;
    private javax.swing.JComboBox departComboBox;
    private javax.swing.JTextField fatherNameTextField;
    private javax.swing.JTextField groupdescTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox programComboBox;
    private javax.swing.JTextArea remarksTextArea;
    private javax.swing.JLabel rollNoLabel;
    private javax.swing.JList rollNoList;
    private javax.swing.JTextField rollNoTextField;
    private javax.swing.JTextField shiftTextField;
    private javax.swing.JTextField surnameTextField;
    // End of variables declaration//GEN-END:variables
}
