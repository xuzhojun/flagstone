package dao;

import entity.OperateFlow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperateFlowMapper {
    void add(OperateFlow of);
    List<OperateFlow> queryAll();
}
