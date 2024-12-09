package wallet;

import java.time.LocalDateTime;

import wallet.model.entity.*;
import wallet.dao.impl.*;
import wallet.ConsultarPrecioCripto;
import java.util.*;
import wallet.MyTimerTask;

public class prueba {
    public static void main(String[] args) {
        Timer timer;
        timer = new Timer();
        TimerTask task = new MyTimerTask();
        
        timer.schedule(task, 10, 10000);
    }
}
public class MyTimerTask extends TimerTask {       
        ConsultarPrecioCripto consultar = new ConsultarPrecioCripto();
        double precio = 0;
        @Override
        public void run(){
            precio = consultar.getPrecioCripto("BTC");
            System.out.println(precio);
        }
    



