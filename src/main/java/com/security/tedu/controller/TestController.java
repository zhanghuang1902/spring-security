package com.security.tedu.controller;

import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RequestMapping("/testHutu")
@RestController
public class TestController {
    @PostMapping("/excel")
    public void excel(){
        ExcelReader reader = ExcelUtil.getReader(new File("C:\\Users\\admin\\Desktop\\hutool2.xls"));
        List<List<Object>> read = reader.read();
        BitMapBloomFilter filter = new BitMapBloomFilter(10);
        filter.add("123");
        filter.add("abc");
        filter.add("ddd");
        boolean abc = filter.contains("abc");
        System.out.println(abc);
        System.out.println(reader);
    }
}
