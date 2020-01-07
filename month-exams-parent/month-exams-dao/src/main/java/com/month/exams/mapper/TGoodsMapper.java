package com.month.exams.mapper;

import com.month.exams.pojo.TGoods;
import com.month.exams.pojo.TGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface TGoodsMapper {
    int countByExample(TGoodsExample example);

    int deleteByExample(TGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TGoods record);

    int insertSelective(TGoods record);

    List<TGoods> selectByExample(TGoodsExample example);

    TGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TGoods record, @Param("example") TGoodsExample example);

    int updateByExample(@Param("record") TGoods record, @Param("example") TGoodsExample example);

    int updateByPrimaryKeySelective(TGoods record);

    int updateByPrimaryKey(TGoods record);

    @Update(value="update t_goods set zt=1 where id=#{id}")
	void up(int id);

    @Update(value="update t_goods set zt=0 where id=#{id}")
	void dwon(int id);
}