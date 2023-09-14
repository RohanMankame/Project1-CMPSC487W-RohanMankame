/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project487w.rohanmankame;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author Rohan_nu3d8wo
 */
public class SQLupdateStatus {
    //Connection con = null;
    PreparedStatement pst;
    
    public void Connect(){
        try {
            Connection con = null;
            String username = "root";
            String password= "rohan";
            String dataConn = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";//"jdbc:mysql://localhost:3306/sunlabswipe";
            Statement stmt = null;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dataConn,username,password);
            System.out.print("sql connection works");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLupdateStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SQLupdateStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    

    
}
