package com.linkedgroup.linfood.threads;

import com.linkedgroup.linfood.domain.CorSemaforo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import static com.linkedgroup.linfood.domain.CorSemaforo.AMARELO;
import static com.linkedgroup.linfood.domain.CorSemaforo.VERMELHO;

@Slf4j
@Data
public class SemaforoThread implements Runnable {

    private CorSemaforo cor;
    private boolean parar;
    private boolean corMudou;

    public SemaforoThread() {
        this.cor = CorSemaforo.VERMELHO;

        new Thread(this).start();
    }


    @Override
    public void run() {
        while (!parar) {
            try {
                Thread.sleep(this.cor.getTempoDaCor());
                mudarCor();
                }
             catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void mudarCor(){
        switch (this.cor){
            case VERMELHO:
                this.cor = CorSemaforo.VERDE;
                break;
            case VERDE:
                this.cor = CorSemaforo.AMARELO;
                break;
            case AMARELO:
                this.cor = CorSemaforo.VERMELHO;
                break;
        }
        this.corMudou = true;
        notify();
    }

    public synchronized void esperaCordMudar(){
        while(!this.corMudou){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        this.corMudou = false;
    }

    public CorSemaforo getCor() {
        return cor;
    }

    public synchronized void pararSemaforo() {
        this.parar = true;
    }
}
