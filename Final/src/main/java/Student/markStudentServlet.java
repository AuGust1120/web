package Student;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
 
public class markStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
 
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("gb2312");
    	String stuid = req.getParameter("stuid");
    	String name=req.getParameter("course");
    	String classes=req.getParameter("score");
        StudentBean studentBean = new StudentBean();
        long a = Long.parseLong(stuid);
        studentBean.setStuid(a);
        studentBean.setCourse(name);
        studentBean.setScore(classes);
        StudentServiceImpl studentService = new StudentServiceImpl(StudentDaoImpl.getStudaoimp());
        studentService.markStudent(studentBean);
        //跳转到页面
        req.getRequestDispatcher("/getall").forward(req, resp);
    	
    }
}