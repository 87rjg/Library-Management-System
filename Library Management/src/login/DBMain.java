package login;

import java.sql.*;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import homepage.Home;

//import com.mysql.jdbc.Statement;

public class DBMain {
	public static int save(String name,String pass,String contact,String ques,String ans)
	{
		int status=0;
		try{
			Connection con = DataBase.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into register(name,password,contact,question,ans) values(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,pass);
			ps.setString(3,contact);
			ps.setString(4,ques);
			ps.setString(5,ans);
			
			status = ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("insertion problem"+e);
		}
		
		return status;
	}
	public static int saveStudent(String name,String fname,String course,String id,String dob,String contact)
	{
		int status=0;
		try{
			Connection con = DataBase.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into student(name,fname,course,id,dob,contact) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,fname);
			ps.setString(3,course);
			ps.setString(4,id);
			ps.setString(5,dob);
			ps.setString(6,contact);
			
			status = ps.executeUpdate();
			//Home.
			con.close();
			ps.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Student insertion problem "+e);
		}
		
		return status;
	}
	public static boolean login(String name,String pass)
	{
		boolean status=false;
		try{
			Connection con = DataBase.getConnection();
			PreparedStatement ps =  con.prepareStatement("select * from register where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet res = ps.executeQuery();
			status = res.next();
			//if()
			Home.getPost(res.getString("name"));
			con.close();
			ps.close();
			
		}catch(Exception e)
		{
			System.out.println("Exception at Login "+e);
		}
		return status;
	}
	public static void bookShelf(String book_id,String book_name,String shelf_no)
	{
		int quant=0;
		try
		{
			Connection con = DataBase.getConnection();
			PreparedStatement ps =  con.prepareStatement("select book_id,quantity from bookshelf where book_id=? ");
			ps.setString(1, book_id);
			//ps.setString(2, shelf_no);
			//ps.setString(3,);
			ResultSet res = ps.executeQuery();
			if(res.next())
			{
				quant = res.getInt("quantity");
				PreparedStatement pst =  con.prepareStatement("update bookshelf set quantity=? where book_id=?");
				//pst.setString(1, book_id);
				pst.setInt(1, quant+1);
				pst.setString(2, book_id);
				
				pst.executeUpdate();
				//System.out.println("Updated");
				con.close();
				pst.close();
			}
			else
			{
				try
				{
					PreparedStatement pst1 = con.prepareStatement("insert into bookshelf(book_id,book_name,shelf_no,quantity) values(?,?,?,?)");
					pst1.setString(1, book_id);
					pst1.setString(2, book_name);
					pst1.setString(3, shelf_no);
					pst1.setInt(4, 1);
					pst1.executeUpdate();
					pst1.close();
					//System.out.println("inserted");
				}catch(Exception e)
				{
					System.out.println("Exception at Updation "+e);
				}
				
			}
			con.close();
			ps.close();
			
		}catch(Exception e)
		{
			System.out.println("Exception at ADD Shelf "+e);
			
		}
	}
	public static int addBook(String book_id,String book_name,String auther_name,String date,String shelf_no)
	{
		int status=0;
		Connection con = DataBase.getConnection();
		try
		{
		 PreparedStatement pstmt = con.prepareStatement("select book_id from book_details where book_id = ?");
		pstmt.setString(1,book_id);
		ResultSet rs= pstmt.executeQuery();
		if(rs.next())
		{
			 status=0;
		} 
		else
		{
			try
			{
				
				PreparedStatement ps = con.prepareStatement("insert into book_details(book_id,book_name,auther_name,Add_Date,shelf_no) values(?,?,?,?,?)");
				
				ps.setString(1, book_id);
				ps.setString(2, book_name);
				ps.setString(3, auther_name);
				ps.setString(4, date);
				ps.setString(5, shelf_no);
				
				status = ps.executeUpdate();
				
				ps.close();
				
			}catch(Exception e)
			{
				System.out.println("Exception at ADD BOOK "+e);
			}
		}
		con.close(); 
		rs.close();
		pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception  "+e);
		}
		
		bookShelf(book_id,book_name,shelf_no);
		return status;
	}
	public static int issueBook(String Student_id, String book_id,String date)
	{
		int status =0,quant;
		try
		{
			Connection con =  DataBase.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select book_id,quantity from bookshelf where book_id=?");
			ps.setString(1, book_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				quant = rs.getInt("quantity");
				if(quant > 0)
				{
					PreparedStatement pst=null;
					pst = con.prepareStatement("update bookshelf set quantity=? where book_id=?");
					pst.setInt(1, quant-1);
					pst.setString(2, book_id);
					pst.executeUpdate();
					
					PreparedStatement pst1 = con.prepareStatement("insert into issuebook(student_id,book_id,issue_date) values(?,?,?)");
					pst1.setString(1, Student_id);
					pst1.setString(2, book_id);
					pst1.setString(3, date);
					status = pst1.executeUpdate();
					
					pst1.close();
					pst.close();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Sorry! Book Currently Unavailble!");
				}
				con.close();
				rs.close();
				
			}
		}catch(Exception e)
		{
			System.out.println("Exception Something went Wrong "+e);
		}
		
		return status;
		
	}
	public static int returnBook(String student_id, String book_id) {
		int status=0,quant;
		try
		{
			Connection con = DataBase.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select student_id,book_id from issuebook where student_id=? and book_id=?");
			ps.setString(1, student_id);
			ps.setString(2, book_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				PreparedStatement pst = con.prepareStatement("delete from issuebook where book_id=? and student_id=?");
				pst.setString(1, book_id);
				pst.setString(2, student_id);
				pst.executeUpdate();
				PreparedStatement pst1 = con.prepareStatement("select quantity from bookshelf where book_id=?");
				pst1.setString(1, book_id);
				ResultSet res = pst1.executeQuery();
				if(res.next())
				{
					quant = res.getInt("quantity");
					PreparedStatement pst2=null;
					pst2 = con.prepareStatement("update bookshelf set quantity=? where book_id=?");
					pst2.setInt(1, quant+1);
					pst2.setString(2, book_id);
					pst2.executeUpdate();
					status=1;
				}
				pst.close();
				pst1.close();
			}
			else
			{
				JOptionPane.showMessageDialog(null, book_id+" is not Issue to "+student_id);
			}
			con.close();
			rs.close();
		}catch(Exception e)
		{
			System.err.println(e);
		}
		return status;
	}

}
