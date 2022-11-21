/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfianwardyanto_171011400038_uas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Wardyanto
 */
public class koneksi {
    public static Connection cn;
    public static Statement stm;
    
    public static Connection getKoneksi(){
        if(cn == null){
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                cn = DriverManager.getConnection("jdbc:mysql://localhost/database_alfianwardyanto", "root", "");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return cn;
    }
}
