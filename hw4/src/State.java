import java.util.HashMap;


public class State {
    final int stateID;
    HashMap<Character,State> transistion;

    public State(int stateID){
        this.stateID = stateID;
        transistion = new HashMap<>();
    }
    public void addTrans(char letter, State newState){
        transistion.put(letter, newState);
    }
    public int getID(){
        return this.stateID;
    }
    public State getNext(char trans){
        return transistion.get(trans);
    }
}
