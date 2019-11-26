package cn.urban.system.service.impl;

import cn.urban.system.model.Authorities;
import cn.urban.system.mapper.AuthoritiesMapper;
import cn.urban.system.service.AuthoritiesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panda
 * @since 2019-11-25
 */
@Service
public class AuthoritiesServiceImpl extends ServiceImpl<AuthoritiesMapper, Authorities> implements AuthoritiesService {

    @Override
    public List<Authorities> listByUserId(Integer userId) {
        return baseMapper.listByUserId(userId);
    }
}
