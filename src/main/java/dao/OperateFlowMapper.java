package dao;

import entity.OperateFlow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateFlowMapper {
    void add(OperateFlow of);
}
