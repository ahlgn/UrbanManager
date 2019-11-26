package cn.urban.common.shiro;

import cn.urban.system.model.Authorities;
import cn.urban.system.model.User;
import cn.urban.system.model.UserRole;
import cn.urban.system.service.impl.AuthoritiesServiceImpl;
import cn.urban.system.service.impl.UserRoleServiceImpl;
import cn.urban.system.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserRoleServiceImpl userRoleService;
    @Autowired
    private AuthoritiesServiceImpl authoritiesService;
    @Autowired
    private UserServiceImpl userService;
    /**
     * 注册权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //创建权限用户
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //查询所有权限用户
        List<UserRole> userRoles = userRoleService.list(new QueryWrapper<UserRole>().eq("user_id",user.getId()));
        Set<String> roles=new HashSet<>();
        //设置用户对应身份
        for (UserRole userRole: userRoles) {
            roles.add(String.valueOf(userRole.getRoleId()));
            System.out.println("正在设置用户身份："+userRole.getUserId());
        }
        info.setRoles(roles);

        List<Authorities> authorities = authoritiesService.listByUserId(user.getId());
        Set<String> permissions = new HashSet<>();
        for (Authorities authority: authorities) {
            String auth = authority.getAuthority();
            if(auth!=null || auth!="" || auth!=" ") {
                permissions.add(auth);
            }
        }
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 验证权限
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username= (String) authenticationToken.getPrincipal();
        User user = userService.getUserByUsername(username);
        if(user==null){
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(EndecryptUtil.DEFAULT_SALT),getName());
        System.out.println("正在验证"+username+"的权限，密码为:"+user.getPassword()+"getname()="+getName());
        return info;
    }
}
