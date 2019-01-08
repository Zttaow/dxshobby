package club.ztt.action;

import club.ztt.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;

/**
 * @author 赵涛涛
 * @date 2017/11/14.
 */
@RestController
@RequestMapping(value = "/visitor")
public class VisitorAction {
    @Autowired
    private VisitorService visitorService;

    @RequestMapping(value = "/addOneVisitor",method = RequestMethod.GET)
    public void addOneVisiter(HttpServletRequest httpServletRequest){
        visitorService.addOneVistor(httpServletRequest);
    }

}
