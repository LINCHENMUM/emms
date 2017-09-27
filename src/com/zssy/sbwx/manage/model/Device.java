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
	
	private int deviceId; //�豸���
	private String deviceName; //�豸����
	private String type; //�豸�ͺ�
	private String specification; //�豸���
	private Double price; //�豸����
	private Date buyDate; //��������
	private String supplier; //����
	private String unit; //��λ
	private String sn; //�������
	private int status; //�豸״̬ 2Ϊ������1Ϊά�ޣ�3Ϊ���ϣ�0Ϊ�����4Ϊ�߼�ɾ����5Ϊ�Ѱ�װ
	private String createBy; //�����
	private Date createDate; //�������
	private String deleteBy; //������
	private Date deleteDate; //��������
	private String remark;
	private String statusString;//״̬�������ַ���
	private String buyDateString="0000-00-00";////���������ַ���
	private String createDateString="0000-00-00";////��������ַ���
	private String deleteDateString="0000-00-00";////���������ַ���
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
			case 0: this.statusString="���";break;
			case 1: this.statusString="ά��";break;
			case 2: this.statusString="����";break;
			case 3: this.statusString="����";break;
			case 4: this.statusString="�߼�ɾ��";break;
			case 5: this.statusString="�Ѱ�װ";break;
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
