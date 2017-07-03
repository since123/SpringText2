package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by TXJ on 2017/6/26.
 */
@WebServlet("/PageRedirect1")
public class PageRedirect extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        //设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        //重定向方法一
        //要重定向的新位置
        try{
            String site=new String("https://www.baidu.com/");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("location",site);
            }catch (Exception e){
                response.getWriter();
            }

        //重定向方法二
       /* try{    response.sendRedirect("https://www.baidu.com");
            return;
            }catch (Exception e){
        response.getWriter();}*/


    }
}
