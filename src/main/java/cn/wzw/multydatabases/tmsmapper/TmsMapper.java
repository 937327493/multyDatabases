package cn.wzw.multydatabases.tmsmapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface TmsMapper {
    HashMap<String, Object> selectById();
}
