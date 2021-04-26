package com.linkedgroup.linfood.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
public enum CorSemaforo {

    VERDE(500),AMARELO(300),VERMELHO(2000);

    private int tempoDaCor;

    public int getTempoDaCor() {
        return tempoDaCor;
    }

    public void setTempoDaCor(int tempoDaCor) {
        this.tempoDaCor = tempoDaCor;
    }
}
