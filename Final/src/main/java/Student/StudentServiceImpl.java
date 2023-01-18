package Student;
import java.util.List;
 
public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao=null;
    public StudentServiceImpl(StudentDao studentDao){
        this.studentDao=studentDao;
    }
    @Override
    public List<StudentBean> queryAllStudent() {
        return studentDao.getAllStudent();
    }
 
    @Override
    public boolean addStudent(StudentBean studentBean) {
        return studentDao.insertStudent(studentBean);
    }
 
    @Override
    public boolean deleteStudent(long stuid) {
        return studentDao.removeStudent(stuid);
    }
 
    @Override
    public boolean modifyStudent(StudentBean studentBean) {
        return studentDao.updateStudent(studentBean);
    }
 
    @Override
    public StudentBean queryOneStudent(long stuid) {
        return studentDao.getOneStudent(stuid);
    }
	public boolean modStudent(StudentBean studentBean) {
		return studentDao.checkStudent(studentBean);
	}
	public boolean markStudent(StudentBean studentBean) {
		// TODO Auto-generated method stub
		return studentDao.dmarkStudent(studentBean);
	}
}