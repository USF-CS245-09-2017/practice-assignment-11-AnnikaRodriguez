import java.lang.*;

public class Hashtable {
    HashNode[] slots;
    int initial;
    int size; //num of items in hash table
    //  public final double lambda = .7;

    public Hashtable()
    {
        size = 0;
        initial = 3000;
        slots = new HashNode[initial];

    }

    public int getSlot(String key){

        int slot = key.hashCode();
        return (slot % slots.length);
    }

    public boolean containsKey(String key){

        int slot = getSlot(key);
        HashNode current = slots[slot];

        while(current != null){
            if(current.key.equals(key)){
                return true;
            }
        }
        return false;

    }

    public String get (String key){

        int slot = getSlot(key); //find slot it exists in
        HashNode current = slots[slot];     //head of Linkedlist

        while(current != null){
            if(current.getKey().equals(key)){
                return current.value;
            }

            current = current.next;
        }

        return null;

    }

    public void put (String key, String value){

        int slot = getSlot(key); //find slot it exists in
        HashNode current = slots[slot];     //head of Linkedlist

        //dont add the node at the end of the list because the run time would result in O(n)
        //so you add it to the front
        while(current != null){
            if(current.getKey().equals(key)){
                current.key = key;
                current.value = value;
                return;
            }

            current = current.next;
        }

        HashNode newNode = new HashNode(key, value);
        newNode.next = slots[slot];
        //change value of the head of the linked list to point to the new node
        slots[slot] = newNode;
        size++;

              /*
        check if the lambda is within range and if full
        if(size/slots.size() >= lambda)
            //double size of the array list
            //Does the key already exist in the hash table—> change value
*/
    }


    public String remove(String key) {

        int slot = getSlot(key);

        HashNode temp = slots[slot];
        HashNode previous = null;

        while (temp != null && temp.getKey() != key) {
            previous = temp;
            temp = temp.next;
        }

        if (temp.getKey() == key){
            if(temp == null){
                return null;
            }
        }

        if (previous == null) {
            slots[slot] = temp.next;

        } else if (temp.getKey() == key) {
            return null;
        } else {
            previous.next = temp.next;
            size--;
        }

        return temp.value;

    }

}

     class HashNode {

public String key;
public String value;
public HashNode next;

public HashNode(String key, String value)
    {
        this.key = key;
        this.value = value;
        next = null;
        }

public String getKey() {
        return this.key;
        }

public String getValue(){
        return this.value;
        }

public void setKey(String key){
        this.key= key;

        }

public void setValue(String value){
        this.value = value;
        }


}
