package club.ztt.dao;

import org.springframework.stereotype.Repository;
import club.ztt.entity.*;

/**
 * @author 赵涛涛
 * @date 2017/11/7.
 */
@Repository
public interface VisitorDao {

    int insert(Visitor record);

    Visitor selectByPrimaryKey(String ip);


}