package Student;
import java.util.List;
 
public interface StudentService {
     List<StudentBean> queryAllStudent();
     boolean  addStudent(StudentBean studentBean);
     boolean modifyStudent(StudentBean studentBean);
     StudentBean queryOneStudent(long stuid);
	boolean deleteStudent(long stuid);
	boolean modStudent(StudentBean studentBean);
	boolean markStudent(StudentBean studentBean);
}