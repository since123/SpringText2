package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by TXJ on 2017/6/27.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    //JDBC驱动名及数据库URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/test";
    //数据库用户名及密码
    static final String USER="root";
    static final String PASS="123456";
    protected void doGet(HttpServletRequest request,HttpServletResponse response )throws ServletException,IOException {
        Connection conn = null;
        PreparedStatement stmt=null;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try{
            //注册JDBC驱动器
            Class.forName("com.mysql.jdbc.Driver");
            //打开一个连接
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            //执行sql
            String sql="select name,password from consumer";
            stmt=conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            int flag=1;

            while(rs.next()) {
                if (rs.getString(1).equals(request.getParameter("name")) && rs.getInt(2)== Integer.parseInt(request.getParameter("password")))
                    flag = 0;
            }
                if (flag ==0) {
                    try {
                        response.sendRedirect("http://localhost:8070/main.jsp");
                        return;
                    } catch (Exception e) {
                        response.getWriter();
                    }
                } else {
                    try {
                        response.sendRedirect("http://localhost:8070/login.jsp");
                        return;
                    } catch (Exception e) {
                        response.getWriter();
                    }
                }


            // 完成后关闭
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //处理JDBC的错误
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
