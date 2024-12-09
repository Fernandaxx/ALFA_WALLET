package wallet;

import java.util.*;

public class MyTimerTask extends TimerTask {       
        ConsultarPrecioCripto consultar = new ConsultarPrecioCripto();
        double precio = 0;
        @Override
        public void run(){
            precio = consultar.getPrecioCripto("BTC");
            System.out.println(precio);
        }
}
