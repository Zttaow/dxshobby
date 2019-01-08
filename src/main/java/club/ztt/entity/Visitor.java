package club.ztt.entity;

import java.util.Date;

/**
 * @author 赵涛涛
 * @date 2017/11/7.
 */
public class Visitor {
    private String ip;

    private String address;

    private Date gmtCreate;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "ip='" + ip + '\'' +
                ", address='" + address + '\'' +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}