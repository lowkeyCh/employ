package org.du3.ccisp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.du3.ccisp.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    /**已使用
     * 增加一条数据
     * @param user 数据
     */
    void add(User user);

    /**已使用
     * 匹配一条数据
     * @param user 数据
     */
    User match(User user);

    /**
     * 删除一条数据
     * @param userId 被删除数据的id
     */
    void delete(Integer userId);

    /**
     * 修改一条数据
     * @param user 修改的数据
     */
    void update(User user);

    /**
     * 根据id去查询一条数据
     * @param userId 查询的id
     */
    User queryById(Integer userId);

    /**
     * 查询全部数据
     * @return
     */
    List<User> queryAll();
}

