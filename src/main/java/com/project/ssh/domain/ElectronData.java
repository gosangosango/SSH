package com.project.ssh.domain;


public class ElectronData {
   private int dataId;
   private String deviceId;
   private String kind;
   private String receivedDate;
   private String gpsLatitude;
   private String gpsLongitude;
   private String checked;
   

   
   public ElectronData() {
      super();
   }




public ElectronData(int dataId, String deviceId, String kind, String receivedDate, String latitude, String longitude,
		String checked) {
	super();
	this.dataId = dataId;
	this.deviceId = deviceId;
	this.kind = kind;
	this.receivedDate = receivedDate;
	this.gpsLatitude = latitude;
	this.gpsLongitude = longitude;
	this.checked = checked;
}


   public String getDeviceId() {
      return deviceId;
   }
   public void setDeviceId(String deviceId) {
      this.deviceId = deviceId;
   }
   public String getKind() {
      return kind;
   }
   public void setKind(String kind) {
      this.kind = kind;
   }
   public String getReceivedDate() {
      return receivedDate;
   }
   public void setReceivedDate(String receivedDate) {
      this.receivedDate = receivedDate;
   }

   
   public String getChecked() {
	return checked;
   }

   public void setChecked(String checked) {
	this.checked = checked;
   }

@Override
   public String toString() {
	   return "ElectronData [dataNo=" + dataId + ", deviceId=" + deviceId + ", kind=" + kind + ", receivedDate="
			   + receivedDate + ", latitude=" + gpsLatitude + ", longitude=" + gpsLongitude + ", checked=" + checked + "]";
   }




public int getDataId() {
	return dataId;
}




public void setDataId(int dataId) {
	this.dataId = dataId;
}




public String getGpsLatitude() {
	return gpsLatitude;
}




public void setGpsLatitude(String gpsLatitude) {
	this.gpsLatitude = gpsLatitude;
}




public String getGpsLongitude() {
	return gpsLongitude;
}




public void setGpsLongitude(String gpsLongitude) {
	this.gpsLongitude = gpsLongitude;
}


}
   
   
   
   
   
   
   
