package study.toby.chapter01.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DUserDao extends UserDao {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // D DB 커넥션 생성코드
        return null;
    }
}
