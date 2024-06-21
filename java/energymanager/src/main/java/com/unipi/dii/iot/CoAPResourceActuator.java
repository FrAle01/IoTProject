package com.unipi.dii.iot;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoAPResourceActuator extends CoapResource{

    DatabaseManager db = new DatabaseManager();

    public CoAPResourceActuator(String name){
        super(name);
    }

    @Override
    public void handleGET(CoapExchange exchange){
        exchange.respond("hello world");
    }

    @Override
    public void handlePOST(CoapExchange exchange){
        
        if(!db.allSensorsOnline()){

            System.out.println("NOT ALL SENSORS REGISTERED YET!");
            Response response = new Response(CoAP.ResponseCode.BAD_REQUEST);
            exchange.respond(response);
            return;
        }        
        
        System.out.println("POST ACTUATOR received");
    }

}
