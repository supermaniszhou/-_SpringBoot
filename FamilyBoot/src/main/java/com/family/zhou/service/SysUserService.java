package com.family.zhou.service;

import com.family.zhou.pojo.SysUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author 周刘成123
 * @since 2019-07-08
 */
public interface SysUserService extends IService<SysUser> {
    SysUser selectSysUserByName(SysUser sysUser);

}
