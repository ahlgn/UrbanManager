package cn.urban.system.service;

import cn.urban.system.model.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.tools.javac.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panda
 * @since 2019-11-25
 */
public interface UserRoleService extends IService<UserRole> {

    List<UserRole> selectAll();
}
