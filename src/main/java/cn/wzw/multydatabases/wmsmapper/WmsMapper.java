package cn.wzw.multydatabases.wmsmapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface WmsMapper {
    HashMap<String, Object> selectById();
}
