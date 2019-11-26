package cn.urban.system.controller;

import cn.urban.common.BaseController;
import cn.urban.common.utils.StringUtil;
import cn.urban.system.model.Authorities;
import cn.urban.system.model.User;
import cn.urban.system.service.impl.AuthoritiesServiceImpl;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class MainController extends BaseController {

    @Autowired
    private AuthoritiesServiceImpl authoritiesService;
    @GetMapping({"/","/index"})
    public String index(Model model){
        if (getLoginUser()==null) {
            return "redirect:/login";
        }
        List<Authorities> authorities = authoritiesService.listByUserId(getLoginUserId());
        List<Map<String, Object>> menuTree = getMenuTree(authorities, -1);
        model.addAttribute("menus", menuTree);
        model.addAttribute("loginUser", getLoginUser());
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {
        if (getLoginUser() != null) {
            return "redirect:/index";
        }
        return "login.html";
    }

    @PostMapping("/login")
    public String doLogin(User user){
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            SecurityUtils.getSubject().login(token);
            return "登录成功";
        } catch (IncorrectCredentialsException ice) {
            return "密码错误";
        } catch (UnknownAccountException uae) {
            return "账号不存在";
        } catch (LockedAccountException e) {
            return "账号被锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "操作频繁，请稍后再试";
        }
    }

    // 递归转化树形菜单
    private List<Map<String, Object>> getMenuTree(List<Authorities> authorities, Integer parentId) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < authorities.size(); i++) {
            Authorities temp = authorities.get(i);
            if (temp.getIsMenu() == 0 && parentId.equals(temp.getParentId())) {
                Map<String, Object> map = new HashMap<>();
                map.put("menuName", temp.getAuthorityName());
                map.put("menuIcon", temp.getMenuIcon());
                map.put("menuUrl", StringUtil.isBlank(temp.getMenuUrl()) ? "javascript:;" : (temp.getMenuUrl()));
                map.put("subMenus", getMenuTree(authorities, authorities.get(i).getAuthorityId()));
                list.add(map);
            }
        }
        return list;
    }
}
