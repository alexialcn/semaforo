package com.linkedgroup.linfood;

import com.linkedgroup.linfood.threads.SemaforoThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LinfoodApplication {

    public static void main(String[] args) {

        SemaforoThread thread = new SemaforoThread();

        for(int i = 0; i<10; i++){
            log.info(thread.getCor().toString());
            thread.esperaCordMudar();
        }
        thread.pararSemaforo();
    }
}



