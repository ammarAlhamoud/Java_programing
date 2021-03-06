package CommandPattern;

public class RestaurantStarter {

	public static void main(String[] args) {
		
		PräsedintTische P_tisch = new PräsedintTische();
		NormalTisch N_tisch = new NormalTisch();
		VIP_Tisch V_tisch = new VIP_Tisch();
		
		NormalKunde n_k = new NormalKunde();
		n_k.setServiceBefehl(new NormalTischBefehl(N_tisch));
		n_k.Service_durchführen();
		
		VIPKunde v_k = new VIPKunde();
		v_k.setServiceBefehl(new VIP_TischBefehl(V_tisch));
		v_k.Service_durchführen();
		
		Präsedint p = new Präsedint();
		p.setServiceBefehl(new PräsedintTischeBefehl(P_tisch));
		p.Service_durchführen();
		
		v_k.setServiceBefehl(new PräsedintTischeBefehl(P_tisch));
		v_k.Service_durchführen();

	}

}
