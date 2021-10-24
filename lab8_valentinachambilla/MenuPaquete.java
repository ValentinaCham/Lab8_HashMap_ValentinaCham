// Laboratorio Nro 8 - Ejercicio 1
// Autor: Valentina Milagros Chambilla Perca
// Considero que mi principal dificultad fue que al inicio no podia comprender verdaderamente el tema
// pero luego de mucha practica logre dominarlo en un 25%.

package lab8_valentinachambilla;

import java.util.*;

public class MenuPaquete {

    public static void main(String[] args) {
        HashMap<String, Paquete> PaquetesReg = new HashMap<>();
        HashMap<String, Integer> EstEntrega = new HashMap<>();
        int desicion;
        Scanner scan= new Scanner(System.in);
        /*
        Para el HashMap EstEntrega, compartiran la clave, mientras que la segunda columna se diferenciará por el contenido
        1: RECIBIDO
        2: EN PROCESO
        2: ENTREGADO
        3: FALLO EN ENTREGA
        */
        GenerarPaquetes(PaquetesReg);
        
        //MENÚ INICIAL
        while(true){
        System.out.println("*********************************MENÚ DE EMPRESA XXXXXXXXXXX*********************************");
        
        System.out.println("1. Mostrar Paquetes \n2. Registro de paquete RECIBIDO \n3. Registro de paquete EN PROCESO\n"
                + "4. Registro de paquete ENTREGADO \n5. Registro de paquete FALLO EN ENTREGA \n6. Mostrar Paquetes según estado ");
        desicion = scan.nextInt();
        
            if(desicion<=6 && desicion>=1){
                break;
            }
            else{
                System.out.println("Numero no permitido, volver a ingresar el número por favor");
            }
        }
        
        while(true){
            //SWITCH PARA TODOS LOS CASOS
            switch (desicion){
                case 1:{
                    //MOSTRAR PAQUETES
                    MostrarPaquetes(PaquetesReg);
                    break;
                }
                case 2:{
                    //REGISTRO DE PAQUETES RECIBIDOS
                    RegistrarPaqueteREC(PaquetesReg,EstEntrega);
                    break;
                }
                case 3:{
                    //REGISTRO DE PAQUETES EN PROCESO
                    RegistrarPaquetePROC(PaquetesReg,EstEntrega);
                    break;
                }
                case 4: {
                    //REGISTRO DE PAQUETES ENTREGADOS
                    RegistrarPaqueteENT(PaquetesReg,EstEntrega);
                    break;
                }
                case 5: {
                    //REGISTRO DE PAQUETES FALLO
                    RegistrarPaqueteFALL(PaquetesReg,EstEntrega);
                    break;
                }
                case 6: {
                    //MOSTRAR REGUN ESTADO
                    MostrarEst(PaquetesReg,EstEntrega);
                    break;
                }
            }
            
            System.out.println("¿Desea realizar otra operación? \n1. SI \n2. NO");
            desicion = scan.nextInt();
            
            if (desicion==1){
                System.out.println("1. Mostrar Paquetes \n2. Registro de paquete RECIBIDO \n3. Registro de paquete EN PROCESO\n"
                + "4. Registro de paquete ENTREGADO \n5. Registro de paquete FALLO EN ENTREGA \n6. Mostrar Paquetes según estado ");
                desicion = scan.nextInt();
            }
            else if (desicion==2){
                System.out.println("Hasta luego OwO");
                break;
            }
        }
    }
    
    public static void GenerarPaquetes(HashMap<String, Paquete> ListaPaq){
        int kil, cant0;
        double cos;
        String name, cod, ceros;
        //Generar
        for (int i=0; i<20; i++){
            cant0=0;
            ceros="";
            name = "Paquete" + (i+1);
            cos = Math.random()*50;
            kil = Aleatorio(50,1);
            //El código tendra el formato de P000###
            cant0 = 5 - (i/10);
            for (int j=0; j<cant0; j++){
                ceros=ceros+"0";
            }
            cod = "P" + ceros + i;
            
            ListaPaq.put(cod, new Paquete(name, cos, kil));
        }
    }
    
    public static void MostrarPaquetes(HashMap<String, Paquete> ListaPaq){
        System.out.printf( "%10s%3s%20s%12s%8s\n", "Código", " ", "Nombre", "Costo", "Peso");
        for (String cod: ListaPaq.keySet()){
            System.out.printf("%10s%3s%20s%9.2f%8d\n", cod, ": ", ListaPaq.get(cod).getNom(), ListaPaq.get(cod).getCos(),ListaPaq.get(cod).getKil());
        }
    }
    
    public static void MostrarEst(HashMap<String, Paquete> ListaPaq,HashMap<String, Integer> EstEntrega){
        boolean pres=false;
        System.out.print( "INGRESAR EL ESTADO BUSCADO: \n1: RECIBIDO\n" +
        "2: EN PROCESO\n" +
        "3: ENTREGADO\n" +
        "4: FALLO EN ENTREGA\n");
        Scanner scan= new Scanner(System.in);
        int des = scan.nextInt();
        for (String cod: EstEntrega.keySet()){
            if (EstEntrega.get(cod)==des){
                pres=true;
                break;
            }
        }
        if (pres){
            System.out.printf( "%10s%3s%20s%12s%8s\n", "Código", " ", "Nombre", "Costo", "Peso");
            for (String cod: EstEntrega.keySet()){
                if(EstEntrega.get(cod)==des)
                    System.out.printf("%10s%3s%20s%9.2f%8d\n", cod, ": ", ListaPaq.get(cod).getNom(), ListaPaq.get(cod).getCos(),ListaPaq.get(cod).getKil());
            }
        }
        else {
            System.out.println( "Aún no hay ningun paquete en ese estado");
        }
    }
    
    public static void RegistrarPaqueteREC(HashMap<String, Paquete> ListaPaq,HashMap<String, Integer> EstEntrega){
        String cod;
        Scanner scan= new Scanner(System.in);
        System.out.print( "INGRESAR EL CÓDIGO DE PAQUETE RECIBIDO: ");
        cod = scan.next();
        if (ListaPaq.containsKey(cod)){
            if (EstEntrega.containsKey(cod)){
                switch (EstEntrega.get(cod)){
                    case 1:{
                        System.out.println( "El paquete se encuentra ya en proceso de RECIBIDO");
                        break;
                    }
                    case 2:{
                        System.out.println( "El paquete se encuentra ya en proceso de envio");
                        break;
                    }
                    case 3:{
                        System.out.println( "El paquete ya esta Entregado");
                        break;
                    }
                    case 4:{
                        System.out.println( "El paquete se encuentra se registro como falla de envío");
                        break;
                    }
                }
            }
            else{
                EstEntrega.put(cod, 1);
                System.out.println( "REGISTRO EXITOSO");
            }
        }
        else
        {
            System.out.println( "NO HAY NINGUN PAQUETE QUE TENGA EL CÓDIGO INGRESADO, por favor verificarlo y volver a intentar");
        }
    }
    
    public static void RegistrarPaquetePROC(HashMap<String, Paquete> ListaPaq,HashMap<String, Integer> EstEntrega){
        String cod;
        Scanner scan= new Scanner(System.in);
        System.out.print( "INGRESAR EL CÓDIGO DE PAQUETE EN PROCESO: ");
        cod = scan.next();
        if (ListaPaq.containsKey(cod)){
            if (EstEntrega.containsKey(cod)){
                switch (EstEntrega.get(cod)){
                    case 1:{
                        EstEntrega.put(cod, 2);
                        System.out.println( "REGISTRO EXITOSO");
                        break;
                    }
                    case 2:{
                        System.out.println( "El paquete se encuentra ya en proceso de envio");
                        break;
                    }
                    case 3:{
                        System.out.println( "El paquete ya esta Entregado");
                        break;
                    }
                    case 4:{
                        System.out.println( "El paquete se encuentra se registro como falla de envío");
                        break;
                    }
                }
            }
            else{
                System.out.println("El paquete aún no ha sido ingresado como RECIBIDO");
            }
        }
        else
        {
            System.out.println( "NO HAY NINGUN PAQUETE QUE TENGA EL CÓDIGO INGRESADO, por favor verificarlo y volver a intentar");
        }
    }
    
    public static void RegistrarPaqueteENT(HashMap<String, Paquete> ListaPaq,HashMap<String, Integer> EstEntrega){
        String cod;
        Scanner scan= new Scanner(System.in);
        System.out.print( "INGRESAR EL CÓDIGO DE PAQUETE ENTREGADO: ");
        cod = scan.next();
        if (ListaPaq.containsKey(cod)){
            if (EstEntrega.containsKey(cod)){
                switch (EstEntrega.get(cod)){
                    case 1:{
                        System.out.println( "El paquete aún se encuentra en proceso de RECIBIDO, para poder catalogarlo"
                        + " como enviado debe estar en proceso");
                        break;
                    }
                    case 2:{
                        EstEntrega.put(cod, 3);
                        System.out.println( "REGISTRO EXITOSO");
                        break;
                    }
                    case 3:{
                        System.out.println( "El paquete ya esta Entregado");
                        break;
                    }
                    case 4:{
                        System.out.println( "El paquete se encuentra se registro como falla de envío");
                        break;
                    }
                }
            }
            else{
                System.out.println("El paquete aún no ha sido ingresado como RECIBIDO");
            }
        }
        else
        {
            System.out.printf( "NO HAY NINGUN PAQUETE QUE TENGA EL CÓDIGO INGRESADO, por favor verificarlo y volver a intentar");
        }
    }
    
    public static void RegistrarPaqueteFALL(HashMap<String, Paquete> ListaPaq,HashMap<String, Integer> EstEntrega){
        String cod;
        Scanner scan= new Scanner(System.in);
        System.out.print( "INGRESAR EL CÓDIGO DE PAQUETE CON FALLA DE ENTREGA: ");
        cod = scan.next();
        if (ListaPaq.containsKey(cod)){
            if (EstEntrega.containsKey(cod)){
                switch (EstEntrega.get(cod)){
                    case 1:{
                        System.out.println( "El paquete aún se encuentra en proceso de RECIBIDO, para poder catalogarlo"
                        + " como FALLA DE ENTREGA debe estar en proceso");
                        break;
                    }
                    case 2:{
                        EstEntrega.put(cod, 4);
                        System.out.println( "REGISTRO EXITOSO");
                        break;
                    }
                    case 3:{
                        System.out.println( "El paquete ya esta Entregado");
                        break;
                    }
                    case 4:{
                        System.out.println( "El paquete ya se encuentra como falla de envío");
                        break;
                    }
                }
            }
            else{
                System.out.println("El paquete aún no ha sido ingresado como RECIBIDO");
            }
        }
        else
        {
            System.out.printf( "NO HAY NINGUN PAQUETE QUE TENGA EL CÓDIGO INGRESADO, por favor verificarlo y volver a intentar");
        }
    }
    
    public static int Aleatorio(int Mayor, int Menor){
        Random aleatorio = new Random();
        
        int num = aleatorio.nextInt(Mayor-Menor+1)+Menor;
        return num;
    }
}
