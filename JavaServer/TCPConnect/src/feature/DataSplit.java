package feature;

import protocol.DataProtocol;

public class DataSplit {

	private static int Id;
    private static String EnvHumidity;//����ʪ��
    private static String EnvTemperature;//�����¶�
    private static String LightVal1;//����ֵ1
    private static String LightVal2;//����ֵ2
    private static String LightVal3;//����ֵ3
    private static String WaterLevel;//ˮλ
    private static String Electricity;//����
    private static String SoilHumidity;//����ʪ��
    
    public int getId() {return Id;}
    public void setId(int Id) {DataSplit.Id = Id;}
    
    public String getEnvHumidity() {return EnvHumidity;}
    public void setEnvHumidity(String EnvHumidity) {DataSplit.EnvHumidity = EnvHumidity;}
    
    public String getEnvTemperature() {return EnvTemperature;}
    public void setEnvTemperature(String EnvTemperature) {DataSplit.EnvTemperature = EnvTemperature;}
    
    public String getLightVal1() {return LightVal1;}
    public void setLightVal1(String LightVal1) {DataSplit.LightVal1 = LightVal1;}
    
    public String getLightVal2() {return LightVal2;}
    public void setLightVal2(String LightVal2) {DataSplit.LightVal2 = LightVal2;}
    
    public String getLightVal3() {return LightVal3;}
    public void setLightVal3(String LightVal3) {DataSplit.LightVal3 = LightVal3;}
    
    public String getWaterLevel() {return WaterLevel;}
    public void setWaterLevel(String WaterLevel) {DataSplit.WaterLevel = WaterLevel;}
    
    public String getElectricity() {return Electricity;}
    public void setElectricity(String Electricity) {DataSplit.Electricity = Electricity;}
    
    public String getSoilHumidity() {return SoilHumidity;}
    public void setSoilHumidity(String SoilHumidity) {DataSplit.SoilHumidity = SoilHumidity;}
    
    
    public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}
     
	public static void Split(DataProtocol reciveMsg) {
    	String[] strArray={"","","","","","","",""};
        if (reciveMsg != null) {
            String Data = reciveMsg.getData();
            int count = 0;
            for(int i=0; i<Data.length(); i++){
            	if(count == 8)
            		break;
            	String temp = "";
            	if(Data.charAt(i) != ',')
            		temp += Data.charAt(i);
            	else{
            		strArray[count] = temp;
            		count++;
            	}
            }
            EnvHumidity = strArray[0];
            EnvTemperature = strArray[1];
            LightVal1 = strArray[2];
            LightVal2 = strArray[3];
            LightVal3 = strArray[4];
            WaterLevel = strArray[5];
            Electricity = strArray[6];
            SoilHumidity = strArray[7];
        }
    }
}