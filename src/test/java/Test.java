public class Test {
    public static void main(String[] args){
            String nomClass="Produit";
        try {
            Class classe=Class.forName(nomClass);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
