package cn.urban.system.service;

import cn.urban.system.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panda
 * @since 2019-11-25
 */
public interface UserService extends IService<User> {

    boolean addUser(User user);

    User getUserByUsername(String username);
}
