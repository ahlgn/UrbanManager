package cn.urban.system.model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author panda
 * @since 2019-11-25
 */
@TableName("sys_authorities")
public class Authorities implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 授权id
     */
    @TableId(value = "authority_id", type = IdType.AUTO)
    private Integer authorityId;

    /**
     * 授权名称
     */
    private String authorityName;

    /**
     * 授权标识
     */
    private String authority;

    /**
     * 菜单url
     */
    private String menuUrl;

    /**
     * 父级id,-1表示无父级
     */
    private Integer parentId;

    /**
     * 权限类型
     */
    private Integer isMenu;

    /**
     * 排序号
     */
    private Integer orderNumber;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Authorities{" +
        ", authorityId=" + authorityId +
        ", authorityName=" + authorityName +
        ", authority=" + authority +
        ", menuUrl=" + menuUrl +
        ", parentId=" + parentId +
        ", isMenu=" + isMenu +
        ", orderNumber=" + orderNumber +
        ", menuIcon=" + menuIcon +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
