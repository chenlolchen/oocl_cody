package util;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by CHENCO7 on 7/18/2017.
 */
public class DBUtil {
//    private static final int MAX_ACTIVE = 8;
//    private static final String className = "oracle.jdbc.OracleDriver";
//    private static final String url = "jdbc:oracle:thin:@//ZHA-ITA077-w7:1521/ita3";
//    private static final String username = "cody";
//    private static final String password = "123";
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(DataSource dataSource) {
        DBUtil.dataSource = dataSource;
        System.out.println(DBUtil.dataSource);
    }

    //    static {
//        dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(className);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setMaxActive(MAX_ACTIVE);
//    }

//    public static Connection createConnection() throws Exception {
//        Connection connection = null;
//        Class.forName(className);
//        connection = DriverManager.getConnection(url, username, password);
//        return connection;
//    }

    public static Connection createConnectionWithDataSource(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
