package com.dreamTimes.dao;


import com.dreamTimes.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    /**
     * 创建一项订单
     * @param order
     * @return
     */
    int addOrder(@Param("order") Order order);

    /**
     * 查询所有的订单
     * @return
     */
    List<Order> selectAll();

    /**
     * 根据oid进行删除
     * @param oid
     * @return
     */
    int delete(@Param("oid") Integer oid);

    /**
     * 通过UID进行查询
     * @param uid
     * @return
     */
    List<Order> selectByUid(@Param("uid") Integer uid);
}
