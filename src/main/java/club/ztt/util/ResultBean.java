package club.ztt.util;

import java.io.Serializable;

/**
 * 封装返回结果
 *
 * @author 赵涛涛
 * @date 2017/8/14.
 */
public class ResultBean<T> implements Serializable {
//    private static final long serialVersionUID = 1L;

    //标识处理是否成功, 0: 表示成功, 其它值, 表示失败
    private int errNum;
    //错误详细说明
    private String errMsg;
    //返回数据集
    private T data;

    //构造方法私有
    private ResultBean() {
    }

    private ResultBean(int errNum, String errMsg, T data) {
        this.errNum = errNum;
        this.errMsg = errMsg;
        this.data = data;
    }

    //getter、setter方法
    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 操作成功的响应结果
     *
     * @param data
     * @return
     */
    public static <U> ResultBean successResponse(U data) {
        ResultBean<U> resultBean = new ResultBean(0, "", null);
        if (data != null) {
            resultBean.setData(data);
        }
        return resultBean;
    }

    /**
     * 操作失败的响应结果
     *(静态方法的形参不能是类的类型变量)
     * @param errMsg
     * @return
     */
    public static ResultBean failResponse(String errMsg) {
        ResultBean<String> resultBean = new ResultBean(1, errMsg, null);
        if (errMsg != null) {
            resultBean.setErrMsg(errMsg);
        }
        return resultBean;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "errNum=" + errNum +
                ", errMsg='" + errMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
