package com.family.zhou.service.impl;

import com.family.zhou.pojo.SysUser;
import com.family.zhou.mapper.sys.SysUserMapper;
import com.family.zhou.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author 周刘成123
 * @since 2019-07-08
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectSysUserByName(SysUser sysUser) {
        return sysUserMapper.selectSysUserByName(sysUser);
    }
}
