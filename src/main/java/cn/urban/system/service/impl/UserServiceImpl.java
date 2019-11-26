package cn.urban.system.service.impl;

import cn.urban.common.exception.BusinessException;
import cn.urban.system.model.User;
import cn.urban.system.mapper.UserMapper;
import cn.urban.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panda
 * @since 2019-11-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUser(User user) {
        if (baseMapper.selectByUsername(user.getUsername())!=null) {
            throw new BusinessException("账号已存在");
        }
        boolean is = baseMapper.insert(user) > 0;
        return is;
    }

    @Override
    public User getUserByUsername(String username) {

        return  baseMapper.selectByUsername(username);
    }
}
