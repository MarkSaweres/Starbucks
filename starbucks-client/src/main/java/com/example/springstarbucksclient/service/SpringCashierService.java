package com.example.springstarbucksclient.service;

import com.example.springstarbucksclient.model.CashierOrder;
import com.example.springstarbucksclient.model.Command;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Service
public class SpringCashierService {
//    private String api_endpoint =  "http://localhost:8080";
//    private String api_key     =  "2742a237475c4703841a2bf906531eb0";
//    private String secret_key  =  "kwRg54x2Go9iEdl49jFENRM12Mp711QI" ;
//    private String register_id =  "5012349"; // default to Dub-C Store

    @Value("${starbucks.client.apikey}")
    String API_KEY;
    @Value("${starbucks.client.apihost}")
    String API_HOST;
    @Value("${starbucks.client.register}")
    String REGISTER;

    HttpHeaders headers = new HttpHeaders();
    private RestTemplate restTemplate = new RestTemplate();

    public String placeOrder(@Valid Command command) {
        CashierOrder cashierOrder = CashierOrder.GetNewOrder();
        cashierOrder.setRegister(command.getRegister());

        headers.set( "apikey", API_KEY );
        HttpEntity<CashierOrder> cashierOrderHttpEntity = new HttpEntity<>(cashierOrder, headers);

        String resourceUrl = "http://" + API_HOST + "/order/register/" + cashierOrder.getRegister();

        // get response as a CashierOrder instance
        ResponseEntity<CashierOrder> response = restTemplate.postForEntity(resourceUrl, cashierOrderHttpEntity, CashierOrder.class);
        CashierOrder createdCashierOrderBody = response.getBody();

        return  "Starbucks Reserved Order" + "\n\n" +
                "Drink: " + createdCashierOrderBody.getDrink() + "\n" +
                "Milk:  " + createdCashierOrderBody.getMilk() + "\n" +
                "Size:  " + createdCashierOrderBody.getSize() + "\n" +
                "Total: " + createdCashierOrderBody.getTotal() + "\n" +
                "\n" +
                "Register: " + createdCashierOrderBody.getRegister() + "\n" +
                "Status:   " + createdCashierOrderBody.getStatus() + "\n";
    }

    public String clearOrder(@Valid Command command){
        CashierOrder cashierOrder = CashierOrder.GetNewOrder();
        cashierOrder.setRegister(command.getRegister());

        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl = "http://" + API_HOST + "/order/register/" + cashierOrder.getRegister() + "?apikey=" + API_KEY;

        // get response as a CashierOrder instance
        restTemplate.delete(resourceUrl);
        //grab and remove order with corresponding register

        return getOrder(command.getRegister());
    }

    public String getOrder(String registerID){
        System.out.println("The API host" + API_HOST);

        //create new rest template?
        RestTemplate restTemplate = new RestTemplate();
        //grab url with corresponding register
        String resourceUrl = "http://" + API_HOST + "/order/register/" + registerID + "?apikey=" + API_KEY;;

        try {
            // get response as a CashierOrder instance
            ResponseEntity<CashierOrder> stringResponse = restTemplate.getForEntity(resourceUrl, CashierOrder.class);
            CashierOrder cashierOrder = stringResponse.getBody();
            return "Starbucks Reserved Order" + "\n\n" +
                    "Drink: " + cashierOrder.getDrink() + "\n" +
                    "Milk:  " + cashierOrder.getMilk() + "\n" +
                    "Size:  " + cashierOrder.getSize() + "\n" +
                    "Total: " + cashierOrder.getTotal() + "\n" +
                    "\n" +
                    "Register: " + cashierOrder.getRegister() + "\n" +
                    "Status:   " + cashierOrder.getStatus() + "\n";
        } catch (HttpClientErrorException httpClientErrorException) {
            return "Starbucks Reserved Order" + "\n\n" +
                    "Register: " + registerID + "\n" +
                    "Status:  Ready for New Order\n";
        }
    }

/*    var result = new Object() ;
    var client = new Client();

    var drink = "";
    var milk  = "" ;
    var size  = "" ;
    var status = "" ;
    var total = 0.0 ;

    var args = {
            headers: { "apikey": api_key }
};

    console.log( "==> api_endpoint: " + api_endpoint ) ;
            console.log( "==> api_key:      " + api_key ) ;
            console.log( "==> secret_key:   " + secret_key ) ;
            console.log( "==> register_id:  " + register_id ) ;

            client.get( api_endpoint + "/order/register/" + register_id, args,
            function(data, response_raw){
            console.log( "** GET **")
            console.log("Current Order for Register " + register_id + ": " + data);

            // for(var key in data) {
            //     console.log( "key:" + key + ", value:" + data[key] );
            // }

            var msg =   "\n\nStarbucks Reserved Order\n\n" ;

            drink = data.drink ;
            milk  = data.milk  ;
            size  = data.size  ;
            total = data.total ;
            status = data.status ;

            if ( !drink ) {
            console.log( "No Order Found!")
            status = "Ready for New Order" ;
            } else {
            msg = msg +
            "Drink: " + drink + "\n" +
            "Milk:  " + milk + "\n" +
            "Size:  " + size +"\n" +
            "Total: " + formatter.format(total) +"\n" ;
            }


            // jsdata = JSON.parse(data)
            // for(var key in jsdata) {
            //     console.log( "key:" + key + ", value:" + jsdata[key] );
            // }
            // drink = jsdata.drink ;
            // milk  = jsdata.milk  ;
            // size  = jsdata.size  ;
            // total = jsdata.total ;
            // status = jsdata.status ;


            msg = msg +
            "\n" +
            "Register: " + register_id + "\n" +
            "Status: " + status + "\n" ;

            console.log( "msg = " + msg ) ;

            state = ""
            if ( drink ) {
            state = "has-order" ;
            } else {
            state = "no-order" ;
            }
            hash = get_hash ( state, ts ) ;
            console.log( state ) ;
            result.msg = msg ;
            result.ts = ts ;
            result.hash = hash ;
            result.state = state ;

            res.render('starbucks', {
            state: result.state,
            ts: result.ts,
            hash: result.hash,
            message: result.msg,
            register: register_id
            });*/
}
