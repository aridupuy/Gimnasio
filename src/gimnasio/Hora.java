package gimnasio;

public class Hora {
String hora;
String minutos;
public Hora(){
}
public Hora (int hora){
    if (hora<10)
    this.hora="0"+hora;
    else
        this.hora=""+hora;
    minutos=":00";
}
public String toHora(){
return hora+minutos;
}
}
