import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter total number of states: ");
        int stateCount = input.nextInt();
        System.out.println("Enter initial state: ");
        int initState = input.nextInt();

        System.out.println("\nEnter final states (comma separated) : ");
        String finState = input.next();
        String[] temp = finState.split(",");
        int[] finalStates = new int[temp.length];
        for(int i = 0;i < finalStates.length;i++)
            finalStates[i] = Integer.parseInt(temp[i]);



        char[] alphabet = {'a','b'};

        List<State> states = new ArrayList<State>();
        for(int i = 0; i < stateCount; i++)
        {
            State tmp = new State(i);
            states.add(tmp);
        }

        int i = 0;
        for(State state : states){
            for(int j = 0; j < alphabet.length; j++) {
                System.out.println("\n\nfor state " + i + ", " + alphabet[j] + " will go to: ");
                int stateNum = input.nextInt();
                state.addTrans(alphabet[j], states.get(stateNum));
            }
            i++;
        }

        System.out.println("\nEnter the String to test: ");
        String test = input.next();
        char[] testchar = test.toCharArray();
        input.close();

        List<String> printState = new ArrayList<>();
        State currentState = states.get(0);
        int prevState = currentState.getID();

        for(i = 0; i < testchar.length; i++){
            currentState = currentState.getNext(testchar[i]);
            System.out.println("q" + prevState + ", " + testchar[i] + " ->" + currentState.getID());
            prevState = currentState.getID();
        }
        boolean found = false;
        for(i = 0; i<finalStates.length; i++){
            if(currentState.getID() == finalStates[i])
                found = true;
        }
        if(found == true)
            System.out.println("test string matches DFA!");
        else
            System.out.println("test string does not match DFA!");


    }
}
