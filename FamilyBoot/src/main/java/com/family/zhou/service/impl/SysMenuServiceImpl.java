package com.family.zhou.service.impl;

import com.family.zhou.pojo.SysMenu;
import com.family.zhou.mapper.sys.SysMenuMapper;
import com.family.zhou.service.SysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author 周刘成123
 * @since 2019-07-10
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> selectAllMenu() {
        List<SysMenu> list = sysMenuMapper.selectAllMenu();

        List<SysMenu> parentList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            SysMenu menu = list.get(i);
            if (menu.getParentId() == 0) {
                menu.setChildren(getChildren(list, menu.getMenuId()));
                parentList.add(menu);
            }
        }
        return parentList;
    }

    public List<SysMenu> getChildren(List<SysMenu> list, long parentId) {
        List<SysMenu> childList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            SysMenu sysMenu = list.get(i);
            if (sysMenu.getParentId() == parentId) {
                childList.add(sysMenu);
            }
        }
        for (int j = 0; j < childList.size(); j++) {
            SysMenu menu = childList.get(j);
            menu.setChildren(getChildren(list, menu.getMenuId()));
        }
        return childList;
    }

}
