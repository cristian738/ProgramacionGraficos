
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Hilo1 hilo1 = new Hilo1();
		//Hilo2 hilo2 = new Hilo2();
		
		//Frame f = new  Frame();

		
		//creando nodos originales
		Nodo DSC = new Nodo("DSC",50,50);
		Nodo lenguas = new Nodo("lenguas",80,10);
		Nodo Derecho = new Nodo("Derecho",100,55);
		Nodo SocialesB = new Nodo("Sociales B",100,20);
		Nodo Humanidades = new Nodo("Humanidades",150,65);
		Nodo Agropecuarias = new Nodo("Agropecuarias",80,80);
		//Nodo Pesquerias = new Nodo("Pesquerias",200,70);
		Nodo CienciasMar = new Nodo("CienciasdelMar",250,90);
		Nodo SocialesV = new Nodo("Sociales V",50,50);
		Nodo CienciasPoliticas = new Nodo("CienciasPoliticas",80,10);
		Nodo Poliforo = new Nodo("Poliforo",100,55);
	//	Nodo AreaDeportiva = new Nodo("AreaDeportiva",100,20);
		Nodo Macrocentro = new Nodo("Macrocentro",150,65);
		Nodo Libreria = new Nodo("Libreria",80,80);
		Nodo Biblioteca = new Nodo("Biblioteca",200,70);
		Nodo ServiciosMedicos = new Nodo("ServiciosMedicos",250,90);
		Nodo Rectoria = new Nodo("Rectoria",50,50);
		Nodo ServiciosEscolares = new Nodo("ServiciosEscolares",80,10);
		Nodo Radio = new Nodo("Radio",100,55);
		Nodo Gym = new Nodo("Gym",100,20);
		Nodo Buses1 = new Nodo("Parada1",150,65);
		Nodo Buses2 = new Nodo("Parada2",150,65);
		Nodo Cafeteria = new Nodo("Cafeteria",80,80);
		//creando nodos aux
		Nodo aux1 = new Nodo("a",25,25);
		Nodo aux2 = new Nodo("b",25,25);
		Nodo aux3 = new Nodo("c",25,25);
		Nodo aux4 = new Nodo("d",25,25);
		Nodo aux5 = new Nodo("e",25,25);
		Nodo aux6 = new Nodo("f",25,25);
		Nodo aux7 = new Nodo("g",25,25);
		Nodo aux8 = new Nodo("h",25,25);
		Nodo aux9 = new Nodo("i",25,25);
		Nodo aux10 = new Nodo("j",25,25);
		Nodo aux11 = new Nodo("k",25,25);
		Nodo aux12 = new Nodo("l",25,25);
		Nodo aux13 = new Nodo("m",25,25);
		Nodo aux14 = new Nodo("n",25,25);
		Nodo aux15 = new Nodo("o",25,25);
		Nodo aux16 = new Nodo("p",25,25);
		Nodo aux17 = new Nodo("k",25,25);
		Nodo aux18 = new Nodo("r",25,25);
		Nodo aux19 = new Nodo("s",25,25);
		Nodo aux20 = new Nodo("t",25,25);
		Nodo aux21 = new Nodo("u",25,25);
		Nodo aux22 = new Nodo("v",25,25);
		
		
		//enlazar la ligas
		
		Liga l1 = new Liga(Poliforo,aux1,60);//ligado y peso
		Liga l2 = new Liga(aux1,Poliforo,60);
		
		Liga l3 = new Liga(aux1,Macrocentro,18);
		Liga l4 = new Liga(Macrocentro,aux1,18);
		
		Liga l5 = new Liga(aux1,aux2,48);
		Liga l6 = new Liga(aux2,aux1,48);
		
		Liga l7 = new Liga(aux2,DSC,30);
		Liga l8 = new Liga(DSC,aux2,30);
		
		Liga l9 = new Liga(aux2,ServiciosEscolares,36);
		Liga l10 = new Liga(ServiciosEscolares,aux2,36);
		
		Liga l11 = new Liga(aux2,aux3,54);
		Liga l12 = new Liga(aux3,aux2,54);
		
		Liga l13 = new Liga(aux3,Libreria,30);
		Liga l14 = new Liga(Libreria,aux3,30);
		
		Liga l15 = new Liga(aux3,aux4,24);
		Liga l16 = new Liga(aux4,aux3,24);
		///
		Liga l17 = new Liga(aux4,Radio,30);
		Liga l18 = new Liga(Radio,aux4,30);
		
		Liga l19 = new Liga(aux4,aux5,42);
		Liga l20 = new Liga(aux5,aux4,42);
		
		Liga l21 = new Liga(aux5,aux6,12);
		Liga l22 = new Liga(aux6,aux5,12);
		
		Liga l23 = new Liga(aux6,Biblioteca,24);
		Liga l24 = new Liga(Biblioteca,aux6,24);
		
		Liga l25 = new Liga(aux6,Rectoria,78);
		Liga l26 = new Liga(Rectoria,aux6,78);
		
		Liga l27 = new Liga(Rectoria,lenguas,108);
		Liga l28 = new Liga(lenguas,Rectoria,108);
	
		Liga l29 = new Liga(aux5,ServiciosMedicos,30);
		Liga l30 = new Liga(ServiciosMedicos,aux5,30);
		
		Liga l31 = new Liga(ServiciosMedicos,Buses1,36);
		Liga l32 = new Liga(Buses1,ServiciosMedicos,36);
		
		Liga l33 = new Liga(Buses1,Buses2,30);
		Liga l34 = new Liga(Buses2,Buses1,30);
		
		Liga l35 = new Liga(Buses2,aux7,36);
		Liga l36 = new Liga(aux7,Buses2,36);
		
		Liga l37 = new Liga(aux7,CienciasMar,30);
		Liga l38 = new Liga(CienciasMar,aux7,30);
		
		Liga l39 = new Liga(CienciasMar,aux8,90);
		Liga l40 = new Liga(aux8,CienciasMar,90);
		
		Liga l41 = new Liga(aux8,aux9,90);
		Liga l42 = new Liga(aux9,aux8,90);
		
		Liga l43 = new Liga(aux9,aux10,24);
		Liga l44 = new Liga(aux10,aux9,24);
		
		Liga l45 = new Liga(aux10,lenguas,30);
		Liga l46 = new Liga(lenguas,aux10,30);
		
		Liga l47 = new Liga(aux8,aux11,42);
		Liga l48 = new Liga(aux11,aux8,42);
		
		Liga l49 = new Liga(aux11,Cafeteria,18);
		Liga l50 = new Liga(Cafeteria,aux11,18);
		
		Liga l51 = new Liga(Cafeteria,aux12,24);
		Liga l52 = new Liga(aux12,Cafeteria,24);
		
		Liga l53 = new Liga(aux12,Agropecuarias,48);
		Liga l54 = new Liga(Agropecuarias,aux12,48);
		
		Liga l55 = new Liga(aux8,Agropecuarias,60);
		Liga l56 = new Liga(Agropecuarias,aux8,60);
		
		Liga l57 = new Liga(Agropecuarias,SocialesV,36);
		Liga l58 = new Liga(SocialesV,Agropecuarias,36);
		
		Liga l59 = new Liga(SocialesV,aux13,90);
		Liga l60 = new Liga(aux13,SocialesV,90);
		
		Liga l61 = new Liga(aux13,aux14,78);
		Liga l62 = new Liga(aux14,aux13,78);
		
		Liga l63 = new Liga(aux14,aux7,24);
		Liga l64 = new Liga(aux7,aux14,24);
		
		Liga l65 = new Liga(aux14,SocialesB,60);
		Liga l66 = new Liga(SocialesB,aux14,60);
		
		Liga l67 = new Liga(SocialesB,Buses2,48);
		Liga l68 = new Liga(Buses2,SocialesB,48);
		
		Liga l69 = new Liga(Buses2,Gym,180);
		Liga l70 = new Liga(Gym,Buses2,180);
		
		Liga l71 = new Liga(Gym,aux15,42);
		Liga l72 = new Liga(aux15,Gym,42);
		
		Liga l73 = new Liga(aux15,aux16,18);
		Liga l74 = new Liga(aux16,aux15,18);
		
		Liga l75 = new Liga(aux16,aux17,30);
		Liga l76 = new Liga(aux17,aux16,30);
		
		Liga l77 = new Liga(aux17,SocialesB,12);
		Liga l78 = new Liga(SocialesB,aux17,12);
		
		Liga l79 = new Liga(Gym,aux18,48);
		Liga l80 = new Liga(aux18,Gym,48);
		
		Liga l81 = new Liga(aux18,aux19,54);
		Liga l82 = new Liga(aux19,aux18,54);
		
		Liga l83 = new Liga(aux19,aux20,120);
		Liga l84 = new Liga(aux20,aux19,120);
		
		Liga l85 = new Liga(aux20,SocialesV,120);
		Liga l86 = new Liga(SocialesV,aux20,120);
		
		Liga l87 = new Liga(aux20,CienciasPoliticas,30);
		Liga l88 = new Liga(CienciasPoliticas,aux20,30);
		
		Liga l89 = new Liga(aux19,Humanidades,30);
		Liga l90 = new Liga(Humanidades,aux19,30);
		
		Liga l91= new Liga(CienciasPoliticas,Humanidades,120);
		Liga l92 = new Liga(Humanidades,CienciasPoliticas,120);
		
		Liga l93= new Liga(Humanidades,aux21,48);
		Liga l94 = new Liga(aux21,Humanidades,48);
		
		Liga l95= new Liga(aux21,aux22,48);
		Liga l96 = new Liga(aux22,aux21,48);
		
		Liga l97 = new Liga(aux22,Derecho,60);
		Liga l98 = new Liga(Derecho,aux22,60);
			
		//Grafo
		Grafo gr =new Grafo();
		
		gr.addLiga(l1);
		gr.addLiga(l2);
		gr.addLiga(l3);
		gr.addLiga(l4);
		gr.addLiga(l5);
		gr.addLiga(l6);
		gr.addLiga(l7);
		gr.addLiga(l8);
		gr.addLiga(l9);
		gr.addLiga(l10);
		gr.addLiga(l11);
		gr.addLiga(l12);
		gr.addLiga(l13);
		gr.addLiga(l14);
		gr.addLiga(l15);
		gr.addLiga(l16);
		gr.addLiga(l17);
		gr.addLiga(l18);
		gr.addLiga(l19);
		gr.addLiga(l20);
		gr.addLiga(l21);
		gr.addLiga(l22);
		gr.addLiga(l23);
		gr.addLiga(l24);
		gr.addLiga(l25);
		gr.addLiga(l26);
		gr.addLiga(l27);
		gr.addLiga(l28);
		gr.addLiga(l29);
		gr.addLiga(l30);
		gr.addLiga(l31);
		gr.addLiga(l32);
		gr.addLiga(l33);
		gr.addLiga(l34);
		gr.addLiga(l35);
		gr.addLiga(l36);
		gr.addLiga(l37);
		gr.addLiga(l38);
		gr.addLiga(l39);
		gr.addLiga(l40);
		gr.addLiga(l41);
		gr.addLiga(l42);
		gr.addLiga(l43);
		gr.addLiga(l44);
		gr.addLiga(l45);
		gr.addLiga(l46);
		gr.addLiga(l47);
		gr.addLiga(l48);
		gr.addLiga(l49);
		gr.addLiga(l50);
		gr.addLiga(l51);
		gr.addLiga(l52);
		gr.addLiga(l53);
		gr.addLiga(l54);
		gr.addLiga(l55);
		gr.addLiga(l56);
		gr.addLiga(l57);
		gr.addLiga(l58);
		gr.addLiga(l59);
		gr.addLiga(l60);
		gr.addLiga(l61);
		gr.addLiga(l62);
		gr.addLiga(l63);
		gr.addLiga(l64);
		gr.addLiga(l65);
		gr.addLiga(l66);
		gr.addLiga(l67);
		gr.addLiga(l68);
		gr.addLiga(l69);
		gr.addLiga(l70);
		gr.addLiga(l71);
		gr.addLiga(l72);
		gr.addLiga(l73);
		gr.addLiga(l74);
		gr.addLiga(l75);
		gr.addLiga(l76);
		gr.addLiga(l77);
		gr.addLiga(l78);
		gr.addLiga(l79);
		gr.addLiga(l80);
		gr.addLiga(l81);
		gr.addLiga(l82);
		gr.addLiga(l83);
		gr.addLiga(l84);
		gr.addLiga(l85);
		gr.addLiga(l86);
		gr.addLiga(l87);
		gr.addLiga(l88);
		gr.addLiga(l89);
		gr.addLiga(l90);
		gr.addLiga(l91);
		gr.addLiga(l92);
		gr.addLiga(l93);
		gr.addLiga(l94);
		gr.addLiga(l95);
		gr.addLiga(l96);
		gr.addLiga(l97);
		gr.addLiga(l98);
		
		gr.inicio("Gym");//donde quieres iniciar
		gr.fin("Parada1");
		gr.recorrer();
		//gr.fin("parada1");
		
		/*
		Grafo mapa = new Grafo();
		
		Nodo n1 = new Nodo();
		n1.setDato("Nodo 1");
		Nodo n11 = new Nodo();
		n11.setDato("Nodo 1.1");
		n1.addLiga(n11);
		
		Nodo n2 = new Nodo();
		n2.setDato("Nodo 2");
		
		Nodo n21 = new Nodo();
		n21.setDato("Nodo 2.1");
		
		Nodo n22 = new Nodo();
		n22.setDato("Nodo 2.2");
		

		
		n2.addLiga(n21);
		n2.addLiga(n22);
		
		n22.addLiga(n11);
		Liga link1 = new Liga();
		
		link1.setOrigen(n1);
		link1.setDestino(n11);
		link1.setPeso(1);
		
		Liga link2 = new Liga();
		link2.setOrigen(n1);
		link2.setDestino(n22);
		
		
		mapa.addLiga(link1);
		mapa.addLiga(link2);
		//mapa.dibujar();
		 */ 
		
	}

}



