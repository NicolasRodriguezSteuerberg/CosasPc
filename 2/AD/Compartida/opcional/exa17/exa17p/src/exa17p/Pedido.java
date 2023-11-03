/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exa17p;

import java.text.NumberFormat;

/**
 *
 * @author oracle
 */

 public class Pedido
{
	private String codcli;
        private String codpro;

	private int cantidade;
	private String data;

	public Pedido()
	{
		this("", "",0, "");
	}

	public Pedido(String codcli, String codpro, int cantidade, String data)
	{
		this.codcli = codcli;
                this.codpro = codpro;
                this.cantidade = cantidade;
		this.data = data;
	}

	public void setCodcli(String codcli)
	{
		this.codcli = codcli;
	}

	public String getCodcli(){
		return codcli;
	}
        public void setCodpro(String codpro)
	{
		this.codpro = codpro;
	}

	public String getCodpro(){
		return codpro;
	}
               
	public void setCantidade(int cantidade)
	{
		this.cantidade = cantidade;
	}

	public int getCantidade()
	{
		return cantidade;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	public String getData()
	{
		return data;
	}

	public String getFormattedCantidade()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(cantidade);
	}

    
	public String toString()
	{
		return "Codcli:        " + codcli + "\n" +
                        "Codpro:        " + codpro + "\n" +
			   "Cantidade: " +this.getFormattedCantidade() + "\n" +
			   "Data:       " + data + "\n";
	}
}
