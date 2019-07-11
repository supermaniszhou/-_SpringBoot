package com.family.zhou.mapper.sys;

import com.family.zhou.pojo.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author 周刘成123
 * @since 2019-07-10
 */
@Repository
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> selectAllMenu();
}
