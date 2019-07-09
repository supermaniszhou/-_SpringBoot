package com.family.zhou.service.impl;

import com.family.zhou.pojo.SysConfig;
import com.family.zhou.mapper.sys.SysConfigMapper;
import com.family.zhou.service.SysConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author 周刘成123
 * @since 2019-07-09
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {
    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Override
    public String selectValueByKey(SysConfig sysConfig) {
        SysConfig config = sysConfigMapper.selectValueByKey(sysConfig);
        return StringUtils.isEmpty(config) ? "" : config.getConfigValue();
    }
}
