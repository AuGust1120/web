package Student;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
 
public class addStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
 
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("gb2312");
    	String stuid = req.getParameter("stuid");
    	String name=req.getParameter("name");
    	String classes=req.getParameter("classes");
    	String score=req.getParameter("score");
    	String time=req.getParameter("time");
    	String address=req.getParameter("address");
    	String hob1=req.getParameter("hobby1");
    	String hob2=req.getParameter("hobby2");
    	String hob3=req.getParameter("hobby3");
    	String hob4=req.getParameter("hobby4");
    	String hob5=req.getParameter("hobby5");
    	String course =req.getParameter("course");
    	String hob = "";
    	if(hob1!=null){hob = hob+" 周一";}
    	if(hob2!=null){hob = hob+" 周二";}
    	if(hob3!=null){hob = hob+" 周三";}
    	if(hob4!=null){hob = hob+" 周四";}
    	if(hob5!=null){hob = hob+" 周五";}
        StudentBean studentBean = new StudentBean();
        long a = Long.parseLong(stuid);
        studentBean.setStuid(a);
        studentBean.setStuname(name);
        studentBean.setClasses(classes);
        studentBean.setStuaddress(address);
        studentBean.setCourse(course);
        studentBean.setScore(score);
        studentBean.setDay(hob);
        studentBean.setTime(time);
        StudentServiceImpl studentService = new StudentServiceImpl(StudentDaoImpl.getStudaoimp());
        studentService.addStudent(studentBean);
        //跳转到页面
        req.getRequestDispatcher("/getall").forward(req, resp);
    	
    }
}