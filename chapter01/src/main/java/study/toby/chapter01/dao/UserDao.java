package study.toby.chapter01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import study.toby.chapter01.ConnectionMaker;
import study.toby.chapter01.domain.User;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values (?, ?, ?)"
        );
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?"
        );

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();

        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionMaker connectionMaker1 = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker1);

        User user = new User();

        user.setId("crispin");
        user.setName("crispindeity");
        user.setPassword("molru");

        userDao.add(user);

        System.out.println("등록 성공 = " + user.getId());

        User user2 = userDao.get(user.getId());

        System.out.println("user2.getName() = " + user2.getName());
        System.out.println("user2.getPassword() = " + user2.getPassword());

        System.out.println("조회 성공 = " + user2.getId());
    }
}

