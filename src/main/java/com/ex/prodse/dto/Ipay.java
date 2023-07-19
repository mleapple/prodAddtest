package com.ex.prodse.dto;

/**
 * fileName:Ipay
 * 작성날짜:2023-07-19
 * desc :
 **/
public interface Ipay {

    boolean paymentConfirmation(long amontOfpayment);
    boolean paymentConfirmation();
    boolean paymentConfirmation(String paymentTyoe , long amontOfpayment);



     long getamontOfpayment();

     void setAmontOfpayment(long price) ;

}
