package CommandPattern;

public class RestaurantStarter {

	public static void main(String[] args) {
		
		Pr�sedintTische P_tisch = new Pr�sedintTische();
		NormalTisch N_tisch = new NormalTisch();
		VIP_Tisch V_tisch = new VIP_Tisch();
		
		NormalKunde n_k = new NormalKunde();
		n_k.setServiceBefehl(new NormalTischBefehl(N_tisch));
		n_k.Service_durchf�hren();
		
		VIPKunde v_k = new VIPKunde();
		v_k.setServiceBefehl(new VIP_TischBefehl(V_tisch));
		v_k.Service_durchf�hren();
		
		Pr�sedint p = new Pr�sedint();
		p.setServiceBefehl(new Pr�sedintTischeBefehl(P_tisch));
		p.Service_durchf�hren();
		
		v_k.setServiceBefehl(new Pr�sedintTischeBefehl(P_tisch));
		v_k.Service_durchf�hren();

	}

}