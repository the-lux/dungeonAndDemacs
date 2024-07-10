package application.model;

public class PowerUp {
    int id; //per distinguere di quale dei 4 p-up si tratta
    /*LEGGENDA: 1=coffee(speed), 2=Tessera Associazione, 3=Domanda alla segreteria, 4=Sigaretta
                5=ChatGPT(+Danno)
    */
    String name;
    public PowerUp (int _id){
        id=_id;
    }

    public int getId() {
        return id;
    }
}
