package com.dreamTimes.dao;


import com.dreamTimes.pojo.Type;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TypeDao {
    /**
     * 查询所有的类型
     * @return
     */
//    @Select("select * from typetable")
    List<Type> selectAll();
}
