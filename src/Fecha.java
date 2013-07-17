package gimnasio;
public class Fecha {
public int dia;
public int mes;
public int año;
    int setDia;
public Fecha(){}

    public Fecha(String year, String month, String day) {
        setAño(year);
        setMes(month);
        setDia(day);
    }

    public int getAño() {
        return año;
    }

       public void setAño(int año) {
        if (año>1900)
        this.año = año;
    }

    public void setAño(String year) {
       int año;
       año = Integer.parseInt(year);
        if (año>1900)
        this.año = año;
    }

    public int getDia() {
        return dia;
    }
public void setDia(int dia){
          this.dia=dia;
                        }
    
    public void setDia(String day) {
        int dia;
        dia= Integer.parseInt(day);
         if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12)
            if (dia<32)
            this.dia = dia;
            else if (mes==4||mes==6||mes==9||mes==11)
                if (dia<31)
                    this.dia=dia;
                else if (mes==2)
                    if (año%4==0)
                        if (dia <30)
                        this.dia=dia;
                        else if (dia<29)
                            this.dia=dia;
                        }

    public int getMes() {
        return mes;
    }
    
    public void setMes(int mes) {
        if (mes>0&&mes<13)
        this.mes = mes;
    }
    public void setMes(String month) {
        int mes ;
        mes = Integer.parseInt(month);
        if (mes>0&&mes<13)
        this.mes = mes;
    }

    @Override
    public String toString() {
        String year;
        String month;
        String day;
        year = String.valueOf(año);
        if (mes<10)
        month = "0"+mes;
        else 
            month=String.valueOf(mes);
        if (dia<10)
        day = "0"+dia;
        else
            day = String.valueOf(dia);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        return year+month+day; 
        
        
    }

}
