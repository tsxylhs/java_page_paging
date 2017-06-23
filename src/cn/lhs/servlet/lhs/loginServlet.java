package cn.lhs.servlet.lhs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
    	  String username =req.getParameter("username");
    	  String userpassword=req.getParameter("userpassword");
    	  if(username.equals("lvhou")&&userpassword.equals("123")){
    	     //请求装啊
    		  req.getRequestDispatcher("Index.jsp").forward(req, resp);
    	  }
    	  else
    	  {
    		 resp.sendRedirect("login.jsp");;
    	  }
    	  
    }
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
    }
}
