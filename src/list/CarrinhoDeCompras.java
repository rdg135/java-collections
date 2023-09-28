package list;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itemList;
    
    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preço, int quantidade) {
        itemList.add(new Item(nome, preço, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                    }
                }
                itemList.removeAll(itensParaRemover);
            } else {
        System.out.println("A lista está vazia!");
        }
    }
        

    public void calcularValorTotal() {
        double valorTotal = 0;
        for( Item i : itemList) {
            double valorItem = i.getPreco() * i.getQuantidade();
            valorTotal += valorItem;
        }
        System.out.println("Valor total : R$" + valorTotal);
    }

    public void exibirItems() {
        System.out.println("Lista de items : " + itemList);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras comprasDoMes = new CarrinhoDeCompras();

        comprasDoMes.adicionarItem("banana", 0.50, 8);
        comprasDoMes.adicionarItem("pao", 8, 1);
        comprasDoMes.adicionarItem("file peito frango", 16.50, 2);

        comprasDoMes.exibirItems();
        comprasDoMes.calcularValorTotal();

        comprasDoMes.adicionarItem("ovos", 1, 22);
        comprasDoMes.removerItem("banana");
        comprasDoMes.exibirItems();
        comprasDoMes.calcularValorTotal();
    }
}