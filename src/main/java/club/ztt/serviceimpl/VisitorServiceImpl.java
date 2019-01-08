package club.ztt.serviceimpl;

import club.ztt.dao.VisitorDao;
import club.ztt.entity.Visitor;
import club.ztt.service.VisitorService;
import club.ztt.util.CommonException;
import club.ztt.util.IpAddressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * Created by ztt1 on 2017/11/14.
 */
@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorDao visitorDao;

    /**
     * @param httpServletRequest
     */
    public void addOneVistor(HttpServletRequest httpServletRequest) {
        String ip = IpAddressUtil.getUserIpAddress(httpServletRequest);
        if (visitorDao.selectByPrimaryKey(ip) != null) {
            throw new CommonException("此条ip已存在！");
        }
        String address = IpAddressUtil.getAddressOfIp(ip, "utf-8");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Visitor visitor = new Visitor();
        visitor.setIp(ip);
        visitor.setAddress(address);
        visitor.setGmtCreate(timestamp);
        System.out.println(visitor);
        visitorDao.insert(visitor);
    }


    /**
     * @param ip
     */
    public void selectOneVisitor(String ip) {

    }
}
