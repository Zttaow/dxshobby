package club.ztt.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 *
 * @author 赵涛涛
 * @date 2017/8/14.
 */
public class CheckFieldUtil {

    public static ResultBean checkField(BindingResult bindingResult) {
        //有错误，失败响应，返回错误信息
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            StringBuilder stringBuilder = new StringBuilder();
            int count = 1;
            for (ObjectError error : errorList) {
                String str = error.getDefaultMessage();
                //
                System.out.println("数据绑定出错:" + str);
                stringBuilder.append(new StringBuilder().append(count++).append(".").append(str).append(""));
            }
            String errMsg = stringBuilder.toString();
            return ResultBean.failResponse(errMsg);
        }
        //无误返回空
        return null;
    }
}
