package com.family.zhou.mapper.sys;

import com.family.zhou.pojo.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author 周刘成123
 * @since 2019-07-08
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectSysUserByName(SysUser sysUser);
}
