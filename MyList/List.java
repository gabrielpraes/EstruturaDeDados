import java.util.Scanner;

public class List {

    private int[] list;
    private int n;

    public int getTam() {
        return n;
    }
    
    public List() {
        this(86);
    }
    public List(int tam) {
        list = new int[tam];
        n = 0;
    }
    
    
    public void inserirInicio(int value) {
        int size = list.length;
        if(n == 0) {
            list[0] = value;
            n++;
        }
        else if(n < size) {
            for(int i = n; i > 0; i--) {
                list[i] = list[i-1];
            }
            list[0] = value;
            n++;
        }
        else {   
            System.out.println("--------Erro ao inserir no inicio--------");
        }
    }


    public void inserir(int value, int position) {
        int size = list.length;
        if(n < size && position > 0 && position < n) {
            for(int i = n; i > position; i--) {
                list[i] = list[i-1];
            }
            list[position] = value;
            n++;
        }
        else {
            System.out.println("--------Erro ao inserir--------");
        }
    }


    public void inserirFim(int value) {
        int size = list.length;
        if(n < size) {
            list[n] = value;
            n++;
        }
        else {
            System.out.println("--------Erro ao inserir no final--------");
        }
    }

    public int removerInicio() throws Exception {
        if(n <= 0) {
            throw new Exception("--------Erro ao remover no init!--------");
        }
        int removed = list[0];
        for(int i = 1; i < n; i++) {
            list[i-1] = list[i];
        }
        n--;
        return removed;
    }

    public int remover(int position) throws Exception {
        if(position > n || position < 0) {
            throw new Exception("--------Erro ao remover pos!--------");
        }
        int removed = list[position];
        for(int i = position; i < n; i++) {
            list[i] = list[i+1];
        }
        n--;
        return removed;
    }

    public int removerFim() throws Exception {
        if(n <= 0) {
            throw new Exception("--------Erro ao remover fim!--------");
        }
        int removed = list[n-1];
        n--;
        return removed;
    }

    public void imprimir() {
        System.out.print("[");
        int i = 0;
        for(; i < n-1; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println(list[i] + "]");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        List list = new List(50);
        String op = sc.next();

        while(!op.equals("FIM")) {
            if(op.equals("II")) {
                int value = sc.nextInt();
                list.inserirInicio(value);
            }
            else if(op.equals("IF")) {
                int value = sc.nextInt();
                list.inserirFim(value);
            }
            else if(op.equals("I*")) {
                int value = sc.nextInt();
                int pos = sc.nextInt();
                list.inserir(value, pos);
            }
            else if(op.equals("RI")) {
                System.out.println(list.removerInicio());
            }
            else if(op.equals("RF")) {
                System.out.println(list.removerFim());
            }
            else if(op.equals("R*")) {
                int pos = sc.nextInt();
                System.out.println(list.remover(pos));
            }
            else {
                throw new Exception("ERRO");
            }

            op = sc.next();
        }
        list.imprimir();

        sc.close();
    }
}