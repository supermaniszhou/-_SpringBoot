package com.family.zhou.mapper.sys;

import com.family.zhou.pojo.SysConfig;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 参数配置表 Mapper 接口
 * </p>
 *
 * @author 周刘成123
 * @since 2019-07-09
 */
@Repository
public interface SysConfigMapper extends BaseMapper<SysConfig> {
    SysConfig selectValueByKey(SysConfig sysConfig);
}
