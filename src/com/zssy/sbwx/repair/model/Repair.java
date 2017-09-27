package com.zssy.sbwx.repair.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.zssy.sbwx.util.Dom4jUtil;

public class Repair implements Serializable {
	
	public Repair(){
		
	}
	
	private int repairId; //��άid���
	private String repairOffices; //���Ϳ���
	private String repairDevice; //�����豸��������
	private Date transportDate; //��������
	private String transportor; //������
	private String repairMan; //ά����
	private int repairStatus; //ά���豸״̬��0�ǿ���ά�ޣ�1������ά�ޣ�2�ǳ��ұ��ޣ�3���ֳ�ά�ޣ�4�ǵ绰ά��
	private int repairResult;//ά�޽����0�Ǵ��ޣ�1������ά�ޣ�2���޺ã�3�Ǳ���
	private Date repairStartDay; //��ά��ʼʱ��
	private Date repairEndDay; //��ά����ʱ��
	private String repairReason; //��άԭ��
	private String repairMethod; //��ά����
	private String sendbackMan; //�ͷ���
	private Date sendbackDate; //�ͷ�����
	private int returnFlag; //�ͷ���ʶ��0Ϊδ�ͻ���1Ϊ�ͻ�
	private String remark; //��ע
	private String repairStatusString;//ά���豸״̬�������ַ���
	private String repairResultString;//ά�޽���������ַ���
	private String returnFlagString;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRepairDevice() {
		return repairDevice;
	}

	public void setRepairDevice(String repairDevice) {
		this.repairDevice = repairDevice;
	}

	public Date getRepairEndDay() {
		return repairEndDay;
	}

	public void setRepairEndDay(Date repairEndDay) {
		this.repairEndDay = repairEndDay;
	}

	public int getRepairId() {
		return repairId;
	}

	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}

	public String getRepairMan() {
		return repairMan;
	}

	public void setRepairMan(String repairMan) {
		this.repairMan = repairMan;
	}

	public String getRepairMethod() {
		return repairMethod;
	}

	public void setRepairMethod(String repairMethod) {
		this.repairMethod = repairMethod;
	}

	public String getRepairOffices() {
		return repairOffices;
	}

	public void setRepairOffices(String repairOffices) {
		this.repairOffices = repairOffices;
	}

	public String getRepairReason() {
		return repairReason;
	}

	public void setRepairReason(String repairReason) {
		this.repairReason = repairReason;
	}

	public Date getRepairStartDay() {
		return repairStartDay;
	}

	public void setRepairStartDay(Date repairStartDay) {
		this.repairStartDay = repairStartDay;
	}

	public int getRepairStatus() {
		return repairStatus;
	}

	public void setRepairStatus(int repairStatus) {
		this.repairStatus = repairStatus;
	}

	public String getRepairStatusString() {
		Map<Integer,String> map = Dom4jUtil.getrepairStatusMap("d:\\repairStatus.xml","״̬");
		switch(this.getRepairStatus()){
			case 0: this.repairStatusString=map.get(0);break;
			case 1: this.repairStatusString=map.get(1);break;
			case 2: this.repairStatusString=map.get(2);break;
			case 3: this.repairStatusString=map.get(3);break;
			case 4: this.repairStatusString=map.get(4);break;
			default: this.repairStatusString="";break;
		}
		return repairStatusString;
	}

	public void setRepairStatusString(String repairStatusString) {
		this.repairStatusString = repairStatusString;
	}

	public Date getSendbackDate() {
		return sendbackDate;
	}

	public void setSendbackDate(Date sendbackDate) {
		this.sendbackDate = sendbackDate;
	}

	public String getSendbackMan() {
		return sendbackMan;
	}

	public void setSendbackMan(String sendbackMan) {
		this.sendbackMan = sendbackMan;
	}

	public Date getTransportDate() {
		return transportDate;
	}

	public void setTransportDate(Date transportDate) {
		this.transportDate = transportDate;
	}

	public String getTransportor() {
		return transportor;
	}

	public void setTransportor(String transportor) {
		this.transportor = transportor;
	}

	public int getReturnFlag() {
		return returnFlag;
	}

	public void setReturnFlag(int returnFlag) {
		this.returnFlag = returnFlag;
	}

	public int getRepairResult() {
		return repairResult;
	}

	public void setRepairResult(int repairResult) {
		this.repairResult = repairResult;
	}

	public String getRepairResultString() {
		Map<Integer,String> map = Dom4jUtil.getrepairStatusMap("d:\\repairResult.xml","���");
		switch(this.getRepairResult()){
			case 0: this.repairResultString=map.get(0);break;
			case 1: this.repairResultString=map.get(1);break;
			case 2: this.repairResultString=map.get(2);break;
			case 3: this.repairResultString=map.get(3);break;
			default: this.repairResultString="";break;
		}
		return repairResultString;
	}

	public void setRepairResultString(String repairResultString) {
		this.repairResultString = repairResultString;
	}

	public String getReturnFlagString() {
		switch(this.getReturnFlag()){
			case 0:this.returnFlagString="��";break;
			case 1:this.returnFlagString="��";break;
			default: this.returnFlagString="";break;
		}
		return returnFlagString;
	}

	public void setReturnFlagString(String returnFlagString) {
		this.returnFlagString = returnFlagString;
	}
	
}
