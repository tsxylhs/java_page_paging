package cn.lhs.servlet.lhs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lhs.dao.UserDao;
import cn.lhs.dao.book;

public class listbookservlet extends HttpServlet {
	public listbookservlet(){
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 resp.setCharacterEncoding("utf-8");
	 int pageNo=1;
	 UserDao userdao=new UserDao();
	 List<book> booklist=new ArrayList<book>();
	 String pageno=req.getParameter("pageNos");
	 String bookid=req.getParameter("delete");
	 if(bookid!=null){
		 int id=Integer.parseInt(bookid);
		 System.out.println(id);
		 userdao.remove(id);
	 }
	 if(pageno!=null){
		 pageNo=Integer.parseInt(pageno);
		 
	 }
	 booklist=userdao.listBook(pageNo);
	 req.setAttribute("recordCount", userdao.getPage());
	 req.setAttribute("listss", booklist);
	 req.setAttribute("pageNos",pageNo);
	 req.getRequestDispatcher("Index.jsp").forward(req, resp);
	 
	 
	}

}
