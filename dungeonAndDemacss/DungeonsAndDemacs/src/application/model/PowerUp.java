package application.model;

public record PowerUp(int id) {
    //per distinguere di quale dei 4 p-up si tratta
    /*LEGGENDA: 1=GPT(+danno), 2=Tessera Associazione, 3=Sigaretta(invisibile), 4=caffè vita

    public PowerUp (int _id){
        id=_id;
    }*/

    public int getId() {
        return id;
    }
}
