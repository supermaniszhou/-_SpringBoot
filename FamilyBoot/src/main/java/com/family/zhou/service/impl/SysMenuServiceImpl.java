package com.family.zhou.service.impl;

import com.family.zhou.pojo.SysMenu;
import com.family.zhou.mapper.sys.SysMenuMapper;
import com.family.zhou.service.SysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return sysMenuMapper.selectAllMenu();
    }
}