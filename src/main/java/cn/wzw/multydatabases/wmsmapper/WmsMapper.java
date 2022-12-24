package cn.wzw.multydatabases.wmsmapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;

/**
 * @author wangziwei
 */
@Mapper
public interface WmsMapper {
    /**
     * 查询
     * @return HashMap<String, Object>
     */
    HashMap<String, Object> selectById();
}
