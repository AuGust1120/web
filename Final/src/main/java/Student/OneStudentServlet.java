package Student;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
 
public class OneStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String a=req.getParameter("stuidid");
        long stuid =  Long.parseLong(a);
        StudentServiceImpl studentService = new StudentServiceImpl(StudentDaoImpl.getStudaoimp());
        StudentBean studentBean = studentService.queryOneStudent(stuid);
        req.setAttribute("studentBean",studentBean);
        req.setAttribute("stuidid",stuid);
        req.getRequestDispatcher("/showone.jsp").forward(req,resp);
    }
}