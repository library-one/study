import java.sql.*;

public class test {
    Connection conn = null;

    public test(){}

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("성공");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb",
                    "jaewon", "aq@97524123");
            System.out.println("DB 연결 성공");
        } catch (ClassNotFoundException var2) {
            System.out.println("JDBC 드라이버 로드 오류");
        } catch (SQLException var3) {
            System.out.println("JDBC 드라이버 로드 오류");
        }

        return conn;
    }
}
