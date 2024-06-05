package application.model;

public class PowerUp {
    int id; //per distinguere di quale dei 4 p-up si tratta
    String name;
    public PowerUp (int _id){
        id=_id;
    }
    public void effect (){
        //TODO: Ci sarà uno switch che a seconda dell'id attiva un effetto diverso
        System.out.println("Sto usando un powerup di tipo"+id);
    }
}
