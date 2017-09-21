package com.dnp.attend.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
    /**
     * <p>
     * 处理分页后的返回json数据
     *
     * @param total 总条数
     * @param rows  分页后的信息
     * @return Map<String, Object>
     */
    public static Map<String, Object> pageInMap(int total, Object rows) {
        Map<String, Object> pageMap = new HashMap<String, Object>();
        pageMap.put("total", total);
        pageMap.put("rows", rows);
        return pageMap;
    }
}
