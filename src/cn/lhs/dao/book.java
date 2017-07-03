package cn.lhs.dao;

public class book {
   @Override
	public String toString() {
		return "book [bookID=" + bookID + ", bookName=" + bookName + ", autherName=" + autherName + "]";
	}
private int bookID;
   private String bookName;
   private String autherName;
public int getBookID() {
	return bookID;
}
public void setBookID(int bookID) {
	this.bookID = bookID;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getAutherName() {
	return autherName;
}
public void setAutherName(String autherName) {
	this.autherName = autherName;
}
    
}
