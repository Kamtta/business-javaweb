package com.dreamTimes.dao;




import com.dreamTimes.pojo.Goods;
import com.dreamTimes.pojo.ShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartDao {
    /**
     * 添加商品
     * @param goods
     * @return
     */
    int addGoods(@Param("goods") Goods goods);

    /**
     * 删除菜篮选项
     * @param gname
     * @return
     */
    int delete(@Param("gname") String gname);

    /**
     * 查询菜篮中所有的商品
     * @return
     */
    List<ShoppingCart> selectAll();

    /**
     * 通过商品名进行寻找
     * @param gname
     * @return
     */
    ShoppingCart selectByGname(@Param("gname") String gname);

    /**
     * 更新shoppingcart
     * @param shoppingCart
     * @return
     */
    int update(@Param("shoppingcart") ShoppingCart shoppingCart);
}
