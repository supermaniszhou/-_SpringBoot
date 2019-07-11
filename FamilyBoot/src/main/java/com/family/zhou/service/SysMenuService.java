package com.family.zhou.service;

import com.family.zhou.pojo.SysMenu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author 周刘成123
 * @since 2019-07-10
 */
public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> selectAllMenu();
}
