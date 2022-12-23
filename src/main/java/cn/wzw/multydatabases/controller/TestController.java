package cn.wzw.multydatabases.controller;

import cn.wzw.multydatabases.tmsmapper.TmsMapper;
import cn.wzw.multydatabases.wmsmapper.WmsMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private TmsMapper tmsMapper;
    @Resource
    private WmsMapper wmsMapper;

    @GetMapping("/01")
    public void select() {
        HashMap tmsMapperHashMap = tmsMapper.selectById();
        System.out.println(tmsMapperHashMap.toString());
        HashMap wmsMapperHashMap = wmsMapper.selectById();
        System.out.println(wmsMapperHashMap.toString());
    }
}
