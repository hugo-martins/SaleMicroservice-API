package br.com.phoebustecnologia.SaleMicroservice.exceptions;

public class SaleNotFoundException extends RuntimeException{
    public SaleNotFoundException(){
        super("The sale with the specific id does not exist");
    }
}
