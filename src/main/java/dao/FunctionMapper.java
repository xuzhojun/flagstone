package dao;

import entity.Function;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FunctionMapper {
    void add(Function f);
    void delete(Function f);
    Function searchByID(int id);
    List<Function> queryAllFunction();
    List<Function> searchByPersonInCharge(String personInCharge);
    int updateById(Function f);
}
