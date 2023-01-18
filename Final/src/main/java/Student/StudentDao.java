package Student;
import java.util.List;
 
/**
 * 创建数据访问接口
 */
public interface StudentDao {
    //接口下的抽象方法
        //查询所有学生信息,返回一个学生信息集合供遍历显示
        List<StudentBean> getAllStudent();
        //添加学生信息,返回添加结果
        Boolean insertStudent(StudentBean studentBean);
        //根据学号查询单个学生信息
        StudentBean getOneStudent(long stuid);
        //修改学生信息
        Boolean updateStudent(long stuid);
        //根据学号删除学生信息
		Boolean updateStudent(StudentBean student);
		Boolean removeStudent(long stuid);
		Boolean checkStudent(StudentBean studentBean);
		Boolean dmarkStudent(StudentBean studentBean);
 
 
}