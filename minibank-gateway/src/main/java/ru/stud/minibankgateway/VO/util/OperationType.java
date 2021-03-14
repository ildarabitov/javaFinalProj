package ru.stud.minibankgateway.VO.util;

public enum OperationType {
    PAY("Оплата"),
    BALANCE_REFILL("Пополнение");


    private final String value;
    OperationType(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
