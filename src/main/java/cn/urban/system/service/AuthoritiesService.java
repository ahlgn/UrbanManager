package cn.urban.system.service;

import cn.urban.system.model.Authorities;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panda
 * @since 2019-11-25
 */
public interface AuthoritiesService extends IService<Authorities> {
    List<Authorities> listByUserId(Integer userId);
}
