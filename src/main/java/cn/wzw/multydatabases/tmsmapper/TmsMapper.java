package cn.wzw.multydatabases.tmsmapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;

/**
 * @author wangziwei
 */
@Mapper
public interface TmsMapper {
    /**
     * 查询
     * @return HashMap<String, Object>
     */
    HashMap<String, Object> selectById();
}
