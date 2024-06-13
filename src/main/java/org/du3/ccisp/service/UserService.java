package org.du3.ccisp.service;

import org.du3.ccisp.pojo.User;

import java.util.List;

public interface UserService {
    void add(User user);

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
     */
    List<User> queryAll();
}

