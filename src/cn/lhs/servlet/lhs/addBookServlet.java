package cn.lhs.servlet.lhs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lhs.dao.UserDao;
import cn.lhs.dao.book;
@WebServlet("/addbookservlet")
public class addBookServlet extends HttpServlet{
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	           book book=new book();
    	           book.setBookID(Integer.parseInt(req.getParameter("bookID")));
    	           book.setAutherName(req.getParameter("autherName"));
    	           book.setBookName(req.getParameter("bookName"));
    	           List<book> booklist=new ArrayList<book>();
    	               UserDao userdao=new UserDao();
    	                if(userdao.addbook(book)!=0){
    	                	 booklist=userdao.listBook(1);
    	                	 req.setAttribute("recordCount", userdao.getPage());
    	                	 req.setAttribute("listss", booklist);
    	                	 req.setAttribute("pageNos",1);
    	                	req.getRequestDispatcher("Index.jsp").forward(req, resp);
    	                	
    	                }
    	                else{
    	                	resp.sendRedirect("add.jsp");
    	                }
    	  
    	  
    	  
    }
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
    }
}
