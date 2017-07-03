package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by TXJ on 2017/6/28.
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
    private static final long serialVersionUID=1L;
    //JDBC驱动名及数据库URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/test";
    //数据库的用户名及密码
    static final String USER="root";
    static final String  PASS="123456";
    public RegisterServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        Connection conn=null;
        PreparedStatement stmt=null;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try{
            //注册JDBC驱动器
            Class.forName("com.mysql.jdbc.Driver");
            //打开一个连接
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            //执行SQL插入,
            // 编写预处理sql语句
            String sql="insert into consumer(name,password,address,phone) VALUES (?,?,?,?)";
            //实例化prepareStatement
            stmt=conn.prepareStatement(sql);
            //传入参数，来自于register.jsp
            stmt.setString(1, request.getParameter("username"));
            stmt.setString(2,request.getParameter("password"));
            stmt.setString(3,request.getParameter("address"));
            stmt.setString(4,request.getParameter("phone"));
            stmt.executeUpdate();
            // 完成后关闭
            stmt.close();
            conn.close();
           /* request.getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);*/

        }catch (SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally {
            // 最后是用于关闭资源的块
            try {
                if (stmt != null)
                    stmt.close();
                }catch(SQLException se2){
                }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        try{
            response.sendRedirect("http://localhost:8070/login.jsp");
            return;
        }catch (Exception e){
            response.getWriter();}
    }
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
