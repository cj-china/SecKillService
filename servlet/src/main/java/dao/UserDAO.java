package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtil;

public class UserDAO {

  public User findByUsername(String uname) throws SQLException {
    User user=null;
    Connection conn=null;
    PreparedStatement stat=null;
    ResultSet rs=null;
    conn=DBUtil.getConnection();
    String sql="select * from t_user where username=?";
    stat=conn.prepareStatement(sql);
    stat.setString(1,uname);
    rs=stat.executeQuery();
    while(rs.next()){
      user=new User();
      user.setId(rs.getInt("id"));
      user.setUsername(rs.getString("username"));
      user.setPwd(rs.getString("password"));
      user.setEmail(rs.getString("email"));

    }
    DBUtil.close(conn,stat,rs);
    return user;
  }

  public void delete(int id){
    Connection conn=null;
    PreparedStatement stat=null;
    try {
      conn=DBUtil.getConnection();
      String sql="delete from t_user where id=?" ;
      stat=conn.prepareStatement(sql);
      stat.setInt(1,id);
      stat.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      DBUtil.close(conn,stat,null);
    }
  }

  public void save(User user){
    Connection conn=null;
    PreparedStatement stat=null;
    try {
      conn=DBUtil.getConnection();
      String sql="insert into t_user values(null,?,?,?)";
      stat=conn.prepareStatement(sql);
      stat.setString(1,user.getUsername());
      stat.setString(2,user.getPwd());
      stat.setString(3,user.getEmail());
      stat.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      DBUtil.close(conn,stat,null);
    }
  }

  public List<User> findAll(){
    List<User> users=new ArrayList<User>();
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    try {
      conn= DBUtil.getConnection();
      String sql="select * from t_user";
      ps=conn.prepareStatement(sql);
      rs=ps.executeQuery();
      while (rs.next()){
        int id=rs.getInt(1);
        String username=rs.getString(2);
        String pwd=rs.getString(2);
        String email=rs.getString(3);
        User user=new User();
        user.setId(id);
        user.setUsername(username);
        user.setPwd(pwd);
        user.setEmail(email);
        users.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      DBUtil.close(conn,ps,rs);
    }
    return users;
  }
}
