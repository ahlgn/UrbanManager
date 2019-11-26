package cn.urban.system.model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author panda
 * @since 2019-11-25
 */
@TableName("sys_department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 部门
     */
    private String department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Department{" +
        ", id=" + id +
        ", department=" + department +
        "}";
    }
}
