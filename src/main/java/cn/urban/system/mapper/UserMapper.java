package cn.urban.system.mapper;

import cn.urban.system.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author panda
 * @since 2019-11-25
 */
public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(String name);
}
