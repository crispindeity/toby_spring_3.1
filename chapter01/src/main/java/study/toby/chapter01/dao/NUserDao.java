package study.toby.chapter01.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class NUserDao extends UserDao {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // N DB 커넥션 생성코드
        return null;
    }
}
