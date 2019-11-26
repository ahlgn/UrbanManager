package cn.urban.system.service.impl;

import cn.urban.system.model.UserRole;
import cn.urban.system.mapper.UserRoleMapper;
import cn.urban.system.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.tools.javac.util.List;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panda
 * @since 2019-11-25
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public List<UserRole> selectAll() {

        return null;
    }
}
