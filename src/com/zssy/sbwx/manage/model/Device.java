package com.zssy.sbwx.manage.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import com.zssy.sbwx.util.DateUtil;

public class Device implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Device(){
		
	}
	
	private int deviceId; //设备编号
	private String deviceName; //设备名称
	private String type; //设备型号
	private String specification; //设备规格
	private Double price; //设备单价
	private Date buyDate; //购置日期
	private String supplier; //厂商
	private String unit; //单位
	private String sn; //出厂编号
	private int status; //设备状态 2为正常，1为维修，3为报废，0为借出，4为逻辑删除，5为已安装
	private String createBy; //入库人
	private Date createDate; //入库日期
	private String deleteBy; //报废人
	private Date deleteDate; //报废日期
	private String remark;
	private String statusString;//状态的中文字符串
	private String buyDateString="0000-00-00";////购置日期字符串
	private String createDateString="0000-00-00";////入库日期字符串
	private String deleteDateString="0000-00-00";////报废日期字符串
	//private int orderNO;
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDeleteBy() {
		return deleteBy;
	}
	public void setDeleteBy(String deleteBy) {
		this.deleteBy = deleteBy;
	}
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getStatusString(){
		switch(this.getStatus()){
			case 0: this.statusString="借出";break;
			case 1: this.statusString="维修";break;
			case 2: this.statusString="正常";break;
			case 3: this.statusString="报废";break;
			case 4: this.statusString="逻辑删除";break;
			case 5: this.statusString="已安装";break;
			default: this.statusString="";break;
		}
		return statusString;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBuyDateString() {
		try {
			if(this.getBuyDate()!=null){
				this.buyDateString = DateUtil.getFormatDate("yyyy-MM-dd", this.getBuyDate());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buyDateString;
	}
	public String getCreateDateString() {
		try {
			if(this.getCreateDate()!=null){
				this.createDateString = DateUtil.getFormatDate("yyyy-MM-dd", this.getCreateDate());
			}
			//System.out.println(createDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return createDateString;
	}
	public String getDeleteDateString() {
		try {
			if(this.getDeleteDate()!=null){
				this.deleteDateString = DateUtil.getFormatDate("yyyy-MM-dd", this.getDeleteDate());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteDateString;
	}
	/*public int getOrderNO() {
		return orderNO;
	}
	public void setOrderNO(int orderNO) {
		this.orderNO = orderNO;
	}*/
}
