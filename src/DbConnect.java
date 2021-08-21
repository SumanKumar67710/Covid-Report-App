import java.sql.*;
import javax.swing.JOptionPane;
public class DbConnect {
    public static Connection c;
    public static Statement st;
    public static PreparedStatement insertPatient;
    public static PreparedStatement getPatientById;
    public static PreparedStatement getPatientByPhone;
    public static PreparedStatement getPatientByStatus;
    public static PreparedStatement getPatientLikeName;
    public static PreparedStatement getPatientLikePhone;
    public static PreparedStatement getPatientByDateAndStatus;
    public static PreparedStatement getPatientByDateAndStatusAndCity;
    public static PreparedStatement getPatientByDate;
    static{
        try{
            //for mysql
            Class.forName("com.mysql.jdbc.Driver"); //optional
            c=DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/covidreport?useSSL=false&allowPublicKeyRetrieval=true",
                "root","Suman@12");
            //for oracle
//            Class.forName("oracle.jdbc.driver.OracleDriver"); //optional
//           c=DriverManager.getConnection(
//            "jdbc:oracle:thin:@localhost:1521:xe",
//                "covidreport","covidreport");
            st=c.createStatement();
            insertPatient=c.prepareStatement("insert into patient (name,father_name,phone,email,age,city,test_date,gender,address,status) values(?,?,?,?,?,?,?,?,?,'pending')");
            getPatientById=c.prepareStatement("select * from patient where pid=?");
            getPatientByPhone=c.prepareStatement("select * from patient where phone=?");
            getPatientByStatus=c.prepareStatement("select * from patient where status=?");
            getPatientLikePhone=c.prepareStatement("select * from patient where phone like ?");
            getPatientLikeName=c.prepareStatement("select * from patient where name like ?");
            getPatientByDateAndStatus=c.prepareStatement("select * from patient where test_date>=? and test_date<=? and status=?");
            getPatientByDateAndStatusAndCity=c.prepareStatement("select * from patient where test_date>=? and test_date<=? and status=? and city=?");
            getPatientByDate=c.prepareStatement("select * from patient where test_date>=? and test_date<=? ");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
