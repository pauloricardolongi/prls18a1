package model.servico;

import model.entities.AluguelCarro;
import model.entities.Fatura;

public class ServicoAluguel {
	private Double precoPorDia;
	private Double precoPorHora;
	
	private TaxaServicoBrasil taxaServico;

	public ServicoAluguel(Double precoPorDia, Double precoPorHora, TaxaServicoBrasil taxaServico) {
		super();
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.taxaServico = taxaServico;
	}
	
	public void processandoFatura(AluguelCarro aluguelCarro) {
		long t1= aluguelCarro.getComeco().getTime();
		long t2= aluguelCarro.getFim().getTime();
		double horas= (double)  (t2-t1)/1000/60/60;//diferença em horas
		
		double pagamentoBasico;
		if(horas <= 12.0) {
		 pagamentoBasico = Math.ceil(horas) * precoPorHora;
			
		}
		else {
		pagamentoBasico = Math.ceil(horas / 24)	* precoPorDia;
		
		}
		double taxa= taxaServico.taxa(pagamentoBasico);
		
		aluguelCarro.setFatura(new Fatura(pagamentoBasico,taxa));
	}
	

}



