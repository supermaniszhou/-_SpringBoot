package com.family.zhou.controller.thService;

import com.family.zhou.pojo.SysConfig;
import com.family.zhou.service.SysConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 周刘成   2019/7/9
 */
@Service("config")
public class ThSysConfigService {
    @Resource
    private SysConfigService configService;

    public String getValueByKey(String configKey) {
        SysConfig config = new SysConfig();
        config.setConfigKey(configKey);
        String configValue = configService.selectValueByKey(config);
        return configValue;
    }
}
