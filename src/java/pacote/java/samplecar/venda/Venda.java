/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote.java.samplecar.venda;

/**
 *
 * @author yuri.abel
 */
public class Venda {
    private int id;
    private String nome_cliente;
    private String nome_vendedor;
    private int id_veiculo;
    private float preco_venda;
    
    public Venda(){}
    
    public Venda(int id){
        this.id = id;
    }
    
    public Venda(int id, String nome_cliente, String nome_vendedor, int id_veiculo, float preco_venda){
        this.id = id;
        this.nome_cliente = nome_cliente;
        this.nome_vendedor = nome_vendedor;
        this.id_veiculo = id_veiculo;
        this.preco_venda = preco_venda;
    }
    
     public Venda(String nome_cliente, String nome_vendedor, int id_veiculo, float preco_venda){
        this.id = id;
        this.nome_cliente = nome_cliente;
        this.nome_vendedor = nome_vendedor;
        this.id_veiculo = id_veiculo;
        this.preco_venda = preco_venda;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome_cliente
     */
    public String getNome_cliente() {
        return nome_cliente;
    }

    /**
     * @param nome_cliente the nome_cliente to set
     */
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    /**
     * @return the nome_vendendor
     */
    public String getNome_vendendor() {
        return nome_vendedor;
    }

    /**
     * @param nome_vendendor the nome_vendendor to set
     */
    public void setNome_vendendor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

    /**
     * @return the id_veiculo
     */
    public int getId_veiculo() {
        return id_veiculo;
    }

    /**
     * @param id_veiculo the id_veiculo to set
     */
    public void setId_veiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return preco_venda;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float preco_venda) {
        this.preco_venda = preco_venda;
    }
    
    
}
