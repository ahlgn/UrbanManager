package cn.urban.system.mapper;

import cn.urban.system.model.Authorities;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.tools.javac.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author panda
 * @since 2019-11-25
 */
public interface AuthoritiesMapper extends BaseMapper<Authorities> {
    List<Authorities> listByUserId(Integer userId);
}
