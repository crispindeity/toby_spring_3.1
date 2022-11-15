package study.toby.chapter01.dao;

import java.sql.Connection;
import java.sql.SQLException;

import study.toby.chapter01.ConnectionMaker;

public class DConnectionMaker implements ConnectionMaker {
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        return null;
    }
}
