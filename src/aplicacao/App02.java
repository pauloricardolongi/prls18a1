package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AluguelCarro;
import model.entities.Veiculo;
import model.servico.ServicoAluguel;
import model.servico.TaxaServicoBrasil;

public class App02 {

	public static void main(String[] args)throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Entre com dados do aluguel");
		System.out.print("modeo do carro");
		String modeloVeiculo= sc.nextLine();
		System.out.print("Começo (dd/MM/yyyy hh:ss):");
		Date retirado = sdf.parse(sc.nextLine());
		System.out.print("retorno (dd/MM/yyyy hh:ss):");
		Date entregue = sdf.parse(sc.nextLine());
		
		AluguelCarro ac = new AluguelCarro(retirado, entregue, new Veiculo(modeloVeiculo));
		System.out.print("Entre com o preço por hora");
		double precoPorHora = sc.nextDouble();
		System.out.print("Entre com o preço por dia");
		double precoPorDia = sc.nextDouble();
		
		ServicoAluguel servicoAluguel= new ServicoAluguel(precoPorDia, precoPorHora ,new TaxaServicoBrasil());
		servicoAluguel.processandoFatura(ac);
		System.out.println("FATURA");
		System.out.println("pagamento basico: "+ String.format("%.2f", ac.getFatura().getPagamentoBasico()));
		System.out.println("taxa : "+ String.format("%.2f", ac.getFatura().getTaxa()));
		System.out.println("pagamento total: "+ String.format("%.2f", ac.getFatura().getPagamentoTotal()));
		
		
		sc.close();

	}

}


	


