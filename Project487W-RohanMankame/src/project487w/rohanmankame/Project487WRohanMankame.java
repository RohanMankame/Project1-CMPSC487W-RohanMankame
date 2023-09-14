/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project487w.rohanmankame;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rohan_nu3d8wo
 */
public class Project487WRohanMankame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ScannerGUI scannerGui = new ScannerGUI();
        scannerGui.show();
        
        //SQLupdateStatus sqlconnector = new SQLupdateStatus();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime DateTime = LocalDateTime.now();
        String StrDateTime = String.valueOf(dtf.format(DateTime));
        
        String[] CurrDateTimeArr = StrDateTime.split("/");
        int CurrYear =  Integer.valueOf(CurrDateTimeArr[0]);
        int DeleteYear = CurrYear - 5;
        
        
        
                
        try {
            java.sql.Connection con = null;
            String username = "root";
            String password= "rohan";
            String dataConn = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";//"jdbc:mysql://localhost:3306/sunlabswipe";
            Statement stmt = null;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dataConn,username,password);
            System.out.print("sql connection works");
            String sql = "SELECT * FROM sunlabswipe.labaccess";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            String[] YearSplitArr;
            String DateTimeTemp;
            String[] DelDateTimeArr = new String [100] ;
            int YearTemp;
            int i = 0;
            //DefaultTableModel model = (DefaultTableModel)AccessTable.getModel();
            while(rs.next()){
                //model.addRow(new String[]{rs.getString(1),rs.getString(2)});
                DateTimeTemp = rs.getString(2);
                String CurrID = rs.getString(1);
                YearSplitArr = DateTimeTemp.split("/");
                YearTemp = Integer.valueOf(YearSplitArr[0]);
                
                if(YearTemp < DeleteYear){
                    //rs.deleteRow();
                    
                    DelDateTimeArr[i] = DateTimeTemp;
                    i = i +1;
                    
                    
                    
                }
            }
            System.out.println(DelDateTimeArr[0]);
            
            String DateTimeDeletion;
            for (int y = 0 ; y<100; y++){
                DateTimeDeletion = DelDateTimeArr[y];
                String DelSql ="DELETE FROM sunlabswipe.labaccess WHERE DateEnter ="+ "'"+DateTimeDeletion+"';";
                PreparedStatement Delpst = con.prepareStatement(DelSql);
                Delpst.executeUpdate();
            }
                
                
            
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLupdateStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLupdateStatus.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        //sqlconnector.Connect();
        
        
    }
    
}
