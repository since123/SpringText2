package com.servlet;

import com.sun.deploy.net.HttpResponse;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by TXJ on 2017/6/25.
 */
@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet{
    private static final long serialVersionUID=1L;
    //jdbc驱动名及数据库URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/test";
    //数据库的用户名和密码，需要根据自己的设置
    static final String  USER="root";
    static final String  PASS="123456";
    public DatabaseAccess(){
        super();
    }
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        Connection conn =null;
        Statement stmt=null;
        //设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String title="Servlet Myaql 测试—菜鸟教程";
        String docType="<!DOCTYPE html>\n";
        out.println(docType+
        "<html>\n"+
        "<head><title>"+title+"</title></head>\n"+
        "<body bgcolor=\"#f0f0f0\">\n "+
        "<h1 align=\"center\">"+title+"</h1>\n");
        try{
            //注册JDBC驱动器
            Class.forName("com.mysql.jdbc.Driver");
            //d打开一个连接
            conn= DriverManager.getConnection(DB_URL,USER,PASS);
            //执行sql查询
            stmt=conn.createStatement();
            String sql;
            sql="SELECT id,name,url from websites";
            ResultSet rs=stmt.executeQuery(sql);
            //展开结果集数据库
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String url=rs.getString("url");
                //输出数据
                out.println("ID: "+id);
                out.println(",name: "+name);
                out.println(",站点URL： "+url);
                out.println("<br/>");
            }
            out.println("</body></html>");
            rs.close();
            stmt.close();
            conn.close();

        }catch (SQLException se){
            //处理JDBC错误
            se.printStackTrace();
        }catch(Exception e){
            //处理Class.ForName错误
            e.printStackTrace();

        }finally {
            // 最后是用于关闭资源的块
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    protected  void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        doGet(request,response);
    }
}
